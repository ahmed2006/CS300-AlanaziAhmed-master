
/**
 * Adviser Class. Adviser gives hint for the player about the room.
 *
 * @author Ahmed
 * @version 2018-04-04
 */
public class Adviser extends NPC {

    /**
     * Adviser constructor.
     *
     * @param name name.
     * @param description description
     */
    @SuppressWarnings("empty-statement")
    public Adviser(String name, String description) {
        super(name, description);
        setCanTalk(true);
        setIsEnemy(false);

    }

    /**
     * advice method.
     *
     * @param room room
     * @param player player
     * @return String.
     */
    public String advice(Room room, Player player) {
        String hint = "";
        for (Character character : room.getCharacters()) {
            if (character instanceof Enemy) {
                hint += "This room contain an enemy\n";
                if (character instanceof Thief) {
                    hint += "You can to kill the thief to get what you have lost.\n";
                }
            }
            if (character instanceof Shop) {
                if (player.getMoney() == 0) {
                    hint += "You are out of money search for money in the rooms\n";
                } 
                else {
                    hint += "You can buy thing in the shop\n";
                }
            }
            
        }
        return hint;
    }
    
}
