import Controller.Controller;
import Model.Model;
import Model.*;
import View.View;
import com.fasterxml.jackson.databind.ObjectMapper;
import exc.NotFoundObject;
import exc.WrongNameCategory;
import exc.WrongNameFood;



public class Main {
    public static void main(String[] args) throws WrongNameCategory, WrongNameFood, NotFoundObject{
        ObjectMapper objectMapper = new ObjectMapper();



        Model model = new Model();
        View view = new View(model);
        Controller controller = new Controller(model, view, objectMapper);
        controller.addCategoryOfFood("ASd");
        controller.addFood("qe", 0, 789);
        controller.addFood("asd", 0, 789);

        Command command = Command.ADD_CATEGORY_OF_FOOD;

        String[] strings = new String[1];
        strings[0] = "myaso";

        strings[0] = String.valueOf(command.processCommand(strings, model));
        command.updateView(view, strings);















    }
}
