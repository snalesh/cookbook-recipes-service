package com.cookbook.recipes.application;

import com.cookbook.recipes.domain.RecipeService;
import com.cookbook.recipes.domain.entities.Recipe;
import com.cookbook.recipes.domain.ports.RecipeStorage;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.data.redis.connection.RedisConnectionFactory;
import org.springframework.data.redis.core.RedisTemplate;

@Configuration
public class BeanConfiguration {
    @Bean
    public RecipeService recipeService(RecipeStorage recipeStorage) {
        return new RecipeService(recipeStorage);
    }

    @Bean
    public RedisTemplate<Long, Recipe> redisTemplate(RedisConnectionFactory connectionFactory) {
        RedisTemplate<Long, Recipe> template = new RedisTemplate<>();
        template.setConnectionFactory(connectionFactory);
        // Add some specific configuration here. Key serializers, etc.
        return template;
    }
}
