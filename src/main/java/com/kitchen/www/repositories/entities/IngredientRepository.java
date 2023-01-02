package com.kitchen.www.repositories.entities;

import com.kitchen.www.entities.Ingredient;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.data.mongodb.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface IngredientRepository extends MongoRepository<Ingredient, String> {

    Ingredient findByName(String name);

    //List<Ingredient> getIngredients();


    //@Query(value = "{'name' : { '$regex' : ?0 }}")
  //  @Query(value = "{ $name: { $search: ?0 } }")
    List<Ingredient> findByNameContaining(String name);

    @Query("{ 'name': { $regex:?0, $options: 'i'}, 'foodCategory': {$regex :?1 , $options: 'i'}}")
    List<Ingredient> findByNameAndFoodCategoryContaining(String name, String foodCategory);

    @Query(value = "{'ingredientCategory' : ?0 }",fields = "{'name' : 1 , 'pictureUrl' : 1 , 'ingredientCategory': 1 , 'foodCategory' : 1}")
    List<Ingredient> findByContainsIngredientCategory(String id);
}
