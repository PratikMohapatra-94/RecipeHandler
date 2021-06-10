package com.recipe.RecipeHandler.util;

import com.recipe.RecipeHandler.payload.*;

public class ValidationUtil {

	public static String validateRqst(RecipeRqstPL recipeRequest) {
		if (recipeRequest != null) {
			if (recipeRequest.getDishName() == null || recipeRequest.getDishName().trim() == "") {
				return "Enter valid Recipe name!";
			} else if (recipeRequest.getDishName().length() < 3 || recipeRequest.getDishName().length() > 50) {
				return "Recipe name is either too long or too short!";
			}
			if (recipeRequest.getSuggestedServings() == 0) {
				return "Enter value for number of serving!";
			} else if (recipeRequest.getSuggestedServings() > 100 || recipeRequest.getSuggestedServings() < 1) {
				return "Enter valid number of servings between 1 - 99!";
			}
			if (recipeRequest.getInstructions() == null || recipeRequest.getInstructions().trim() == "") {
				return "Enter recipe Instructions!";
			} else if (recipeRequest.getInstructions().length() < 3 || recipeRequest.getInstructions().length() > 500) {
				return "Recipe Instructions are either too long or too short!";
			}
		}

		return null;
	}

}
