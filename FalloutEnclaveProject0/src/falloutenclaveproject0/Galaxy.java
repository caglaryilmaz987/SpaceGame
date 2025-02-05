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
public class Galaxy extends Substance {

    private Substance[][] galaxy;
    private Blackhole blackHole;
    private Planet planet;
    Random random = new Random();
    private RepconnSpaceRocket rocket;

    public Galaxy() {
        this.galaxy = new Substance[5][5];
        this.blackHole = new Blackhole();
        this.rocket = rocket;

        // I need an empty galaxy
        for (int i = 0; i < 5; i++) {
            for (int j = 0; j < 5; j++) {
                galaxy[i][j] = null;
            }
        }
        // Galaxy formation wasn't written in the constructor because it would get too long, so I prefer writing it as a method and adding it to the constructor

        galaxyBlackHolePlacement();
        galaxyPlanetPlacement();
    }

    public void galaxyBlackHolePlacement() {
        // Instead of taking a fixed number of black holes, I randomly choose the number to add some fun and variety to gameplay each time
        int blackHoleCountRandomization = random.nextInt(3) + 1;
        // Black hole placement should continue until the specified number of black holes are placed
        for (int i = 0; i < blackHoleCountRandomization; i++) {
            boolean blackHolePlacementFinished = false;
            while (!blackHolePlacementFinished) {

                int randomX = random.nextInt(5);
                int randomY = random.nextInt(5);

                if (galaxy[randomX][randomY] == null) {
                    galaxy[randomX][randomY] = new Blackhole();
                    blackHolePlacementFinished = true;
                }
            }
        }
    }

    public void galaxyPlanetPlacement() {
        // Here, I randomly choose the number of planets, but I need separate placements for each planet type. So, I'll use randomization and switch cases to create random planets
        int randomPlanetPlacement = random.nextInt(10) + 3;

        for (int i = 0; i < randomPlanetPlacement; i++) {
            // Keep going until all planets are placed
            boolean planetPlacementFinished = false;

            while (!planetPlacementFinished) {
                int randomX = random.nextInt(5);
                int randomY = random.nextInt(5);
                if (galaxy[randomX][randomY] == null) {
                    // Defining the properties of the planets here
                    String planetNumber = Integer.toString(random.nextInt(25) + 1);
                    // Instead of randomly setting gravity in the planet class, I do it here
                    int gravity = random.nextInt(20) + 1;
                    switch (random.nextInt(4) + 1) {
                        case 1:
                            galaxy[randomX][randomY] = new NuclearPlanet("Planet" + planetNumber, "Cant Liveable atmosphere so radioactive", gravity, new Metal(random.nextInt(5) + 5), new Uranium(random.nextInt(10) + 10), rocket);
                            break;
                        case 2:
                            galaxy[randomX][randomY] = new MagneticPlanet("Planet" + planetNumber, "Cant liveable atmosphere so magnetic", gravity, new Metal(random.nextInt(10) + 10), new Uranium(random.nextInt(5) + 5), rocket);
                            break;
                        case 3:
                            galaxy[randomX][randomY] = new HabitablePlanet("Planet" + planetNumber, "Livable atmosphere", gravity, new Metal(random.nextInt(5) + 5), new Uranium(random.nextInt(5) + 5), rocket);
                            break;
                    }
                    planetPlacementFinished = true;
                }
            }
        }
    }

    public void galaxyInfo() {
        for (int i = 0; i < 5; i++) {
            for (int j = 0; j < 5; j++) {
                // Checking if the object in the galaxy at the i-th and j-th positions is a black hole or a planet, and printing the appropriate information
                if (galaxy[i][j] instanceof Blackhole) {
                    System.out.println("My Commander, Enclave units found a BlackHole named: " + blackHole.getName() + " X Location: " + (i) + " Y Location: " + (j));
                } else if (galaxy[i][j] instanceof Planet) {
                    Planet planet = (Planet) galaxy[i][j];
                    System.out.println("My Commander, Enclave units found a Planet named: " + planet.getName() + " X Location: " + (i) + " Y Location: " + (j));
                }
            }
            System.out.println(" ");
        }
    }

    public void galaxyMap() {
        // Information line
        System.out.println("This map is based on point (0, 0) as the upper left corner.");
        // Map visuals for the upper row
        for (int i = 0; i < 37; i++) {
            System.out.print("*");
        }
        System.out.println("");
        // Main code for map layout
        for (int i = 0; i < galaxy.length; i++) {
            for (int j = 0; j < galaxy[i].length; j++) {
                // Map visuals for the left side
                if (j == 0) {
                    System.out.print("|");
                }

                // Planet map layout
                if (galaxy[i][j] instanceof Planet) {
                    System.out.print("   P   ");
                } else if (galaxy[i][j] instanceof Blackhole) {
                    System.out.print("   B   ");
                } else {
                    System.out.print("   .   ");
                }

                // Map visuals for the right side
                if (j == galaxy[i].length - 1) {
                    System.out.print("|");
                }
            }
            System.out.println("");
        }

        for (int i = 0; i < 37; i++) {
            System.out.print("*");
        }
        System.out.println("");
    }

    public int planetCount() {
        int sum = 0;
        for (int i = 0; i < 5; i++) {
            for (int j = 0; j < 5; j++) {
                if (galaxy[i][j] instanceof Planet) {
                    sum += 1;
                }
            }
        }
        return sum;
    }

    public int blackHoleCount() {
        int sum = 0;
        for (int i = 0; i < 5; i++) {
            for (int j = 0; j < 5; j++) {
                if (galaxy[i][j] instanceof Blackhole) {
                    sum += 1;
                }
            }
        }
        return sum;
    }

    public Substance[][] getGalaxy() {
        return galaxy;
    }

    public void setGalaxy(Substance[][] galaxy) {
        this.galaxy = galaxy;
    }

    public Blackhole getBlackHole() {
        return blackHole;
    }

    public void setBlackHole(Blackhole blackHole) {
        this.blackHole = blackHole;
    }

    public Planet getPlanet() {
        return planet;
    }

    public void setPlanet(Planet planet) {
        this.planet = planet;
    }

    public Random getRandom() {
        return random;
    }

    public void setRandom(Random random) {
        this.random = random;
    }

}
