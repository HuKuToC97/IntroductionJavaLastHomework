public class Laptop {
    String manufacturer;
    String model;
    Integer amountRAM;
    Integer capacityHardDrive;
    String operatingSystem;
    String color;
    
    public String laptopName() {
        return (manufacturer + " " + model);
    }

    @Override
    public String toString() {
        return "Laptop :" + name;
    }
}
