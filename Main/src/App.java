import java.util.List;

public class App {
    public static void main(String[] args) {

        List<Laptop> laptops = CreateListLaptop.Create(5);
        for (Laptop laptop : laptops) {
            System.out.println(laptop);
        }

    }
}
