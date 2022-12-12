package model.bouquet;

import util.comparator.FlowerComparator;

import java.util.Comparator;
import java.util.List;
import java.util.ArrayList;
import java.util.stream.Collectors;

import model.flowers.Flowers;

/**
 * this is disc director that controls the disc
 *
 */
public class BouquetManager {

    /**
     * count total amount of song in disc
     *
     * @param flowers list of disc song
     * @return totalSongsAmount total amount of song in disc
     */
    public int countTotalFlowersAmount(List<Flowers> flowers) {
        return flowers.size();
    }

    /**
     * select song with certain age
     *
     * @param flowers song list
     * @param minDur minimal years of work
     * @param maxDur maximum years of work
     * @return songList list of song with appropriate age
     */
    public List<Flowers> selectFlowersByDuration(List<Flowers> flowers, Double minDur, Double maxDur) {
        ArrayList<Flowers> flowerList = new ArrayList<>();
        for (Flowers flower :
                flowers) {
            if(flower.getAge() <= maxDur
                    && flower.getAge() >= minDur) {
                flowerList.add(flower);
            }
        }
        return flowerList;
    }

    /**
     * select song from certain salesman
     *
     * @param flowers song list
     * @param salesman name of the required salesman
     * @return songList list of song with appropriate salesman name
     */
    public List<Flowers> selectFlowersBySalesman(List<Flowers> flowers, String salesman) {
        ArrayList<Flowers> flowerList = new ArrayList<>();
        for (Flowers flower :
                flowers) {
            if(flower.getSalesman().equals(salesman)) {
                flowerList.add(flower);
            }
        }
        return flowerList;
    }

    /**
     * select specific song of disc
     *
     * @param flowers list of song
     * @param age maximum years of work in disc
     * @param salesman name of salesman song work
     * @return songList required song list
     */
    public List<Flowers> selectSpecificFlowers(List<Flowers> flowers, Double age, String salesman) {
        ArrayList<Flowers> flowerList = new ArrayList<>();
        for (Flowers flower :
                flowers) {
            if((flower.getAge() <= age) && (flower.getSalesman().equals(salesman))) {
                flowerList.add(flower);
            }
        }
        return flowerList;
    }

    /**
     * sort song by work age in disc
     *
     * @param flowers song list of disc
     * @param isReversed is list should be sorted in reversed order
     * @return sorted song list
     */
    public List<Flowers> sortFlowersByAge(List<Flowers> flowers, boolean isReversed) {
        Comparator<Flowers> durComparator = new FlowerComparator();
        if(isReversed) {
            durComparator = durComparator.reversed();
        }
        return flowers.stream()
                .sorted(durComparator)
                .collect(Collectors.toList());
    }
}