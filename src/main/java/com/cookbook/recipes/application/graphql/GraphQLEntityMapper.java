package com.cookbook.recipes.application.graphql;

import com.cookbook.recipes.domain.entities.Recipe;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring")
public interface GraphQLEntityMapper {
    Recipe toDomainEntity(com.cookbook.recipes.generated.types.Recipe recipe);
    com.cookbook.recipes.generated.types.Recipe toGraphQLEntity(Recipe recipe);
}
