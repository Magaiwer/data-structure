/**
 * @author Magaiver Santos
 */
public class BinarySearch {

    public static void main(String[] args) {
        int[] orderArray = {0, 1, 2, 3, 5, 6, 7, 8};

        int position = binarySearch(orderArray, -1);
        System.out.println( (position == 7) + " position " + position);
       // System.out.println((binarySearch(orderArray, 5) == 5));


    }

    public static int binarySearch(int[] arr, int target) {
        int leftPointer = 0;
        int rightPointer = arr.length -1;
        int middlePosition = (leftPointer + rightPointer) / 2;

        while (arr.length > middlePosition) {
            System.out.println("interation");
            int middleElement = arr[middlePosition];

            if(target == middleElement) {
                return middlePosition;
            }

            if(target < middleElement) {
                rightPointer = middleElement -1;
            }

            if(target > middleElement) {
                leftPointer = middlePosition + 1;
            }

            if(leftPointer > rightPointer) {
                return -1;
            }

            middlePosition = (leftPointer + rightPointer) / 2;
        }


        return -1;
    }
}
