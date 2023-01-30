package com.BlogApp.payloads;


import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Size;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
public class CategoryDto  {


    private Integer categoryId;
    @NotBlank
    @Size(min=4)
    private String ategoryTitle;
    @NotBlank
    @Size(min=20)
    private String categoryDescription;


}
