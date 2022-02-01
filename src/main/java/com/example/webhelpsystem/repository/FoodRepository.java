package com.example.webhelpsystem.repository;

import com.example.webhelpsystem.Model.Food;
import org.springframework.data.jpa.repository.JpaRepository;

interface FoodRepository extends JpaRepository<Food, String> {

}
