public class Laptop {
    String manufacturer;
    String model;
    Integer amountRAM;
    Integer capacityHardDrive;
    String operatingSystem;
    String color;

    public String laptopName() {
        if (manufacturer == null || manufacturer.isEmpty()) {
            manufacturer = "manufacturer-unknown";
        }
        if (model == null || model.isEmpty()) {
            model = "model-unknown";
        }
        return (manufacturer + " " + model);
    }

    @Override
    public String toString() {
        return String.format("Laptop: %s, RAM: %dGB, HDD: %dGB, OS: %s, Color: %s",
                laptopName(), amountRAM != null ? amountRAM : 0,
                capacityHardDrive != null ? capacityHardDrive : 0,
                operatingSystem != null ? operatingSystem : "Unknown",
                color != null ? color : "Unknown");
    }

    public boolean equalsIgnoreCase(String str1, String str2) {
        return str1.equalsIgnoreCase(str2);
    }

    public String getManufacturer() {
        return manufacturer;
    }

    public String getModel() {
        return model;
    }

    public Integer getAmountRAM() {
        return amountRAM;
    }

    public Integer getCapacityHardDrive() {
        return capacityHardDrive;
    }

    public String getOperatingSystem() {
        return operatingSystem;
    }

    public String getColor() {
        return color;
    }

}
