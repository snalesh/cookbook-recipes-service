package com.cookbook.recipes.domain;

import com.cookbook.recipes.domain.entities.Recipe;
import com.cookbook.recipes.domain.ports.RecipeStorage;
import lombok.AllArgsConstructor;

import java.util.Optional;
import java.util.UUID;

@AllArgsConstructor
public class RecipeService {
    private final RecipeStorage recipeStorage;

    public Recipe createRecipe(String name, String description) {
        return recipeStorage.createRecipe(name, description);
    }

    public Optional<Recipe> getRecipeById(UUID id) {
        return recipeStorage.getRecipeById(id);
    }
}
