package com.kitchen.www.controller.categories;

import com.kitchen.www.entities.categories.IngredientCategory;
import com.kitchen.www.inputs.PaginationInput;
import com.kitchen.www.inputs.category.IngredientCategoryInput;
import com.kitchen.www.services.categories.IngredientCategoryService;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("ingredientCategory")
public class IngredientCategoryController {

    private final IngredientCategoryService ingredientCategoryService;

    @Autowired
    public IngredientCategoryController(IngredientCategoryService ingredientCategoryService) {
        this.ingredientCategoryService = ingredientCategoryService;
    }

    @GetMapping("/getIngredientCategoryById")
    public IngredientCategory getIngredientCategory(@RequestBody IngredientCategoryInput ingredientCategoryInput){

        return ingredientCategoryService.getIngredientCategoryById(ingredientCategoryInput);
    }

    @GetMapping("/getAllIngredientCategories")
    public Page<IngredientCategory> getAllIngredientCategories(@RequestBody PaginationInput paginationInput){

        return ingredientCategoryService.getAllIngredientCategories(paginationInput);
    }

    @PostMapping("/addIngredientCategory")
    public IngredientCategory addIngredientCategory(@Valid @RequestBody IngredientCategoryInput ingredientCategoryInput){

        return ingredientCategoryService.addIngredientCategory(ingredientCategoryInput);
    }

    @PostMapping("/updateIngredientCategory")
    public IngredientCategory updateIngredientCategory(@Valid @RequestBody IngredientCategoryInput ingredientCategoryInput){

        return ingredientCategoryService.updateIngredientCategory(ingredientCategoryInput);
    }

    @PostMapping("/deleteIngredientCategory")
    public String deleteIngredientCategory(@Valid @RequestBody IngredientCategoryInput ingredientCategoryInput){

        return ingredientCategoryService.deleteIngredientCategory(ingredientCategoryInput);
    }
}
