package NeetCode.RoadMap;

import java.util.Arrays;
import java.util.PriorityQueue;
import java.util.Stack;

public class DailyTemperatures {
    public static void main(String[] args) {
        System.out.println(Arrays.toString(dailyTemperatures(new int[]{30, 38, 30, 36, 35, 40, 28})));
    }

    //temperatures = [30,38,30,36,35,40,28]
    //               [1,4,1,2,1,0,0]
    public static int[] dailyTemperatures(int[] temperatures) {
        int[] res = new int[temperatures.length];
        Stack<int[]> stack = new Stack<>();

        for (int i = 0; i < temperatures.length; i++) {
            int currTemp = temperatures[i];
            if (stack.isEmpty() || currTemp < stack.peek()[0]) {
                stack.push(new int[]{currTemp, i});
                continue;
            }

            while (!stack.isEmpty() && currTemp > stack.peek()[0]) {
                int[] pop = stack.pop();
                int popIndex = pop[1];
                res[popIndex] = i - popIndex;
            }
            stack.push(new int[]{currTemp, i});
        }

        return res;
    }
}
