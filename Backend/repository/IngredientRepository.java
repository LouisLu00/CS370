package com.end.fridge.repository;

import com.end.fridge.domain.Ingredient;

import java.util.List;

import org.springframework.data.repository.CrudRepository;

public interface IngredientRepository extends CrudRepository<Ingredient, Long> {

    // Finds and returns a list of Ingredient objects whose names contain the
    // specified keyword.
    List<Ingredient> findByNameContaining(String keyword);
}
