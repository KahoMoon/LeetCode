package NeetCode.RoadMap;

import java.util.Arrays;

public class LastStoneWeight {

    public static void main(String[] args) {
        System.out.println(lastStoneWeight(new int[]{2,2}));
    }

    public static int lastStoneWeight(int[] stones) {

        int size = stones.length;
        while (size > 1) {
            Arrays.sort(stones, 0, size);

            int stoneOne = stones[size - 1];
            int stoneTwo = stones[size - 2];

            if (stoneOne == stoneTwo) {
                size -= 2;
            } else {
                int newStone = Math.abs(stoneOne - stoneTwo);
                stones[size - 2] = newStone;
                size -= 1;
            }
        }

        if (size == 0) {
            return size;
        } else {
            return stones[0];
        }
    }

}
