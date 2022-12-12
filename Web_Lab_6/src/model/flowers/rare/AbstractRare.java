package model.flowers.rare;

import model.flowers.Flowers;

/**
 * abstract class of old music
 */
public abstract class AbstractRare extends Flowers {

    /**
     * number of worked likes
     */
    protected int likesAmount;

    /**
     * getter of worked likes
     */
    public int getShiftsAmount() {
        return likesAmount;
    }


    /**
     * Constructor, creates songs with name, price, age and salesman
     *
     * @param name         name of songs
     * @param price       price of songs
     * @param age   age of songs
     * @param salesman   salesman of songs
     * @param likesAmount amount of worked likes
     * @throws IllegalArgumentException if price, age or shiftAmount is below 0
     */
    protected AbstractRare(String name, double price, String musician, double duration, int likesAmount) {
        super(name, price, musician, duration);
        if(price < 0 || duration < 0 || likesAmount < 0) {
            throw new IllegalArgumentException();
        }
        this.likesAmount = likesAmount;
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj) return true;
        if (obj == null || getClass() != obj.getClass()) return false;


        Flowers flowers = (Flowers) obj;
        AbstractRare abstractRare = (AbstractRare) obj;

        return (abstractRare.likesAmount == this.likesAmount)
                && flowers.equals(this);
    }
/*
    @Override
    public String toString() {
        String stringFromSuper = super.toString();
        return String.format("%sMonthly worked likes amount: %d\n", stringFromSuper, likesAmount);
    }
*/
    @Override
    public int hashCode() {
        int hashCodeFromSuper = super.hashCode();
        return hashCodeFromSuper + likesAmount * 31;
    }

}
