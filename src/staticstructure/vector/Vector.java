package staticstructure.vector;

/**
 * @author Magaiver Santos
 */
public class Vector {
    private String[] elements;
    private int size;

    public Vector(int capacity) {
        elements = new String[capacity];
        this.size = 0;
    }

    public boolean add(String element) {
        increaseSize();
        if (this.size < this.elements.length) {
            this.elements[this.size] = element;
            this.size++;
            return true;
        }
        return false;
    }

    public boolean add(int position, String element) {
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

    public boolean remove(String element) {
        int index = indexOf(element);
        if (index >= 0 ) {
            return remove(index);
        }
        return false;
    }


    public String search(int position) {
        if (!(position >= 0 && position < this.size)) {
            return null;
        }
        return elements[position];
    }

    public boolean contains(String element) {
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

    public int indexOf(String element) {
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

    private void increaseSize() {
        if (this.size == this.elements.length) {
            String[] elementsNew = new String[this.elements.length * 2];

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
