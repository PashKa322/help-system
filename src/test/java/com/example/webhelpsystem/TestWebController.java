package com.example.webhelpsystem;

import com.example.webhelpsystem.Controller.WebController;
import com.example.webhelpsystem.Model.CategoryOfFood;
import com.example.webhelpsystem.Model.Food;
import com.example.webhelpsystem.Model.ModelInterface;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mockito;
import org.skyscreamer.jsonassert.JSONAssert;
import org.skyscreamer.jsonassert.JSONCompareMode;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.*;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.MvcResult;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;

import java.util.LinkedList;
import java.util.List;

import static org.mockito.Mockito.when;
import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.print;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;


@RunWith(SpringRunner.class)
@WebMvcTest(WebController.class)
@AutoConfigureMockMvc
public class TestWebController {
    @Autowired
    private MockMvc mockMvc;
    @MockBean
    ModelInterface model;
    @Autowired
    WebController webController;

    private List<Food> foods;
    private List<CategoryOfFood> categoryOfFoods;
    private ObjectMapper mapper;

    @Before
    public void setup(){
        foods = new LinkedList<Food>();
        CategoryOfFood category = new CategoryOfFood("Myasnoe");
        Food food = new Food("lala", category, 789);
        food.setIdFood(0);
        Food food1 = new Food("adada", category, 547);
        food1.setIdFood(1);
        foods.add(food);
        foods.add(food1);

        categoryOfFoods = new LinkedList<CategoryOfFood>();
        CategoryOfFood category1 = new CategoryOfFood("Myasnoe");
        category1.setIdCategoryFood(0);
        CategoryOfFood category2 = new CategoryOfFood("Riba");
        category2.setIdCategoryFood(1);
        categoryOfFoods.add(category1);
        categoryOfFoods.add(category2);

        mapper = new ObjectMapper();
    }

    @Test
    public void testGetAllFoods() throws Exception {
        when(webController.getAllFood()).thenReturn(foods);

        MvcResult result = mockMvc.perform(MockMvcRequestBuilders
                        .get("/getAllFood")
                        .contentType(MediaType.APPLICATION_JSON))
                .andExpect(status().isOk()).andDo(print()).andReturn();

        String content = result.getResponse().getContentAsString();
        String json = mapper.writeValueAsString(foods);
        JSONAssert.assertEquals(content, json, JSONCompareMode.LENIENT);
    }

    @Test
    public void testGetAllCategoryOfFood() throws Exception {
        when(webController.getAllCategoryOfFood()).thenReturn(categoryOfFoods);

        MvcResult result = mockMvc.perform(MockMvcRequestBuilders
                        .get("/getAllCategoryOfFood")
                        .contentType(MediaType.APPLICATION_JSON))
                .andExpect(status().isOk()).andDo(print()).andReturn();

        String content = result.getResponse().getContentAsString();
        String json = mapper.writeValueAsString(categoryOfFoods);
        JSONAssert.assertEquals(content, json, JSONCompareMode.LENIENT);
    }

    @Test
    public void testAddCategoryOfFood() throws Exception {
        String name = "Myasnoe";
        CategoryOfFood category = new CategoryOfFood(name);

        when(webController.addCategoryOfFood(name)).thenReturn(category);

        MvcResult result = mockMvc.perform(MockMvcRequestBuilders.post("/addCategoryOfFood")
                .contentType(MediaType.APPLICATION_JSON)
                .param("name", name))
                .andExpect(status().isOk()).andDo(print()).andReturn();

        String content = result.getResponse().getContentAsString();
        String json = mapper.writeValueAsString(category);

        JSONAssert.assertEquals(content, json, JSONCompareMode.LENIENT);
    }

    @Test
    public void testGetCategoryOfFoodById() throws Exception {
        when(webController.getCategoryById(0)).thenReturn(categoryOfFoods.get(0));

        MvcResult result = mockMvc.perform(MockMvcRequestBuilders
                        .get("/getCategoryById")
                        .param("id", String.valueOf(0))
                        .contentType(MediaType.APPLICATION_JSON))
                .andExpect(status().isOk()).andDo(print()).andReturn();

        String content = result.getResponse().getContentAsString();
        String json = mapper.writeValueAsString(categoryOfFoods.get(0));
        JSONAssert.assertEquals(content, json, JSONCompareMode.LENIENT);
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

        Mockito.when(webController.addFood(name, id, price)).thenReturn(food);

        MvcResult result = mockMvc.perform(MockMvcRequestBuilders.post("/addFood")
                        .contentType(MediaType.APPLICATION_JSON)
                        .param("name", name).param("id", String.valueOf(id)).param("price", String.valueOf(price)))
                .andExpect(status().isOk()).andDo(print()).andReturn();

        String content = result.getResponse().getContentAsString();
        String json = mapper.writeValueAsString(food);
        JSONAssert.assertEquals(content, json, JSONCompareMode.LENIENT);
    }

    @Test
    public void testGetFoodByID() throws Exception {
        when(webController.getFoodById(0)).thenReturn(foods.get(0));

        MvcResult result = mockMvc.perform(MockMvcRequestBuilders
                        .get("/getFoodById").param("id", String.valueOf(0))
                        .contentType(MediaType.APPLICATION_JSON))
                .andExpect(status().isOk()).andDo(print()).andReturn();

        String content = result.getResponse().getContentAsString();
        String json = mapper.writeValueAsString(foods.get(0));
        JSONAssert.assertEquals(content, json, JSONCompareMode.LENIENT);
    }

    @Test
    public void testGetFoodByCategoryId() throws Exception {
        when(webController.getFoodByCategoryId(0)).thenReturn(foods);

        MvcResult result = mockMvc.perform(MockMvcRequestBuilders
                        .get("/getFoodByCategoryId").param("id", String.valueOf(0))
                        .contentType(MediaType.APPLICATION_JSON))
                .andExpect(status().isOk()).andDo(print()).andReturn();

        String content = result.getResponse().getContentAsString();
        String json = mapper.writeValueAsString(foods);
        JSONAssert.assertEquals(content, json, JSONCompareMode.LENIENT);
    }
}
