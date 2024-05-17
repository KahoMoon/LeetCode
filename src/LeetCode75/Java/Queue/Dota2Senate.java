package LeetCode75.Java.Queue;

import java.util.LinkedList;
import java.util.Queue;

public class Dota2Senate {
    public static void main(String[] args) {

    }

    public static String predictPartyVictory(String senate) {
        Queue<Integer> radiantQ = new LinkedList<>();
        Queue<Integer> direQ = new LinkedList<>();

        for (int i = 0; i < senate.length(); i++) {
            char c = senate.charAt(i);
            if (c == 'R') {
                radiantQ.add(i);
            } else {
                direQ.add(i);
            }
        }

        while (!radiantQ.isEmpty() && !direQ.isEmpty()) {
            int radiantIndex = radiantQ.poll();
            int direIndex = direQ.poll();

            if (radiantIndex < direIndex) {
                radiantQ.add(radiantIndex + senate.length());
            } else {
                direQ.add(direIndex + senate.length());
            }
        }

        return (radiantQ.size() > direQ.size()) ? "Radiant" : "Dire";
    }
}
