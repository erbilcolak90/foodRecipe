package com.kitchen.www.inputs;

import com.kitchen.www.entities.User;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Date;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class UserInput{

    private String id;
    @NotNull(message = "name cannot be null")
    @Size(min = 2, max = 50, message = "name must be between 2-50 characters")
    @NotBlank
    private String name;
    @NotNull(message = "surname cannot be null")
    @Size(min = 2, max = 50, message = "surname must be between 2-50 characters")
    @NotBlank
    private String surname;
    @NotNull(message = "username cannot be null")
    @Size(min = 2, max = 50, message = "username must be between 2-50 characters")
    @NotBlank
    private String username;
    @NotNull
    @NotEmpty
    @NotBlank
    private String password;
    private Date createDate;
    private boolean isDeleted= false;
}
