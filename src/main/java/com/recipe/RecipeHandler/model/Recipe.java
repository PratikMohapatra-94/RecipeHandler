package com.recipe.RecipeHandler.model;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.*;

//mark class as an Entity   
@Entity
//defining class name as Table name  
@Table
public class Recipe {

	public Recipe() {
	}

	public Recipe(int id, int suggestedServings, boolean isVeg, String dishName, String instructions,
			String creationTime, List<Ingredient> ingredients) {
		super();
		this.id = id;
		this.suggestedServings = suggestedServings;
		this.isVeg = isVeg;
		this.dishName = dishName;
		this.instructions = instructions;
		this.creationTime = creationTime;
		this.ingredients = ingredients;
	}

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	@Column
	private int id;
	@Column
	private int suggestedServings;
	@Column
	private boolean isVeg;
	@Column
	private String dishName;
	@Column
	private String instructions;
	@Column
	private String creationTime;

	@Column
	@OneToMany(mappedBy = "recipe", cascade = CascadeType.ALL, orphanRemoval = true, fetch = FetchType.LAZY)
	private List<Ingredient> ingredients = new ArrayList<>();

	public List<Ingredient> getIngredients() {
		return ingredients;
	}

	public void setIngredients(List<Ingredient> ingredients) {
		this.ingredients = ingredients;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

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

	public String getCreationTime() {
		return creationTime;
	}

	public void setCreationTime(String creationTime) {
		this.creationTime = creationTime;
	}

	public Recipe setRecipeToIngredient(Ingredient ingredient) {
		ingredient.setRecipe(this); // set recipe for updating recipeid to ingredients

		return this;
	}

}
