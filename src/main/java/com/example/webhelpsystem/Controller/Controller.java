package com.example.webhelpsystem.Controller;

import com.example.webhelpsystem.Model.*;
import com.example.webhelpsystem.View.ViewInterface;
import com.example.webhelpsystem.exc.NotFoundObject;
import com.example.webhelpsystem.exc.WrongNameCategory;
import com.example.webhelpsystem.exc.WrongNameFood;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.List;

/**
 * Класс контроллер с атрибутами model, view, objectMapper. Управляет действиями над моделью
 */
@Service
public class Controller implements ControllerInterface{
    @Autowired
    private ModelInterface model;
    @Autowired
    private ViewInterface view;
    @Autowired
    private ObjectMapper objectMapper;

    /**
     * Функция проверки существования категории по номеру
     * @param id - номер
     * @return возвращает false, если категория существует
     */

    /**
     * Функция проверки существования категории по номеру
     * @param id - номер
     * @return возвращает false, если категория существует
     */
    private boolean checkCategory(int id) {
        for (CategoryOfFood category : model.getAllCategoryOfFood()) {
            if (category.getIdCategoryFood() == id) {
                return false;
            }
        }
        return true;
    }

    /**
     * Конструктор - создание нового обхекта с определенными значениями
     * @param model - ссылка на model
     * @param view - ссылка на view
     * @param objectMapper - ссылка на objectMapper
     */
    public Controller(ModelInterface model, ViewInterface view, ObjectMapper objectMapper) {
        this.model = model;
        this.view = view;
        this.objectMapper = objectMapper;
    }

    public Controller(){

    }

    /**
     * Функция добавления новой категории блюд
     * @param name - имя
     * @throws WrongNameCategory - ошибка, если категория с таким иминем существует
     */
    public CategoryOfFood addCategoryOfFood(String name) throws WrongNameCategory {
        for (CategoryOfFood categoryOfFood : model.getAllCategoryOfFood()) {
            if (categoryOfFood.getName().equals(name)) {
                throw new WrongNameCategory();
            }
        }
        int num = model.addCategoryOfFood(new CategoryOfFood(name));
        view.printLastCategoryOfFood(num);
        return null;
    }

    /**
     * Функция, выводящая на экран все категории блюд
     */
    public List<CategoryOfFood> getAllCategoryOfFood() {
        view.printAllCategoryOfFood();
        return null;
    }

    /**
     * Функция, выводящая на экран категорию блюд по номеру
     * @param id - номер
     * @throws NotFoundObject - ошибка поиска категории
     */
    public CategoryOfFood getCategoryById(int id) throws NotFoundObject {
        if (checkCategory(id)) {
            throw new NotFoundObject();
        }
        view.printCategoryById(id);
        return null;
    }

    /**
     * Функция добавления блюда 
     * @param name - названия блюда
     * @param id - номер категории блюд
     * @param price - цена
     * @throws WrongNameFood - ошибка повторяющегося названия блюда
     * @throws NotFoundObject - ошибка поиска категории
     */
    public Food addFood(String name, int id, int price) throws WrongNameFood, NotFoundObject {
        if (checkCategory(id)) {
            throw new NotFoundObject();
        }
        for (Food food : model.getAllFood()) {
            if (food.getName().equals(name)) {
                throw new WrongNameFood();
            }
        }
        int num = model.addFood(new Food(name, model.getCategoryOfFoodById(id), price));
        view.printLastFood(num);
        return null;
    }

    /**
     * Функция получения блюда по номеру
     * @param id - номер
     * @throws NotFoundObject - ошибка поиска блюда
     */
    public Food getFoodById(int id) throws NotFoundObject {
        if (id > model.getAllFood().size() || id < 0) {
            throw new NotFoundObject();
        }
        view.printFoodById(id);
        return null;
    }

    /**
     * Функция, выводящая все блюда
     */
    public List<Food> getAllFood() {
        view.printAllFood();
        return null;
    }

    /**
     * Функция, выводящая список блюд по номеру категории
     * @param id - номер категории
     * @throws NotFoundObject - ошибка поиска блюда
     */
    public List<Food> getFoodByCategoryId(int id) throws NotFoundObject {
        if (checkCategory(id)) {
            throw new NotFoundObject();
        }
        view.printFoodByCategoryId(id);
        return null;
    }

    /**
     * Функция сохранения модели в json файл
     * @throws IOException
     */
    public void writingToJson() throws IOException {
        FileOutputStream out = new FileOutputStream("z.json");
        out.write(objectMapper.writeValueAsBytes(model));
        out.close();
    }


    /**
     * Функция получения модели из json файла
     * @return
     * @throws IOException
     */
    public Model readingFromJson() throws IOException {
        Model model = objectMapper.readValue(new File("z.json"), Model.class);
        return model;
    }

}




