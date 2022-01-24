package com.example.webhelpsystem.Controller;

import com.example.webhelpsystem.Model.CategoryOfFood;
import com.example.webhelpsystem.Model.Food;
import com.example.webhelpsystem.Model.Model;
import com.example.webhelpsystem.Model.ModelInterface;
import com.example.webhelpsystem.exc.NotFoundObject;
import com.example.webhelpsystem.exc.WrongNameCategory;
import com.example.webhelpsystem.exc.WrongNameFood;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;

import java.io.IOException;
import java.util.LinkedList;
import java.util.List;

@RestController
@Service
public class WebController implements ControllerInterface{
    @Autowired
    private ModelInterface model;
    @Autowired
    private ObjectMapper objectMapper;

    public WebController(ModelInterface model, ObjectMapper objectMapper){
        this.model = model;
        this.objectMapper = objectMapper;
    }

    private boolean checkCategory(int id) {
        for (CategoryOfFood category : model.getAllCategoryOfFood()) {
            if (category.getIdCategoryFood() == id) {
                return false;
            }
        }
        return true;
    }

    @PostMapping("addCategoryOfFood")
    @Override
    public void addCategoryOfFood(String name) throws WrongNameCategory {
        for (CategoryOfFood categoryOfFood : model.getAllCategoryOfFood()) {
            if (categoryOfFood.getName().equals(name)) {
                throw new WrongNameCategory();
            }
        }
        model.addCategoryOfFood(new CategoryOfFood(name));
    }

    @GetMapping("getAllCategoryOfFood")
    @Override
    public List<CategoryOfFood> getAllCategoryOfFood() {
        return model.getAllCategoryOfFood();
    }

    @GetMapping("getCategoryById")
    @Override
    public CategoryOfFood getCategoryById(int id) throws NotFoundObject {
//        if (checkCategory(id)) {
//            throw new NotFoundObject();
//        }
        return model.getCategoryOfFoodById(id);
    }
    @PostMapping("addFood")
    @Override
    public void addFood(String name, int id, int price) throws WrongNameFood, NotFoundObject {
//        if (checkCategory(id)) {
//            throw new NotFoundObject();
//        }
        for (Food food : model.getAllFood()) {
            if (food.getName().equals(name)) {
                throw new WrongNameFood();
            }
        }
        model.addFood(new Food(name, model.getCategoryOfFoodById(id), price));
    }

    @GetMapping("getFoodById")
    @Override
    public Food getFoodById(int id) throws NotFoundObject {
        if (id > model.getAllFood().size() || id < 0) {
            throw new NotFoundObject();
        }
        return model.getFoodById(id);
    }

    @GetMapping("/getAllFood")
    @Override
    public List<Food> getAllFood() {
        return model.getAllFood();
    }

    @GetMapping("getFoodByCategoryId")
    @Override
    public List<Food> getFoodByCategoryId(int id) throws NotFoundObject {
//        if (checkCategory(id)) {
//            throw new NotFoundObject();
//        }

        return model.getFoodByCategoryId(id);
    }

    @Override
    public void writingToJson() throws IOException {
    }

    @Override
    public Model readingFromJson() throws IOException {
        return null;
    }
}
