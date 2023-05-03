package com.cookbook.recipes.application.storage.redis.entities;

import lombok.Builder;
import lombok.Data;
import org.springframework.data.annotation.Id;
import org.springframework.data.redis.core.RedisHash;

import java.util.UUID;

@Data
@Builder
@RedisHash("Recipe")
public class RecipeRedisEntity {
    @Id
    UUID id;
    String name;
    String description;
}
