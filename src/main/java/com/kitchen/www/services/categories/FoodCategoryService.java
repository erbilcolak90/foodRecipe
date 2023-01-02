package com.kitchen.www.services.categories;

import com.kitchen.www.entities.categories.FoodCategory;
import com.kitchen.www.inputs.PaginationInput;
import com.kitchen.www.inputs.category.FoodCategoryInput;
import com.kitchen.www.repositories.categories.FoodCategoryRepository;
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
public class FoodCategoryService {

    @Autowired
    private FoodCategoryRepository foodCategoryRepository;

    public FoodCategory getFoodCategoryById(FoodCategoryInput foodCategoryInput){

        return foodCategoryRepository.findById(foodCategoryInput.getId()).orElseThrow();
    }

    public Page<FoodCategory> getAllFoodCategories(PaginationInput paginationInput){

        Pageable pageable = PageRequest.of(paginationInput.getPage(), paginationInput.getSize(), Sort.by(Sort.Direction.ASC, paginationInput.getSortBy()));

        return foodCategoryRepository.findAll(pageable);
    }

    @Transactional
    public FoodCategory addFoodCategory(FoodCategoryInput foodCategoryInput){
        FoodCategory foodCategory = new FoodCategory();
        foodCategory.setName(foodCategoryInput.getName());

        foodCategoryRepository.save(foodCategory);

        return foodCategory;
    }

    @Transactional
    public FoodCategory updateFoodCategory(FoodCategoryInput foodCategoryInput){
        FoodCategory foodCategory = foodCategoryRepository.findById(foodCategoryInput.getId()).orElseThrow();
        foodCategory.setName(foodCategoryInput.getName());

        foodCategoryRepository.save(foodCategory);

        return foodCategory;
    }

    public String deleteFoodCategory(FoodCategoryInput foodCategoryInput){
        FoodCategory foodCategory = foodCategoryRepository.findById(foodCategoryInput.getId()).orElseThrow();
        foodCategory.setDeleted(true);

        return "Food category deleted";
    }
}
