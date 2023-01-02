package com.kitchen.www.controller;

import com.kitchen.www.entities.Food;
import com.kitchen.www.inputs.FoodInput;
import com.kitchen.www.inputs.PaginationInput;
import com.kitchen.www.inputs.PaginationWithListInput;
import com.kitchen.www.services.FoodService;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("food")
public class FoodController {

    private FoodService foodService;

    @Autowired
    public FoodController(FoodService foodService) {
        this.foodService = foodService;
    }

    @GetMapping("/getFoodById")
    public Food getFoodById(@RequestParam String id){
        return foodService.getFoodById(id);
    }

    @GetMapping("/getFoodByName")
    public Food getFoodByName(@RequestParam String name){
        return foodService.getFoodByName(name);
    }

    @GetMapping("/getAllFoods")
    public Page<Food> getAllFood(@RequestBody PaginationInput paginationInput){
        return foodService.getAllFood(paginationInput);
    }

    @GetMapping("/getAllFoodByIngredients")
    public Page<Food> getAllFoodByIngredients(@RequestBody PaginationWithListInput paginationWithListInput){
        return foodService.getAllFoodByIngredients(paginationWithListInput);
    }

    @PostMapping("/addFood")
    public Food addFood(@Valid @RequestBody FoodInput foodInput){
        return foodService.addFood(foodInput);
    }

    @PostMapping("/updateFood")
    public Food updateFood(@Valid @RequestBody FoodInput foodInput){
        return foodService.updateFood(foodInput);
    }

    @PostMapping("/deleteFood")
    public String deleteFood(@RequestParam String id) {
        return foodService.deleteFood(id);
    }
}
