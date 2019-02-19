import java.util.ArrayList;
import java.util.List;

/**
 * Thief class. Thief will steal money and items from the player in the same
 * room as the thief.
 * @author ahmed
 * @version 2018-04-03
 */
public class Thief extends Enemy {
    /**
     * stolen.
     */
    private List<Item> stolen = new ArrayList<Item>();
    /**
     * total of money stolen from players.
     */
    private double money = 30;

    /**
     * Thief constructor.
     *
     * @param name for the name
     * @param description for the description
     */
    public Thief(String name, String description) {
        super(name, description);
    }

    /**
     * Getter for stolen items.
     * @return stolen.
     */
    public List<Item> getStolen() {
        return stolen;
    }

    /**
     * Getter for money.
     * @return money.
     */
    public double getMoney() {
        return money;
    }

    /**
     * Attack a player by stealing all his money and items.
     *
     * @param player to the player
     */
    @Override
    public void attack(Player player) {
        money += player.getMoney();
        for (String string : player.getInventoryString().split(" ")) {
            Item item = player.getItem(string);
            if (item != null && !(item instanceof Weapon)) {
                stolen.add(item);
                player.removeItem(string);
            }
        }
        player.setMoney(0);
    }

    /**
     * method toString.
     * @return String representation of the character.
     */
    @Override
    public String toString() {
        return super.toString() + "\t" + "Can steal.";
    }
}