package LeetCode75.Java.ArraysAndStrings;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class KidsWithGreatestNumberOfCandies {

    public static void main(String[] args) {
        System.out.println(kidsWithCandies(new int[]{2,3,5,1,3}, 3));
    }

    public static List<Boolean> kidsWithCandies(int[] candies, int extraCandies) {

        ArrayList<Boolean> result = new ArrayList<>();
        int maxCandies = findMaxNumOfCandies(candies);
        for (int i = 0; i < candies.length; i++) {
            if (candies[i] + extraCandies < maxCandies) {
                result.add(false);
            } else {
                result.add(true);
            }
        }
        return result;
    }

    private static int findMaxNumOfCandies(int[] candies) {
        int[] temp = Arrays.copyOf(candies, candies.length);
        Arrays.sort(temp);
        return temp[temp.length - 1];
    }

}
