package model.flowers.common;

import model.flowers.Flowers;

/**
 * abstract class of financial job
 *
 */
public abstract class AbstractCommon extends Flowers {

    /**
     * monthly reposts amount
     */
    protected int repostsAmount;

    /**
     * getter of reposts amount
     *
     * @return amount of monthly reposts
     */
    public int getReportsAmount() {
        return repostsAmount;
    }

    /**
     * Constructor, creates songs with name, price and age
     *
     * @param name          name of songs
     * @param price        price of songs
     * @param age    age of songs
     * @param salesman    salesman name
     * @param repostsAmount monthly amount of reposts
     * @throws IllegalArgumentException if age or price is bellow 0
     */
    protected AbstractCommon(String name, double price, String musician, double duration, int repostsAmount) {
        super(name, price, musician, duration);
        if (duration < 0 || price < 0)
            throw new IllegalArgumentException();
        this.repostsAmount = repostsAmount;
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj) return true;
        if (obj == null || getClass() != obj.getClass()) return false;


        Flowers flowers = (Flowers) obj;
        AbstractCommon finantialJob = (AbstractCommon) obj;

        return (finantialJob.repostsAmount == this.repostsAmount)
                && flowers.equals(this);
    }
/*
    @Override
    public String toString() {
        String stringFromSuper = super.toString();
        return String.format("%sMonthly reposts amount: %d\n", stringFromSuper, repostsAmount);
    }
*/
    @Override
    public int hashCode() {
        int hashCodeFromSuper = super.hashCode();
        return hashCodeFromSuper + repostsAmount * 13;
    }

}
