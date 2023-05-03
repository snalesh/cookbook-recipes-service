package com.cookbook.recipes.domain.entities;

import lombok.Builder;
import lombok.Data;

import java.util.UUID;

@Data
@Builder
public class Recipe {
    UUID id;
    String name;
    String description;
}
