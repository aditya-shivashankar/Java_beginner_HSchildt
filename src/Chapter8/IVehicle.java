package Chapter8;

public interface IVehicle {

    int range();

    // Compute fuel needed for a given distance.
    public double fuelneeded(int miles);

    public int getPassengers();

    public int getFuelcap();

    public int getMpg();

    public void setPassengers(int passengers);

    public void setFuelcap(int fuelcap);

    public void setMpg(int mpg);

}
