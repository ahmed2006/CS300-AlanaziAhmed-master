
/**
 * Weapon class.
 *
 * @author ahmed
 * @version 2018.04.02
 */
public class Weapon extends Item implements Equippable {

    /**
     * equiped.
     */
    private boolean equiped = false;

    /**
     * Constructor.
     *
     * @param name :name
     * @param description :description 
     * @param pointValue : point value
     * @param weight : weight
     */
    public Weapon(String name, String description, int pointValue, double weight) {
        super(name, description, pointValue, weight);
    }

    /**
     * Equip.
     */
    @Override
    public void equip() {
        this.equiped = true;
    }

    /**
     * Unequip.
     */
    @Override
    public void unequip() {
        this.equiped = false;
    }

    /**
     * isEquiped.
     *
     * @return equiped.
     */
    public boolean isEquiped() {
        return equiped;
    }

}
