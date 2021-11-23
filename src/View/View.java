package View;

import Model.*;


public class View {

    private Model model;

    public View(Model model){
        this.model = model;
    }

    public void printAllFood(){
        System.out.println("Список всех блюд: ");
        for(Food food: model.getAllFood()){
            System.out.println(food);
        }
    }

    public void printAllCategoryOfFood(){
        System.out.println("Список всех категорий блюд: ");
        for(CategoryOfFood categoryOfFood: model.getAllCategoryOfFood()){
            System.out.println(categoryOfFood);
        }
    }

    public void printLastFood(){
        System.out.println("Добавленное блюдо: ");
        System.out.println(model.getAllFood().get(model.getLengthFood() - 1));
    }

    public void printLastCategoryOfFood(){
        System.out.println("Добавленная категория: ");
        System.out.println(model.getAllCategoryOfFood().get(model.getLengthCategoryOfFood() - 1));
    }

}
