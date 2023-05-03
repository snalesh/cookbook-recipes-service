package com.cookbook.recipes.application.storage.redis;

import com.cookbook.recipes.application.storage.redis.entities.RecipeRedisEntity;
import com.cookbook.recipes.domain.entities.Recipe;
import org.mapstruct.Mapper;
import org.springframework.stereotype.Component;

@Mapper(componentModel = "spring")
public interface RedisEntityMapper {
    Recipe toRecipe(RecipeRedisEntity recipeRedisEntity);
    RecipeRedisEntity toRecipeRedisEntity(Recipe recipe);
}
