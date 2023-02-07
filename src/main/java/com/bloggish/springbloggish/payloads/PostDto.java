package com.bloggish.springbloggish.payloads;

import com.bloggish.springbloggish.entities.Category;
import com.bloggish.springbloggish.entities.User;

import jakarta.validation.constraints.NotEmpty;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@NoArgsConstructor
@Getter
@Setter
public class PostDto {

    private Integer id;

    @NotEmpty(message = "Title is mandatory.")
    private String title;

    private String description;
    private String imageName;

    @NotEmpty(message = "User is mandatory.")
    private UserDto user;

    @NotEmpty(message = "Category is mandatory.")
    private CategoryDto category;

    private int status = 1;
}
