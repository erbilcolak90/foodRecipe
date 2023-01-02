package com.kitchen.www.repositories.categories;

import com.kitchen.www.entities.categories.IngredientCategory;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface IngredientCategoryRepository extends MongoRepository<IngredientCategory,String> {
}
