package com.example.webhelpsystem.Model;

/**
 * Класс Food с атрибутами: name, categoryOfFood, price, idFood
 */
public class Food {

    private String name;

    private CategoryOfFood categoryOfFood;

    private int price;

    private int idFood;

    /**
     * Конструктор - создание нового объекта с определенными значениями, используется для создания новых блюд
     * @param name - название блюда
     * @param categoryOfFood - в какую категорию блюд входит
     * @param price - цена
     */
    public Food(String name, CategoryOfFood categoryOfFood, int price){
        this.name = name;
        this.categoryOfFood = categoryOfFood;
        this.price = price;
    }

    /**
     * Конструктор - используется для воссоздания экземпляра из json
     */
    public Food(){

    }

    /**
     * Функция определения имени блюда
     * @param name - название блюда
     */
    public void setName(String name) {
        this.name = name;
    }

    /**
     * Функция определения категории блюда
     * @param categoryOfFood - категория блюда
     */
    public void setCategoryOfFood(CategoryOfFood categoryOfFood) {
        this.categoryOfFood = categoryOfFood;
    }

    /**
     * Функция определения цены блюда
     * @param price - цена блюда
     */
    public void setPrice(int price) {
        this.price = price;
    }

    /**
     * Функция получения названия блюда
     * @return возвращает название блюда
     */
    public String getName() {
        return name;
    }

    /**
     * Функция получения категории блюда
     * @return возвращает категорию блюда
     */
    public CategoryOfFood getCategoryOfFood() {
        return categoryOfFood;
    }

    /**
     * Функция получения цены блюда
     * @return возвращает цена блюда
     */
    public int getPrice() {
        return price;
    }

    /**
     * Функция определения номера блюда
     * @param idFood - номер блюда
     */
    public void setIdFood(int idFood) {
        this.idFood = idFood;
    }

    /**
     * Функция получения номера блюда
     * @return возвращает номер блюда
     */
    public int getIdFood() {
        return idFood;
    }

    /**
     * Фнкция представление объекта класса в виде строки
     * @return возвращает строку
     */
    @Override
    public String toString() {
        return "Name: " + name + " price: " + price + " category: " + categoryOfFood;
    }
}
