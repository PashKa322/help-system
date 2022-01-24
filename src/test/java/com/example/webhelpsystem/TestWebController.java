package com.example.webhelpsystem;

import com.example.webhelpsystem.Controller.WebController;
import com.example.webhelpsystem.Model.CategoryOfFood;
import com.example.webhelpsystem.Model.Food;
import com.example.webhelpsystem.Model.ModelInterface;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mockito;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.*;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.request.MockHttpServletRequestBuilder;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;

import java.util.LinkedList;
import java.util.List;

import static org.mockito.Mockito.when;
import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.print;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;


@RunWith(SpringRunner.class)
@WebMvcTest(WebController.class)
public class TestWebController {
    @Autowired
    private MockMvc mockMvc;

    @MockBean
    ModelInterface model;


    @Test
    public void testGetAllFoods() throws Exception {
        List<Food> foods = new LinkedList<Food>();
        CategoryOfFood category = new CategoryOfFood("Myasnoe");
        Food food = new Food("lala", category, 789);
        food.setIdFood(0);
        Food food1 = new Food("adada", category, 547);
        food1.setIdFood(1);
        foods.add(food);
        foods.add(food1);

        when(model.getAllFood()).thenReturn(foods);

        mockMvc.perform(MockMvcRequestBuilders
                        .get("/getAllFood")
                        .contentType(MediaType.APPLICATION_JSON))
                .andExpect(status().isOk()).andDo(print());
    }

    @Test
    public void testGetAllCategoryOfFood() throws Exception {
        List<CategoryOfFood> category = new LinkedList<CategoryOfFood>();
        CategoryOfFood category1 = new CategoryOfFood("Myasnoe");
        category1.setIdCategoryFood(0);
        CategoryOfFood category2 = new CategoryOfFood("Riba");
        category2.setIdCategoryFood(1);
        category.add(category1);
        category.add(category2);

        when(model.getAllCategoryOfFood()).thenReturn(category);

        mockMvc.perform(MockMvcRequestBuilders
                        .get("/getAllCategoryOfFood")
                        .contentType(MediaType.APPLICATION_JSON))
                .andExpect(status().isOk()).andDo(print());
    }

    @Test
    public void testAddCategoryOfFood() throws Exception {
        String name = "Myasnoe";
        CategoryOfFood category = new CategoryOfFood(name);

        Mockito.when(model.addCategoryOfFood(category)).thenReturn(category.getIdCategoryFood());

        MockHttpServletRequestBuilder mockRequest = MockMvcRequestBuilders.post("/addCategoryOfFood")
                .contentType(MediaType.APPLICATION_JSON)
                .accept(MediaType.APPLICATION_JSON)
                .param("name", name);

        mockMvc.perform(mockRequest)
                .andExpect(status().isOk()).andDo(print());
    }

    @Test
    public void testGetCategoryOfFoodById() throws Exception {
        List<CategoryOfFood> category = new LinkedList<CategoryOfFood>();
        CategoryOfFood category1 = new CategoryOfFood("Myasnoe");
        category1.setIdCategoryFood(0);
        CategoryOfFood category2 = new CategoryOfFood("Riba");
        category2.setIdCategoryFood(1);
        category.add(category1);
        category.add(category2);

        when(model.getCategoryOfFoodById(0)).thenReturn(category.get(0));

        mockMvc.perform(MockMvcRequestBuilders
                        .get("/getCategoryById")
                        .param("id", String.valueOf(0))
                        .contentType(MediaType.APPLICATION_JSON))
                .andExpect(status().isOk()).andDo(print());
    }

    @Test
    public void testAddFood() throws Exception {
        String name = "Myaso";
        int id = 0;
        int price = 789;
        CategoryOfFood category = new CategoryOfFood("Myasnoe");
        category.setIdCategoryFood(0);
        Food food = new Food(name, category, price);
        food.setIdFood(0);

        Mockito.when(model.addFood(food)).thenReturn(food.getIdFood());

        MockHttpServletRequestBuilder mockRequest = MockMvcRequestBuilders.post("/addFood")
                .contentType(MediaType.APPLICATION_JSON)
                .accept(MediaType.APPLICATION_JSON)
                .param("name", name).param("id", String.valueOf(0)).param("price", String.valueOf(price));

        mockMvc.perform(mockRequest)
                .andExpect(status().isOk()).andDo(print());
    }

    @Test
    public void testGetFoodByID() throws Exception {
        List<Food> foods = new LinkedList<Food>();
        CategoryOfFood category = new CategoryOfFood("Myasnoe");
        Food food = new Food("lala", category, 789);
        food.setIdFood(0);
        Food food1 = new Food("adada", category, 547);
        food1.setIdFood(1);
        foods.add(food);
        foods.add(food1);

        when(model.getFoodById(0)).thenReturn(food);

        mockMvc.perform(MockMvcRequestBuilders
                        .get("/getFoodById").param("id", String.valueOf(0))
                        .contentType(MediaType.APPLICATION_JSON))
                .andExpect(status().isOk()).andDo(print());
    }

    @Test
    public void testGetFoodByCategoryId() throws Exception {
        List<Food> foods = new LinkedList<Food>();
        CategoryOfFood category = new CategoryOfFood("Myasnoe");
        Food food = new Food("lala", category, 789);
        food.setIdFood(0);
        Food food1 = new Food("adada", category, 547);
        food1.setIdFood(1);
        foods.add(food);
        foods.add(food1);

        when(model.getFoodByCategoryId(0)).thenReturn(foods);

        mockMvc.perform(MockMvcRequestBuilders
                        .get("/getFoodByCategoryId").param("id", String.valueOf(0))
                        .contentType(MediaType.APPLICATION_JSON))
                .andExpect(status().isOk()).andDo(print());
    }







}
