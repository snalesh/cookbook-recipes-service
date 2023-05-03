package com.cookbook.recipes.application.graphql.resolvers.queries;

import com.cookbook.recipes.application.graphql.GraphQLEntityMapper;
import com.cookbook.recipes.domain.RecipeService;
import com.cookbook.recipes.generated.types.Recipe;
import com.netflix.graphql.dgs.DgsComponent;
import com.netflix.graphql.dgs.DgsQuery;
import com.netflix.graphql.dgs.InputArgument;
import lombok.AllArgsConstructor;

import java.util.UUID;

@DgsComponent
@AllArgsConstructor
public class recipeQuery {
    private final RecipeService recipeService;
    private final GraphQLEntityMapper graphQLEntityMapper;

    @DgsQuery
    public Recipe recipe(@InputArgument String id) {
        var recipe = recipeService.getRecipeById(UUID.fromString(id));
        return recipe.map(graphQLEntityMapper::toGraphQLEntity).orElse(null);
    }
}
