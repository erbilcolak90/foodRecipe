package com.kitchen.www.controller;

import com.kitchen.www.entities.Ingredient;
import com.kitchen.www.inputs.IngredientInput;
import com.kitchen.www.inputs.PaginationInput;
import com.kitchen.www.services.IngredientService;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.mongodb.core.MongoTemplate;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/ingredient")
public class IngredientController {

    private IngredientService ingredientService;
    private MongoTemplate mongoTemplate;

    @Autowired
    public IngredientController(IngredientService ingredientService, MongoTemplate mongoTemplate) {
        this.ingredientService = ingredientService;
        this.mongoTemplate = mongoTemplate;
    }

    @GetMapping("/getIngredientById")
    public Ingredient getIngredientById(@RequestParam String id){
        return ingredientService.getIngredientById(id);
    }

    @GetMapping("/getIngredientByName")
    public Ingredient getIngredientByName(@RequestParam String name){
        return ingredientService.getIngredientByName(name);
    }

    @GetMapping("/getAllIngredients")
    public Page<Ingredient> getAllIngredient(@RequestBody PaginationInput paginationInput){
        return ingredientService.getAllIngredient(paginationInput);
    }

   /* @GetMapping("/getIngredients")
    public List<Ingredient> getIngredients(){
        return ingredientService.getIngredients();
    }*/

    @GetMapping("/getData")
    public List<Object> getData(String ingredientName, String foodName, String kitchenName){
        return ingredientService.getData(ingredientName, foodName, kitchenName);
    }

    //ingredientCategory içeriğinde verilen id yi içeren tüm ürünlerin listelenmesi.
    @GetMapping("/findByContainsIngredientCategory")
    public List<Ingredient> findByContainsIngredientCategory(@RequestParam String id){
        return ingredientService.findByContainsIngredientCategory(id);
    }

    @GetMapping("/findByNameContaining")
    public List<Ingredient> findByNameContaining(@RequestParam String name){
        return ingredientService.findByNameContaining(name);
    }

    @GetMapping("/findByNameAndFoodCategoryContaining")
    public List<Ingredient> findByNameAndFoodCategoryContaining(@RequestParam String name,@RequestParam String foodCategory){
        return ingredientService.findByNameAndFoodCategoryContaining(name, foodCategory);
    }

    @PostMapping("/addIngredient")
    public Ingredient addIngredient(@RequestBody @Valid IngredientInput ingredientInput){
        return ingredientService.addIngredient(ingredientInput);
    }

    @PostMapping("/updateIngredient")
    public Ingredient updateIngredient(@RequestBody @Valid IngredientInput ingredientInput){
        return ingredientService.updateIngredient(ingredientInput);
    }

    @PostMapping("/deleteIngredient")
    public String deleteIngredient(@RequestParam String id) {
        return ingredientService.deleteIngredient(id);
    }
}
