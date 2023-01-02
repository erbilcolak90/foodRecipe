package com.kitchen.www.repositories.categories;

import com.kitchen.www.entities.categories.FoodCategory;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface FoodCategoryRepository extends MongoRepository<FoodCategory,String> {
}
