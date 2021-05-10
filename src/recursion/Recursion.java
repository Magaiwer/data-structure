package recursion;

/**
 * @author Magaiver Santos
 */
public class Recursion {

    private static int factorial(int n) {
        if (n > 0) {
            return n * factorial(n - 1);
        }
        return 1;
    }

    private static int notFactorial(int n) {
        int count = 1;
        int resultFat = 1;
        while (count <= n) {
            resultFat = resultFat * count;
            count = count + 1;
        }
        return resultFat;
    }

    private static int mdcRecursive(int dividend, int divisor) {
        if (divisor > dividend) {
            return mdcRecursive(divisor, dividend);
        } else if (divisor == 0) {
            return dividend;
        } else {
            return mdcRecursive(divisor, (dividend % divisor));
        }
    }

    private static int mdcNotRecursive(int dividend, int divisor) {
        int dividend1 = 0;
        int divisor1 = 0;
        if (dividend > divisor) {
            dividend1 = dividend;
            divisor1 = divisor;
        } else {
            dividend1 = divisor;
            divisor1 = dividend;
        }
        while ((dividend1 % divisor1) != 0) {
            int aux = divisor1;
            divisor1 = (dividend1 % divisor1);
            dividend1 = aux;
        }
        return divisor1;
    }

    public static void main(String[] args) {
        System.out.println(" Recursive factorial 10 ----> " + factorial(10));
        System.out.println(" Not Recursive factorial 5 ----> " + notFactorial(5));
        System.out.println(" MDC recursive 1495 e 7315 ----> " + mdcRecursive(1495, 7315));
        System.out.println(" MDC not recursive 1495 e 7315 ----> " + mdcNotRecursive(1495, 7315));
    }
}
