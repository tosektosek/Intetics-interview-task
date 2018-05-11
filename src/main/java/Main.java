import java.math.BigInteger;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.stream.Collectors;

public class Main {

    public static void main(String[] args) {

        System.out.println(doSomeWork());
    }

    public static BigInteger doSomeWork() {
        int a = 10000;
        int b = 99999;

        List<BigInteger> list = new ArrayList<>();

        for (int i = a; i < b; i++)
            list.add(BigInteger.valueOf(i));

        List<BigInteger> primeNumbers = new ArrayList<>();
        list.stream().filter(Main::isPrime).forEach(primeNumbers::add);
        return findBiggestPalindrome(primeNumbers);
    }

    private static BigInteger findBiggestPalindrome(List<BigInteger> primeNumbers) {
        List<BigInteger> list = new ArrayList<>();
        for (int i = primeNumbers.size()-1; i > 0; i--) {
            for (int j = i; j > 0; j--) {
                BigInteger result = primeNumbers.get(i).multiply(primeNumbers.get(j));
                if (isPalindrome(result)) {
                    list.add(result);
                }
            }
        }

        Collections.sort(list);
        return list.get(list.size()-1);
    }

    private static boolean isPalindrome(BigInteger i) {
        return new StringBuilder(""+i).reverse().toString().equals(""+i);
    }

    private static boolean isPrime(BigInteger number) {
        BigInteger temp;
        for (int i = 2;number.divide(BigInteger.valueOf(2)).compareTo(BigInteger.valueOf(i)) > 0; i++) {
            temp = number.mod(BigInteger.valueOf(i));
            if (temp.equals(BigInteger.ZERO))
                return false;
        }
        return true;
    }
}
