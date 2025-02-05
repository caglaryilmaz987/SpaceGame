/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package falloutenclaveproject0;

import java.util.Scanner;

/**
 *
 * @author cagla
 */
public class RepconnSpaceRocket extends Substance {

    private int carryingCapacity, fuelStatus, enginePower, cargo;
    private Uranium Uranium;
    private Metal Metal;
    private Planet planet;
    private final Blackhole blackhole;
    private Substance substance;
    private HellFire hellFire;
    private X_01 x_01;
    private X_02 x_02;
    Scanner scanner = new Scanner(System.in);

    public RepconnSpaceRocket(int carryingCapacity, int fuelStatus, int enginePower, int cargo, Uranium Uranium, Metal Metal, Blackhole blackhole, Substance substance, Planet planet, HellFire hellFire, X_01 x_01, X_02 x_02) {
        this.carryingCapacity = carryingCapacity;
        this.fuelStatus = fuelStatus;
        this.enginePower = enginePower;
        this.cargo = cargo;
        this.Uranium = Uranium;
        this.Metal = Metal;
        this.planet = planet;
        this.blackhole = blackhole;
        this.substance = substance;
        this.hellFire = hellFire;
        this.x_01 = x_01;
        this.x_02 = x_02;
        this.x = 0;
        this.y = 0;
    }

// Displaying the current situation
    public void currentSituation() {
        System.out.println("Hello my Commander, your Repconn rocket's current situation : " + "Engine power : " + getEnginePower() + " " + "Carrying capacity : " + getCarryingCapacity() + " " + "Fuel : " + getFuelStatus() + " " + "Cargo : " + getCargo());
        System.out.println("");
        System.out.println("Your Metal Cargo : " + Metal.getQuantity() + " " + "Uranium Cargo : " + Uranium.getQuantity());
        System.out.println("");
        System.out.println("Your power armors : " + hellFire.getName() + " : " + hellFire.getQuantity() + " " + x_01.getName() + " : " + x_01.getQuantity() + " " + x_02.getName() + " : " + x_02.getQuantity());
    }

// To get current location
    public void location() {
        System.out.println("My commander, your current X location : " + getX() + " " + "Y location : " + getY());
    }

// Resource gathering methods
    public void gatherResources() {
        if (planet != null) {
            // Based on the incoming planet, we perform specific resource gathering actions
            planet.collectResources(this);
            Metal.specialRandomEvents(this);
            Uranium.specialRandomEvents(this);
        } else {
            System.out.println("Commander, unfortunately, our troops cannot gather resources here. For God's sake, God save the Enclave.");
        }
    }

// Ship modifications
    public void increaseCarryingCapacity() {
        int metalAmount = this.Metal.getQuantity();
        if (metalAmount < 5) {
            System.out.println("My Commander, we do not have enough resources for this operation.");
            System.out.println("");
        } else if (metalAmount >= 5) {
            setCarryingCapacity(getCarryingCapacity() + 10);
            Metal.setQuantity(metalAmount - 5);
            System.out.println("Commander, the carrying capacity has been increased successfully. Long live the Enclave.");
            System.out.println("");
        }
    }
// Power armor production

    public void increasePowerArmor() {
        System.out.println("Please choose a power armor unit for this action");
        System.out.println("\n");
        System.out.println("If you want choose " + hellFire.getName() + " model please sign 1");
        System.out.println("\n");
        System.out.println("If you want choose " + x_01.getName() + " model please sign 2");
        System.out.println("\n");
        System.out.println("If you want choose " + x_02.getName() + " model please sign 3");
        System.out.println("\n");
        int pow_arm_choice = scanner.nextInt();
        switch (pow_arm_choice) {
            case 1:
                hellFire.production(this);
                break;
            case 2:
                x_01.production(this);
                break;
            case 3:
                x_02.production(this);
                break;
            default:
                System.out.println("Commander plaese sign again");

        }

    }

// Engine power upgrade
    public void increaseEnginePower() {
        if (Metal.getQuantity() < 3) {
            System.out.println("My Commander, we do not have enough resources for this operation.");
            System.out.println("");
        } else if (Metal.getQuantity() >= 3) {
            setEnginePower(getEnginePower() + 5);
            Metal.setQuantity(Metal.getQuantity() - 3);
            System.out.println("Commander, engine power has been increased successfully. Long live the Enclave.");
            System.out.println("");
        }
    }

// Fuel production: for every 4 uranium, 2 fuel produced
    public void produceFuel() {
        if (Uranium.getQuantity() >= 4) {
            setFuelStatus(fuelStatus + 5);
            Uranium.setQuantity(Uranium.getQuantity() - 4);
            System.out.println("Commander, uranium has been successfully converted into fusion core. Long live the Enclave.");
            System.out.println("");
        } else if (Uranium.getQuantity() < 4) {
            System.out.println("My Commander, we do not have enough resources for this operation.");
            System.out.println("");
        }
    }

// Movement cost calculation
    public int movementCost() {
        // First, calculate the distance based on the object class since blackhole and planet are subclasses of object
        double distance = Math.sqrt(Math.pow(substance.getX() - getX(), 2) + Math.pow(substance.getY() - getY(), 2));
        // Then, calculate the fuel cost based on engine efficiency
        int cost = (int) ((int) (distance * 2.0) - ((int) enginePower * 0.2));
        return cost;
    }

// Getter and setter methods
    public int getCarryingCapacity() {
        return carryingCapacity;
    }

    public void setCarryingCapacity(int carryingCapacity) {
        this.carryingCapacity = carryingCapacity;
    }

    public int getFuelStatus() {
        return fuelStatus;
    }

    public void setFuelStatus(int fuelStatus) {
        this.fuelStatus = fuelStatus;
    }

    public int getEnginePower() {
        return enginePower;
    }

    public void setEnginePower(int enginePower) {
        this.enginePower = enginePower;
    }

    public Uranium getUranium() {
        return Uranium;
    }

    public int getCargo() {
        return cargo;
    }

    public void setCargo(int cargo) {
        this.cargo = cargo;
    }

    public Metal getMetal() {
        return Metal;
    }

    public void setMetal(Metal Metal) {
        this.Metal = Metal;
    }

    public void setUranium(Uranium Uranium) {
        this.Uranium = Uranium;
    }

// Overridden properties from the superclass
    @Override
    public int getX() {
        return x;
    }

    @Override
    public void setX(int x) {
        this.x = x;
    }

    @Override
    public int getY() {
        return y;
    }

    public Planet getPlanet() {
        return planet;
    }

    public void setPlanet(Planet planet) {
        this.planet = planet;
    }

    public Substance getSubstance() {
        return substance;
    }

    public void setSubstance(Substance substance) {
        this.substance = substance;
    }

    @Override
    public void setY(int y) {
        this.y = y;
    }

    public HellFire getHellFire() {
        return hellFire;
    }

    public void setHellFire(HellFire hellFire) {
        this.hellFire = hellFire;
    }

    public X_01 getX_01() {
        return x_01;
    }

    public void setX_01(X_01 x_01) {
        this.x_01 = x_01;
    }

    public X_02 getX_02() {
        return x_02;
    }

    public void setX_02(X_02 x_02) {
        this.x_02 = x_02;
    }

}
