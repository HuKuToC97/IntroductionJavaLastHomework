import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Scanner;

public class Filter {

    public static Map<Integer, String> create(List<Laptop> laptops) {
        Scanner scanner = new Scanner(System.in);
        Map<Integer, String> newFilter = new HashMap<>();
        boolean continueWhile = true;
        Integer countWhile = 0;
        int choice = 0;
        while (continueWhile) {
            App.clearConsole();
            App.ShowAllListForModBugFix(laptops);

            System.out.println("НАСТРОЙКА ФИЛЬТРА ПОИСКА НОУТБУКА:");

            if (countWhile != 0) {
                printFilter(newFilter);
            }

            printMenu();
            choice = scanner.nextInt();
            scanner.nextLine();

            switch (choice) {
                case 1:
                    System.out.print("Введите производителя: ");
                    String manufacturer = scanner.nextLine();
                    newFilter.put(choice, manufacturer);
                    break;
                case 2:
                    System.out.print("Введите модель: ");
                    String model = scanner.nextLine();
                    newFilter.put(choice, model);
                    break;
                case 3:
                    System.out.print("Введите МИНИМАЛЬНЫЙ объем оперативной памяти (в ГБ): ");
                    String ram = scanner.nextLine();
                    newFilter.put(choice, ram);
                    break;
                case 4:
                    System.out.print("Введите МИНИМАЛЬНЫЙ объем жесткого диска (в ГБ): ");
                    String hardDrive = scanner.nextLine();
                    newFilter.put(choice, hardDrive);
                    break;
                case 5:
                    System.out.print("Введите операционную систему: ");
                    String os = scanner.nextLine();
                    newFilter.put(choice, os);
                    break;
                case 6:
                    System.out.print("Введите цвет: ");
                    String color = scanner.nextLine();
                    newFilter.put(choice, color);
                    break;
                case 7:
                    continueWhile = false;
                    break;
                default:
                    System.out.println("Неверный ввод. Пожалуйста, выберите цифру от 1 до 7.");
                    break;
            }
            countWhile++;
        }
        App.clearConsole();
        return newFilter;
    }

    public static void printMenu() {
        System.out.println("Введите цифру, чтобы добавить определенный критерий поиска:");
        System.out.println("1 - Производитель");
        System.out.println("2 - Модель");
        System.out.println("3 - Оперативная память ОЗУ");
        System.out.println("4 - Объем жесткого диска");
        System.out.println("5 - Операционная система");
        System.out.println("6 - Цвет");
        System.out.println("7 - Создать фильтр");
        System.out.print("Ваша цифра: ");
    }

    public static void printFilter(Map<Integer, String> filter) {
        System.out.println("Ваш текущий фильтр выглядит так: ");
        for (Map.Entry<Integer, String> entry : filter.entrySet()) {
            Integer choice = entry.getKey();
            switch (choice) {
                case 1:
                    System.out.println(String.format("Выбранный производитель: %s", entry.getValue()));
                    break;
                case 2:
                    System.out.println(String.format("Выбранная модель: %s", entry.getValue()));
                    break;
                case 3:
                    System.out.println(String.format("Выбранный МИНИМАЛЬНЫЙ объем оперативной памяти (ОЗУ): %sGB",
                            entry.getValue()));
                    break;
                case 4:
                    System.out.println(
                            String.format("Выбранный МИНИМАЛЬНЫЙ объем жесткого диска: %sGB", entry.getValue()));
                    break;
                case 5:
                    System.out.println(String.format("Выбранная операционная система: %s", entry.getValue()));
                    break;
                case 6:
                    System.out.println(String.format("Выбранный цвет: %s", entry.getValue()));
                    break;
                default:
                    System.out.println("Ошибка в Filter.printFilter");
                    break;
            }

        }
        System.out.println("---------------------------------");
    }

    public static List<Laptop> startFiltering(List<Laptop> laptops, Map<Integer, String> filter) {
        List<Laptop> resultList = new ArrayList<>();

        for (Laptop laptop : laptops) {
            if (checkСriteriaFilter(laptop, filter)) {
                resultList.add(laptop);
            }
        }

        return resultList;
    }

    private static boolean checkСriteriaFilter(Laptop laptop, Map<Integer, String> filter) {
        for (Map.Entry<Integer, String> entry : filter.entrySet()) {
            int criterion = entry.getKey();
            String value = entry.getValue();

            switch (criterion) {
                case 1:
                    if (!laptop.getManufacturer().equalsIgnoreCase(value)) {
                        return false;
                    }
                    break;
                case 2:
                    if (!laptop.getModel().equalsIgnoreCase(value)) {
                        return false;
                    }
                    break;
                case 3:
                    if (laptop.getAmountRAM() < Integer.parseInt(value)) {
                        return false;
                    }
                    break;
                case 4:
                    if (laptop.getCapacityHardDrive() < Integer.parseInt(value)) {
                        return false;
                    }
                    break;
                case 5:
                    if (!laptop.getOperatingSystem().equalsIgnoreCase(value)) {
                        return false;
                    }
                    break;
                case 6:
                    if (!laptop.getColor().equalsIgnoreCase(value)) {
                        return false;
                    }
                    break;
                default:
                    System.out.println("Ошибка в Filter.printFilter");
                    break;
            }
        }

        return true;
    }
}
