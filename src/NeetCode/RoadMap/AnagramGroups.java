package NeetCode.RoadMap;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;

public class AnagramGroups {
    public static void main(String[] args) {
        System.out.println(groupAnagrams(new String[]{"act","pots","tops","cat","stop","hat"}));
        //isAnagram("pots", "tops");
    }
    public static List<List<String>> groupAnagrams(String[] strs) {
        List<List<String>> list = new ArrayList<>();
        for (String s : strs) {
            helper(s, list);
        }

        return list;
    }

    private static void helper(String s, List<List<String>> list) {
        if (list.isEmpty()) {
            List<String> test = new ArrayList<>();
            test.add(s);
            list.add(test);

            return;
        }
        for (int i = 0; i < list.size(); i++) {
            List<String> l = list.get(i);
            if (isAnagram(s, l.get(0))) {
                l.add(s);
            } else {
                List<String> test = new ArrayList<>();
                test.add(s);
                list.add(test);
                return;
            }
        }

    }

    private static boolean isAnagram(String a, String b) {
        HashSet<Character> set = new HashSet<>();

        if (a.length() != b.length()) {
            return false;
        }

        for (char c : a.toCharArray()) {
            set.add(c);
        }

        for (char c : b.toCharArray()) {
            if (!set.contains(c)) {
                return false;
            }
        }

        return true;
    }
}
