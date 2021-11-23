package Model;

import java.util.ArrayList;

public class Model {

   private ArrayList<Food> arrFood = new ArrayList<Food>();

   private ArrayList<CategoryOfFood> arrCategoryOfFood = new ArrayList<CategoryOfFood>();

   public void addFood(Food food){
      arrFood.add(food);
   }

   public void addCategoryOfFood(CategoryOfFood  categoryOfFood){
      arrCategoryOfFood.add(categoryOfFood);
   }

   public void getAllFood(){
      for(Food food : arrFood){
         System.out.println(food);
      }
   }

   public void getAllCategoryOfFood(){
      for(CategoryOfFood categoryOfFood : arrCategoryOfFood){
         System.out.println(categoryOfFood);
      }
   }

   public Food getFood(int num){
      return arrFood.get(num);
   }

   public CategoryOfFood getCategoryOfFood(int num){
      return arrCategoryOfFood.get(num);
   }


}
