package com.example.webhelpsystem.View;

import org.springframework.stereotype.Service;

@Service
public interface ViewInterface {
    public void printAllFood();

    public void printAllCategoryOfFood();

    public void printLastFood(int num);

    public void printLastCategoryOfFood(int num);

    public void printCategoryById(int num);

    public void printFoodById(int num);

    public void printFoodByCategoryId(int num);

}
