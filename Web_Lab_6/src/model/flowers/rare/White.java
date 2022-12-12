package model.flowers.rare;

/**
 * Class of welder
 *
 */
public class White extends AbstractRare {

    /**
     * skill of shipbuilding
     */
    protected Boolean isPopular;

    /**
     * getter of shipbuilder skill
     */
    public boolean getIsShipbuiler() {
        return isPopular;
    }


    /**
     * Constructor, creates songs with name, price, age and salesman
     *
     * @param name          name of songs
     * @param price        price of songs
     * @param age    age of songs
     * @param salesman    salesman of songs
     * @param likesAmount  amount of worked likes
     * @param isPopular shipbuilders skills
     * @throws IllegalArgumentException if price, age, shiftAmount or maxKilos is below 0
     */
    public White(String name, double price, String musician, double duration,
                   int likesAmount, boolean isPopular) {
        super(name, price, musician, duration, likesAmount);
        if(price < 0 || duration < 0 || likesAmount < 0) {
            throw new IllegalArgumentException();
        }
        this.isPopular = isPopular;
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj) return true;
        if (obj == null || getClass() != obj.getClass()) return false;


        AbstractRare abstractRare = (AbstractRare) obj;
        White white = (White) obj;

        return (white.isPopular == this.isPopular)
                && abstractRare.equals(this);
    }

    @Override
    public String toString() {
        String stringFromSuper = super.toString();
        return String.format("%sIs it popular: %s\n", stringFromSuper, isPopular ? "YES" : "NO");
    }

    @Override
    public int hashCode() {
        int hashCodeFromSuper = super.hashCode();
        return hashCodeFromSuper + isPopular.hashCode() * 31 + 13;
    }

    @Override
    public String performWork() {
        return String.format("Singer can sing%s", isPopular ? " popular songs." : ".");
    }
}