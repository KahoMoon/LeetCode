package Java.DFSGraphs;

import java.util.*;

public class KeysAndRooms {
    public static void main(String[] args) {
//        List<Integer> first = new ArrayList<>();
//        first.add(1);
//        first.add(3);
//        List<Integer> second = new ArrayList<>();
//        second.add(3);
//        second.add(0);
//        second.add(1);
//        List<Integer> third = new ArrayList<>();
//        third.add(2);
//        List<Integer> fourth = new ArrayList<>();
//        fourth.add(0);
//        List<List<Integer>> rooms = new ArrayList<>();
//        rooms.add(first);
//        rooms.add(second);
//        rooms.add(third);
//        rooms.add(fourth);
//        canVisitALlRooms(rooms);

        List<Integer> first = new ArrayList<>();
        first.add(1);
        List<Integer> second = new ArrayList<>();
        second.add(1);
        List<List<Integer>> rooms = new ArrayList<>();
        rooms.add(first);
        rooms.add(second);
        System.out.println(canVisitALlRooms(rooms));
    }

    public static boolean canVisitALlRooms(List<List<Integer>> rooms) {

        if (rooms.size() == 0) {
            return true;
        }

        Set<Integer> visited = new HashSet<>();
        Stack<Integer> stack = new Stack<>();
        stack.addAll(rooms.get(0));
        visited.add(0);
        while (!stack.isEmpty()) {
            int curr;
            try {
                curr = stack.pop();
                while(visited.contains(curr)) {
                    curr = stack.pop();
                }
            } catch (Exception e) {
                return visited.size() == rooms.size();
            }
            visited.add(curr);
            stack.addAll(rooms.get(curr));
        }

        System.out.println(visited);
        return visited.size() == rooms.size();
    }
}
