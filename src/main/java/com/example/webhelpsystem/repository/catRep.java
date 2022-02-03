package com.example.webhelpsystem.repository;

import com.example.webhelpsystem.Model.CategoryOfFood;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface catRep extends CrudRepository<CategoryOfFood, Integer> {
    CategoryOfFood getCategoryOfFoodByIdCategoryFood(int id);
}
