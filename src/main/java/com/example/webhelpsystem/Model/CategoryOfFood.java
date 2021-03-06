package com.example.webhelpsystem.Model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

/**
 * Класс CategoryOfFood с атрибутами name, idCategoryOfFood
 */
@Entity
public class CategoryOfFood {
    @Id
    private int idCategoryFood;
    private String name;

    /**
     * Конструктор - создание нового объекта с определенными значениями
     * @param name - название категории
     */
    public CategoryOfFood(String name){
        this.name = name;
    }

    /**
     * Конструктор - используется для воссоздания экземпляра из json
     */
    public CategoryOfFood(){
    }

    /**
     * Функция определения имени блюда
     * @param name - название блюда
     */
    public void setName(String name) {
        this.name = name;
    }

    /**
     * Функция получения названия блюда
     * @return возвращает название блюда
     */
    public String getName() {
        return name;
    }

    /**
     * Функция определения номера категории
     * @param idCategoryFood
     */
    public void setIdCategoryFood(int idCategoryFood) {
        this.idCategoryFood = idCategoryFood;
    }

    /**
     * Функция получения номера категории
     * @return возвращает номер категории
     */
    public int getIdCategoryFood() {
        return idCategoryFood;
    }

    /**
     * Фнкция представление объекта класса в виде строки
     * @return возвращает строку
     */
    @Override
    public String toString() {
        return "Name: " + name;
    }



}
