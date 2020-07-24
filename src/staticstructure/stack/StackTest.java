package staticstructure.stack;

/**
 * @author Magaiver Santos
 */
public class StackTest {

    public static void main(String[] args) {
        Stack<Integer> stack = new Stack<>();

        stack.push(1);
        stack.push(2);
        stack.push(3);
        stack.push(4);

        System.out.println(stack.toString());
        System.out.println("Peek stack " + stack.peek());
        System.out.println("Pop stack " + stack.pop());
        System.out.println("Pop stack " + stack.toString());
    }

}
