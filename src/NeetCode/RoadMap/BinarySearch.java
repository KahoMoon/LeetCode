package NeetCode.RoadMap;

public class BinarySearch {
    public static void main(String[] args) {
        System.out.println(search(new int[]{-1,0,2,4,6,8}, 3));
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
