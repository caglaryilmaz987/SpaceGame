/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package falloutenclaveproject0;

/**
 *
 * @author cagla
 */
public class Resource {

    protected String name;
    protected int quantity;
    protected RepconnSpaceRocket rocket;

    public Resource(String name, int quantity) {
        this.name = name;
        this.quantity = quantity;
    }

    public Resource(String name, int quantity, RepconnSpaceRocket rocket) {
        this.name = name;
        this.quantity = quantity;
        this.rocket = rocket;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getQuantity() {
        return quantity;
    }

    public void setQuantity(int quantity) {
        this.quantity = quantity;
    }

    // Methods for adding or subtracting quantity
    public void increaseQuantity(int quantity) {
        this.quantity += quantity;
    }
}
