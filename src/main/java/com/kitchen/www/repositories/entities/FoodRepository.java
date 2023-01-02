package com.kitchen.www.repositories.entities;

import com.kitchen.www.entities.Food;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.data.mongodb.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface FoodRepository extends MongoRepository<Food, String> {

    Food findByName(String name);

    @Query(value = "{'ingredients': { $all: ?0}}")
    Page<Food> findByIngredients(List<String> ingredientList,Pageable pageable);

}
