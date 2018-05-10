import java.util.ArrayList;
import java.util.List;

public class Main {

    public static void main(String[] args) {

        System.out.println(doSomeWork());
    }

    public static Integer doSomeWork() {
        int a = 10000;
        int b = 99999;

        List<Integer> list = new ArrayList<>();

        for (int i = a; i < b; i++)
            list.add(i);

        List<Integer> primeNumbers = new ArrayList<>();
        list.stream().filter(Main::isPrime).forEach(primeNumbers::add);

        return findBiggestPalindrome(primeNumbers);
    }

    private static Integer findBiggestPalindrome(List<Integer> primeNumbers) {
        Integer result;
        for (int i = primeNumbers.size()-1; i > 0; i--) {
            for (int j = i; j > 0; j--) {
                 result = primeNumbers.get(i)*primeNumbers.get(j);
                if (isPalindrome(primeNumbers.get(i)*primeNumbers.get(j))) return result;
            }
        }
        return 0;
    }

    private static boolean isPalindrome(Integer i) {
        return new StringBuilder(""+i).reverse().toString().equals(""+i);
    }

    private static boolean isPrime(Integer number) {
        int temp;
        for (int i = 2; i < number/2; i++) {
            temp = number%i;
            if (temp == 0)
                return false;
        }
        return true;
    }
}
