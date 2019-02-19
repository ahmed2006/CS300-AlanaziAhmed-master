
/**
 * Class Door - a door or portal between two Rooms in an adventure game.
 *
 * This class is part of the "The Ghost Game" application. "The Ghost Game" is
 * a very simple, text based adventure game.
 *
 * A "Door" represents a door or portal between two locations of the game. It
 * stores a reference to the neighboring room and whether that door or portal is
 * locked. Doors are not locked by default.
 *
 * @author ahmed
 * @version  2018-04-04
 */
public class Door {

    /**
     * The room that this door leads to.
     */
    private Room destination;
    /**
     * Whether this door is locked.
     */
    private boolean locked;
    /**
     * key to unlock the door .
     */
    private String key;

    /**
     * Constructor for the Door class.
     *
     * @param destination The room this door leads to
     */
    public Door(Room destination) {
        this.destination = destination;
        this.locked = false;
    }

    /**
     * Constructor for the Door class that set locked state and key value.
     * @param destination : destination room.
     * @param locked :locked or not locked.
     * @param key : String key.
     */
    public Door(Room destination, boolean locked, String key) {
        this.destination = destination;
        this.locked = locked;
        this.key = key;
    }

    /**
     * A getter for the room this door leads to.
     *
     * @return The room this door leads to
     */
    public Room getDestination() {
        return destination;
    }

    /**
     * A getter for whether this door is locked.
     *
     * @return Whether this door is locked
     */
    public boolean isLocked() {
        return locked;
    }

    /**
     * A setter for whether this door is locked.
     *
     * @param locked Whether this door is locked.
     */
    public void setLocked(boolean locked) {
        this.locked = locked;
    }

    /**
     * Getter for key used to unlock a door.
     *
     * @return key.
     */
    public String getKey() {
        return key;
    }

}
