import java.io.*;
import java.util.ArrayList;
import java.util.List;

/**
 * @author Magaiver Santos
 */
public class BatchSort {

    public static void main(String[] args) {
        createFileOrdered("numbers-1.txt", "partial-1.txt");
        createFileOrdered("numbers-2.txt", "partial-2.txt");
        mergeFileContent("partial-1.txt", "partial-2.txt", "sorted.txt");
    }

    private static void mergeFileContent(String input1, String input2, String output) {
        SimpleReader reader = new SimpleReader(input1);
        SimpleWriter writer = new SimpleWriter(output);

        List<String> partial1 = reader.fileToStringList(null);
        reader = new SimpleReader(input2);
        partial1 = reader.fileToStringList(partial1);

        long[] arrayToSorted = partial1.stream()
                .mapToLong(Long::parseLong)
                .toArray();

        MergeSort.sort(arrayToSorted, 0, arrayToSorted.length - 1);
        writer.writeNumbersToText(arrayToSorted);
    }

    private static void createFileOrdered(String fileInput, String fileOutput) {
        SimpleReader reader = new SimpleReader(fileInput);
        SimpleWriter writer = new SimpleWriter(fileOutput);
        QuickSort sort = new QuickSort();

        // recupera os numeros do arquivo txt
        List<String> partial = reader.fileToStringList(null);
        reader.close();

        // converte os valores da lista para um array de inteiros
        long[] arraySorted = partial.stream()
                .mapToLong(Long::parseLong)
                .toArray();

        // ordena o array de numeros
        sort.quickSort(arraySorted, 0, partial.size() - 1);
        writer.writeNumbersToText(arraySorted);
        writer.close();
    }

    // File reader
    public static class SimpleReader {
        private BufferedReader bufferedReader;

        public SimpleReader(String filename) {
            try {
                FileReader fileReader = new FileReader(filename);
                bufferedReader = new BufferedReader(fileReader);
            } catch (FileNotFoundException e) {
                System.err.println("Input file not found: " + filename);
            }
        }

        public String readLine() {
            try {
                if (bufferedReader != null) {
                    return bufferedReader.readLine();
                }
            } catch (IOException e) {
                System.err.println("Error reading file");
            }
            return null;
        }

        public List<String> fileToStringList(List<String> stringList) {
            if (stringList == null) {
                stringList = new ArrayList<>();
            }
            String line = this.readLine();

            while (line != null) {
                stringList.add(line);
                line = this.readLine();
            }
            this.close();
            return stringList;
        }

        public void close() {
            try {
                if (bufferedReader != null) {
                    bufferedReader.close();
                }
            } catch (IOException e) {
                System.err.println("Error closing file");
            }
            bufferedReader = null;
        }
    }

    // File writer
    public static class SimpleWriter {
        private BufferedWriter bufferedWriter;

        public SimpleWriter(String filename) {
            try {
                FileWriter fileWriter = new FileWriter(filename);
                bufferedWriter = new BufferedWriter(fileWriter);
            } catch (IOException e) {
                System.err.println("Output file cannot be written to: " + filename);
            }
        }

        public void write(String line) {
            try {
                if (bufferedWriter != null) {
                    bufferedWriter.write(line + "\n");
                }
            } catch (IOException e) {
                System.err.println("Error writing file");
            }
        }

        public void writeNumbersToText(long[] numbers) {
            for (long number : numbers) {
                this.write(String.valueOf(number));
            }
            this.close();
        }

        public void close() {
            try {
                if (bufferedWriter != null) {
                    bufferedWriter.close();
                }
            } catch (IOException e) {
                System.err.println("Error closing file");
            }
            bufferedWriter = null;
        }
    }

    // Quick sort
    public static class QuickSort {

        private void swap(long[] array, int i, int j) {
            long temp = array[i];
            array[i] = array[j];
            array[j] = temp;
        }

        public int partition(int start, int end, long[] array) {
            long pivot = array[end];
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

        public void quickSort(long[] array, int start, int end) {
            if (start < end) {
                int pivot = partition(start, end, array);
                quickSort(array, start, pivot - 1);
                quickSort(array, pivot + 1, end);
            }
        }
    }

    public static class MergeSort {
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
    }
}


