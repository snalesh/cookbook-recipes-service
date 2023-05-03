Feature: Query a existing recipe

  Background:
    * def createResult = callonce read('./createRecipe.feature')
    * def recipeId = createResult.response.data.createRecipe.id

  Scenario: Create a recipe
    Given url 'http://localhost:8080/graphql'
    And def queryPayload = 'query { recipe(id: "' + recipeId + '") { id name description } }'
    And request { "query": '#(queryPayload)' }
    When method POST
    Then status 200
    And match $.data.recipe.id == $recipeId
    And match $.data.recipe.name == $createResult.response.data.createRecipe.name
    And match $.data.recipe.description == $createResult.response.data.createRecipe.description
