/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Main.java to edit this template
 */
package falloutenclaveproject0;

import java.util.Random;
import java.util.Scanner;

/**
 *
 * @author cagla
 */
public class FalloutEnclaveProject0 {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {

        // TODO code application logic here
        // Required tools
        Scanner scanner = new Scanner(System.in);
        Random random = new Random();

        // Prologue
        System.out.println("                               Welcome to Fallout Enclave : Space Adventure Of Group 64 ");
        System.out.println("                                          A Post Nuclear Role Playing Game         ");
        System.out.println("\n\n");
        System.out.println("                                             War ... War never changes       ");
        System.out.println("In the year 2077, right after the great war,");
        System.out.println("a group of Enclave soldiers lost contact with the main base at the Poseidon Oil Rig. ");
        System.out.println("In this situation, they had only one course of action left: to fulfill the Enclave's ultimate goal by gathering intelligence about habitable planets and somehow transmitting this information back to the main base. ");
        System.out.println("Let's see if they can explore enough planets.");
        System.out.println("\n\n");

        // First, we need to create the spaceship and inform the player about its current status
        // 1) Creating objects for initial resource status
        Uranium uranium = new Uranium(0);
        Metal metal = new Metal(0);
        // Objects required for the rocket, initially null
        Substance substance = new Substance();
        // To prevent null pointer errors
        Planet planet = null;
        Blackhole blackHole = new Blackhole();
        HellFire hellFire = new HellFire(1);
        X_01 x_01 = new X_01(1);
        X_02 x_02 = new X_02(1);

        // 2) Creating the rocket
        RepconnSpaceRocket rocket = new RepconnSpaceRocket(50, 100, 0, 0, uranium, metal, blackHole, substance, planet, hellFire, x_01, x_02);
        // 3) Function displaying the rocket's current status
        rocket.currentSituation();
        System.out.println("\n");
        // 4) Galaxy formation
        Galaxy galaxy = new Galaxy();

        // The game continues until either the fuel runs out or all planets are visited
        int totalPlanets = galaxy.planetCount();
        int visitedPlanets = 0;

        while (visitedPlanets < totalPlanets) {
            // Providing information about the galaxy each turn
            System.out.println("In our aspects we have : " + galaxy.planetCount() + " Planets and " + galaxy.blackHoleCount() + " Black Holes");
            System.out.println("\n");
            System.out.println("Commander, the x-y range of our galaxy is 0 to 4. Please make your choice accordingly.");
            System.out.println("\n");
            System.out.println("Please choose your direction, Commander ");
            System.out.println("\n");
            // Display galaxy information
            galaxy.galaxyInfo();
            System.out.println("\n");
            // Display galaxy map
            galaxy.galaxyMap();
            // Choosing the target coordinates
            System.out.println("Commander, Enclave units await your command. Choose your X direction: ");
            int x = scanner.nextInt();
            System.out.println("Commander, Enclave units await your command. Choose your Y direction: ");
            int y = scanner.nextInt();
            System.out.println("\n");

            if (x >= 5 || y >= 5) {
                System.out.println("Commander, why did you give such an order? Are you crazy? Maybe you are not the right person to be a commander.");
                System.out.println("Game over");
                break;
            }

            if (galaxy.getGalaxy()[x][y] instanceof Planet) {
                planet = (Planet) galaxy.getGalaxy()[x][y];
                System.out.println("Commander, we have turned our orbit towards that planet.");
                System.out.println("\n");

                // Cost calculations
                int landingCost = planet.landingCost(rocket);
                int movementCost = rocket.movementCost();
                int totalCost = movementCost + landingCost;

                if (rocket.getFuelStatus() >= totalCost) {
                    rocket.setFuelStatus(rocket.getFuelStatus() - totalCost);
                    System.out.println("Commander, Enclave units successfully landed on that planet.");
                    System.out.println("\n");
                    visitedPlanets++;
                    rocket.setX(x);
                    rocket.setY(y);
                    rocket.setPlanet(planet);
                    rocket.location();
                    System.out.println("\n");
                    rocket.currentSituation();
                    System.out.println("\n");

                    boolean moveRequest = true;
                    while (moveRequest) {
                        System.out.println("\n");
                        System.out.println("Commander, choose an action to perform on this planet:");
                        System.out.println("\n");
                        System.out.println(planet.toString());
                        System.out.println("\n");
                        System.out.println("1 - Collect resources from this planet");
                        System.out.println("2 - Refuel spaceship");
                        System.out.println("3 - Upgrade cargo capacity");
                        System.out.println("4 - Increase engine power");
                        System.out.println("5 - Produce PowerArmor");
                        System.out.println("6 - Travel to another planet or black hole");
                        System.out.println("\n");
                        int choice = scanner.nextInt();

                        switch (choice) {
                            case 1 -> {
                                rocket.gatherResources();
                                rocket.currentSituation();
                            }
                            case 2 -> {
                                rocket.produceFuel();
                                rocket.currentSituation();
                            }
                            case 3 -> {
                                rocket.increaseCarryingCapacity();
                                rocket.currentSituation();
                            }
                            case 4 -> {
                                rocket.increaseEnginePower();
                                rocket.currentSituation();
                            }
                            case 5 -> {
                                rocket.increasePowerArmor();
                                rocket.currentSituation();

                            }
                            case 6 -> {
                                System.out.println("\n");
                                galaxy.galaxyMap();
                                moveRequest = false;
                            }
                            default ->
                                System.out.println("Commander, please choose a valid action.");
                        }
                    }
                }
            } else if (galaxy.getGalaxy()[x][y] instanceof Blackhole) {
                blackHole = (Blackhole) galaxy.getGalaxy()[x][y];
                System.out.println("Are we going into a black hole? Okay, I hope nothing bad happens to us.");
                if (rocket.movementCost() <= rocket.getFuelStatus()) {
                    rocket.setX(x);
                    rocket.setY(y);
                    System.out.println("We successfully arrived, Commander.");
                    blackHole.randomMove(rocket);
                    System.out.println("Commander, I think we've been teleported to a random part of the universe.");
                    rocket.location();
                } else {
                    System.out.println("Commander, we don't have enough fuel. Please choose another direction.");
                    break;
                }
            } else {
                System.out.println("Commander, there is nothing there. Choose another place.");
            }

            if (totalPlanets <= visitedPlanets) {
                System.out.println("Congratulations Commander, we have gathered enough information about all planets!");
                break;
            } else if (rocket.getUranium().quantity < 5 && rocket.getFuelStatus() == 0) {
                System.out.println("You are the worst thing that ever happened to the enclave.");
                break;
            }

        }
    }
}
