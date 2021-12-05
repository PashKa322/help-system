package Model;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;


import java.util.LinkedList;
import java.util.List;

@JsonIgnoreProperties(ignoreUnknown = true)
public class Model{

   private List<Food> arrFood = new LinkedList<Food>();

   private List<CategoryOfFood> arrCategoryOfFood = new LinkedList<CategoryOfFood>();



   public int addFood(Food food){
      arrFood.add(food);
      food.setIdFood(arrFood.size() - 1);
      return food.getIdFood();
   }

   public int addCategoryOfFood(CategoryOfFood  categoryOfFood){
      arrCategoryOfFood.add(categoryOfFood);
      categoryOfFood.setIdCategoryFood(arrCategoryOfFood.size() - 1);
      return categoryOfFood.getIdCategoryFood();
   }

   public List<Food> getAllFood(){
      return arrFood;
   }

   public List<CategoryOfFood> getAllCategoryOfFood(){
      return arrCategoryOfFood;
   }

   public Food getFoodById(int num){
      return arrFood.get(num);
   }

   public CategoryOfFood getCategoryOfFoodById(int num){
      return arrCategoryOfFood.get(num);
   }

   public int getLengthFood(){
      return arrFood.size();
   }

   public int getLengthCategoryOfFood(){
      return arrCategoryOfFood.size();
   }



}
