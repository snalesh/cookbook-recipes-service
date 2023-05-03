package com.cookbook.recipes.application.storage.redis;

import com.cookbook.recipes.application.storage.redis.entities.RecipeRedisEntity;
import org.springframework.data.repository.CrudRepository;
import java.util.UUID;

public interface RecipeRepository extends CrudRepository<RecipeRedisEntity, UUID> {
}
