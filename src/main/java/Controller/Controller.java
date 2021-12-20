package Controller;

import Model.CategoryOfFood;
import Model.*;
import View.*;

import com.fasterxml.jackson.databind.ObjectMapper;
import exc.NotFoundObject;
import exc.WrongNameCategory;
import exc.WrongNameFood;

import java.io.*;

/**
 * Класс контроллер с атрибутами model, view, objectMapper. Управляет действиями над моделью
 */
public class Controller {
    private Model model;
    private View view;
    private ObjectMapper objectMapper;

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
    public Controller(Model model, View view, ObjectMapper objectMapper) {
        this.model = model;
        this.view = view;
        this.objectMapper = objectMapper;
    }

    /**
     * Функция добавления новой категории блюд
     * @param name - имя
     * @throws WrongNameCategory - ошибка, если категория с таким иминем существует
     */
    public void addCategoryOfFood(String name) throws WrongNameCategory {
        for (CategoryOfFood categoryOfFood : model.getAllCategoryOfFood()) {
            if (categoryOfFood.getName().equals(name)) {
                throw new WrongNameCategory();
            }
        }
        int num = model.addCategoryOfFood(new CategoryOfFood(name));
        view.printLastCategoryOfFood(num);
    }

    /**
     * Функция, выводящая на экран все категории блюд
     */
    public void getAllCategoryOfFood() {
        view.printAllCategoryOfFood();
    }

    /**
     * Функция, выводящая на экран категорию блюд по номеру
     * @param id - номер
     * @throws NotFoundObject - ошибка поиска категории
     */
    public void getCategoryById(int id) throws NotFoundObject {
        if (checkCategory(id) == true) {
            throw new NotFoundObject();
        }
        view.printCategoryById(id);
    }

    /**
     * Функция добавления блюда 
     * @param name - названия блюда
     * @param id - номер категории блюд
     * @param price - цена
     * @throws WrongNameFood - ошибка повторяющегося названия блюда
     * @throws NotFoundObject - ошибка поиска категории
     */
    public void addFood(String name, int id, int price) throws WrongNameFood, NotFoundObject {
        if (checkCategory(id) == true) {
            throw new NotFoundObject();
        }
        for (Food food : model.getAllFood()) {
            if (food.getName().equals(name)) {
                throw new WrongNameFood();
            }
        }
        int num = model.addFood(new Food(name, model.getCategoryOfFoodById(id), price));
        view.printLastFood(num);
    }

    /**
     * Функция получения блюда по номеру
     * @param id - номер
     * @throws NotFoundObject - ошибка поиска блюда
     */
    public void getFoodById(int id) throws NotFoundObject {
        if (id > model.getAllFood().size() || id < 0) {
            throw new NotFoundObject();
        }
        view.printFoodById(id);
    }

    /**
     * Функция, выводящая все блюда
     */
    public void getAllFood() {
        view.printAllFood();
    }

    /**
     * Функция, выводящая список блюд по номеру категории
     * @param id - номер категории
     * @throws NotFoundObject - ошибка поиска блюда
     */
    public void getFoodByCategoryId(int id) throws NotFoundObject {
        if (checkCategory(id) == true) {
            throw new NotFoundObject();
        }
        view.printFoodByCategoryId(id);
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




