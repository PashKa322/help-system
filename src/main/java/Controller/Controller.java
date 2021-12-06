package Controller;

import Model.CategoryOfFood;
import Model.*;
import View.*;

import com.fasterxml.jackson.databind.ObjectMapper;
import exc.NotFoundObject;
import exc.WrongNameCategory;
import exc.WrongNameFood;

import java.io.*;

public class Controller {
    private Model model;
    private View view;
    private ObjectMapper objectMapper;


    private boolean checkCategory(int id) {
        for (CategoryOfFood category : model.getAllCategoryOfFood()) {
            if (category.getIdCategoryFood() == id) {
                return false;
            }
        }
        return false;
    }

    public Controller(Model model, View view, ObjectMapper objectMapper) {
        this.model = model;
        this.view = view;
        this.objectMapper = objectMapper;
    }

    public void addCategoryOfFood(String name) throws WrongNameCategory {
        for (CategoryOfFood categoryOfFood : model.getAllCategoryOfFood()) {
            if (categoryOfFood.getName().equals(name)) {
                throw new WrongNameCategory();
            }
        }
        int num = model.addCategoryOfFood(new CategoryOfFood(name));
        view.printLastCategoryOfFood(num);
    }

    public void getAllCategoryOfFood() {
        view.printAllCategoryOfFood();
    }

    public void getCategoryById(int id) throws NotFoundObject {
        if (checkCategory(id) == true) {
            throw new NotFoundObject();
        }
        view.printCategoryById(id);
    }

    public void addFood(String name, int id, int price) throws WrongNameFood, NotFoundObject {
        if (id > model.getAllCategoryOfFood().size() || id < 0) {
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

    public void getFoodById(int id) throws NotFoundObject {
        if (id > model.getAllFood().size() || id < 0) {
            throw new NotFoundObject();
        }
        view.printFoodById(id);
    }

    public void getAllFood() {
        view.printAllFood();
    }

    public void getFoodByCategoryId(int id) throws NotFoundObject {
        if (id > model.getAllCategoryOfFood().size() || id < 0) {
            throw new NotFoundObject();
        }
        view.printFoodByCategoryId(id);
    }

    public void writingToJson() throws IOException {
        FileOutputStream out = new FileOutputStream("z.json");
        out.write(objectMapper.writeValueAsBytes(model));
        out.close();
    }


    public Model readingFromJson() throws IOException {
        Model model = objectMapper.readValue(new File("z.json"), Model.class);
        return model;
    }

}




