package com.end.fridge.controller;

import com.end.fridge.domain.Recipe;
import com.end.fridge.service.RecipeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/recipe")
public class RecipeController {
    @Autowired
    private RecipeService recipeService;

    @GetMapping("/list")
    public Iterable<Recipe> list() {
        return recipeService.list();
    }
}
