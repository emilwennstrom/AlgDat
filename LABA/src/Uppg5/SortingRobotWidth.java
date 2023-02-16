package Uppg5;

import java.util.LinkedList;
import java.util.Queue;

public class SortingRobotWidth {


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
    }

    public static String sortBoxes(String start) {
        State beginningState = new State(start.charAt(0), start.charAt(1), start.charAt(2), start.charAt(3), start.charAt(4), "");
        if (checkState(beginningState)) return "Nothing to sort";
        return sortBoxes(beginningState);
    }

    private static String sortBoxes(State state) {
        Queue<State> queue = new LinkedList<>();
        while (!checkState(state)) {
            queue.offer(new State(state.c2, state.c1, state.c3, state.c4, state.c5, state.order + "b"));
            queue.offer(new State(state.c5, state.c1, state.c2, state.c3, state.c4, state.order + "s"));
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
