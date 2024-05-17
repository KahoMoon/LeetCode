package LeetCode75.Java.HashMapSet;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;

public class UniqueNumberOfOccurrences {
    public static void main(String[] args) {
        int[] arr = {1,2,2,1,1,3};
        System.out.println(uniqueOccurrences(arr));
    }
    public static boolean uniqueOccurrences(int[] arr) {
        HashMap<Integer, Integer> occurrenceValue = new HashMap<>();
        for (int i : arr) {
            if (occurrenceValue.containsKey(i)) {
                occurrenceValue.replace(i, occurrenceValue.get(i) + 1);
            } else {
                occurrenceValue.put(i, 1);
            }
        }

        HashSet<Integer> unique = new HashSet<>();
        for (Map.Entry<Integer, Integer> entry : occurrenceValue.entrySet()) {
            int key = entry.getKey();
            int val = entry.getValue();
            if (unique.contains(val)) {
                return false;
            } else {
                unique.add(val);
            }
        }

        return true;
    }
}
