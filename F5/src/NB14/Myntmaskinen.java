package NB14;

public class Myntmaskinen {
    public static int scoreCounter(int score) {
        int points = 1;
        int kronor = 0;
        return scoreCount(score, points, kronor);
    }
    private static int scoreCount(int score, int points, int kronor) {
        if (score == points) {
            return kronor;
        } else if (score < points) {
            return Integer.MAX_VALUE;
        }

        int noOf10s = scoreCount(score, points * 3, kronor + 10);
        int noOf5s = scoreCount(score, points + 4, kronor + 5);

        if (noOf5s <= noOf10s) {
            return noOf5s;
        } else {
            return noOf10s;
        }
    }
}
