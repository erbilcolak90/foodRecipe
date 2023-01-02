package com.kitchen.www.inputs.category;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.NotNull;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class IngredientCategoryInput {

    private String id;
    @NotEmpty
    @NotBlank
    @NotNull
    private String name;
    private boolean isDeleted;
}
