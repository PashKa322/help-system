package Model;

import java.util.LinkedList;
import java.util.List;

public class Model {

   private List<Food> arrFood = new LinkedList<Food>();

   private List<CategoryOfFood> arrCategoryOfFood = new LinkedList<CategoryOfFood>();

   public void addFood(Food food){
      arrFood.add(food);
   }

   public void addCategoryOfFood(CategoryOfFood  categoryOfFood){
      arrCategoryOfFood.add(categoryOfFood);
   }

   public List<Food> getAllFood(){
      return arrFood;
   }

   public List<CategoryOfFood> getAllCategoryOfFood(){
      return arrCategoryOfFood;
   }

   public Food getFood(int num){
      return arrFood.get(num);
   }

   public CategoryOfFood getCategoryOfFood(int num){
      return arrCategoryOfFood.get(num);
   }

   public int getLengthFood(){
      return arrFood.size();
   }

   public int getLengthCategoryOfFood(){
      return arrCategoryOfFood.size();
   }


}
