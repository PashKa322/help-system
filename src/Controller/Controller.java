package Controller;

import Model.CategoryOfFood;
import Model.Model;
import Model.Food;

public class Controller {

    private Model model;

    public Controller(Model model){
        this.model = model;
    }

    public void addCategoryOfFood(String name){
        model.addCategoryOfFood(new CategoryOfFood(name));
    }

    public void getAllCategoryOfFood(){
        System.out.println("Список всех категорий блюд: ");
        model.getAllCategoryOfFood();
    }

    public void addFood(String name, int id, int price){
        model.addFood(new Food(name, model.getCategoryOfFood(id), price));
    }

    public void getAllFood(){
        System.out.println("Список всех блюд: ");
        model.getAllFood();
    }

}
