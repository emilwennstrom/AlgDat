package NB14;

import java.util.Arrays;

public class Myntmaskinen {
    static int dynCount;
    static int count;
    private static int[] savedResults;

    public static int scoreCounter(int score) {
        int points = 1;
        int kronor = 0;
        count = 0;
        dynCount = 0;
        savedResults = new int[score * 3];
        Arrays.fill(savedResults, Integer.MAX_VALUE);
        int nonDyn =  scoreCount(score, points, kronor);
        int dyn = scoreCountDynamic(score, points, kronor);
        System.out.println("Regular: " + nonDyn + "kr, anrop: " + count);
        System.out.println("Dynamic: " + dyn + "kr, anrop: " + dynCount);
        return Math.min(dyn, nonDyn);
    }
    private static int scoreCountDynamic(int score, int points, int kronor) {
        dynCount++;
        if (savedResults[points] <= kronor) {
            return savedResults[points];
        }
        if (score == points) {
            return kronor;
        } else if (score < points) {
            return Integer.MAX_VALUE;
        }
        int result = Math.min(scoreCountDynamic(score, points + 4, kronor + 5),
                scoreCountDynamic(score, points * 3, kronor + 10));
        if (savedResults[points] > result) {
            savedResults[points] = result;
        }

        return result;

    }
    private static int scoreCount(int score, int points, int kronor) {
        count++;
        if (score == points) {
            return kronor;
        } else if (score < points) {
            return Integer.MAX_VALUE;
        }
        return Math.min(scoreCount(score, points + 4, kronor + 5), scoreCount(score, points * 3, kronor + 10));
    }
}
