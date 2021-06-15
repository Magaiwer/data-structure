package staticstructure.stack;

import staticstructure.base.generic.VectorGeneric;

/**
 * @author Magaiver Santos
 */
public class Stack<T> extends VectorGeneric<T> {

    public Stack() {
        super();
    }

    public void push(T element) {
        super.increaseSize();
        super.add(element);
    }

    public T peek() {
        if (this.isEmpty()) {
            return null;
        }
        return this.elements[this.size - 1];
    }

    public T pop() {
        return this.elements[--this.size];
    }
}
