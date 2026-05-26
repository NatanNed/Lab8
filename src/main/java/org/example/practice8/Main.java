package org.example.practice8;

import java.util.ArrayList;
import java.util.Scanner;

/**
 * ПР №8.
 * Реалізує меню створення об'єктів різних типів і збереження їх в одному ArrayList.
 */
public class Main {

    private static final Scanner SCANNER = new Scanner(System.in);
    private static final ArrayList<Device> DEVICES = new ArrayList<>();

    public static void main(String[] args) {

        boolean running = true;

        while (running) {
            printMainMenu();
            int choice = readInt("Оберіть пункт меню: ");

            switch (choice) {
                case 1 -> createObjectMenu();
                case 2 -> printAllObjects();
                case 3 -> {
                    System.out.println("Роботу програми завершено.");
                    running = false;
                }
                default -> System.out.println("Помилка! Такого пункту меню немає.");
            }
        }

        SCANNER.close();
    }

    private static void printMainMenu() {
        System.out.println();
        System.out.println("===== ГОЛОВНЕ МЕНЮ =====");
        System.out.println("1. Створити новий об'єкт");
        System.out.println("2. Вивести інформацію про всі об'єкти");
        System.out.println("3. Завершити роботу програми");
    }

    private static void createObjectMenu() {
        boolean creating = true;

        while (creating) {
            System.out.println();
            System.out.println("===== СТВОРЕННЯ ОБ'ЄКТА =====");
            System.out.println("1. Device");
            System.out.println("2. Phone");
            System.out.println("3. Smartphone");
            System.out.println("4. GamingPhone");
            System.out.println("5. FoldablePhone");
            System.out.println("0. Повернутися до головного меню");

            int choice = readInt("Оберіть тип об'єкта: ");

            switch (choice) {
                case 1 -> {
                    DEVICES.add(createDevice());
                    System.out.println("Об'єкт Device додано.");
                }
                case 2 -> {
                    DEVICES.add(createPhone());
                    System.out.println("Об'єкт Phone додано.");
                }
                case 3 -> {
                    DEVICES.add(createSmartphone());
                    System.out.println("Об'єкт Smartphone додано.");
                }
                case 4 -> {
                    DEVICES.add(createGamingPhone());
                    System.out.println("Об'єкт GamingPhone додано.");
                }
                case 5 -> {
                    DEVICES.add(createFoldablePhone());
                    System.out.println("Об'єкт FoldablePhone додано.");
                }
                case 0 -> creating = false;
                default -> System.out.println("Помилка! Такого типу об'єкта немає.");
            }
        }
    }

    private static Device createDevice() {
        String brand = readString("Бренд: ");
        String model = readString("Модель: ");
        double price = readPositiveDouble("Ціна: ");

        return new Device(brand, model, price);
    }

    private static Phone createPhone() {
        String brand = readString("Бренд: ");
        String model = readString("Модель: ");
        double price = readPositiveDouble("Ціна: ");
        int memoryGb = readPositiveInt("Пам'ять, GB: ");
        boolean has5G = readBoolean("Підтримує 5G? true/false: ");

        return new Phone(brand, model, price, memoryGb, has5G);
    }

    private static Smartphone createSmartphone() {
        String brand = readString("Бренд: ");
        String model = readString("Модель: ");
        double price = readPositiveDouble("Ціна: ");
        int memoryGb = readPositiveInt("Пам'ять, GB: ");
        boolean has5G = readBoolean("Підтримує 5G? true/false: ");
        String operatingSystem = readString("Операційна система: ");
        int cameraMp = readPositiveInt("Камера, MP: ");

        return new Smartphone(brand, model, price, memoryGb, has5G, operatingSystem, cameraMp);
    }

    private static GamingPhone createGamingPhone() {
        String brand = readString("Бренд: ");
        String model = readString("Модель: ");
        double price = readPositiveDouble("Ціна: ");
        int memoryGb = readPositiveInt("Пам'ять, GB: ");
        boolean has5G = readBoolean("Підтримує 5G? true/false: ");
        String operatingSystem = readString("Операційна система: ");
        int cameraMp = readPositiveInt("Камера, MP: ");
        int refreshRateHz = readPositiveInt("Частота оновлення екрана, Hz: ");
        boolean coolingSystem = readBoolean("Є система охолодження? true/false: ");

        return new GamingPhone(
                brand,
                model,
                price,
                memoryGb,
                has5G,
                operatingSystem,
                cameraMp,
                refreshRateHz,
                coolingSystem
        );
    }

    private static FoldablePhone createFoldablePhone() {
        String brand = readString("Бренд: ");
        String model = readString("Модель: ");
        double price = readPositiveDouble("Ціна: ");
        int memoryGb = readPositiveInt("Пам'ять, GB: ");
        boolean has5G = readBoolean("Підтримує 5G? true/false: ");
        String operatingSystem = readString("Операційна система: ");
        int cameraMp = readPositiveInt("Камера, MP: ");
        int foldingCycles = readPositiveInt("Кількість циклів згинання: ");
        double unfoldedScreenSize = readPositiveDouble("Розмір розкритого екрана: ");

        return new FoldablePhone(
                brand,
                model,
                price,
                memoryGb,
                has5G,
                operatingSystem,
                cameraMp,
                foldingCycles,
                unfoldedScreenSize
        );
    }

    private static void printAllObjects() {
        System.out.println();

        if (DEVICES.isEmpty()) {
            System.out.println("Колекція порожня.");
            return;
        }

        System.out.println("===== УСІ ОБ'ЄКТИ =====");

        for (int i = 0; i < DEVICES.size(); i++) {
            System.out.println((i + 1) + ". " + DEVICES.get(i));
        }
    }

    private static String readString(String message) {
        while (true) {
            System.out.print(message);
            String value = SCANNER.nextLine().trim();

            if (!value.isEmpty()) {
                return value;
            }

            System.out.println("Помилка! Значення не може бути порожнім.");
        }
    }

    private static int readInt(String message) {
        while (true) {
            System.out.print(message);

            if (SCANNER.hasNextInt()) {
                int value = SCANNER.nextInt();
                SCANNER.nextLine();
                return value;
            }

            SCANNER.nextLine();
            System.out.println("Помилка! Введіть ціле число.");
        }
    }

    private static int readPositiveInt(String message) {
        while (true) {
            int value = readInt(message);

            if (value > 0) {
                return value;
            }

            System.out.println("Помилка! Число має бути додатним.");
        }
    }

    private static double readPositiveDouble(String message) {
        while (true) {
            System.out.print(message);

            if (SCANNER.hasNextDouble()) {
                double value = SCANNER.nextDouble();
                SCANNER.nextLine();

                if (value > 0) {
                    return value;
                }
            } else {
                SCANNER.nextLine();
            }

            System.out.println("Помилка! Введіть додатне число.");
        }
    }

    private static boolean readBoolean(String message) {
        while (true) {
            System.out.print(message);
            String value = SCANNER.nextLine().trim().toLowerCase();

            if (value.equals("true") || value.equals("так") || value.equals("yes")) {
                return true;
            }

            if (value.equals("false") || value.equals("ні") || value.equals("no")) {
                return false;
            }

            System.out.println("Помилка! Введіть true або false.");
        }
    }
}
