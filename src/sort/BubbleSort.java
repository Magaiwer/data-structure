package sort;

/**
 * @author Magaiver Santos
 */
public class BubbleSort {

    public static void main(String[] args) {
        int[] vector = {1, 15, 12, 14, 11, 10, 3, 4, 5, 8};
        print(vector);
        bubbleSort(vector);
        print(vector);
    }
    int[] vector = {1, 15, 12, 14, 11, 10, 3, 4, 5, 8};
    private static void bubbleSort(int[] arr) {
        int n = arr.length; //Tamnaho do array
        for (int i = 0; i < n - 1; i++)
            for (int j = 0; j < n - i - 1; j++)  // percorre o vetor agrupando pares da esquerda para a direita
                if (arr[j] > arr[j + 1]) { // testa se o valor na posição da esquerda é maior que o da direita
                    int temp = arr[j];  // armazena o valor da posição da esquerda em uma variavel temporaria
                    arr[j] = arr[j + 1]; // passa o valor da direita para a posição da esquerda
                    arr[j + 1] = temp;   // passa o valor que estava na esquerda para a direita
                }


/*        int count = 0;
        while (count < 3) {
            for (int i = 0; i < arr.length - 1; i++) {
                if (arr[i] > arr[i + 1]) {
                    int aux = arr[i];
                    arr[i] = arr[i + 1];
                    arr[i + 1] = aux;
                    print(arr);
                }
            }
            count++;
        }*/
    }

    private static void print(int[] arr) {
        System.out.println();
        System.out.print("[");
        String aux = "";
        for (int value : arr) {
            aux += value + ", ";
        }
        System.out.print(aux.substring(0, aux.length() - 2) + "]");
    }
}



