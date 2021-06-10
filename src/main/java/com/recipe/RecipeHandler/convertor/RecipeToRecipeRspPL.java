package com.recipe.RecipeHandler.convertor;

import java.util.ArrayList;

import org.springframework.core.convert.converter.Converter;
import org.springframework.stereotype.Component;

import com.recipe.RecipeHandler.model.Recipe;
import com.recipe.RecipeHandler.payload.IngredientRspPL;
import com.recipe.RecipeHandler.payload.RecipeRspPL;

@Component

public class RecipeToRecipeRspPL implements Converter<Recipe, RecipeRspPL> {
	private final IngredienttoIngredientRspPL ingToRsp = new IngredienttoIngredientRspPL();

	@Override
	public RecipeRspPL convert(Recipe rRsp) {
		if (rRsp == null)
			return null;
		RecipeRspPL recipeRspPL = new RecipeRspPL();
		recipeRspPL.setCreationTime(rRsp.getCreationTime());
		recipeRspPL.setDishName(rRsp.getDishName());
		recipeRspPL.setId(rRsp.getId());
		recipeRspPL.setInstructions(rRsp.getInstructions());
		recipeRspPL.setIsVeg(rRsp.getIsVeg());
		recipeRspPL.setSuggestedServings(rRsp.getSuggestedServings());

		if (rRsp.getIngredients() != null && !rRsp.getIngredients().isEmpty()) {
			if (recipeRspPL.getIngredients() == null)
				recipeRspPL.setIngredients(new ArrayList<IngredientRspPL>());
			rRsp.getIngredients().forEach(ingredient -> {
				IngredientRspPL ingrdientResponse = ingToRsp.convert(ingredient);
				recipeRspPL.getIngredients().add(ingrdientResponse);
			});
		}
		return recipeRspPL;

	}
}
