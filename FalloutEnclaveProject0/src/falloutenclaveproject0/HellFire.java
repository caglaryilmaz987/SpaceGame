/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package falloutenclaveproject0;

/**
 *
 * @author cagla
 */
public class HellFire extends PowerArmor {

    public HellFire(int quantity) {
        super("HellFire", quantity);
    }

    @Override
    public void production(RepconnSpaceRocket rocket) {
        //for hellfire production 
        if (rocket.getMetal().getQuantity() >= 3 && rocket.getUranium().getQuantity() >= 1) {
            //increasing power armor
            int newQuantity = rocket.getHellFire().getQuantity() + 1;
            rocket.setHellFire(new HellFire(newQuantity));
            System.out.println("Commander, we have successfully completed the production");
        } else {
            System.out.println("Commander, we do not have enough resources");
        }

    }

}
