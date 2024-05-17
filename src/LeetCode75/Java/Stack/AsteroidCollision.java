package LeetCode75.Java.Stack;

import java.util.Arrays;
import java.util.Stack;

public class AsteroidCollision {
    public static void main(String[] args) {
        int[] asteroids = {8,-8};
        System.out.println(Arrays.toString(asteroidCollision(asteroids)));
    }

    public static int[] asteroidCollision(int[] asteroids) {
        Stack<Integer> res = new Stack<>();
        for (int i : asteroids) {
            if (res.isEmpty()) {
                res.push(i);
                continue;
            }

            if (Math.signum(i) == 1) {
                res.push(i);
            } else if (Math.signum(i) == -1){
                int peek = res.peek();
                if (Math.signum(peek) == 1) {
                    if (Math.abs(peek) < Math.abs(i)) {
                        res.pop();
                        res.push(i);
                    }
                } else {
                    res.push(i);
                }
            } else {
                res.pop();
            }
        }

        int[] resArr = new int[res.size()];
        for (int i = 0; i < res.size(); i++) {
            resArr[i] = res.get(i);
        }

        return resArr;
    }
}
