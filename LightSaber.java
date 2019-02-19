/**
 * Light saber class.
 * @author ahmed
 * @version 2018.04.02
 */
public class LightSaber extends Container implements Equippable, Switchable {
    /**
     * equiped.
     */
    private boolean equiped = false;
    /**
     * on.
     */
    private boolean on = false;

    /**
     * Constructor.
     *
     * @param name name
     * @param description description
     * @param pointValue pointValue
     * @param weight weight
     */
    public LightSaber(String name, String description, int pointValue, double weight) {
        super(name, description, pointValue, weight);
    }

    /**
     * equip.
     */
    @Override
    public void equip() {
        this.equiped = true;
    }

    /**
     * unequip.
     */
    @Override
    public void unequip() {
        this.equiped = false;
    }

    /**
     * is equiped method.
     *
     * @return equiped.
     */
    public boolean isEquiped() {
        return equiped;
    }

    /**
     * switchOn.
     */
    @Override
    public void switchOn() {
        this.on = true;
    }

    /**
     * switchOff.
     *
     */
    @Override
    public void switchOff() {
        this.on = false;
    }

    /**
     * isOn.
     *
     * @return on.
     */
    public boolean isOn() {
        return on;
    }

}
