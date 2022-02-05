package com.example.webhelpsystem.Model;

import org.springframework.stereotype.Service;

import java.util.List;

@Service
public interface ModelInterface {
    public int addFood(Food food);

    public int addCategoryOfFood(CategoryOfFood  categoryOfFood);

    public List<Food> getAllFood();

    public void setAllFood(List<Food> newArrFood);

    public List<CategoryOfFood> getAllCategoryOfFood();

    public Food getFoodById(int num);

    public CategoryOfFood getCategoryOfFoodById(int num);

    public List<Food> getFoodByCategoryId(int id);

    public int getLengthFood();

    public int getLengthCategoryOfFood();
}
