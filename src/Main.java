import Controller.Controller;
import Model.Model;
import Model.Food;
import Model.CategoryOfFood;
import View.View;

public class Main {
    public static void main(String[] args) {

        Model model = new Model();
        model.addCategoryOfFood(new CategoryOfFood("asd"));
        model.addFood(new Food("Asd", model.getCategoryOfFood(0), 149));
        Controller controller = new Controller(model, new View(model));

        controller.addFood("asd", 0, 78900);
        controller.addFood("ddd", 0, 78900);
        controller.addFood("qwe", 0, 78900);
        controller.addFood("zxc", 0, 78900);

        controller.getAllFood();



    }
}
