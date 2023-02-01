package com.bloggish.springbloggish.payloads;

import jakarta.validation.constraints.NotEmpty;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class CategoryDto {

    private int id;

    @NotEmpty(message = "Title is mandatory.")
    private String title;

    private String description;
}
