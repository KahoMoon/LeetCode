package Java.PrefixSum;

import java.util.Arrays;

public class FindTheHighestAltitude {
    public static void main(String[] args) {
        int[] gain = {-4,-3,-2,-1,4,3,2};
        System.out.println(largestAltitude(gain));
    }

    public static int largestAltitude(int[] gain) {
        int altitude = 0;
        int[] altitudes = new int[gain.length];
        for (int i = 0; i < gain.length; i++) {
            altitudes[i] = altitude + gain[i];
            altitude += gain[i];
        }

        Arrays.sort(altitudes);
        return Math.max(0, altitudes[altitudes.length - 1]);
    }
}
