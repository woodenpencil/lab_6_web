package util.builder;

import model.flowers.Flowers;
import model.flowers.common.Orange;
import model.flowers.common.Purple;
import model.flowers.rare.Red;
import model.flowers.rare.White;
import model.flowers.rare.Blue;

/**
 * Flowers builder class that manage employees
 *
 */
public class FlowerBuilder implements Builder {

    /**
     * songs name
     */
    private String name;

    /**
     * songs price
     */
    private Double price;

    /**
     * songs work age
     */
    private Double age;

    /**
     * salesman songs works in
     */
    private String salesman;

    /**
     * set name
     */
    @Override
    public void setName(String name) {
        this.name = name;
    }

    /**
     * set price
     */
    @Override
    public void setPrice(double price) {
        this.price = price;
    }

    /**
     * set age
     */
    @Override
    public void setAge(double duration) {
        this.age = duration;
    }

    /**
     * set salesman
     */
    @Override
    public void setSalesman(String musician) {
        this.salesman = musician;
    }


    /**
     * make all fields as null
     */
    @Override
    public void reset() {
        name = null;
        price = null;
        age = null;
        salesman = null;
    }

    /**
     * make new employee
     *
     * @return disc employee with configured fields
     * @throws IllegalArgumentException if some field doesn't set
     */
    @Override
    public Flowers makeFlower() {
        if (name == null
                || price == null
                || age == null) {
            throw new IllegalArgumentException();
        }
        else if(name == "Rose") {
            return new Red(name, price, salesman, age, 0, 0);
        }
        else {
        	return new Orange(name, price, salesman, age, 0, 0);   
        }
    }
}
