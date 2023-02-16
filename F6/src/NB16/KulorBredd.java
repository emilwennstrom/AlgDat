package NB16;

import java.util.LinkedList;
import java.util.Queue;

public class KulorBredd {

    private static class State {
        public int blue, white, red, noOfSwitches;

        public State(int blue, int white, int red, int noOfSwitches) {
            this.blue = blue;
            this.white = white;
            this.red = red;
            this.noOfSwitches = noOfSwitches;
        }
    }


    public static int beads(int blue, int white, int red) {
        int noOfSwitches = beadSwitching(blue, white, red);
        if (noOfSwitches > 15) return -1;
        else return noOfSwitches;
    }


    private static int beadSwitching(int blue, int white, int red) {
        Queue<State> queue = new LinkedList<>();
        State state = new State(blue, white, red, 0);
        while ((state.blue != state.white) || (state.blue != state.red)) {
            if (state.blue > 0) {
                queue.offer(new State(state.blue - 1, state.white + 1, state.red + 3, state.noOfSwitches + 1));
            }
            if (state.white > 0) {
                queue.offer(new State(state.blue + 2, state.white - 1, state.red + 4, state.noOfSwitches + 1));
            }
            if (state.red > 0) {
                queue.offer(new State(state.blue + 1, state.white + 5, state.red - 1, state.noOfSwitches + 1));
            }
            state = queue.poll();
            assert state != null;
            if (state.noOfSwitches > 15) break;
        }
        return state.noOfSwitches;
    }
}
