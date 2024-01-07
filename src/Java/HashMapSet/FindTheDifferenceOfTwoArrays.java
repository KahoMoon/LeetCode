package Java.HashMapSet;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;

public class FindTheDifferenceOfTwoArrays {
    public static void main(String[] args) {

    }

    public static List<List<Integer>> findDifference(int[] nums1, int[] nums2) {
        List<List<Integer>> res = new ArrayList<>();
        HashSet<Integer> setOne = new HashSet<>();
        for (int i : nums1) {
            setOne.add(i);
        }

        HashSet<Integer> setTwo = new HashSet<>();
        for (int i : nums2) {
            setTwo.add(i);
        }

        List<Integer> one = new ArrayList<>();
        for (int i : nums1) {
            if (!setTwo.contains(i) && !one.contains(i)) {
                one.add(i);
            }
        }

        List<Integer> two = new ArrayList<>();
        for (int i : nums2) {
            if (!setOne.contains(i) && !two.contains(i)) {
                two.add(i);
            }
        }

        res.add(one);
        res.add(two);
        return res;
    }
}
