package ru.practicum.dinner;

import java.util.ArrayList;
import java.util.HashMap;
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
                default:
                    System.out.println("Введена неверная комманда");
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
        if (dc.mapOfDishes.isEmpty()) {
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

        int index;

        ArrayList<ArrayList<String>> dishes = new ArrayList<>();


        //реализуйте ввод типов блюд
        while (!nextItem.isEmpty()) {
            if (!dc.mapOfDishes.containsKey(nextItem)) {
                System.out.println("Такого типа не существет: " + nextItem);
                System.out.println("Введите другой тип.");
                return;
            }
            dishes.add(dc.mapOfDishes.get(nextItem));
            nextItem = scanner.nextLine();
        }
        HashMap<String, ArrayList<String>> mapOfCombos = new HashMap<>();

        ArrayList<String> combos = new ArrayList<>();
        for (int i = 0; i < numberOfCombos; i++) {
            for (ArrayList<String> dish : dishes) {
                index = rand.nextInt(dish.size());
                combos.add(dish.get(index));
            }
            String keyCombo = "Комбо " + (i + 1);
            System.out.println(keyCombo);
            System.out.println(combos);
            mapOfCombos.put(keyCombo, combos);
            combos = new ArrayList<>();
        }
        // сгенерируйте комбинации блюд и выведите на экран
    }
}
