package NeetCode.RoadMap;

public class TrappingRainWater {
    public static void main(String[] args) {
        System.out.println(trap(new int[]{4,2,3}));
    }

    public static int trap(int[] height) {
        if (height.length == 1 || height.length == 2) {
            return 0;
        }

        int totalArea = 0;
        int index = findFirst(height);
        int nextIndex = getNextIndex(height, index);
        for (int i = index; i < height.length; i++) {
            if (index == -1 || nextIndex == -1) {
                break;
            }

            totalArea += getArea(height, index, nextIndex);

            index = nextIndex;
            nextIndex = getNextIndex(height, index);

            while(nextIndex == -1 && index < height.length - 1) {
                index++;
                nextIndex = getNextIndex(height, index);
            }
        }

        return totalArea;
    }

    private static int getArea(int[] height, int leftIndex, int rightIndex) {

        //case 1: when height.length = 1
        if (height.length == 1 || height.length == 2) {
            return 0;
        }

        //case 2: common case
        int leftHeight = height[leftIndex];
        int rightHeight = height[rightIndex];
        int minHeight = Math.min(leftHeight, rightHeight);
        int length = rightIndex - leftIndex - 1;
        int deadSpace = getDeadSpace(height, leftIndex, rightIndex);

        return minHeight * length - deadSpace;
    }

    //non-inclusive
    private static int getDeadSpace(int[] height, int leftIndex, int rightIndex) {
        int res = 0;
        for (int i = leftIndex + 1; i < rightIndex; i++) {
            res += height[i];
        }
        return res;
    }

    private static int getNextIndex(int[] height, int currIndex) {
        int currHeight = height[currIndex];
        for (int i = currIndex + 1; i < height.length; i++) {
            if (height[i] >= currHeight) {
                return i;
            }
        }

        return -1;
    }

    private static int findFirst(int[] height) {
        for (int i = 0; i < height.length; i++) {
            if (height[i] != 0) {
                return i;
            }
        }
        return -1;
    }
}
