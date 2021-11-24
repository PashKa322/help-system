import Controller.Controller;
import Model.Model;
import Model.Food;
import Model.CategoryOfFood;
import View.View;

public class Main {
    public static void main(String[] args) {

        Model model = new Model();
        View view = new View(model);

        Controller controller = new Controller(model, view);

        controller.addCategoryOfFood("Мясное");

        controller.addFood("asd", 0, 789);
        controller.addFood("ass", 0, 999);
        controller.addFood("ddd", 0, 1024);


    }
}
