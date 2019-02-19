import java.util.HashMap;
import java.util.Map;
/**
 * Shop non playing character where player can buy items.
 *
 * @author ahmed
 * @version 2018.04.02
 */
public class Merchant extends Character {
    /**
     * map of items and their prices.
     */
    private Map<Item, Double> items = new HashMap<Item, Double>();

    /**
     * Constructor.
     * @param name for the name
     * @param description for the description
     */
    public Merchant(String name, String description) {
        super(name, description);
    }

    /**
     * Get Item from its name.
     *
     * @param name fot the name
     * @return the name
     */
    public Item getItem(String name) {
        Item letter = null;
        for (Item item : items.keySet()) {
            if (item.getName().toLowerCase().equals(name.toLowerCase())) {
                letter = item;
                //return letter;
            }
        }
        return letter;
    }

    /**
     * price of an item.
     * @param item for the item
     * @return item price.
     */
    public double getPrice(String item) {
        Item item1 = getItem(item);
        //Item itemvalue = 0;
        int itemvalue = 0;
        if (item1 != null) {
            itemvalue += items.get(item1);
            //return itemvalue;
        } 
        return itemvalue;
    }

    /**
     * Adds item to the merchant store.
     *
     * @param item for the item
     * @param price to add price
     */
    public void addItem(Item item, double price) {
        items.put(item, price);
    }

    /**
     * removes item from the merchant store.
     *
     * @param item for the item
     */
    public void removeItem(Item item) {
        items.remove(item);
    }

    /**
     * ToString method.
     *
     * @return String representation of the shop.
     */
    @Override
    public String toString() {
        String store = "Merchant " + getName();
        for (Item item : items.keySet()) {
            store += "\t" + item + " " + items.get(item);
        }
        return store;
    }

}
