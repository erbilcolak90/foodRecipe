package com.kitchen.www.services.categories;

import com.kitchen.www.entities.categories.IngredientCategory;
import com.kitchen.www.inputs.PaginationInput;
import com.kitchen.www.inputs.category.IngredientCategoryInput;
import com.kitchen.www.repositories.categories.IngredientCategoryRepository;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@AllArgsConstructor
@NoArgsConstructor
@Data
public class IngredientCategoryService {

    @Autowired
    private IngredientCategoryRepository ingredientCategoryRepository;

    public IngredientCategory getIngredientCategoryById(IngredientCategoryInput ingredientCategoryInput){

        return ingredientCategoryRepository.findById(ingredientCategoryInput.getId()).orElseThrow();
    }

    public Page<IngredientCategory> getAllIngredientCategories(PaginationInput paginationInput){

        Pageable pageable = PageRequest.of(paginationInput.getPage(), paginationInput.getSize(), Sort.by(Sort.Direction.ASC, paginationInput.getSortBy()));

        return ingredientCategoryRepository.findAll(pageable);
    }

    @Transactional
    public IngredientCategory addIngredientCategory(IngredientCategoryInput ingredientCategoryInput){
        IngredientCategory ingredientCategory = new IngredientCategory();
        ingredientCategory.setName(ingredientCategoryInput.getName());

        ingredientCategoryRepository.save(ingredientCategory);

        return ingredientCategory;
    }

    @Transactional
    public IngredientCategory updateIngredientCategory(IngredientCategoryInput ingredientCategoryInput){
        IngredientCategory ingredientCategory = ingredientCategoryRepository.findById(ingredientCategoryInput.getId()).orElseThrow();
        ingredientCategory.setName(ingredientCategoryInput.getName());

        ingredientCategoryRepository.save(ingredientCategory);

        return ingredientCategory;
    }

    public String deleteIngredientCategory(IngredientCategoryInput ingredientCategoryInput){
        IngredientCategory ingredientCategory = ingredientCategoryRepository.findById(ingredientCategoryInput.getId()).orElseThrow();
        ingredientCategory.setDeleted(true);

        return "Ingredient category deleted";
    }
}
