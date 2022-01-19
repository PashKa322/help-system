package com.example.webhelpsystem.Controller;


import com.example.webhelpsystem.Model.*;
import com.example.webhelpsystem.exc.NotFoundObject;
import com.example.webhelpsystem.exc.WrongNameCategory;
import com.example.webhelpsystem.exc.WrongNameFood;
import org.springframework.stereotype.Service;

import java.io.IOException;
import java.util.List;

@Service
public interface ControllerInterface {
    public void addCategoryOfFood(String name) throws WrongNameCategory;

    public List getAllCategoryOfFood();

    public CategoryOfFood getCategoryById(int id) throws NotFoundObject;

    public void addFood(String name, int id, int price) throws WrongNameFood, NotFoundObject;

    public Food getFoodById(int id) throws NotFoundObject;

    public List getAllFood();

    public List<Food> getFoodByCategoryId(int id) throws NotFoundObject;

    public void writingToJson() throws IOException;

    public Model readingFromJson() throws IOException;

}
