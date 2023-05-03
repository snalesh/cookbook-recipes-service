package com.cookbook.recipes.domain.ports;

import com.cookbook.recipes.domain.entities.Recipe;

import java.util.Optional;
import java.util.UUID;

public interface RecipeStorage {
    Recipe createRecipe(String name, String description);

    Optional<Recipe> getRecipeById(UUID id);
}
