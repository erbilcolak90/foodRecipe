package com.kitchen.www.entities;

import com.kitchen.www.entities.categories.IngredientCategory;
import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import java.util.Date;
import java.util.List;

@Document("ingredient")
@Data
@AllArgsConstructor
@NoArgsConstructor
public class Ingredient {

        @Id
        private String id;
        @NotNull(message = "name cannot be null")
        @Size(min = 2, max = 50, message = "name must be between 2-50 characters")
        private String name;
        private String pictureURL;
        @NotEmpty
        private List<String> ingredientCategory;
        private List<String> foodCategory;
        private Date createDate;
        private boolean isDeleted= false;

    }
