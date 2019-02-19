import java.util.ArrayList;
import java.util.List;
/**
 * A container : packs other items.
 * @author ahmed
 * @version 2018.04.02
 */
public class Container extends Item {
    /**
     * Items.
     */
    private List<Item> items;
    /**
     * constructor .
     * @param name name
     * @param description description
     * @param pointValue pointValue
     * @param weight weight
     */
    public Container(String name, String description, int pointValue, double weight) {
        super(name, description, pointValue, weight);
        this.items = new ArrayList<Item>();
    }

    /**
     * Add an item to the container.
     *
     * @param item item
     */
    public void addItem(Item item) {
        this.items.add(item);
    }

    /**
     * get an item from the container.
     *
     * @param name name
     * @return item item
     */
    public Item getItem(String name) { 
        Item ret = null;
        for (Item item : items) {
            if (item.getName().equals(name.toLowerCase())) {
                ret = item;
               // return ret;
            }
        }
        return ret;
    }

    /**
     * remove an item to the container.
     *
     * @param name the name
     * @return the name of the item removed if found or null.
     */
    public Item removeItem(String name) {
        Item forRemove = getItem(name);
        Item check = null;
        if (forRemove != null) {
            items.remove(forRemove);
           check = forRemove;
            //return forRemove;
        }    
            return check;
        }

    /**
     * Count all the point value of the container and the items packed.
     *
     * @return total point value.
     */
    @Override
    public int getPointValue() {
        int pointValue = super.getPointValue();
        for (Item item : items) {
            pointValue += item.getPointValue();
        }
        return pointValue;
    }

    /**
     * Count all the weight of the container and the items packed.
     *
     * @return total weight.
     */
    @Override
    public double getWeight() {
        double weight = super.getWeight();
        for (Item item : items) {
            weight += item.getWeight();
        }
        return weight;
    }

    /**
     * String representation of the item.
     *
     * @return String representation of the item.
     */
    @Override
    public String toString() {
        String container = "Container :\t" + super.toString() + "\n";
        for (Item item : items) {
            container += "\t - " + item + "\n";
        }
        container += "Total point value : " + getPointValue() + "\n";
        container += "Total weight : " + getWeight();
        return container;
    }
}
