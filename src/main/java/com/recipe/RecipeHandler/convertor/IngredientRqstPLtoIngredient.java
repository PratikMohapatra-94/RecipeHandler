package com.recipe.RecipeHandler.convertor;

import org.springframework.core.convert.converter.Converter;
import org.springframework.stereotype.Component;

import com.recipe.RecipeHandler.model.Ingredient;
import com.recipe.RecipeHandler.payload.*;

@Component
public class IngredientRqstPLtoIngredient implements Converter<IngredientRqstPL, Ingredient> {

	@Override
	public Ingredient convert(IngredientRqstPL iRqstPL) {
		if (iRqstPL == null)
			return null;
		final Ingredient ingredient = new Ingredient();
		ingredient.setUnit(iRqstPL.getUnit());
		ingredient.setName(iRqstPL.getName());
		ingredient.setQuantity(iRqstPL.getQuantity());
		return ingredient;

	}
}
