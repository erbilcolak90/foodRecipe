package com.kitchen.www.controller.categories;

import com.kitchen.www.entities.categories.FoodCategory;
import com.kitchen.www.inputs.PaginationInput;
import com.kitchen.www.inputs.category.FoodCategoryInput;
import com.kitchen.www.services.categories.FoodCategoryService;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("foodCategory")
public class FoodCategoryController {

    private final FoodCategoryService foodCategoryService;

    @Autowired
    public FoodCategoryController(FoodCategoryService foodCategoryService) {
        this.foodCategoryService = foodCategoryService;
    }

    @GetMapping("/getFoodCategoryById")
    public FoodCategory getFoodCategory(@RequestBody FoodCategoryInput foodCategoryInput){

        return foodCategoryService.getFoodCategoryById(foodCategoryInput);
    }

    @GetMapping("/getAllFoodCategories")
    public Page<FoodCategory> getAllFoodCategories(@RequestBody PaginationInput paginationInput){

        return foodCategoryService.getAllFoodCategories(paginationInput);
    }

    @PostMapping("/addFoodCategory")
    public FoodCategory addFoodCategory(@Valid @RequestBody FoodCategoryInput foodCategoryInput){

        return foodCategoryService.addFoodCategory(foodCategoryInput);
    }

    @PostMapping("/updateFoodCategory")
    public FoodCategory updateFoodCategory(@Valid @RequestBody FoodCategoryInput foodCategoryInput){

        return foodCategoryService.updateFoodCategory(foodCategoryInput);
    }

    @PostMapping("/deleteFoodCategory")
    public String deleteFoodCategory(@Valid @RequestBody FoodCategoryInput foodCategoryInput){

        return foodCategoryService.deleteFoodCategory(foodCategoryInput);
    }

}
