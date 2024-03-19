package com.end.fridge.controller;

import com.end.fridge.domain.Ingredient;
import com.end.fridge.service.IngredientService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/ingredient")
public class IngredientController {
    @Autowired
    private IngredientService ingredientService;

    @GetMapping("/list")
    public Iterable<Ingredient> list() {

        return ingredientService.list();
    }
}
