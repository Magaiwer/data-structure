package sort;

/**
 * @author Magaiver Santos
 */
public class QuickSort {

    public static void main(String[] args) {
        int[] array = {1, 15, 12, 14, 11, 10, 3, 4, 5, 8};
        quickSort(array, 0, array.length - 1);
        print(array);
    }

    public static int partition(int start, int end, int[] array) {
        int pivot = array[end];
        int posSmallElement = (start - 1);

        for (int i = start; i <= end - 1; i++) {

            // swap elements
            if (array[i] < pivot) {
                posSmallElement++;
                swap(array, posSmallElement, i);
            }
        }
        swap(array, posSmallElement + 1, end);

        return (posSmallElement + 1);
    }

    public static void quickSort(int[] array, int start, int end) {
        if (start < end) {
            int pivot = partition(start, end, array);
            quickSort(array, start, pivot - 1);
            quickSort(array, pivot + 1, end);
        }
    }

    private static void print(int[] arr) {
        System.out.println();
        System.out.print("[");
        StringBuilder aux = new StringBuilder();
        for (int value : arr) {
            aux.append(value).append(", ");
        }
        System.out.print(aux.substring(0, aux.length() - 2) + "]");
    }

    private static void swap(int[] array, int i, int j) {
        int temp = array[i];
        array[i] = array[j];
        array[j] = temp;
    }
}
