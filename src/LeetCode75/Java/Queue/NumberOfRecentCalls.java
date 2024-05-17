package LeetCode75.Java.Queue;

import java.util.Deque;
import java.util.LinkedList;

public class NumberOfRecentCalls {
    public static void main(String[] args) {
        RecentCounter test = new RecentCounter();
        System.out.println(test.ping(1));
        System.out.println(test.ping(100));
        System.out.println(test.ping(3001));
        System.out.println(test.ping(3002));
    }

    static class RecentCounter {

        Deque<Integer> counter;
        public RecentCounter() {
            counter = new LinkedList<>();
        }

        public int ping(int t) {
            while (!counter.isEmpty() && t - counter.getFirst() > 3000) {
                counter.removeFirst();
            }
            counter.add(t);

            return counter.size();
        }

    }

}
