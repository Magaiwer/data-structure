package sort;

// Java program for implementation of Selection Sort
class SelectionSort
{
    static void sort(int arr[])
    {
        int n = arr.length;
        // One by one move boundary of unsorted subarray
        int count = 0;
        for (int i = 0; i < n-1; i++)
        {
            printArray(arr);
            // Find the minimum element in unsorted array
            int min_idx = i;
            for (int j = i+1; j < n; j++)
                if (arr[j] < arr[min_idx])
                    min_idx = j;

            // Swap the found minimum element with the first
            // element
            int temp = arr[min_idx];
            arr[min_idx] = arr[i];
            arr[i] = temp;

        }
    }
  
    // Prints the array
    static void printArray(int arr[])
    {
        int n = arr.length;
        for (int i=0; i<n; ++i)
            System.out.print(arr[i]+" ");
        System.out.println();
    }
  
    // Driver code to test above
    public static void main(String args[])
    {
        SelectionSort ob = new SelectionSort();
        int arr[] = {11, 7, 12, 14, 19, 1, 6, 18, 8, 20};
        ob.sort(arr);
        //ob.printArray(arr);
        System.out.println("Sorted array");
    }
}