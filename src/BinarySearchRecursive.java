/**
 * @author Magaiver Santos
 */
public class BinarySearchRecursive {
    public static void main(String[] args) {
        int[] vector = {1, 2, 3, 4, 5, 6, 7, 8, 9, 10, 11, 12, 13};

        System.out.println(binSearch(vector, 0, vector.length -1, 12));
    }

    public static int binSearch(int[] vector, int left, int right, int target) {
        if (left >= right) {
            return -1;
        }

        System.out.println("passou");
        int middleVector = left + ((right - left) / 2);
        int middleElement = vector[middleVector];

        if (target == middleElement) {
            return middleVector;
        }

        if (target < middleElement) {
            return binSearch(vector, left, middleElement -1, target);
        }

        // target > middleElement
        return binSearch(vector, middleElement + 1, right, target);


    }
}
