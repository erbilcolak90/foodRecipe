package com.kitchen.www.entities.categories;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.NotNull;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.data.mongodb.core.mapping.Document;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Document("ingredientCategory")
public class IngredientCategory {

    private String id;
    @NotEmpty
    @NotBlank
    @NotNull
    private String name;
    private boolean isDeleted= false;
}
