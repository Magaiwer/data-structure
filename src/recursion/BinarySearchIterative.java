package recursion;

/**
 * @author Magaiver Santos
 */
public class BinarySearchIterative {

    public static void main(String[] args) {
        int[] orderArray = {10, 20, 24, 33, 36, 44, 59};

        int position = binarySearch(orderArray, 10);
        System.out.println(" position " + position);
        // System.out.println((binarySearch(orderArray, 5) == 5));


    }

    public static int binarySearch(int[] arr, int target) {
        int leftPointer = 0;
        int rightPointer = arr.length - 1;

        while (leftPointer <= rightPointer) {
            int middlePosition = (leftPointer + rightPointer) / 2;
            System.out.println("interation");
            int middleElement = arr[middlePosition];

            if (target == middleElement) {
                return middlePosition;
            }
            if (target > middleElement) {
                leftPointer = middlePosition + 1;
            }
            if (target < middleElement) {
                rightPointer = middlePosition - 1;
            }
        }

        return -1;
    }
}
