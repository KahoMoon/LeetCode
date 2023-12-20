package Java.TwoPointers;

public class ContainerWithMostWater {
    public static void main(String[] args) {
        int[] height = {1,8,6,2,5,4,8,3,7};
        System.out.println(maxArea(height));
    }

    public static int maxArea(int[] height) {
        int leftIndex = 0;
        int rightIndex = height.length - 1;

        int maxArea = Integer.MIN_VALUE;
        while (true) {
            if (leftIndex >= rightIndex) {
                break;
            }

            int tempArea = calculateAmountOfWater(leftIndex, rightIndex, height);
            if (tempArea > maxArea) {
                maxArea = tempArea;
            }

            int leftHeight = height[leftIndex];
            int rightHeight = height[rightIndex];
            if (leftHeight < rightHeight) {
                leftIndex++;
            } else if (leftHeight > rightHeight) {
                rightIndex--;
            } else {
                leftIndex++;
                rightIndex--;
            }
        }

        return maxArea;
    }

    private static int calculateAmountOfWater(int left, int right, int[] height) {
        return Math.min(height[left], height[right]) * (right - left);
    }
}
