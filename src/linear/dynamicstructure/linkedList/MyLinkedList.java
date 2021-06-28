package linear.dynamicstructure.linkedList;

import java.util.NoSuchElementException;

/**
 * @author Magaiver Santos
 */
public class MyLinkedList<T> {
    private Node<T> first;
    private Node<T> last;
    private int size;

    public MyLinkedList() {
        this.first = null;
        this.size = 0;
    }

    public int size() {
        return this.size;
    }

    public T removeFirst() {
        if (isEmpty()) throw new NoSuchElementException();

        T value = this.first.item;

        // verifica se a lista contem apenas um elemento e atualiza os ponteiros
        if (this.first.next == null) {
            this.first = null;
            this.last = null;
        } else {
            this.first = this.first.next; // atualiza o ponteiro para o próximo elemento da lista
            this.first.prev = null; // atualiza o ponteiro anterior para null.
        }

        --this.size;
        return value;
    }

    public T removeLast() {
        if (isEmpty()) throw new NoSuchElementException();

        T value = this.last.item;

        // verifica se a lista contem apenas um elemento e atualiza os ponteiros
        if (this.first.next == null) {
            this.first = null;
            this.last = null;
        } else {
            this.last = this.last.prev; // aponta o ponteiro para o anterior ao elemento removido
            this.last.next = null; // aponta o próximo para null
        }
        --this.size;
        return value; // retorna o valor removido
    }

    public T remove(int index) {
        checkIndexOfBound(index);

        if (index == 0) return removeFirst(); // se o index passado for 0 remove do inicio
        if (index == size - 1) return removeLast();// se o index passado for igual ao numero de elementos remove do final

        Node<T> nodeTemp = this.first;

        // itera a lista até encontrar o index do elemento a ser removido
        for (int i = 0; i < index; i++) {
            nodeTemp = nodeTemp.next;
        }

        // ajusta o ponteiro dos elementos
        nodeTemp.prev.next = nodeTemp.next;
        nodeTemp.next.next = nodeTemp.prev;

        --this.size;
        return nodeTemp.item;
    }

    public void addFirst(T value) {
        Node<T> node = new Node<>(value);

        // se a lista nao tiver vazia adiciona o valor do elemento que estava no inicio no próximo do elemento atual
        if (!isEmpty()) {
            node.next = this.first;
        }
        // o valor da cabeça da lista passa a ser o elemento atual
        this.first = node;
        ++this.size;
    }

    public void add(int index, T value) {
        checkIndexOfBound(index);
        Node<T> node = new Node<>(value);

        // se o index passado for 0, adiciona no inicio da lista
        if (index == 0) addFirst(value);
        else if (index == size - 1) addLast(value); // se for igual a quantidade de elementos, adiciona no final
        else {
            Node<T> nodeTemp = this.first; // variável auxiliar para iterar a lista
            for (int i = 0; i < index - 1; i++)
                nodeTemp = nodeTemp.next;

            // vincula os valores do novo no, com inicio e fim
            node.next = nodeTemp.next;
            nodeTemp.next = nodeTemp;
            node.next.prev = node;
            node.prev = nodeTemp;

            ++this.size;
        }
    }

    private void checkIndexOfBound(int index) {
        // valida se é um index valido
        if (index < 0 || index >= size) {
            System.out.println("invalid index");
            throw new IndexOutOfBoundsException();
        }
    }

    public void addLast(T value) {
        Node<T> node = new Node<>(value);

        // se a lista estiver vazia adiciona na primeira e ultima posição da lista, se não adiciona na ultima posicao e
        if (isEmpty()) {
            this.first = node;
        } else {
            this.last.next = node;
            node.prev = this.last;
        }
        this.last = node;
        ++this.size;

    }

    public T get(int index) {
        checkIndexOfBound(index); // testa se o index é valido maior que -1 e menor que a quantidade de elementos na lista
        Node<T> nodeTemp = this.first;
        // itera a lista até o index passado
        for (int i = 0; i < index; i++) {
            nodeTemp = nodeTemp.next;
        }

        return nodeTemp.item;
    }

    public int indexOf(T value) {
        Node<T> nodeTemp = this.first;
        // itera a lista até encontrar o elemento buscado, se encontrar retorna o index do elemento, se nao retorna -1
        int index = 0;
        while (nodeTemp != null) {
            if (nodeTemp.item.equals(value)) return index;
            nodeTemp = nodeTemp.next;
            index++;
        }
        return -1;
    }


    public boolean contains(T value) {
        return this.indexOf(value) != -1; // verifica se o elemento existe na lista
    }

    public T peek() {
        return this.first.item; // exibe o primeiro elemento
    }

    public T peekLast() {
        return this.last.item; // exibe o ultimo elemento
    }

    public boolean isEmpty() {
        return this.first == null;
    }

    public T getFirst() {
        Node<T> first = this.first; // pega o primeiro elemento da lista
        if (first == null)
            throw new NoSuchElementException();// se o ultimo elemento for nulo lança uma exceção de elemento nao encontrado
        else return first.item; // retorna o valor do primeiro elemento
    }

    public T getLast() {
        Node<T> last = this.last; // pega o ultimo elemento da lista
        if (last == null)
            throw new NoSuchElementException();  // se o ultimo elemento for nulo lança uma exceção de elemento nao encontrado
        else return last.item; // retorna o valor do ultimo elemento
    }

    @Override
    public String toString() {
        if (this.isEmpty()) return "[]";

        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append("[");

        // Pega o primeiro elemento da lista para começar a iterar
        Node<T> current = this.first;

        for (int i = 0; i < this.size-1; i++) {
            stringBuilder.append(current.item);
            stringBuilder.append(",");
            current = current.next;
        }
        // adiciona o ultimo elemento da lista, para escapar a virgula
        stringBuilder.append(current.item);
        stringBuilder.append("]");

        return stringBuilder.toString();
    }

    private static class Node<T> {
        T item;
        Node<T> next;
        Node<T> prev;

        public Node(T item) {
            this.item = item;
        }
    }
}
