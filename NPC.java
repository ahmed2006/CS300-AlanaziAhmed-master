
/**
 * The class for Non-playing character.
 *
 * @author ahmed
 * @version 2018-04-01
 */
public class NPC extends Character {

    /**
     * Conversation object.
     */
    private Conversation conversation;

    /**
     * Constructor with name and description.
     *
     * @param name name
     * @param description description
     */
    public NPC(String name, String description) {
        super(name, description);
    }

    /**
     * Constructor.
     *
     * @param name name
     * @param description description
     * @param conversation conversation related to npc.
     */
    public NPC(String name, String description, Conversation conversation) {
        super(name, description);
        this.conversation = conversation;
        this.setIsEnemy(false);
        this.setCanTalk(true);
    }

    /**
     * Getter for Conversation.
     *
     * @return conversation
     */
    public Conversation getConversation() {
        return conversation;
    }

    /**
     * Setter for conversation.
     * @param conversation 
     */
    public void setConversation(Conversation conversation) {
        this.conversation = conversation;
    }
}