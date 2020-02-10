package Chapter7;

class Vehicle {
    private int passengers; // number of passengers
    private int fuelcap;    // fuel capacity in gallons
    private int mpg;        // fuel consumption in miles per gallon

    // This is a constructor for Vehicle.
    Vehicle(int p, int f, int m) {
        passengers = p;
        fuelcap = f;
        mpg = m;
    }

    // Return the range.
    int range() {
        return mpg * fuelcap;
    }

    // Compute fuel needed for a given distance.
    double fuelneeded(int miles) {
        return (double) miles / mpg;
    }

    public int getPassengers() {
        return passengers;
    }

    public int getFuelcap() {
        return fuelcap;
    }

    public int getMpg() {
        return mpg;
    }

    public void setPassengers(int passengers) {
        this.passengers = passengers;
    }

    public void setFuelcap(int fuelcap) {
        this.fuelcap = fuelcap;
    }

    public void setMpg(int mpg) {
        this.mpg = mpg;
    }
}

class Truck extends Vehicle{

    private int cargocap;

    Truck(int p, int f, int m, int c){
        super(p, f, m);
        cargocap = c;
    }

    public int getCargocap() {
        return cargocap;
    }

    public void setCargocap(int cargocap) {
        this.cargocap = cargocap;
    }
}
public class TruckDemo {
    public static void main(String[] args) {
        Truck semi = new Truck(2, 200, 7, 44000);
        Truck pickup = new Truck(3, 28, 15, 2000);
        double gallons;
        int dist = 252;

        gallons = semi.fuelneeded(dist);
        System.out.println("Semi can carry " + semi.getCargocap() +
                " pounds.");
        System.out.println("To go " + dist + " miles semi needs " +
                gallons + " gallons of fuel.\n");

        gallons = pickup.fuelneeded(dist);

        System.out.println("Pickup can carry " + pickup.getCargocap() +
                " pounds.");
        System.out.println("To go " + dist + " miles pickup needs " +
                gallons + " gallons of fuel.");
    }
}
