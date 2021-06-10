package com.recipe.RecipeHandler.payload;

public class IngredientRqstPL {

	public IngredientRqstPL(String name, Long quantity, String unit) {
		super();
		this.name = name;
		this.quantity = quantity;
		this.unit = unit;
	}

	private String name;

	private Long quantity;

	private String unit;

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public Long getQuantity() {
		return quantity;
	}

	public void setQuantity(Long quantity) {
		this.quantity = quantity;
	}

	public String getUnit() {
		return unit;
	}

	public void setUnit(String unit) {
		this.unit = unit;
	}

}
