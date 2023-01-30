package com.BlogApp.entities;


import jakarta.persistence.*;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.ArrayList;
import java.util.List;

@Entity
@Getter
@Setter
@NoArgsConstructor
public class Category {

@Id
@GeneratedValue(strategy = GenerationType.AUTO)
    private Integer categoryId;
    private String categoryTitle;
    private String categoryDescription;

   @OneToMany(mappedBy = "category" , cascade = CascadeType.ALL)
    private List<Post> posts = new ArrayList<>();




}
