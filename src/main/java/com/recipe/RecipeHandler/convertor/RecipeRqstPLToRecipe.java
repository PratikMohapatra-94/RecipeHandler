package com.recipe.RecipeHandler.convertor;

import java.util.ArrayList;

import org.springframework.core.convert.converter.Converter;
import org.springframework.stereotype.Component;

import com.recipe.RecipeHandler.model.Ingredient;
import com.recipe.RecipeHandler.model.Recipe;
import com.recipe.RecipeHandler.payload.RecipeRqstPL;
import com.recipe.RecipeHandler.util.TimeUtil;

@Component
public class RecipeRqstPLToRecipe implements Converter<RecipeRqstPL, Recipe> {
	private final IngredientRqstPLtoIngredient rqstToIng = new IngredientRqstPLtoIngredient();

	@Override
	public Recipe convert(RecipeRqstPL rReqPL) {
		if (rReqPL == null)
			return null;
		final Recipe recipe = new Recipe();
		recipe.setDishName(rReqPL.getDishName());
		recipe.setSuggestedServings(rReqPL.getSuggestedServings());
		recipe.setCreationTime(TimeUtil.getTime());
		recipe.setIsVeg(rReqPL.getIsVeg());
		recipe.setInstructions(rReqPL.getInstructions());

		if (rReqPL.getIngredients() != null && !rReqPL.getIngredients().isEmpty()) {
			if (recipe.getIngredients() == null)
				recipe.setIngredients(new ArrayList<Ingredient>());
			rReqPL.getIngredients().forEach(ingredientRequestPL -> {
				Ingredient ingredient = rqstToIng.convert(ingredientRequestPL);
				recipe.getIngredients().add(ingredient); // add to list
				recipe.setRecipeToIngredient(ingredient); // set recipe object
			});
		}

		return recipe;
	}

}