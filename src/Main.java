import Controller.Controller;
import Model.Model;
import Model.Food;
import Model.CategoryOfFood;

public class Main {
    public static void main(String[] args) {

        Model a = new Model();

        Controller controller = new Controller(a);

        controller.addCategoryOfFood("myaso");

        controller.addFood("asd", 0, 789);
        controller.addFood("ads", 0, 589);
        controller.addFood("vvv", 0, 1089);

        controller.getAllFood();

        controller.getAllCategoryOfFood();


    }
}
