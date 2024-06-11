package NeetCode.RoadMap;

public class Search2DMatrix {

    public static void main(String[] args) {
        //int[][] matrix = new int[][]{{1,2,4,8},{10,11,12,13},{14,20,30,40}};
        int[][] matrix = new int[][]{{1}};
        System.out.println(searchMatrix(matrix, 0));
    }
    public static boolean searchMatrix(int[][] matrix, int target) {

        int row = binarySearchRows(matrix, target);
        if (row == - 1) {
            return false;
        } else {
            int res = search(matrix[row], target);
            return res != -1;
        }
    }

    //returns the row that the target is possibly in
    private static int binarySearchRows(int[][] matrix, int target) {

        int left = 0;
        int right = matrix.length - 1;
        int mid = (left + right) / 2;

        while (left >= 0 && right >= 0 && left <= mid) {
            int midLeftNum = matrix[mid][0];
            int midRightNum = matrix[mid][matrix[mid].length -  1];

            if (target >= midLeftNum && target <= midRightNum) {
                return mid;
            } else if (target < midLeftNum) {
                right = mid - 1;
                mid = (left + right) / 2;
            } else {
                left = mid + 1;
                mid = (left + right) / 2;
            }
        }

        return -1;
    }

    public static int search(int[] nums, int target) {
        int left = 0;
        int right = nums.length - 1;
        int mid = (right + left) / 2;

        while (left <= right) {
            int leftNum = nums[left];
            int midNum = nums[mid];
            int rightNum = nums[right];

            if (target > midNum) {
                left = mid + 1;
                mid = (right + left) / 2;
            } else if (target < midNum) {
                right = mid - 1;
                mid = (right + left) / 2;
            } else {
                return mid;
            }
        }

        return -1;
    }
}
