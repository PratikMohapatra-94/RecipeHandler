package com.recipe.RecipeHandler.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import com.recipe.RecipeHandler.model.*;

//IngredientRepository that extends CrudRepository to be associated with RecipeRepository
public interface IngredientRepository extends JpaRepository<Ingredient, Integer> {

}
