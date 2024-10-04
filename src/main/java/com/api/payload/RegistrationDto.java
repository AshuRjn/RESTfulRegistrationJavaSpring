package com.api.payload;

import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;
import lombok.Getter;
import lombok.Setter;

// here we used validation concept
@Getter
@Setter
public class RegistrationDto {
    //here we validate all filed through  validation annotation

    @NotNull(message = "Name cannot be null")
    @Size(min = 2, message = "Name must have at least 2 characters")
    private String name;

    @Email(message = "Email should be valid")
    private String email;

    @Size(min = 10,max = 10,message = "mobile no should be 10 digit ")
    private String mobile;
}
