package com.kitchen.www.services;


import com.kitchen.www.entities.Food;
import com.kitchen.www.entities.Ingredient;
import com.kitchen.www.entities.categories.FoodCategory;
import com.kitchen.www.inputs.IngredientInput;
import com.kitchen.www.inputs.PaginationInput;
import com.kitchen.www.repositories.entities.IngredientRepository;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.data.mongodb.core.MongoTemplate;
import org.springframework.data.mongodb.core.query.Criteria;
import org.springframework.data.mongodb.core.query.Query;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;


@Service
@NoArgsConstructor
@Data
public class IngredientService {

    private IngredientRepository ingredientRepository;

    private MongoTemplate mongoTemplate;

    @Autowired
    public IngredientService(IngredientRepository ingredientRepository, MongoTemplate mongoTemplate) {
        this.ingredientRepository = ingredientRepository;
        this.mongoTemplate = mongoTemplate;
    }

    public Ingredient getIngredientById(String id){
        return ingredientRepository.findById(id).orElseThrow();
    }

    public Ingredient getIngredientByName(String name){
        return ingredientRepository.findByName(name);
    }

    public Page<Ingredient> getAllIngredient(PaginationInput paginationInput){

        Pageable pageable = PageRequest.of(paginationInput.getPage(), paginationInput.getSize(), Sort.by(Sort.Direction.ASC, paginationInput.getSortBy()));
        return ingredientRepository.findAll(pageable);
    }

   /* public List<Ingredient> getIngredients(){
        return ingredientRepository.getIngredients();
    }*/

    public List<Object> getData(String ingredientName, String foodName, String kitchenName){
        List<Object> data = new ArrayList<>();

       /* List<Ingredient> ingredientList = ingredientRepository.findByContainsName(ingredientName);
        data.addAll(ingredientList);*/

        Query query1 = new Query();
        query1.addCriteria(Criteria.where("name").is(ingredientName));
        //data.addAll(mongoTemplate.find(query1,Ingredient.class));


        Query query2= new Query();
        query2.addCriteria(Criteria.where("name").is(foodName));
        data.addAll(mongoTemplate.find(query2, Food.class));

        Query query3 = new Query();
        query3.addCriteria(Criteria.where("name").is(kitchenName));
        data.addAll((mongoTemplate.find(query3, FoodCategory.class)));


        return  data;
    }

    public List<Ingredient> findByNameContaining(String name){

        return ingredientRepository.findByNameContaining(name);
    }

    public List<Ingredient> findByNameAndFoodCategoryContaining(String name, String foodCategory){
        return ingredientRepository.findByNameAndFoodCategoryContaining(name, foodCategory);
    }

    public List<Ingredient> findByContainsIngredientCategory(String id){

        return ingredientRepository.findByContainsIngredientCategory(id);
    }

    @Transactional
    public Ingredient addIngredient(IngredientInput ingredientInput){
        Ingredient tempIngredient = new Ingredient();
        tempIngredient.setName(ingredientInput.getName());
        tempIngredient.setPictureURL(ingredientInput.getPictureURL());
        tempIngredient.setIngredientCategory(ingredientInput.getIngredientCategory());
        tempIngredient.setFoodCategory(ingredientInput.getFoodCategory());
        tempIngredient.setCreateDate(new Date());
        ingredientRepository.save(tempIngredient);

        return tempIngredient;
    }

    @Transactional
    public Ingredient updateIngredient(IngredientInput ingredientInput){
        Ingredient tempIngredient = ingredientRepository.findById(ingredientInput.getId()).orElseThrow();
        tempIngredient.setName(ingredientInput.getName());
        tempIngredient.setPictureURL(ingredientInput.getPictureURL());
        if(ingredientInput.getIngredientCategory()!=null && !ingredientInput.getIngredientCategory().isEmpty()){
            tempIngredient.setIngredientCategory(ingredientInput.getIngredientCategory());
        }
        if(ingredientInput.getFoodCategory()!=null && !ingredientInput.getFoodCategory().isEmpty()){
            tempIngredient.setFoodCategory(ingredientInput.getFoodCategory());
        }

        ingredientRepository.save(tempIngredient);

        return tempIngredient;
    }

    @Transactional
    public String deleteIngredient(String id){
        Ingredient tempIngredient = ingredientRepository.findById(id).orElseThrow();
        tempIngredient.setDeleted(true);

        ingredientRepository.save(tempIngredient);
        return "ingredient deleted.";
    }

}
