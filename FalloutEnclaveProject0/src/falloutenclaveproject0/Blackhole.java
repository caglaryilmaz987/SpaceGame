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
public class Blackhole extends Substance {

    private Random random = new Random();
    private RepconnSpaceRocket rocket;
    private String name;

    public Blackhole() {
        this.name = "Blackhole " + (random.nextInt(25) + 1);
    }

    public void randomMove(RepconnSpaceRocket rocket) {
        // There's a chance for free movement
        int fuelConsumption = random.nextInt(5);

        // Entering the black hole costs -5 fuel; I didn't reduce resources as it seemed illogical
        rocket.setFuelStatus(rocket.getFuelStatus() - fuelConsumption);
        if (rocket.getFuelStatus() < 0) {
            System.out.println("What did you do? You destroyed all hopes of the enclave. We are stuck in a black hole.");
            System.out.println("Game over");
            return;
        } else {
            // Random movement to a new position
            int randomX = random.nextInt(5);
            rocket.setX(randomX);
            int randomY = random.nextInt(5);
            rocket.setY(randomY);

            System.out.println("Commander, we are being pulled into a black hole, we are being pulled into the unknown. This will make our heads worse than 1000 jets.");
            System.out.println("We better get the stimpaks ready now.");
        }
    }

// To get information about the black hole's location
    public void blackholeInfo() {
        System.out.println("Blackhole x location : " + getX() + " " + "Y location : " + getY());
    }

// Getter/Setter methods
    public RepconnSpaceRocket getRocket() {
        return rocket;
    }

    public void setRocket(RepconnSpaceRocket rocket) {
        this.rocket = rocket;
    }

    public Random getRandom() {
        return random;
    }

    public void setRandom(Random random) {
        this.random = random;
    }

    public int getX() {
        return x;
    }

    public void setX(int x) {
        this.x = x;
    }

    public int getY() {
        return y;
    }

    public void setY(int y) {
        this.y = y;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

}
