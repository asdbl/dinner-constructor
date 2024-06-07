package ru.practicum.dinner;

import java.util.ArrayList;
import java.util.Random;
import java.util.Scanner;

public class Main {

    static DinnerConstructor dc;
    static Scanner scanner;

    public static void main(String[] args) {
        dc = new DinnerConstructor();
        scanner = new Scanner(System.in);

        while (true) {
            printMenu();
            String command = scanner.nextLine();

            switch (command) {
                case "1":
                    addNewDish();
                    break;
                case "2":
                    generateDishCombo();
                    break;
                case "3":
                    return;
            }
        }
    }

    private static void printMenu() {
        System.out.println("Выберите команду:");
        System.out.println("1 - Добавить новое блюдо");
        System.out.println("2 - Сгенерировать комбинации блюд");
        System.out.println("3 - Выход");
    }

    private static void addNewDish() {
        System.out.println("Введите тип блюда:");
        String dishType = scanner.nextLine();
        System.out.println("Введите название блюда:");
        String dishName = scanner.nextLine();

        dc.addDish(dishType, dishName);
        // добавьте новое блюдо
    }

    private static void generateDishCombo() {
        if (dc.menu.isEmpty()) {
            System.out.println("Список пуст.");
            return;
        }
        System.out.println("Начинаем конструировать обед...");

        System.out.println("Введите количество наборов, которые нужно сгенерировать:");
        int numberOfCombos = scanner.nextInt();
        scanner.nextLine();

        System.out.println("Вводите типы блюда, разделяя символом переноса строки (enter). Для завершения ввода введите пустую строку");
        String nextItem = scanner.nextLine();
        Random rand = new Random();

        ArrayList<ArrayList<String>> comboDishList = new ArrayList<>();
        int index;
        int comboCounter = 0;
        ArrayList<String> comboDish;


        //реализуйте ввод типов блюд
        while (!nextItem.isEmpty()) {
            index = rand.nextInt(dc.menu.get(nextItem).size());
            if (dc.menu.containsKey(nextItem)) {
                comboDish = dc.menu.get(nextItem);
            }
        }
        // сгенерируйте комбинации блюд и выведите на экран

    }
}
