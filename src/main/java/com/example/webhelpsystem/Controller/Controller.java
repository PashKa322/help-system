package com.example.webhelpsystem.Controller;

import com.example.webhelpsystem.Model.*;
import com.example.webhelpsystem.View.ViewInterface;
import com.example.webhelpsystem.exc.NotFoundObject;
import com.example.webhelpsystem.exc.WrongNameCategory;
import com.example.webhelpsystem.exc.WrongNameFood;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.List;

/**
 * Кл

    public List<Food> getFoodByCategoryId(int id) throws NotFoundObject {
        if (checkCategory(id)) {
            throw new NotFoundObject();
        }
        view.printFoodByCategoryId(id);
        return null;
    }


    /**
     * Функция сохранения модели в json файл
     * @throws IOException
     */
    public void writingToJson() throws IOException {
        FileOutputStream out = new FileOutputStream("z.json");
        out.write(objectMapper.writeValueAsBytes(model));
        out.close();
    }


    /**
     * Функция получения модели из json файла
     * @return
     * @throws IOException
     */
    public Model readingFromJson() throws IOException {
        Model model = objectMapper.readValue(new File("z.json"), Model.class);
        return model;
    }

}




