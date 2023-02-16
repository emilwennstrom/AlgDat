package NB141;

public class Kulor {

    public static int beads(int blue, int white, int red) {
        if (red == 0 && blue == 0 && white == 0) return -1;
        int noOfSwitches = 0;
        return beadSwitching(blue, white, red, noOfSwitches);
    }

    public static int beadSwitching(int blue, int white, int red, int noOfSwitches) {
        if (red == blue && blue == white) {
            return noOfSwitches;
        }
        if (noOfSwitches == 15) {
            return Integer.MAX_VALUE;
        } else {
            int blueSwitches = Integer.MAX_VALUE;
            int whiteSwitches = Integer.MAX_VALUE;
            int redSwitches = Integer.MAX_VALUE;
            if (blue > 0)
                blueSwitches = beadSwitching(blue - 1, white + 1, red + 3, noOfSwitches + 1 );
            if (white > 0)
                whiteSwitches = beadSwitching(blue + 2, white - 1, red + 4, noOfSwitches + 1);
            if (red > 0)
                redSwitches = beadSwitching(blue + 1, white + 5, red - 1, noOfSwitches + 1);
            return Math.min(Math.min(blueSwitches, whiteSwitches), redSwitches);
        }
    }
}

