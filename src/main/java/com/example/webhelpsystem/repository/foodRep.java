package com.example.webhelpsystem.repository;

import com.example.webhelpsystem.Model.Food;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface foodRep extends CrudRepository<Food, Integer> {

}
