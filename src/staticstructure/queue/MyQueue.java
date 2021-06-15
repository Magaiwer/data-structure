package staticstructure.queue;

import staticstructure.base.generic.VectorGeneric;

import java.util.Queue;

/**
 * @author Magaiver Santos
 */

// extende o classe genérica do vetor, pode ser estática ou dinâmica, se não for passado a capacidade
public class MyQueue<T> extends VectorGeneric<T> {

    public MyQueue() {
        super();
        Queue<String> queue;
    }

    public MyQueue(int capacidade) {
        super(capacidade);
    }

    public void enqueue(T element) {
        this.add(element);
    }

    public T peek() {
        if (this.isEmpty()) {
            return null;
        }
        // retorna o elemento do topo se a fila tiver vazia retorna null
        return this.elements[0];
    }

    public T dequeue() {
        final int POS = 0;
        if (this.isEmpty()) {
            return null;
        }
        // sempre vai desenfileirar o elemento que está no top
        T elementToRemove = this.elements[POS];
        // remove o elemento
        this.remove(POS);
        // retorna o elemento removido
        return elementToRemove;
    }

    @Override
    public String toString() {
        StringBuilder stringBuilder = new StringBuilder();

        for (int i = 0; i < this.size - 1; i++) {
            stringBuilder.append(this.elements[i]);
            stringBuilder.append(",");
        }

        if (this.size > 0) {
            stringBuilder.append(this.elements[this.size - 1]);
        }
        return stringBuilder.toString();
    }

}










