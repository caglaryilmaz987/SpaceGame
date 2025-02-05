/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package falloutenclaveproject0;

import java.util.Random;

/**
 *
 * @author cagla
 */
public abstract class Planet extends Substance {

    protected String name, atmosphere;
    protected int gravity;
    protected Metal metal;
    protected Uranium uranium;
    protected RepconnSpaceRocket rocket;
    Random random = new Random();

    public Planet(String name, String atmosphere, int gravity, Metal metal, Uranium uranium, RepconnSpaceRocket rocket) {
        this.name = name;
        this.atmosphere = atmosphere;
        this.gravity = gravity;
        this.metal = metal;
        this.uranium = uranium;
        this.rocket = rocket;
    }

    public abstract String toString();

    // Abstract methods for resource collection and landing cost, to be implemented differently for each planet.
    public abstract void collectResources(RepconnSpaceRocket rocket);

    public abstract int landingCost(RepconnSpaceRocket rocket);

    // Getters and setters
    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getAtmosphere() {
        return atmosphere;
    }

    public void setAtmosphere(String atmosphere) {
        this.atmosphere = atmosphere;
    }

    public int getGravity() {
        return gravity;
    }

    public void setGravity(int gravity) {
        this.gravity = gravity;
    }

    public Resource getMetal() {
        return metal;
    }

    public Resource getUranium() {
        return uranium;
    }

    public RepconnSpaceRocket getRocket() {
        return rocket;
    }

    public void setRocket(RepconnSpaceRocket rocket) {
        this.rocket = rocket;
    }
}
