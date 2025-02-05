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
public class Metal extends Resource {

    Random random = new Random();

    public Metal(int quantity) {
        super("Metal", quantity);
    }

    public void specialRandomEvents(RepconnSpaceRocket rocket) {
        int randomNumber = random.nextInt(10) + 1;
        if ((int) rocket.getMetal().quantity / randomNumber == 5 && rocket.getMetal().quantity >= 10) {
            System.out.println("Commander, we needed to repair the power armors, so we used metal.");
            rocket.getMetal().setQuantity(rocket.getMetal().getQuantity() - 10);
        }
    }
}
