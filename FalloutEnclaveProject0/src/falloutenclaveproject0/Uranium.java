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
public class Uranium extends Resource {

    Random random = new Random();

    public Uranium(int quantity) {
        super("Uranium", quantity);
    }

    public void specialRandomEvents(RepconnSpaceRocket rocket) {
        int randomNumber = random.nextInt(10) + 1;
        if ((int) rocket.getUranium().quantity / randomNumber == 5 && rocket.getMetal().quantity >= 10) {
            System.out.println("Commander, power armors needed fusion cores, we used uranium.");
            rocket.getUranium().setQuantity(rocket.getUranium().getQuantity() - 10);
        }
    }
}
