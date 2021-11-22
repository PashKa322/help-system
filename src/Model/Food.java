package Model;

public class Food {

    private String name;

    private CategoryOfFood categoryOfFood;

    private int price;

    public Food(String name, CategoryOfFood categoryOfFood, int price){
        this.name = name;
        this.categoryOfFood = categoryOfFood;
        this.price = price;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setCategoryOfFood(CategoryOfFood categoryOfFood) {
        this.categoryOfFood = categoryOfFood;
    }

    public void setPrice(int price) {
        this.price = price;
    }

    public String getName() {
        return name;
    }

    public CategoryOfFood getCategoryOfFood() {
        return categoryOfFood;
    }

    public int getPrice() {
        return price;
    }
}
