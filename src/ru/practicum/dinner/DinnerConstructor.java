package ru.practicum.dinner;

import java.util.ArrayList;
import java.util.HashMap;

public class DinnerConstructor {
    HashMap<String, ArrayList<String>> mapOfDishes;
    ArrayList<String> dish;

    DinnerConstructor() {
        mapOfDishes = new HashMap<>();
    }

    public void addDish(String dishType, String dishName) {
        if (!checkType(dishType)) {
            dish = new ArrayList<>();
            dish.add(dishName);
            mapOfDishes.put(dishType, dish);
            System.out.println("Добавлено: " + dishType + " - " + dishName);
        } else {
            if (checkDish(dishType,dishName)) {
                System.out.println("Блюдо уже было добавлено");
                return;
            }
            mapOfDishes.get(dishType).add(dishName);
            System.out.println("Добавлено: " + dishType + " - " + dishName);
        }
    }

    public boolean checkDish(String dishType, String dishName) {
        return mapOfDishes.get(dishType).contains(dishName);
    }

    public boolean checkType(String dishType) {
        return mapOfDishes.containsKey(dishType);
    }

}
