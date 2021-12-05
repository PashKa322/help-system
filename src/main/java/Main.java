import Controller.Controller;
import Model.Model;
import Model.*;
import View.View;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import exc.NotFoundObject;
import exc.WrongNameCategory;
import exc.WrongNameFood;


import javax.sound.midi.Soundbank;
import java.io.IOException;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) throws WrongNameCategory, WrongNameFood, NotFoundObject, IOException{
        ObjectMapper objectMapper = new ObjectMapper();



        Model model = new Model();
        View view = new View(model);
        Controller controller = new Controller(model, view, objectMapper);
        controller.addCategoryOfFood("ASd");
        controller.addFood("qe", 0, 789);
        controller.addFood("asd", 0, 789);

        CategoryOfFood category = new CategoryOfFood("Asddd");

        controller.writingToJson();
        System.out.println(controller.readingFromJson().getAllFood().size());
//        Scanner sc;
//        while (true){
//            System.out.println("Введите команду: ");
//            sc = new Scanner(System.in);
//            String str = sc.nextLine();
//            String[] arrstr = str.split(" ");
//
//            switch (arrstr[0]){
//                case "addCategoryOfFood":
//                    controller.addCategoryOfFood(arrstr[1]);
//                    break;
//                case "getAllCategoryOfFood":
//                    controller.getAllCategoryOfFood();
//                    break;
//                case "getCategoryById":
//                    controller.getCategoryById(Integer.parseInt(arrstr[1]));
//                    break;
//                case "addFood":
//                    controller.addFood(arrstr[1], Integer.parseInt(arrstr[2]), Integer.parseInt(arrstr[3]));
//                    break;
//                case "getFoodById":
//                    controller.getFoodById(Integer.parseInt(arrstr[1]));
//                    break;
//                case "getAllFood":
//                    controller.getAllFood();
//                    break;
//                case "getFoodByCategoryId":
//                    controller.getFoodByCategoryId(Integer.parseInt(arrstr[1]));
//                    break;
//            }
//        }









    }
}
