package com.example.webhelpsystem.Model;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import org.springframework.stereotype.Service;

import java.util.LinkedList;
import java.util.List;


/**
 * Клаас модели с атрибутами arrFood, arrCategoryOfFood
 */
@JsonIgnoreProperties(ignoreUnknown = true)
@Service
public class Model implements ModelInterface {
   private List<Food> arrFood = new LinkedList<Food>();

   private List<CategoryOfFood> arrCategoryOfFood = new LinkedList<CategoryOfFood>();


   /**
    * Функция добавления нового блюда в список блюд
    *
    * @param food - блюдо
    * @return возвращает номер добавленного блюда
    */
   public int addFood(Food food) {
      arrFood.add(food);
      food.setIdFood(arrFood.size() - 1);
      return food.getIdFood();
   }

   /**
    * Функция добавления новой категории блюд в список категорий блюд
    *
    * @param categoryOfFood - категория
    * @return возвращает номер добавленного блюда
    */
   public int addCategoryOfFood(CategoryOfFood categoryOfFood) {
      arrCategoryOfFood.add(categoryOfFood);
      categoryOfFood.setIdCategoryFood(arrCategoryOfFood.size() - 1);
      return categoryOfFood.getIdCategoryFood();
   }

   /**
    * Функция получения списка блюд
    *
    * @return возвращает список блюд
    */
   public List<Food> getAllFood() {
      return arrFood;
   }

   public void setAllFood(List<Food> newArrFood) {
      arrFood = newArrFood;
   }

   /**
    * Функция получения списка категорий блюд
    *
    * @return возвращает список категорий блюд
    */
   public List<CategoryOfFood> getAllCategoryOfFood() {
      return arrCategoryOfFood;
   }

   /**
    * Функция получения блюда по номеру
    *
    * @param num - номер
    * @return возвращает блюдо
    */
   public Food getFoodById(int num) {
      return arrFood.get(num);
   }

   /**
    * Функция получения категории блюд по номеру
    *
    * @param num - номер
    * @return возвращает блюдо
    */
   public CategoryOfFood getCategoryOfFoodById(int num) {
      return arrCategoryOfFood.get(num);
   }

   /**
    * Метод получения длина списка блюд
    *
    * @return возвращает длину списка
    */
   public int getLengthFood() {
      return arrFood.size();
   }

   /**
    * Метод получеия длины списка категорий блюд
    *
    * @return возвращает длину списка
    */
   public int getLengthCategoryOfFood() {
      return arrCategoryOfFood.size();
   }

   public List<Food> getFoodByCategoryId(int id) {
      List<Food> listFood = new LinkedList<Food>();
      for (Food food : arrFood) {
         if (food.getCategoryOfFood() == arrCategoryOfFood.get(id)) {
            listFood.add(food);
         }
      }
      return listFood;
   }
}
