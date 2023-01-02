package com.kitchen.www.inputs;


import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import java.util.Date;
import java.util.List;


@Data
@AllArgsConstructor
@NoArgsConstructor
public class FoodInput{

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
}
