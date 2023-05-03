package com.cookbook.recipes.application.graphql.resolvers.mutations;

import com.cookbook.recipes.application.graphql.GraphQLEntityMapper;
import com.cookbook.recipes.domain.RecipeService;
import com.cookbook.recipes.generated.DgsConstants;
import com.cookbook.recipes.generated.types.Recipe;
import com.cookbook.recipes.generated.types.RecipeInput;
import com.netflix.graphql.dgs.DgsComponent;
import com.netflix.graphql.dgs.DgsMutation;
import com.netflix.graphql.dgs.InputArgument;
import lombok.AllArgsConstructor;

@DgsComponent
@AllArgsConstructor
public class createRecipeMutation {
    private final RecipeService recipeService;
    private final GraphQLEntityMapper graphQLEntityMapper;

    @DgsMutation(field = DgsConstants.MUTATION.CreateRecipe)
    public Recipe createRecipe(@InputArgument RecipeInput input) {
        var recipe = recipeService.createRecipe(input.getName(), input.getDescription());
        return graphQLEntityMapper.toGraphQLEntity(recipe);
    }

}
