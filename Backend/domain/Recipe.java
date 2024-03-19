package com.end.fridge.domain;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
@Entity
@Table(name = "recipe")
public class Recipe {
    @Id
    @GeneratedValue( strategy = GenerationType.IDENTITY )
    private Long id;
    private String title;
    private String readyIn;
    private String img;
    @Column(columnDefinition = "LONGTEXT")
    private String directions;
    @Column(columnDefinition = "LONGTEXT")
    private String ingredients;

    public Recipe() {}
}
