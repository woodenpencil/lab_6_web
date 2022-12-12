package util.manager;

import util.builder.Builder;

import java.util.Random;

import model.flowers.Flowers;

/**
 * manager that provides creating new songs
 */
public class FlowerManager {

    private Random random = new Random();

    /**
     * provide accountant creating
     *
     * @param builder    to make some songs
     * @param name       name of songs
     * @param salesman salesman name
     */
    public Flowers buildFlower(Builder builder, String name, String salesman) {
        builder.setName(name);
        builder.setPrice((random.nextDouble() % 1500)*100);
        builder.setAge((random.nextDouble() % 10)*10);
        builder.setSalesman(salesman);
        return builder.makeFlower();
    }
}
