package Uppg5;

public class SortingRobotDepth {

    static final private String LongString = "FFF";
    static final private int MAXDEPTH = 15;
    private static String shortestSolution;

    public static String sortBoxes(String startValues) {
        char[] boxes = new char[]{startValues.charAt(0), startValues.charAt(1), startValues.charAt(2), startValues.charAt(3), startValues.charAt(4)};
        shortestSolution = "";
        if (checkPositions(boxes)) {
            return "Nothing to sort";
        }
        String order = "";
        //sortBoxes(boxes, order);
        System.out.println("sortBoxes2: " + sortBoxes2(boxes,0));
        return shortestSolution;
    }

    private static void sortBoxes(char[] boxes, String order) {
        if (order.length() == MAXDEPTH)
            return;
        if (checkPositions(boxes)) {
            if (shortestSolution.equals("") || shortestSolution.length() > order.length())
                shortestSolution = order;
            return;
        }
        switchLeftBoxes(boxes);
        sortBoxes(boxes, order + "b");
        switchLeftBoxes(boxes);

        moveRightBoxLeft(boxes);
        sortBoxes(boxes, order + "s");
        moveRightBoxBack(boxes);
    }

    private static String sortBoxes2(char[] boxes, int currentDepth) {
        if (currentDepth == MAXDEPTH)
            return LongString;
        if (checkPositions(boxes))
            return "";

        switchLeftBoxes(boxes);
        String b = sortBoxes2(boxes, currentDepth + 1) + "b";
        switchLeftBoxes(boxes);

        moveRightBoxLeft(boxes);
        String s = sortBoxes2(boxes, currentDepth + 1) + "s";
        moveRightBoxBack(boxes);
        return b.length() < s.length() ? b : s;
    }


    private static void moveRightBoxLeft(char[] boxes) {
        char tmp = boxes[boxes.length - 1];
        for (int i = boxes.length - 1; i >= 1; i--) {
            boxes[i] = boxes[i - 1];
        }
        boxes[0] = tmp;
    }

    private static void moveRightBoxBack(char[] boxes) {
        char tmp = boxes[0];
        for (int i = 0; i < boxes.length - 1; i++) {
            boxes[i] = boxes[i + 1];
        }
        boxes[boxes.length - 1] = tmp;
    }

    private static void switchLeftBoxes(char[] boxes) {
        char tmp = boxes[1];
        boxes[1] = boxes[0];
        boxes[0] = tmp;
    }


    private static boolean checkPositions(char[] boxes) {
        char[] solvedPositions = {'A', 'B', 'C', 'D', 'E'};
        for (int i = 0; i < boxes.length; i++) {
            if (boxes[i] != solvedPositions[i]) {
                return false;
            }
        }
        return true;
    }

}
