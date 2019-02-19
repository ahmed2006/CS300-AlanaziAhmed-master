/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 * class LightSource.
 * @author ahmed
 * @version 2018.04.02
 */
public class LightSource extends Item implements Switchable {
    /** on. */ 
    private boolean on = false;

    /**
     * Constructor.
     * @param name name
     * @param description description
     * @param pointValue pointValue
     * @param weight weight 
     */
    public LightSource(String name, String description, int pointValue, double weight) {
        super(name, description, pointValue, weight);
    }

    /**
     * Switch on.
     */
    @Override
    public void switchOn() {
        this.on = true;
    }

    /**
     * Switch off.
     */
    @Override
    public void switchOff() {
        this.on = false;
    }

    /**
     * State of the light source.
     * @return isOn
     */
    public boolean isOn() {
        return on;
    }

}
