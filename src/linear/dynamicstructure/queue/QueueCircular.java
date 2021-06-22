package linear.dynamicstructure.queue;

import linear.staticstructure.base.generic.VectorGeneric;

public class QueueCircular<T> extends VectorGeneric<T> {

    private int start;
    private int end;
    private int capacity;


    public QueueCircular(int capacity) {
        super(capacity);
        this.capacity = capacity;
        this.start = -1;
        this.end = -1;
    }

    public void enqueue(T element) {
        if (isFull()) {
            System.out.println("Queue is full");
        } else {
            // se o ponteiro end for igual a capacidade da fila, retorna ele para o inicio
            if (this.end == this.capacity - 1) {
                this.end = -1;
            }
            this.end++;
            this.add(this.end, element);
        }
    }

    public T dequeue() {
        if (this.isEmpty()) {
            System.out.println("Queue is empty");
            return null;
        }
        // se o ponteiro start for igual a capacidade da fila, retorna ele para o inicio
        if (this.start == this.capacity - 1) {
            this.start = -1;
        }
        // move o ponteiro para o proximo elemento da fila
        this.start++;

        // retorna o elemento do inicio
        return this.elements[this.start];
    }

    public T peek() {
        if (this.isEmpty()) {
            return null;
        }
        // como meu ponteiro inicial "start" começou em -1 ele sempre aponta para uma posição anterior do elemento da fila por isso a validação
        int pointerAux = this.start;
        if (pointerAux == this.capacity - 1) {
            pointerAux = -1;
        }
        // retorna o elemento do inicio, se a fila tiver vazia retorna null
        return this.elements[pointerAux + 1];
    }

    public boolean isFull() {
        return this.size == this.capacity;
    }

    @Override
    public String toString() {
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append("[");

        int j = this.start + 1;

        for (int i = 0; i != this.size; i++) {

            if (j == this.capacity) {
                j = 0;
            }

            if (j == this.end) {
                stringBuilder.append(this.elements[j]);
            } else {
                stringBuilder.append(this.elements[j]);
                stringBuilder.append(",");
            }
            j++;
        }

        if (this.size > 0) {
            stringBuilder.append(this.elements[this.size - 1]);
        }
        stringBuilder.append("]");
        return stringBuilder.toString();
    }

}