package staticstructure.base.generic;

import staticstructure.vector.Vector;

import java.lang.reflect.Array;

/**
 * @author Magaiver Santos
 */
public class VectorGeneric<T> {
    protected T[] elements;
    protected int size;

    public VectorGeneric(int capacity) {
        elements = (T[]) new Object[capacity];
        this.size = 0;
    }

    public VectorGeneric(int capacity, Class<T> type) {
        elements = (T[])  Array.newInstance(type, capacity);
        this.size = 0;
    }

    public VectorGeneric() {
        this(10);
    }

    protected boolean add(T element) {
        increaseSize();
        if (this.size < this.elements.length) {
            this.elements[this.size] = element;
            this.size++;
            return true;
        }
        return false;
    }

    protected boolean add(int position, T element) {
        increaseSize();
        if (!(position >= 0 && position < this.size)) {
            return false;
        }
        for (int i = this.size - 1; i >= position; i--) {
            this.elements[i + 1] = elements[i];
        }

        // SAME WAY
        //System.arraycopy(elements, position, this.elements, position + 1, this.size - position);

        this.elements[position] = element;
        this.size++;

        return true;
    }

    public boolean remove(int position) {
        if (!(position >= 0 && position < this.size)) {
            return false;
        }

        for (int i = position; i < this.size-1 ; i++) {
            this.elements[i] = this.elements[i+1];
        }
/*
        SAME WAY
        if (this.size - 1 - position >= 0)
            System.arraycopy(this.elements, position + 1, this.elements, position, this.size - 1 - position);*/

        this.size--;
        return true;
    }

    public boolean remove(T element) {
        int index = indexOf(element);
        if (index >= 0 ) {
            return remove(index);
        }
        return false;
    }

    public int lastIndexOf(T element) {
        for (int i = this.size - 1; i >= 0; i--) {
            if (this.elements[i].equals(element)) {
                return i;
            }
        }
        return - 1;
    }

    public void removeAll() {
        for (int i = 0; i < this.elements.length; i++) {
            this.elements[i] = null;
        }

        // OR
        //Arrays.fill(this.elements, null);
        this.size = 0;
    }

    public T search(int position) {
        if (!(position >= 0 && position < this.size)) {
            return null;
        }
        return elements[position];
    }

    public boolean contains(T element) {
        for (int i = 0; i < this.size; i++) {
            if (this.elements[i].equals(element)) {
                return true;
            }
        }
        return false;

        // OR
        // return (indexOf(element) >= 0);
    }

    public boolean isEmpty() {
        return this.size == 0;
    }

    public int indexOf(T element) {
        for (int i = 0; i < this.size; i++) {
            if (this.elements[i].equals(element)) {
                return i;
            }
        }
        return -1;
    }

    public int getSize() {
        return this.size;
    }

    protected void increaseSize() {
        if (this.size == this.elements.length) {
            T[] elementsNew = (T[]) new Object[this.elements.length * 2];

            for (int i = 0; i < this.elements.length; i++) {
                elementsNew[i] = this.elements[i];
            }
            // SAME WAY
            // this.elements = Arrays.copyOf(this.elements, (this.elements.length * 2));
            //System.arraycopy(this.elements, 0, elementsNew, 0, this.elements.length);

            this.elements = elementsNew;
        }
    }

    @Override
    public String toString() {
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append("[");

        for (int i = 0; i < this.size - 1; i++) {
            stringBuilder.append(this.elements[i]);
            stringBuilder.append(",");
        }

        if (this.size > 0) {
            stringBuilder.append(this.elements[this.size - 1]);
        }
        stringBuilder.append("]");
        return stringBuilder.toString();
    }
}
