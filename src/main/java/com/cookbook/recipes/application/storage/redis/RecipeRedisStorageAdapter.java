package com.cookbook.recipes.application.storage.redis;

import com.cookbook.recipes.application.storage.redis.entities.RecipeRedisEntity;
import com.cookbook.recipes.domain.entities.Recipe;
import com.cookbook.recipes.domain.ports.RecipeStorage;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Component;

import java.util.Optional;
import java.util.UUID;

@Component
@AllArgsConstructor
public class RecipeRedisStorageAdapter implements RecipeStorage {
    private final RecipeRepository recipeRepository;
    private final RedisEntityMapper redisEntityMapper;

    public Recipe createRecipe(String name, String description) {
        var recipe = RecipeRedisEntity.builder()
                .id(UUID.randomUUID())
                .name(name)
                .description(description)
                .build();

        var result = recipeRepository.save(recipe);

        return redisEntityMapper.toRecipe(result);
    }

    public Optional<Recipe> getRecipeById(UUID id) {
        return recipeRepository.findById(id)
                .map(redisEntityMapper::toRecipe);
    }
}
