package Model;

public class Food {

    private String name;

    private CategoryOfFood categoryOfFood;

    private int price;

    private int idFood;

    public Food(String name, CategoryOfFood categoryOfFood, int price){
        this.name = name;
        this.categoryOfFood = categoryOfFood;
        this.price = price;
    }


    public Food(){

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

    public void setIdFood(int idFood) {
        this.idFood = idFood;
    }

    public int getIdFood() {
        return idFood;
    }

    @Override
    public String toString() {
        return "Name: " + name + " price: " + price + " category: " + categoryOfFood;
    }
}
