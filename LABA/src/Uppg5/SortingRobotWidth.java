package Uppg5;

import java.util.HashSet;
import java.util.LinkedList;
import java.util.Queue;

public class SortingRobotWidth {

    private static int breadth = 0;
    private static int dyna = 0;
    private static HashSet<String> hashSet;
    private static class State {
        char c1, c2, c3, c4, c5;
        String order;


        private State(char c1, char c2, char c3, char c4, char c5, String order) {
            this.c1 = c1;
            this.c2 = c2;
            this.c3 = c3;
            this.c4 = c4;
            this.c5 = c5;
            this.order = order;
        }
        private String stateString() {
            return String.valueOf(c1) + c2 + c3 + c4 + c5;
        }

    }

    public static String sortBoxes(String start) {
        hashSet = new HashSet<>();
        State beginningState = new State(start.charAt(0), start.charAt(1), start.charAt(2), start.charAt(3), start.charAt(4), "");
        if (checkState(beginningState)) return "Nothing to sort";
        System.out.println("Regular: " + sortBoxes(beginningState) + ", loops: " + breadth);
        System.out.println("Dynamic: " + sortBoxesDynamic(beginningState) + ", loops: " + dyna);
        return "";
    }

    private static String sortBoxes(State state) {
        Queue<State> queue = new LinkedList<>();
        breadth = 0;
        while (!checkState(state)) {
            breadth++;
            State b = new State(state.c2, state.c1, state.c3, state.c4, state.c5, state.order + "b");
            State s = new State(state.c5, state.c1, state.c2, state.c3, state.c4, state.order + "s");
            queue.offer(b);
            queue.offer(s);
            state = queue.poll();
            if (state == null) return "Queue is empty";
        }
        return state.order;
    }

    private static String sortBoxesDynamic(State state) {
        Queue<State> queue = new LinkedList<>();
        dyna = 0;
        while (!checkState(state)) {
            dyna++;
            State b = new State(state.c2, state.c1, state.c3, state.c4, state.c5, state.order + "b");
            State s = new State(state.c5, state.c1, state.c2, state.c3, state.c4, state.order + "s");
            if (hashSet.add(b.stateString())) {
                queue.offer(b);
            }
            if (hashSet.add(s.stateString())) {
                queue.offer(s);
            }
            state = queue.poll();
            if (state == null) return "Queue is empty";
        }
        return state.order;
    }

    private static boolean checkState(State state) {
        char[] solvedPositions = {'A', 'B', 'C', 'D', 'E'};
        return  state.c1 == solvedPositions[0] &&
                state.c2 == solvedPositions[1] &&
                state.c3 == solvedPositions[2] &&
                state.c4 == solvedPositions[3] &&
                state.c5 == solvedPositions[4];
    }


}
