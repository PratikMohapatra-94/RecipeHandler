package com.recipe.RecipeHandler.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import com.recipe.RecipeHandler.model.*;

//repository that extends CrudRepository
public interface RecipeRepository extends JpaRepository<Recipe, Integer> {

}
