/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package falloutenclaveproject0;

/**
 *
 * @author cagla
 */
public abstract class PowerArmor extends Resource {

    public PowerArmor(String name, int quantity) {
        super(name, quantity);
    }

    public abstract void production(RepconnSpaceRocket rocket);

}
