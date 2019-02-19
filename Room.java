import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Iterator;
/**
 * Class Room - a room in an adventure game.
 *
 * This class is part of the " the Ghost Game" application. "C is a very simple, text based
 * adventure game.
 *
 * A "Room" represents one location in the scenery of the game. It is connected
 * to other rooms via doors. The doors are labeled north, east, south, west. For
 * each direction, the room stores a reference to an instance of door.
 *
 * @author ahmed
 * @version 2018-04-04
 */
public class Room {

    /**
     * Counter for the total number of rooms created in the world.
     */
    private static int counter = 0;
    /**
     * a points field to your Room class which will contain the number of points
     * a player gets for entering the room for the first time.
     */
    private int points;
    /**
     * The name of this room. Room names should be unique.
     */
    private String name;
    /**
     * The description of this room.
     */
    private String description;
    /**
     * directions hash map with directions keys and doors values.
     */
    private HashMap<String, Door> directions = new HashMap<String, Door>();

    /**
     * items stored in the room.
     */
    private List<Item> items = new ArrayList<Item>();
    /**
     * characters stored in the room: includes enemies and non playing
     * characters.
     */
    private List<Character> characters = new ArrayList<Character>();

    /**
     * Create a room described "description". Initially, it has no exits.
     * "description" is something like "a kitchen" or "an open court yard".
     *
     * @param name The room's name.
     * @param description The room's description.
     */
    public Room(String name, String description) {
        this.name = name;
        this.description = description;
        counter++;
    }

    /**
     * Returns the name of this room.
     *
     * @return The name of this room.
     */
    public String getName() {
        return name;
    }

    /**
     * Returns the description of this room.
     *
     * @return The description of this room.
     */
    public String getDescription() {
        return description;
    }

    /**
     * method to get the door.
     *
     * @param direction to show the direction.
     * @return getExit for getting that direction.
     */
    public Door getExit(String direction) {
        return directions.get(direction);
    }

    /**
     * to Set the exit.
     *
     * @param direction for the direction
     * @param neighbor for the neighbor
     */
    public void setExit(String direction, Door neighbor) {
        directions.put(direction, neighbor);
    }

    /**
     * Returns the number of rooms that have been created in the world.
     *
     * @return The number of rooms that have been created in the world.
     */
    public static int getCounter() {
        return counter;
    }

    /**
     * Returns a string description including all the details of a Room . campus
     * . Exits : north east south west
     *
     * @return A string representing all the details of a Room .
     */
    public String toString() {

        String roomInformation = getName() + " " + getDescription();
        roomInformation += "\n" + "Exits:  ";
        for (String direction : directions.keySet()) {
            roomInformation += direction + " ";
        }
        roomInformation += "\n" + "Items:  ";
        for (Item item : items) {
            roomInformation += " " + item.getName();
        }
        roomInformation += "\n" + "Characters:  ";
        for (Character character : characters) {
            roomInformation += " " + character.getName();
        }
        return roomInformation;
    }

    /**
     * a mutator for the points field in the Room class.
     *
     * @param points to get points
     */
    public void setPoints(int points) {
        this.points = points;
    }

    /**
     * an accessor for the points field in the Room class.
     *
     * @return firstpoint fot firstpoint
     */
    public int getPoints() {
        int firstpoint = points;
        points = 0;

        return firstpoint;
    }

    /**
     * Add an item to the room.
     *
     * @param item for item
     */
    public void addItem(Item item) {
        this.items.add(item);
    }

    /**
     * get an item from the room.
     *
     * @param theName for the name
     * @return newcurrent the new current item
     */
    public Item getItem(String theName) {
        //  HashSet<Item> items = new  HashSet<Item> (); 
        //for (Item item : items) 
        //Scanner scanner = new Scanner(System.in);
        boolean check = false;
        Item newcurrent = null;
        Iterator<Item> iter = items.iterator();
        while (iter.hasNext() && check == false) {
            Item current = iter.next();
            if (current.getName().equals(theName.toLowerCase())) {
                check = true;
                newcurrent = current;
            }
        }
        return newcurrent;
    }

    /**
     * remove an item to the room.
     *
     * @param named item name
     * @return the name of the item removed if found or null.
     */
    public String removeItem(String named) {
        String nameValue = null;
        Item forRemove = getItem(named);
        if (forRemove != null) {
            items.remove(forRemove);
            nameValue = named;
        }
        return nameValue;
    }

    /**
     * add Character.
     *
     * @param character character.
     */
    public void addCharacter(Character character) {
        characters.add(character);
    }

    /**
     * Get Character from name.
     *
     * @param cName : name
     * @return character.
     */
    public Character getCharacter(String cName) {
        Character newcurrent = null;
        boolean check = false;
        Iterator<Character> iter = characters.iterator();
        while (iter.hasNext() && check == false) {
            Character current = iter.next();
            if (current.getName().equals(cName.toLowerCase())) {
                check = true;
                newcurrent = current;
            }
        }
        return newcurrent;
    }

    /**
     * Getter for characters.
     *
     * @return characters
     */
    public List<Character> getCharacters() {
        return characters;
    }

    /**
     * Kill a character.
     * Used to kill enemies.
     * @param character 
     */
    public void kill(Character character) {
        characters.remove(character);
    }
}
