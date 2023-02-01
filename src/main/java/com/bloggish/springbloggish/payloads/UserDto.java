package com.bloggish.springbloggish.payloads;

import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotEmpty;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@NoArgsConstructor
@Getter
@Setter
public class UserDto {

    private int id;

    @NotEmpty(message = "First Name is mandatory.")
    private String firstName;

    private String lastName;

    @NotEmpty(message = "Email is mandatory.")
    @Email(message = "Email is not valid.")
    private String email;

    @NotEmpty(message = "Password is mandatory.")
    private String password;
}
