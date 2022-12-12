package util.builder;

import model.flowers.Flowers;

/**
 * Builder interface
 *
 */
public interface Builder {

    void setName(String name);

    void setPrice(double price);

    void setSalesman(String musician);

    void setAge(double duration);

    void reset();

    Flowers makeFlower();
}
