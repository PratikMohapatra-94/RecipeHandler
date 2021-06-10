package com.recipe.RecipeHandler.payload;

public class IngredientRspPL {

	public IngredientRspPL(int id, String name, Long quantity, String unit) {
		super();
		this.id = id;
		this.name = name;
		this.quantity = quantity;
		this.unit = unit;
	}

	private int id;

	private String name;

	private Long quantity;

	private String unit;

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

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
