/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package falloutenclaveproject0;

/**
 *
 * @author cagla
 */
public class X_02 extends PowerArmor {

    public X_02(int quantity) {
        super("X-02", quantity);
    }

    @Override
    public void production(RepconnSpaceRocket rocket) {
        if (rocket.getMetal().getQuantity() >= 5 && rocket.getUranium().getQuantity() >= 3) {
            //increasing power armor
            int newQuantity = rocket.getHellFire().getQuantity() + 1;
            rocket.setHellFire(new HellFire(newQuantity));
            System.out.println("Commander, we have successfully completed the production");
        } else {
            System.out.println("Commander, we do not have enough resources");
        }

    }

}
