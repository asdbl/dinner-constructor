package ru.practicum.dinner;

import java.util.ArrayList;
import java.util.HashMap;

public class DinnerConstructor {
    HashMap<String, ArrayList<String>> menu;
    ArrayList<String> dish;

    DinnerConstructor() {
        menu = new HashMap<>();

    }

    public void addDish(String dishType, String dishName) {
        if (!checkType(dishType)) {
            dish = new ArrayList<>();
            dish.add(dishName);
            menu.put(dishType, dish);
            System.out.println("Добавлено: " + dishType + " - " + dishName);
        } else {
            if (checkDish(dishType,dishName)) {
                System.out.println("Блюдо уже было добавлено");
                return;
            }
            menu.get(dishType).add(dishName);
            System.out.println("Добавлено: " + dishType + " - " + dishName);
        }
    }

    public boolean checkDish(String dishType, String dishName) {
        if (menu.get(dishType).contains(dishName)) {
            return true;
        }
        return false;
    }

    public boolean checkType(String dishType) {
        if (menu.containsKey(dishType)) {
            return true;
        }
        return false;
    }

}
