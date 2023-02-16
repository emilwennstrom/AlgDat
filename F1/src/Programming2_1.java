import java.util.ArrayList;

public class Programming2_1 {



    public static void replace(ArrayList<String> aList, String oldItem, String newItem) {

        for (int i = 0; i < aList.size(); i++) {
            if (oldItem.compareTo(aList.get(i)) == 0) {
                aList.set(i, newItem);
            }
        }


    }








}
