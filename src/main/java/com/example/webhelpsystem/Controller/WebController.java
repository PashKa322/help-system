package com.example.webhelpsystem.Controller;

import com.example.webhelpsystem.Model.CategoryOfFood;
import com.example.webhelpsystem.Model.Food;
import com.example.webhelpsystem.Model.Model;
import com.example.webhelpsystem.Model.ModelInterface;
import com.example.webhelpsystem.exc.NotFoundObject;
import com.example.webhelpsystem.exc.WrongNameCategory;
import com.example.webhelpsystem.exc.WrongNameFood;
import com.example.webhelpsystem.repository.CategoryOfFoodRepository;
import com.example.webhelpsystem.repository.FoodRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;

import java.io.IOException;
import java.util.List;

@RestController
@Service
public class WebController implements ControllerInterface{
    @Autowired
    private ModelInterface model;
    @Autowired
    private CategoryOfFoodRepository repositoryCategory;
    @Autowired
    private FoodRepository repositoryFood;

    public WebController(ModelInterface model){
        this.model = model;
    }

    private boolean checkCategory(int id) {
        for (CategoryOfFood category : repositoryCategory.findAll()) {
            if (category.getIdCategoryFood() == id) {
                return false;
            }
        }
        return true;
    }

    @PostMapping("addCategoryOfFood")
    @Override
    public CategoryOfFood addCategoryOfFood(String name) throws WrongNameCategory {
        for (CategoryOfFood categoryOfFood : model.getAllCategoryOfFood()) {
            if (categoryOfFood.getName().equals(name)) {
                throw new WrongNameCategory();
            }
        }
        int id = model.addCategoryOfFood(new CategoryOfFood(name));
        return repositoryCategory.save(model.getCategoryOfFoodById(id));
    }

    @GetMapping("getAllCategoryOfFood")
    @Override
    public List<CategoryOfFood> getAllCategoryOfFood() {
        return repositoryCategory.findAll();

    }

    @GetMapping("getCategoryById")
    @Override
    public CategoryOfFood getCategoryById(int id) throws NotFoundObject {
        if (checkCategory(id)) {
            throw new NotFoundObject();
        }
        return repositoryCategory.getById(id);
    }
    @PostMapping("addFood")
    @Override
    public Food addFood(String name, int id, int price) throws WrongNameFood, NotFoundObject {
        if (checkCategory(id)) {
            throw new NotFoundObject();
        }
        for (Food food : model.getAllFood()) {
            if (food.getName().equals(name)) {
                throw new WrongNameFood();
            }
        }
        int id_ = model.addFood(new Food(name, repositoryCategory.getById(id), price));
        Food neededFood = model.getFoodById(id_);
        return repositoryFood.save(neededFood);
    }

    @GetMapping("getFoodById")
    @Override
    public Food getFoodById(int id) throws NotFoundObject {
        if (id > model.getAllFood().size() || id < 0) {
            throw new NotFoundObject();
        }
        return repositoryFood.getById(id);
    }

    @GetMapping("getAllFood")
    @Override
    public List<Food> getAllFood() {
        return repositoryFood.findAll();
    }

    @GetMapping("getFoodByCategoryId")
    @Override
    public List<Food> getFoodByCategoryId(int id) throws NotFoundObject {
        if (checkCategory(id)) {
            throw new NotFoundObject();
        }
        return repositoryFood.findFoodsByCategoryOfFood(model.getCategoryOfFoodById(id));

    }

    @Override
    public void writingToJson() throws IOException {

    }

    @Override
    public Model readingFromJson() throws IOException {
        return null;
    }
}
