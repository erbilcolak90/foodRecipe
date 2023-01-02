package com.kitchen.www.entities;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.NonNull;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import java.util.Date;
import java.util.List;

@Document("food")
@AllArgsConstructor
@NoArgsConstructor
public class Food {

    @Id
    private String id;
    @NotNull(message = "name cannot be null.")
    @Size(min = 2, max = 50, message = "name must be between 2-50 characters.")
    private String name;
    @NotEmpty(message = "ingredient list cannot be empty")
    private List<String> ingredients;
    private String pictureURL;
    @NotEmpty(message = "recipe cannot be empty")
    @NotBlank
    private String recipe;
    @NotEmpty(message = "food category cannot be empty")
    private List<String> foodCategory;
    private Date createDate;
    private boolean isDeleted= false;

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public List<String> getIngredients() {
        return ingredients;
    }

    public void setIngredients(List<String> ingredients) {
        this.ingredients = ingredients;
    }

    public String getPictureURL() {
        return pictureURL;
    }

    public void setPictureURL(String pictureURL) {
        this.pictureURL = pictureURL;
    }

    public String getRecipe() {
        return recipe;
    }

    public void setRecipe(String recipe) {
        this.recipe = recipe;
    }

    public Date getCreateDate() {
        return createDate;
    }

    public void setCreateDate(Date createDate) {
        this.createDate = createDate;
    }

    public boolean isDeleted() {
        return isDeleted;
    }

    public void setDeleted(boolean deleted) {
        isDeleted = deleted;
    }

    public List<String> getFoodCategory() {
        return foodCategory;
    }

    public void setFoodCategory(List<String> foodCategory) {
        this.foodCategory = foodCategory;
    }
}
