
/**
 * Item class: define an item with its name, descrition weight and a point value.
 * @author ahmed
 * @version 2018-04-03
 */
public class Item {
    /**
     * name.
     */
    private String name;
    /**
     * Description.
     */
    private String description;
    /**
     * A point of value of the item.
     */
    private int pointValue;
    /**
     * Weight of the item.
     */
    private double weight;
    /**
     * playing or non playing item.
     */
    private boolean playing;

    /**
     * Constructor for playing items.
     *
     * @param name name
     * @param description description
     * @param pointValue pointValue
     * @param weight weight
     */
    public Item(String name, String description, int pointValue, double weight) {
        this.name = name.toLowerCase();
        this.description = description;
        this.pointValue = pointValue;
        this.weight = weight;
        this.playing = true;
    }

    /**
     * Constructor for non playing items.
     *
     * @param name name
     * @param description description
     */
    public Item(String name, String description) {
        this.name = name.toLowerCase();
        this.description = description;
        this.playing = false;
    }

    /**
     * Getter for name.
     *
     * @return name.
     */
    public String getName() {
        return name;
    }

    /**
     * Getter for description.
     *
     * @return description.
     */
    public String getDescription() {
        return description;
    }

    /**
     * Getter for pointValue.
     *
     * @return pointValue.
     */
    public int getPointValue() {
        return pointValue;
    }

    /**
     * Getter for weight.
     *
     * @return weight.
     */
    public double getWeight() {
        return weight;
    }

    /**
     * Setter for description.
     *
     * @param description description
     */
    public void setDescription(String description) {
        this.description = description;
    }

    /**
     * Setter for pointValue.
     *
     * @param pointValue pointValue
     */
    public void setPointValue(int pointValue) {
        this.pointValue = pointValue;
    }

    /**
     * Setter for weight.
     *
     * @param weight weight
     */
    public void setWeight(double weight) {
        this.weight = weight;
    }

    /**
     * Playing or non playing item.
     *
     * @return if the item is playing or not.
     */
    public boolean isPlaying() {
        return playing;
    }
    //@Override
    //public String toString() {   // if
    //  return name + " " + description + (isPlaying() ? " weight : " + weight + " Point value " + pointValue : "");
    //}
    /**
     * String representation of the item.
     *
     * @return String representation of the item.
     */
    @Override
    public String toString() {
        String playing1 = "";
        if (isPlaying()) {
            playing1 = " weight : " + weight + " Point value " + pointValue;
        }
        return name + " " + description + playing1;
    }
}