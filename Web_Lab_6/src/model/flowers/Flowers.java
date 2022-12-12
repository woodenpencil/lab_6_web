package model.flowers;

import java.io.Serializable;

/**
 * abstract class which describes songs
 */

public abstract class Flowers implements Serializable {

    /**
     * name of the songs
     */
    protected String name;

    /**
     * getter of name
     *
     * @return name of songs
     */
    public String getName() {
        return name;
    }

    /**
     * years of work in disc
     */
    protected double age;

    /**
     * getter of age
     *
     * @return age of songs
     */
    public double getAge() {
        return age;
    }

    /**
     * monthly price of the songs
     */
    protected double price;

    /**
     * getter of songs price
     *
     * @return songs price
     */
    public double getPrice() {
        return price;
    }

    /**
     * name of the salesman songs works
     */
    protected String salesman;

    /**
     * getter of salesman
     *
     * @return name od salesman songs works
     */
    public String getSalesman() {
        return salesman;
    }

    /**
     * social skills of songs
     */
    protected boolean isSocial;

    /**
     * getter of social skills
     *
     * @return social skills of songs
     */
    public boolean getSociality() {
        return isSocial;
    }

    /**
     * Constructor, creates songs with name, price and dates
     *
     * @param name            name of songs
     * @param price          price of songs
     * @param salesman      salesman name songs works
     * @param age      age of songs
     * @throws IllegalArgumentException if age or price is bellow 0
     */
    protected Flowers(String name, double price, String salesman, double age) {
        if (price <= 0 || age <= 0) {
            throw new IllegalArgumentException();
        }
        this.name = name;
        this.price = price;
        this.salesman = salesman;
        this.age = age;
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj) return true;
        if (obj == null || getClass() != obj.getClass()) return false;

        Flowers flowers = (Flowers) obj;

        return price == flowers.price
                && age == flowers.age
                && name.equals(flowers.name)
                && salesman.equals(flowers.salesman);
    }

    @Override
    public String toString() {
        return String.format("Name: %s\nPrice: %.2f\nSalesman: %s\nAge: %.1f\n", name, price, salesman, age);
    }

    @Override
    public int hashCode() {
        int result = name != null ? name.hashCode() : 0;
        result += salesman != null ? salesman.hashCode() : 0;
        result += 31 * (result + price + age);
        return result;
    }

    /**
     * perform some work
     *
     * @return string of working process
     */
    public abstract String performWork();

}
