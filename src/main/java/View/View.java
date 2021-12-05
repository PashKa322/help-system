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

    public void printLastFood(int num){
        System.out.println("Добавленное блюдо: ");
        System.out.println(model.getFoodById(num));
    }

    public void printLastCategoryOfFood(int num){
        System.out.println("Добавленная категория: ");
        System.out.println(model.getCategoryOfFoodById(num));
    }

    public void printCategoryById(int num){
        System.out.printf("Категория с номером %d: \n", num);
        System.out.println(model.getCategoryOfFoodById(num));
    }

    public void printFoodById(int num){
        System.out.printf("Еда с номером %d: \n", num);
        System.out.println(model.getFoodById(num));
    }

    public void printFoodByCategoryId(int num){
        System.out.println("Блюда по номеру категории: ");
        for (Food food: model.getAllFood()){
            if(food.getCategoryOfFood() == model.getCategoryOfFoodById(num)){
                System.out.println(food);
            }
        }
    }



}
