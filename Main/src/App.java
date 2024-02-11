import java.io.IOException;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Scanner;

public class App {
    public static boolean modBugFix = false;

    public static void main(String[] args) {
        Integer countCreateLaptop = 5; // Задаем количество ноутбуков в списке
        List<Laptop> laptops = CreateListLaptop.create(countCreateLaptop);

        setModBagFix();
        startProgram();

        Map<Integer, String> newFilter = Filter.create(laptops);
        ShowAllListForModBugFix(laptops);
        Filter.printFilter(newFilter);
        List<Laptop> filteredLaptops = Filter.startFiltering(laptops, newFilter);
        ShowAllList(filteredLaptops);

    }

    public static void startProgram() {
        clearConsole();
        System.out.println("Добро пожаловать в программу по поиску ноутбуков!");
        System.out.println("Вы можете воспользоваться нашей программой для фильтрации ноутбуков в магазине техники.");
        System.out.println(
                "Мы предлагаем вам ввести критерии фильтрации, чтобы найти ноутбук, который соответствует вашим требованиям.");
        System.out.println("Пожалуйста, следуйте инструкциям, чтобы воспользоваться всеми функциями программы.");
        System.out.println("Удачного использования!");
        pressAnyKeyToContinue();
        clearConsole();
    }

    public static void setModBagFix() {
        clearConsole();
        boolean continueWhile = true;
        while (continueWhile) {

            System.out.println("Использовать ModBagFix?");
            System.out.println(
                    "В этом режиме на всех этапах работы вверху консоли будут выводиться все ноутбуки из сгенерированного списка.");
            System.out.println("1. Да");
            System.out.println("2. Нет");
            System.out.print("Введите цифру: ");
            Scanner scanner = new Scanner(System.in);
            int choice = scanner.nextInt();
            scanner.nextLine();

            switch (choice) {
                case 1:
                    modBugFix = true;
                    continueWhile = false;
                    break;
                case 2:
                    modBugFix = false;
                    continueWhile = false;
                    break;
                default:
                    clearConsole();
                    System.out.println("Вы ввели не корректное значение, введите 1 или 2");
                    break;
            }
        }
    }

    public static void ShowAllListForModBugFix(List<Laptop> laptops) {
        if (modBugFix) {
            System.out.println("ModBugFix: Список ноутбуков для проверки корректности дальнейшей программы:");
            for (Laptop laptop : laptops) {
                System.out.println("    " + laptop);
            }
            System.out.println("---------------------------------------------------------------------------");
        }
    }

    public static void ShowAllList(List<Laptop> laptops) {

        System.out.println("Ноутбуки соответствующие вашему фильтру:");
        for (Laptop laptop : laptops) {
            System.out.println(laptop);
        }
        System.out.println("----------------------------------------------------------------");

    }

    public static void clearConsole() {
        try {
            final String os = System.getProperty("os.name");
            if (os.contains("Windows")) {
                new ProcessBuilder("cmd", "/c", "cls").inheritIO().start().waitFor();
            } else {
                Runtime.getRuntime().exec("clear");
            }
        } catch (final Exception e) {
            System.out.println("Ошибка при попытке очистить консоль: " + e.getMessage());
        }
    }

    public static void pressAnyKeyToContinue() {
        System.out.println("Для продолжения нажмите любую клавишу...");
        try {
            System.in.read(); // Ждем, пока пользователь нажмет клавишу
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

}
