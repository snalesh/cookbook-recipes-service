package com.cookbook.recipes.application.graphql.resolvers.mutations;

import com.cookbook.recipes.generated.DgsConstants;
import com.cookbook.recipes.generated.types.Recipe;
import com.cookbook.recipes.generated.types.RecipeInput;
import com.netflix.graphql.dgs.DgsComponent;
import com.netflix.graphql.dgs.DgsMutation;
import com.netflix.graphql.dgs.InputArgument;

import java.util.UUID;

@DgsComponent
public class createRecipeMutation {
    @DgsMutation(field = DgsConstants.MUTATION.CreateRecipe)
    public Recipe createRecipe(@InputArgument RecipeInput input) {
        Recipe recipe = new Recipe();
        recipe.setId(UUID.randomUUID().toString());
        recipe.setName(input.getName());
        recipe.setDescription(input.getDescription());
        return recipe;
    }

}
