package Java.Stack;

import java.util.Arrays;
import java.util.Stack;

public class AsteroidCollision {
    public static void main(String[] args) {
        int[] asteroids = {-2,-2,1,-2};
        System.out.println(Arrays.toString(asteroidCollision(asteroids)));
    }

    public static int[] asteroidCollision(int[] asteroids) {
        Stack<Integer> res = new Stack<>();
        for (int i : asteroids) {
            if (res.isEmpty() || Integer.signum(res.peek()) == Integer.signum(i)) {
                res.push(i);
            } else {
                if (Integer.signum(res.peek()) == 1 && Integer.signum(i) == -1) {
                    if (Math.abs(res.peek()) == Math.abs(i)) {
                        res.pop();
                    } else if (Math.abs(res.peek()) < Math.abs(i)) {
                        res.pop();
                    }
                } else {
                    res.push(i);
                }
            }
        }

        int[] resArr = new int[res.size()];
        for (int i = 0; i < res.size(); i++) {
            resArr[i] = res.get(i);
        }

        return resArr;
    }
}
