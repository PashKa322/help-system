package Controller;

import Model.Model;
import exc.NotFoundObject;
import exc.WrongNameCategory;
import exc.WrongNameFood;

import java.io.IOException;

public interface ControllerInterface {
    public void addCategoryOfFood(String name) throws WrongNameCategory;

    public void getAllCategoryOfFood();

    public void getCategoryById(int id) throws NotFoundObject;

    public void addFood(String name, int id, int price) throws WrongNameFood, NotFoundObject;

    public void getFoodById(int id) throws NotFoundObject;

    public void getAllFood();

    public void getFoodByCategoryId(int id) throws NotFoundObject;

    public void writingToJson() throws IOException;

    public Model readingFromJson() throws IOException;

}
