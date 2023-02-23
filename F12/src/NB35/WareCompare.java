package NB35;

import java.util.Comparator;

public class WareCompare implements Comparator<Ware> {

    @Override
    public int compare(Ware o1, Ware o2) {
        return Double.compare(o2.getRatio(), o1.getRatio());
    }
}
