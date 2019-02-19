/**
 * new class character.
 *
 * @author ahmed
 * @version 2018.04.03
 */
public class Character {

    /**
     * variable name.
     */
    private String name;
    /**
     * variable description.
     */
    private String description;
    /**
     * isEnemy .
     */
    private boolean isEnemy;
    /**
     * canTalk.
     */
    private boolean canTalk;

    /**
     * constructor class character .
     *
     * @param name name
     * @param description description
     */
    public Character(String name, String description) {
        this.name = name.toLowerCase();
        this.description = description.toLowerCase();
    }

    /**
     * accessor get name.
     *
     * @return name
     */
    public String getName() {
        return name;
    }

    /**
     * accessor get Description.
     *
     * @return Description
     */
    public String getDescription() {
        return description;
    }

    /**
     * accessor get IsEnemy.
     *
     * @return isIsEnemy
     */
    public boolean isEnemy() {
        return isEnemy;
    }

    /**
     * state of character :enemy or not enemy. enemy The enemy
     *
     * @param enemy : enemy.
     */
    public void setIsEnemy(boolean enemy) {
        this.isEnemy = enemy;
    }

    /**
     * accessor isCanTalk.
     *
     * @return canTalk
     */
    public boolean isCanTalk() {
        return canTalk;
    }

    /**
     * mutator set canTalk.
     *
     * @param canTalk canTalk
     */
    public void setCanTalk(boolean canTalk) {
        this.canTalk = canTalk;
    }

    /**
     * Override method.
     * @return String representation of the character.
     */
    @Override
    public String toString() {
        String characters = "";
        if (canTalk) {
            characters += "Can talk\t";
        }
        if (isEnemy) {
            characters += "is an enemy \t";
        }
        else {
            characters += "is not an enemy \t";
        }
        return name + " : " + description + "\n"
                + "\t" + characters;
    }
}
