package com.recipe.RecipeHandler.payload;

import java.util.ArrayList;
import java.util.List;

public class RecipeRqstPL {

	public RecipeRqstPL(int suggestedServings, boolean isVeg, String dishName, String instructions,
			List<IngredientRqstPL> ingredients) {
		super();

		this.suggestedServings = suggestedServings;
		this.isVeg = isVeg;
		this.dishName = dishName;
		this.instructions = instructions;
		this.ingredients = ingredients;
	}

	private int suggestedServings;
	private boolean isVeg;
	private String dishName;
	private String instructions;
	
	private List<IngredientRqstPL> ingredients = new ArrayList<>();

	public int getSuggestedServings() {
		return suggestedServings;
	}

	public void setSuggestedServings(int suggestedServings) {
		this.suggestedServings = suggestedServings;
	}

	public boolean getIsVeg() {
		return isVeg;
	}

	public void setIsVeg(boolean isVeg) {
		this.isVeg = isVeg;
	}

	public String getDishName() {
		return dishName;
	}

	public void setDishName(String dishName) {
		this.dishName = dishName;
	}

	public String getInstructions() {
		return instructions;
	}

	public void setInstructions(String instructions) {
		this.instructions = instructions;
	}

	public List<IngredientRqstPL> getIngredients() {
		return ingredients;
	}

	public void setIngredients(List<IngredientRqstPL> ingredients) {
		this.ingredients = ingredients;
	}

}
