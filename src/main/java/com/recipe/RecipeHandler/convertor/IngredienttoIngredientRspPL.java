package com.recipe.RecipeHandler.convertor;

import org.springframework.core.convert.converter.Converter;
import org.springframework.stereotype.Component;
import com.recipe.RecipeHandler.model.Ingredient;
import com.recipe.RecipeHandler.payload.*;

@Component
public class IngredienttoIngredientRspPL implements Converter<Ingredient, IngredientRspPL> {

	@Override
	public IngredientRspPL convert(Ingredient ing) {

		if (ing == null)
			return null;

		return new IngredientRspPL(ing.getId(), ing.getName(), ing.getQuantity(), ing.getUnit());

	}

}
