package linear.dynamicstructure.linkedList;

import java.util.LinkedList;

/**
 * @author Magaiver Santos
 */
public class MyLinkedList<T> {
    private Node<T> head;
    private int size;
    private T value;

    public MyLinkedList() {
        this.head = null;
        this.size = 0;
    }

    public void removeFirst() {

    }

    public void addFirst(T value) {
        Node<T> node = new Node<>(value);

        if (!isEmpty()) {
            node.next = this.head;
        }
        this.head = node;

    }

    public void peek() {

    }

    public boolean isEmpty() {
        return this.head == null;
    }




    private static class Node<T> {
        T item;
        Node<T> next;
        Node<T> prev;

        public Node(T item, Node<T> next, Node<T> prev) {
            this.item = item;
            this.next = next;
            this.prev = prev;
        }

        public Node(T item) {
            this.item = item;
        }
    }


    public static void main(String[] args) {
        LinkedList<Integer> linkedList = new LinkedList();
        //linkedList.
    }

}
