package com.example.webhelpsystem.repository;

import com.example.webhelpsystem.Model.CategoryOfFood;
import com.example.webhelpsystem.Model.Food;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface FoodRepository extends JpaRepository<Food, Integer> {
    public List<Food> findFoodsByCategoryOfFood(CategoryOfFood category);
}
