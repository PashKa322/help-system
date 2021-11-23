package Controller;

import Model.CategoryOfFood;
import Model.*;
import View.*;

public class Controller {

    private Model model;
    private View view;

    public Controller(Model model, View view){
        this.model = model;
        this.view = view;
    }

    public void addCategoryOfFood(String name){
        model.addCategoryOfFood(new CategoryOfFood(name));
        view.printLastCategoryOfFood();
    }

    public void getAllCategoryOfFood(){
        view.printAllCategoryOfFood();
    }

    public void addFood(String name, int id, int price){
        model.addFood(new Food(name, model.getCategoryOfFood(id), price));
        view.printLastFood();
    }

    public void getAllFood(){
        view.printAllFood();
    }

}
