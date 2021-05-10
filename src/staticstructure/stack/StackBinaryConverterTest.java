package staticstructure.stack;

/**
 * @author Magaiver Santos
 */
public class StackBinaryConverterTest {

    public static void main(String[] args) {
        Stack<Integer> stack = new Stack<>();

        System.out.println("25 in binary - " + decimalToBinary(25));
        System.out.println("40 in binary - " + decimalToBinary(40));
        System.out.println("29 in binary - " + decimalToBinary(29));
        System.out.println("10 in binary - " + decimalToBinary(10));

        System.out.println("25 in base 8 - " + decimalToAnyBase(25, 8));
        System.out.println("40 in base 8 - " + decimalToAnyBase(40, 8));
        System.out.println("29 in base 8 - " + decimalToAnyBase(29, 8));
        System.out.println("10 in base 8 - " + decimalToAnyBase(10, 8));

        // OR
        System.out.println("25 in binary - " + Integer.toBinaryString(25));
        System.out.println("40 in binary - " + Integer.toBinaryString(40));
        System.out.println("29 in binary - " + Integer.toBinaryString(29));
        System.out.println("10 in binary - " + Integer.toBinaryString(10));
    }

    public static String decimalToBinary(int num) {
        Stack<Integer> stack = new Stack<>();
        String binaryNum = "";
        int rest;

        while (num > 0) {
            rest = num % 2;
            stack.push(rest);
            num /= 2;
        }

        while (!stack.isEmpty()) {
            binaryNum += stack.pop();
        }


        return binaryNum;
    }

    public static String decimalToAnyBase(int num, int base) {
        if ( base > 16) {
            return "Ilegal base";
        }

        Stack<Integer> stack = new Stack<>();
        String baseNum = "";
        String bases = "0123456789ABCDEF";
        int rest;

        while (num > 0) {
            rest = num % base;
            stack.push(rest);
            num /= base;
        }

        while (!stack.isEmpty()) {
            baseNum += bases.charAt(stack.pop());
        }
        return baseNum;
    }
}
