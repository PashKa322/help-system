import Controller.Controller;
import Model.Model;
import View.View;
import exc.NotFoundObject;
import exc.WrongNameCategory;
import exc.WrongNameFood;

import java.sql.SQLOutput;
import java.util.ArrayList;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) throws WrongNameCategory, WrongNameFood, NotFoundObject {
        Model model = new Model();
        View view = new View(model);
        Controller controller = new Controller(model, view);
        controller.addCategoryOfFood("ASd");
        Scanner sc;
        while (true){
            System.out.println("Введите команду: ");
            sc = new Scanner(System.in);
            String str = sc.nextLine();
            String[] arrstr = str.split(" ");

            switch (arrstr[0]){
                case "addCategoryOfFood":
                    controller.addCategoryOfFood(arrstr[1]);
                    break;
                case "getAllCategoryOfFood":
                    controller.getAllCategoryOfFood();
                    break;
                case "getCategoryById":
                    controller.getCategoryById(Integer.parseInt(arrstr[1]));
                    break;
                case "addFood":
                    controller.addFood(arrstr[1], Integer.parseInt(arrstr[2]), Integer.parseInt(arrstr[3]));
                    break;
                case "getFoodById":
                    controller.getFoodByI(Integer.parseInt(arrstr[1]));
                    break;
                case "getAllFood":
                    controller.getAllFood();
                    break;
                case "getFoodByCategoryId":
                    controller.getFoodByCategoryId(Integer.parseInt(arrstr[1]));
                    break;
            }
        }






    }
}
