package com.kitchen.www.services;

import com.kitchen.www.entities.Food;
import com.kitchen.www.inputs.FoodInput;
import com.kitchen.www.inputs.PaginationInput;
import com.kitchen.www.inputs.PaginationWithListInput;
import com.kitchen.www.repositories.entities.FoodRepository;
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
import java.util.Date;

@Service
@AllArgsConstructor
@NoArgsConstructor
@Data
public class FoodService {

    @Autowired
    private FoodRepository foodRepository;

    public Food getFoodById(String id){
        return foodRepository.findById(id).orElseThrow();
    }

    public Food getFoodByName(String name){
        return foodRepository.findByName(name);
    }

    public Page<Food> getAllFood(PaginationInput paginationInput){
        Pageable pageable = PageRequest.of(paginationInput.getPage(), paginationInput.getSize(), Sort.by(Sort.Direction.ASC, paginationInput.getSortBy()));
        return foodRepository.findAll(pageable);
    }

    public Page<Food> getAllFoodByIngredients(PaginationWithListInput paginationWithListInput){
        Pageable pageable = PageRequest.of(paginationWithListInput.getPage(), paginationWithListInput.getSize(), Sort.by(Sort.Direction.ASC, paginationWithListInput.getSortBy()));
        return foodRepository.findByIngredients(paginationWithListInput.getStringList(),pageable);
    }

    @Transactional
    public Food addFood(FoodInput foodInput){
        Food tempFood = new Food();
        tempFood.setName(foodInput.getName());
        tempFood.setIngredients(foodInput.getIngredients());
        tempFood.setPictureURL(foodInput.getPictureURL());
        tempFood.setRecipe(foodInput.getRecipe());
        tempFood.setFoodCategory(foodInput.getFoodCategory());
        tempFood.setCreateDate(new Date());
        foodRepository.save(tempFood);

        return tempFood;
    }

    @Transactional
    public Food updateFood(FoodInput foodInput){
        Food tempFood = foodRepository.findById(foodInput.getId()).orElseThrow();
        tempFood.setName(foodInput.getName());
        if(foodInput.getRecipe()!=null && foodInput.getIngredients()!=null && foodInput.getFoodCategory()!=null){
            tempFood.setRecipe(foodInput.getRecipe());
            tempFood.setIngredients(foodInput.getIngredients());
            tempFood.setFoodCategory(foodInput.getFoodCategory());
        }
        tempFood.setCreateDate(tempFood.getCreateDate());
        tempFood.setPictureURL(tempFood.getPictureURL());
        foodRepository.save(tempFood);

        return tempFood;
    }

    @Transactional
    public String deleteFood(String id){
        Food tempFood = foodRepository.findById(id).orElseThrow();
        tempFood.setDeleted(true);

        foodRepository.save(tempFood);
        return "food deleted.";
    }

}
