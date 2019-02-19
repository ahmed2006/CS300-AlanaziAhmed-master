
/**
 * Enemy class.
 *
 * @author ahmed
 * @version 2018.04.02
 */
public abstract class Enemy extends Character {

    /**
     * *
     * Constructor.
     *
     * @param name name
     * @param description description
     */
    public Enemy(String name, String description) {
        super(name, description);
        this.setIsEnemy(true);
        this.setCanTalk(false);
    }

    /**
     * *
     * Attack.
     * @param player player
     */
    public abstract void attack(Player player);

}
