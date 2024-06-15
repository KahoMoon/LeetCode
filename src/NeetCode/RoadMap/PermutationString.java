package NeetCode.RoadMap;

import java.util.HashMap;
import java.util.Map;

public class PermutationString {

    public static void main(String[] args) {
        System.out.println(checkInclusion("hello", "ooolleoooleh"));
    }

    //repetitions not allowed in permutations, so need to account for number of appearances for each char. need map instead of set.
    public static boolean checkInclusion(String s1, String s2) {
        final Map<Character, Integer> map = new HashMap<>();
        for (char c : s1.toCharArray()) {
            if (map.containsKey(c)) {
                map.put(c, map.get(c) + 1);
            } else {
                map.put(c, 1);
            }
        }
        Map<Character, Integer> copy = new HashMap<>(map);

        for (int left = 0, right = map.size(); left < s2.length() && right <= s2.length(); left++, right++) {
            char c = s2.charAt(left);
            if (copy.containsKey(c)) {
                for (int i = left; i < right; i++) {
                    char temp = s2.charAt(i);
                    if (!copy.containsKey(temp)) {
                        copy = new HashMap<>(map);
                        break;
                    } else {
                        if (map.get(c) > 1) {
                            map.put(c, map.get(c) - 1);
                        } else {
                            copy.remove(temp);
                        }
                        if (copy.isEmpty()) {
                            return true;
                        }
                    }
                }
            }
        }


        return false;
    }
}
