package sort;

/**
 * @author Magaiver Santos
 */
public class MergeSort {
    public static void main(String args[]) {
        long[] array = {1, 15, 12, 14, 11, 10, 3, 4, 5, 8};
        sort(array, 0, array.length - 1);
        print(array);
    }


    public static void merge(long[] array, int left, int middle, int right) {
        // acha o tamanho dos dois sub-arrays
        int arr1 = middle - left + 1;
        int arr2 = right - middle;

        // cria dois arrays temporarios para a parte da esquerda e direita
        long[] leftArray = new long[arr1];
        long[] rightArray = new long[arr2];

        // copia a primeira metade para o array da esquerda
        if (arr1 >= 0) System.arraycopy(array, left, leftArray, 0, arr1);

        // copia a segunda metade para o array da direita
        for (int i = 0; i < arr2; ++i) {
            rightArray[i] = array[middle + 1 + i];
        }

        // indices inicias para a primeira e segunda metade do array
        int indexArr1 = 0;
        int indexArr2 = 0;
        // indice inicial para o array que vai ser mergeado
        int indexMerged = left;

        while (indexArr1 < arr1 && indexArr2 < arr2) {
            if (leftArray[indexArr1] <= rightArray[indexArr2]) {
                array[indexMerged] = leftArray[indexArr1];
                indexArr1++;
            } else {
                array[indexMerged] = rightArray[indexArr2];
                indexArr2++;
            }
            indexMerged++;
        }

        while (indexArr1 < arr1) {
            array[indexMerged] = leftArray[indexArr1];
            indexArr1++;
            indexMerged++;
        }

        while (indexArr2 < arr2) {
            array[indexMerged] = rightArray[indexArr2];
            indexArr2++;
            indexMerged++;
        }
    }

    public static void sort(long[] array, int left, int right) {
        if (left < right) {
            int middle = left + ((right - left) / 2);

            // ordena a  primeria metade do array
            sort(array, left, middle);
            // ordena a segunda metade do array
            sort(array, middle + 1, right);

            merge(array, left, middle, right);

        }
    }

    private static void print(long[] arr) {
        System.out.println();
        System.out.print("[");
        StringBuilder aux = new StringBuilder();
        for (long value : arr) {
            aux.append(value).append(", ");
        }
        System.out.print(aux.substring(0, aux.length() - 2) + "]");
    }
}
