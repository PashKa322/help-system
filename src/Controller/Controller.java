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
        int num = model.addCategoryOfFood(new CategoryOfFood(name));
        view.printLastCategoryOfFood(num);
    }

    public void getAllCategoryOfFood(){
        view.printAllCategoryOfFood();
    }

    public void addFood(String name, int id, int price){
        int num =  model.addFood(new Food(name, model.getCategoryOfFoodById(id), price));
        view.printLastFood(num);
    }

    public void getAllFood(){
        view.printAllFood();
    }

}
