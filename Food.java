
/**
 * Food class: describe the food.
 *
 * @author ahmed
 * @version 2018.04.02
 */
public class Food extends Item implements Edible {

    /**
     * constructor.
     *
     * @param name name
     * @param description description
     * @param pointValue pointValue
     * @param weight weight
     */
    public Food(String name, String description, int pointValue, double weight) {
        super(name, description, pointValue, weight);
    }

   /**
    * the player eating food.
    * @param player player who eat the food.
    */
    @Override
    public void eat(Player player) {
        player.removeItem(this.getName());
    }
}
