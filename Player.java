import java.util.ArrayList;
import java.util.List;
/**
 * A class for the player.
 *
 * @author ahmed
 * @version 2018-04-06
 */
public class Player {

    /** Maximum weight that a player can carry. */
    public final static int MAX_CARRY_WEIGHT ;
    static{
        MAX_CARRY_WEIGHT = 30;
    }
    /**
     * previous room the user was in.
     */
    private Room previous;
    /**
     * This stores the room that the player is currnetly in.
     */
    private Room room;

    /** money used to buy items in shops. */
    private double money;

    /**
     * Items inventory .
     */
    private List<Item> inventory = new ArrayList<Item>();

    /**
     * A constructor for the player class.
     *
     * @param currentRoom for the room field.
     */
    public Player(Room currentRoom) {
        room = currentRoom;
        previous = currentRoom;
        money = 20;
    }

    /**
     * Accossor for getting the room.
     *
     * @return for getting the current room that the player is in.
     */
    public Room getRoom() {
        return room;
    }

    /**
     * Accossor for getting the previous room.
     *
     * @return for getting the previous room that the player was in.
     */
    public Room getPrevious() {
        return previous;
    }

    /**
     * Mutator for setting the current room.
     *
     * @param newRoom for setting the current room.
     */
    public void setRoom(Room newRoom) {
        previous = room;
        room = newRoom;
    }

    /**
     * method to add items.
     * @param newItem for new item
     * 
     * @return totalWeight after the loop
     */
    public boolean addItem(Item newItem) {
        int totalWeight = 0;
        boolean check = false;
        for (Item item : inventory) {
            totalWeight += item.getWeight();
        }
        if (totalWeight + newItem.getWeight() <= MAX_CARRY_WEIGHT) {
            inventory.add(newItem);
            check = true;
        }
        return check;
    }

    /**
     * get an item from the room.
     *
     * @param name for the name
     * @return item for the item
     */
    public Item getItem(String name) {
        Item value = null;
        for (Item item : inventory) {
            if (item.getName().equals(name)) {
                value = item;
                // return value;
            }
        }
        return value;
    }

    /**
     * remove an item to the room.
     *
     * @param name for the name
     * @return the name of the item removed if found or null.
     */
    public String removeItem(String name) {
        String nameValue = null;
        Item forRemove = getItem(name);
        if (forRemove != null) {
            this.inventory.remove(forRemove);
            nameValue = name;
        } 
        return nameValue;
    }

    /**
     * Inventory of the items that the player carry.
     *
     * @return inventory as String.
     */
    public String getInventoryString() {
        String stringInventory = "";
        for (Item item : inventory) {
            stringInventory += item + "\n";
        }
        return stringInventory;
    }

    /**
     * total carried weight.
     * @return total carried weight.
     */
    public double carriedWeight(){
        double weight = 0;
        for (Item item : inventory) {
            weight += item.getWeight();
        }
        return weight;
    }

    /**
     * Getter for money.
     * @return money.
     */
    public double getMoney() {
        return money;
    }
    

    /**
     * Setter for money.
     * @param money 
     */
    public void setMoney(double money) {
        this.money = money;
    }

    /**
     * get an equipped weapon or a weapon if no weapon is equipped or null if no
     * weapon is available in the inventory.
     *
     * @return a weapon item or null.
     */
    public Weapon getEquippedWeapon() {
        List<Weapon> weapons = new ArrayList<Weapon>();
        Weapon waeponsValue = null;
        for (Item item : inventory) {
            if(item instanceof Weapon){
                weapons.add((Weapon) item);
                if(((Weapon) item).isEquiped()){
                   waeponsValue = (Weapon) item; 
                   // return (Weapon) item;
                } }  }
        if(weapons.isEmpty()){
           //waepons += null;
            waeponsValue =  null;
        }else{
             weapons.get(0);
        }
        return waeponsValue;
    }
}