
import java.util.ArrayList;
import java.util.List;
/**
 * Shop non playing character where player can buy items.
 *@author ahmed
 *@version 2018
 */
public class Shop extends NPC {
    /** items. */
    private List<Item> items = new ArrayList<Item>();
    //private List<Item> items ;
    /**
     * Constructor.
     *
     * @param name the name
     * @param description description
     * @param conversation conversation
     */
    public Shop(String name, String description, Conversation conversation) {
        super(name, description, conversation);
        //this.items = new ArrayList<Item>();
        //this.conversation = conversation;
    }

    /**
     * Sell method.
     * @param name name
     * @param weight weight
     * @return the item
     */
    public String sell(String name, double weight) {
        Item item = getItem(name);
        // try
        String valu = "";
        if (item == null) {
            //return "Item not in the shop.";
            valu = "Item not in the shop.";
        } 
        else {
            if (item.getWeight() - weight >= 0) {
                item.setWeight(item.getWeight() - weight);
                // return "Sold";
                valu = "Sold";
            }
            else {
                //return "Not enough in the shop.";
                valu = "Not enough in the shop.";
            }
        }
        return valu;
    }

    /**
     * Get Item from its name.
     *
     * @param name name
     * @return the name
     */
    public Item getItem(String name) {
        Item hold = null;
        for (Item item : items) {
            if (item.getName().toLowerCase().equals(name.toLowerCase())) {
                hold = item;
                //return item;
            }
        }
        return hold;
    }

    /**
     * Add item to the shop.
     * @param item 
     */
    public void addItem(Item item) {
        items.add(item);
    }

    /**
     * ToString method.
     * @return String representation of the shop.
     */
    @Override
    public String toString() {
        String shop = super.toString();
        for (Item item : items) {
            shop += "\t" + item;
        }
        return shop;
    }
}