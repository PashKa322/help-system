package com.example.webhelpsystem.View;

import com.example.webhelpsystem.Model.*;
import com.example.webhelpsystem.Model.ModelInterface;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * Класс view. Его задача выводить данные
 */
@Service
public class View implements ViewInterface{
    @Autowired
    private ModelInterface model;

    /**
     * Конструктор - служит для создания экземпляра класса
     * @param model - модель
     */
    public View(ModelInterface model){
        this.model = model;
    }

    /**
     * Функция, выводящая на экран все блюда
     */
    public void printAllFood(){
        System.out.println("Список всех блюд: ");
        for(Food food: model.getAllFood()){
            System.out.println(food);
        }
    }

    /**
     * Функция,выводящая на экран все категории
     */
    public void printAllCategoryOfFood(){
        System.out.println("Список всех категорий блюд: ");
        for(CategoryOfFood categoryOfFood: model.getAllCategoryOfFood()){
            System.out.println(categoryOfFood);
        }
    }

    /**
     * Функция, выводящая на экран последнее добавленное блюдо по номеру
     * @param num - номер
     */
    public void printLastFood(int num){
        System.out.println("Добавленное блюдо: ");
        System.out.println(model.getFoodById(num));
    }

    /**
     * Функция, выводящая на экран последнюю добавленную категорию блюд по номеру
     * @param num - номер
     */
    public void printLastCategoryOfFood(int num){
        System.out.println("Добавленная категория: ");
        System.out.println(model.getCategoryOfFoodById(num));
    }

    /**
     * Функция, выводящая на экран категорию блюд по номеру
     * @param num - номер
     */
    public void printCategoryById(int num){
        System.out.printf("Категория с номером %d: \n", num);
        System.out.println(model.getCategoryOfFoodById(num));
    }

    /**
     * Функция, выводящая на экран блюдо по номеру
     * @param num - номер
     */
    public void printFoodById(int num){
        System.out.printf("Блюдо с номером %d: \n", num);
        System.out.println(model.getFoodById(num));
    }

    /**
     * Функция, выводящая на экран список блюд по номеру категории
     * @param num - номер
     */
    public void printFoodByCategoryId(int num){
        System.out.println("Блюда по номеру категории: ");
        for (Food food: model.getAllFood()){
            if(food.getCategoryOfFood() == model.getCategoryOfFoodById(num)){
                System.out.println(food);
            }
        }
    }
}
