Feature: Create & Query

  Scenario: Create & Query a new Recipe via GraphQL
    Given url 'http://localhost:8080/graphql'
    And def title = "Kaiserschmarn"
    And def description = "Delicious Kaiserschmarn"
    And def createPayload = 'mutation { createRecipe(input: {name: "' + title + '", description: "' + description + '"}) { id name description } }'

    And request { "query": '#(createPayload)' }
    When method POST
    Then status 200
    And match $.data.createRecipe.id == "#uuid"
    And match $.data.createRecipe.name == $title
    And match $.data.createRecipe.description == $description
    And def recipeId = $.data.createRecipe.id

    Given url 'http://localhost:8080/graphql'
    And def queryPayload = 'query { recipe(id: "' + recipeId + '") { id name description } }'
    And request { "query": '#(queryPayload)' }
    When method POST
    Then status 200
    And match $.data.recipe.id == ${recipeId}
    And match $.data.recipe.name == ${title}
    And match $.data.recipe.description == ${description}
