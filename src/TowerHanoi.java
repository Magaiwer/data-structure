import staticstructure.stack.Stack;

/**
 * @author Magaiver Santos
 */
public class TowerHanoi {
    public static void main(String[] args) {
        Stack<Integer> stackOrigin = new Stack<>();
        Stack<Integer> stackDest = new Stack<>();
        Stack<Integer> stackAux = new Stack<>();

        stackOrigin.push(3);
        stackOrigin.push(2);
        stackOrigin.push(1);

        System.out.println(stackOrigin.toString());
        towerHanoi(stackOrigin.getSize(), stackOrigin, stackDest, stackAux);
    }

    public static void towerHanoi(int n, Stack<Integer> stackOrigin, Stack<Integer> stackDest, Stack<Integer> stackAux) {
        if (n > 0) {
            towerHanoi(n - 1, stackOrigin, stackAux, stackDest);
            stackDest.push(stackOrigin.pop());
            System.out.println("-------------");
            System.out.println("Origin: " + stackOrigin);
            System.out.println("Dest: " + stackDest);
            System.out.println("Aux: " + stackAux);
            towerHanoi(n -1, stackAux, stackDest, stackOrigin);
        }
    }
}
