package model.flowers.rare;

/**
 * Class of foreman
 *
 */
public class Red extends AbstractRare {

    /**
     * number of lovers
     */
    protected int loversAmount;

    /**
     * getter of lovers number
     */
    public int getSubordinatedAmount() {
        return loversAmount;
    }


    /**
     * Constructor, creates songs with name, price, age and salesman
     *
     * @param name               name of songs
     * @param price             price of songs
     * @param age         age of songs
     * @param salesman         salesman of songs
     * @param likesAmount       amount of worked likes
     * @param loversAmount amount of lovers
     * @throws IllegalArgumentException if price, age, shiftAmount or lovers is below 0
     */
    public Red(String name, double price, String musician, double duration,
                 int likesAmount, int loversAmount) {
        super(name, price, musician, duration, likesAmount);
        if(price < 0 || duration < 0
                || likesAmount < 0 || loversAmount < 0) {
            throw new IllegalArgumentException();
        }
        this.loversAmount = loversAmount;
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj) return true;
        if (obj == null || getClass() != obj.getClass()) return false;


        AbstractRare abstractRare = (AbstractRare) obj;
        Red red = (Red) obj;

        return (red.loversAmount == this.loversAmount)
                && abstractRare.equals(this);
    }
/*
    @Override
    public String toString() {
        String stringFromSuper = super.toString();
        return String.format("%sSong's lovers amount: %d\n", stringFromSuper, loversAmount);
    }
*/
    @Override
    public int hashCode() {
        int hashCodeFromSuper = super.hashCode();
        return hashCodeFromSuper + loversAmount * 13;
    }

    @Override
    public String performWork() {
        return String.format("Singer manages" +
                "a group of song's lovers up to %d people.", loversAmount);
    }
}
