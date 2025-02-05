/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package falloutenclaveproject0;

import java.util.Random;
import java.util.Scanner;

/**
 *
 * @author cagla
 */
public class MagneticPlanet extends Planet {

    Random random = new Random();
    Scanner scanner = new Scanner(System.in);

    public MagneticPlanet(String name, String atmosphere, int gravity, Metal metal, Uranium uranium, RepconnSpaceRocket rocket) {
        super(name, atmosphere, gravity, metal, uranium, rocket);
    }

    @Override
    public int landingCost(RepconnSpaceRocket rocket) {
        int initialFuel = rocket.getFuelStatus();
        if (gravity < 5 && gravity >= 0) {
            rocket.setFuelStatus(rocket.getFuelStatus() - 2);
            if (atmosphere.equals(atmosphere)) {
                rocket.setFuelStatus(rocket.getFuelStatus() - 2);
            }
        } else if (gravity < 10 && gravity >= 5) {
            rocket.setFuelStatus(rocket.getFuelStatus() - 3);
            if (atmosphere.equals(atmosphere)) {
                rocket.setFuelStatus(rocket.getFuelStatus() - 2);
            }
        } else if (gravity < 15 && gravity >= 10) {
            rocket.setFuelStatus(rocket.getFuelStatus() - 4);
            if (atmosphere.equals(atmosphere)) {
                rocket.setFuelStatus(rocket.getFuelStatus() - 2);
            }
        } else if (gravity <= 20 && gravity >= 15) {
            rocket.setFuelStatus(rocket.getFuelStatus() - 5);
            if (atmosphere.equals(atmosphere)) {
                rocket.setFuelStatus(rocket.getFuelStatus() - 2);
            }
        }
        return initialFuel - rocket.getFuelStatus();
    }

    @Override
    public void collectResources(RepconnSpaceRocket rocket) {
        int totalResources = getMetal().quantity + getUranium().quantity;

        if (rocket.getFuelStatus() < 4 && rocket.getHellFire().quantity <= 0 && rocket.getX_01().quantity <= 0 && rocket.getX_02().quantity <= 0) {
            System.out.println("Commander, the enclave troops do not have enough fuel to extract resources.\n");
            return;
        } else if (rocket.getCarryingCapacity() >= totalResources + rocket.getCargo()) {
            System.out.println("Please choose a power armor unit for this action\n");
            System.out.println("If you want to choose " + rocket.getHellFire().getName() + " model, please sign 1\n");
            System.out.println("If you want to choose " + rocket.getX_01().getName() + " model, please sign 2\n");
            System.out.println("If you want to choose " + rocket.getX_02().getName() + " model, please sign 3\n");

            int pow_arm_choice = scanner.nextInt();
            switch (pow_arm_choice) {
                case 1:
                    rocket.getMetal().increaseQuantity(getMetal().getQuantity());
                    rocket.getUranium().increaseQuantity(getUranium().getQuantity());
                    rocket.setFuelStatus(rocket.getFuelStatus() - ((int) (totalResources * 0.1) + 2));
                    System.out.println("Commander, the enclave soldiers have successfully completed the resource extraction mission.\n");
                    getMetal().setQuantity(0);
                    getUranium().setQuantity(0);
                    rocket.setCargo(rocket.getCargo() + totalResources);
                    rocket.setHellFire(new HellFire(rocket.getHellFire().getQuantity() - 1));
                    break;
                case 2:
                    rocket.getMetal().increaseQuantity(getMetal().getQuantity());
                    rocket.getUranium().increaseQuantity(getUranium().getQuantity());
                    rocket.setFuelStatus(rocket.getFuelStatus() - ((int) (totalResources * 0.1) - 2));
                    System.out.println("Commander, the enclave soldiers have successfully completed the resource extraction mission.\n");
                    getMetal().setQuantity(0);
                    getUranium().setQuantity(0);
                    rocket.setCargo(rocket.getCargo() + totalResources);
                    rocket.setX_01(new X_01(rocket.getX_01().getQuantity() - 2));
                    break;
                case 3:
                    rocket.getMetal().increaseQuantity(getMetal().getQuantity());
                    rocket.getUranium().increaseQuantity(getUranium().getQuantity());
                    rocket.setFuelStatus(rocket.getFuelStatus() - ((int) (totalResources * 0.1) - 4));
                    System.out.println("Commander, the enclave soldiers have successfully completed the resource extraction mission.\n");
                    getMetal().setQuantity(0);
                    getUranium().setQuantity(0);
                    rocket.setCargo(rocket.getCargo() + totalResources);
                    rocket.setHellFire(new HellFire(rocket.getHellFire().getQuantity() - 1));
                    break;
                default:
                    System.out.println("Commander, we cannot extract resources without power armor, please choose the model again.");
            }
        } else if (rocket.getCarryingCapacity() < totalResources + rocket.getCargo()) {
            System.out.println("Please choose a power armor unit for this action");
            System.out.println("\n");
            System.out.println("If you want to choose " + rocket.getHellFire().getName() + " model, please sign 1");
            System.out.println("\n");
            System.out.println("If you want to choose " + rocket.getX_01().getName() + " model, please sign 2");
            System.out.println("\n");
            System.out.println("If you want to choose " + rocket.getX_02().getName() + " model, please sign 3");
            System.out.println("\n");

            int pow_arm_choice = scanner.nextInt();
            int availableCapacity = rocket.getCarryingCapacity() - rocket.getCargo();

            int uraniumAmount = Math.min(availableCapacity, getUranium().getQuantity());
            availableCapacity -= uraniumAmount;

            int metalAmount = Math.min(availableCapacity, getMetal().getQuantity());
            availableCapacity -= metalAmount;

            int collectedAmount = metalAmount + uraniumAmount;

            switch (pow_arm_choice) {
                case 1:
                    rocket.getMetal().increaseQuantity(metalAmount);
                    rocket.getUranium().increaseQuantity(uraniumAmount);

                    rocket.setFuelStatus(rocket.getFuelStatus() - ((int) (collectedAmount * 0.1) + 3));
                    System.out.println("Commander, the enclave soldiers have extracted as much as they could carry using HellFire.");
                    System.out.println("");

                    getMetal().setQuantity(getMetal().getQuantity() - metalAmount);
                    getUranium().setQuantity(getUranium().getQuantity() - uraniumAmount);
                    rocket.setCargo(rocket.getCargo() + collectedAmount);

                    if (rocket.getHellFire() != null) {
                        int newQuantity = rocket.getHellFire().getQuantity() - 1;
                        rocket.setHellFire(new HellFire(Math.max(newQuantity, 0)));
                    }
                    break;

                case 2:
                    rocket.getMetal().increaseQuantity(metalAmount);
                    rocket.getUranium().increaseQuantity(uraniumAmount);

                    rocket.setFuelStatus(rocket.getFuelStatus() - ((int) (collectedAmount * 0.1) - 1));
                    System.out.println("Commander, the enclave soldiers have extracted as much as they could carry using X-01.");
                    System.out.println("");

                    getMetal().setQuantity(getMetal().getQuantity() - metalAmount);
                    getUranium().setQuantity(getUranium().getQuantity() - uraniumAmount);
                    rocket.setCargo(rocket.getCargo() + collectedAmount);

                    if (rocket.getX_01() != null) {
                        int newQuantity = rocket.getX_01().getQuantity() - 1;
                        rocket.setX_01(new X_01(Math.max(newQuantity, 0)));
                    }
                    break;

                case 3:
                    rocket.getMetal().increaseQuantity(metalAmount);
                    rocket.getUranium().increaseQuantity(uraniumAmount);

                    rocket.setFuelStatus(rocket.getFuelStatus() - ((int) (collectedAmount * 0.1) - 3));
                    System.out.println("Commander, the enclave soldiers have extracted as much as they could carry using X-02.");
                    System.out.println("");

                    getMetal().setQuantity(getMetal().getQuantity() - metalAmount);
                    getUranium().setQuantity(getUranium().getQuantity() - uraniumAmount);
                    rocket.setCargo(rocket.getCargo() + collectedAmount);

                    if (rocket.getX_02() != null) {
                        int newQuantity = rocket.getX_02().getQuantity() - 1;
                        rocket.setX_02(new X_02(Math.max(newQuantity, 0)));
                    }
                    break;

                default:
                    System.out.println("Commander, we cannot extract resources without power armor, please choose the model again.");
            }

        } else {
            System.out.println("Commander, we don't have enough space for these resources.\n");
        }
    }

    @Override
    public String toString() {
        return "Commander, here is the information about the planet we successfully landed on. Long live the enclave: "
                + "Planet name: " + getName()
                + ", Planet atmosphere type: " + getAtmosphere()
                + ", Planet X coordinate: " + getX()
                + ", Planet Y coordinate: " + getY()
                + ", Planet gravity: " + getGravity()
                + ", Amount of metal resources on the planet: " + metal.getQuantity()
                + ", Amount of uranium resources on the planet: " + uranium.getQuantity();
    }

    @Override
    public RepconnSpaceRocket getRocket() {
        return rocket;
    }

    @Override
    public void setRocket(RepconnSpaceRocket rocket) {
        this.rocket = rocket;
    }

}
