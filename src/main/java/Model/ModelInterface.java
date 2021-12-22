package Model;

import java.util.List;

public interface ModelInterface {
    public int addFood(Food food);

    public int addCategoryOfFood(CategoryOfFood  categoryOfFood);

    public List<Food> getAllFood();

    public List<CategoryOfFood> getAllCategoryOfFood();

    public Food getFoodById(int num);

    public CategoryOfFood getCategoryOfFoodById(int num);

    public int getLengthFood();

    public int getLengthCategoryOfFood();
}
