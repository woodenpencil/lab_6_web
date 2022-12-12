package util.comparator;

import java.util.Comparator;

import model.flowers.Flowers;


/**
 * Comparator class of songs by work age in disc
 *
 */
public class FlowerComparator implements Comparator<Flowers> {

    @Override
    public int compare(Flowers st1, Flowers st2) {
        return Double.compare(st1.getAge(), st2.getAge());
    }

}
