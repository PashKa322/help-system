package Model;

public class CategoryOfFood {

    private String name;

    private int idCategoryFood;

    public CategoryOfFood(String name){
        this.name = name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }

    public void setIdCategoryFood(int idCategoryFood) {
        this.idCategoryFood = idCategoryFood;
    }

    public int getIdCategoryFood() {
        return idCategoryFood;
    }

    @Override
    public String toString() {
        return "Name: " + name;
    }



}
