package NeetCode.RoadMap;

import java.util.Arrays;
import java.util.Comparator;
import java.util.PriorityQueue;

import static java.lang.Math.sqrt;

public class KClosestPointsToOrigin {
    public static void main(String[] args) {
        System.out.println(Arrays.deepToString(kClosest(new int[][]{{0, 2}, {2,0}, {2,2}}, 2)));
    }

    public static int[][] kClosest(int[][] points, int k) {
        PriorityQueue<Integer> q = new PriorityQueue<>(new Comparator<Integer>() {
            @Override
            public int compare(Integer o1, Integer o2) {
                double distanceOne = findDistanceFromOrigin(points[o1]);
                double distanceTwo = findDistanceFromOrigin(points[o2]);
                int res = Double.compare(distanceOne, distanceTwo);

                return res;
            }
        });

        for (int i = 0; i < points.length; i++) {
            q.offer(i);
        }

        System.out.println(q);

        int[][] res = new int[k][];
        for (int i = 0; i < k; i++) {
            res[i] = points[q.poll()];
        }

        return res;
    }

    private static double findDistanceFromOrigin(int[] point) {
        int x = point[0];
        int y = point[1];

        return Math.sqrt(Math.pow(x, 2) + Math.pow(y, 2));
    }
}
