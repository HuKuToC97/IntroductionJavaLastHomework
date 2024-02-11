import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class CreateListLaptop {
    public static List<Laptop> create(int count) {
        List<Laptop> laptops = new ArrayList<>();
        Random random = new Random();

        String[] manufacturers = { "Sony", "Dell", "HP", "Lenovo", "Asus", "Acer" };
        String[] models = { "XPS", "ThinkPad", "ZenBook", "Inspiron", "Pavilion", "Swift" };
        String[] operatingSystems = { "Windows", "Linux" };
        String[] colors = { "Black", "Silver", "White", "Blue", "Red", "Gray" };

        for (int i = 0; i < count; i++) {
            Laptop laptop = new Laptop();
            laptop.manufacturer = manufacturers[random.nextInt(manufacturers.length)];
            laptop.model = models[random.nextInt(models.length)];
            laptop.amountRAM = random.nextInt(16) + 4; // RAM от 4 до 20 ГБ
            laptop.capacityHardDrive = (random.nextInt(2) + 1) * 256; // Ёмкость жесткого диска: 256 или 512 ГБ
            laptop.operatingSystem = operatingSystems[random.nextInt(operatingSystems.length)];
            laptop.color = colors[random.nextInt(colors.length)];
            laptops.add(laptop);
        }

        return laptops;
    }
}
