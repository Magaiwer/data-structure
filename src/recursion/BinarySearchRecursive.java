package recursion;

/**
 * @author Magaiver Santos
 */
public class BinarySearchRecursive {
    public static void main(String[] args) {
        int[] vector = {10, 20, 24, 33, 36, 44, 59};

        System.out.println(binSearch(vector, 0, vector.length -1, -1));
    }

    public static int binSearch(int[] vector, int left, int right, int target) {
        if (left > right) return -1;
        int middleVector = left + ((right - left) / 2);
        int middleElement = vector[middleVector];

        if (target == middleElement)  return middleVector;

        if (middleElement > target) {
            return binSearch(vector, left, middleVector -1, target);
        }

        // target > middleElement
        return binSearch(vector, middleVector + 1, right, target);
    }
}
