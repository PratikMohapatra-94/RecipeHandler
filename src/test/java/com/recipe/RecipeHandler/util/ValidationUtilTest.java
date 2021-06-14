package com.recipe.RecipeHandler.util;

import java.util.ArrayList;

import org.junit.Assert;
import org.junit.jupiter.api.Test;

import com.recipe.RecipeHandler.payload.RecipeRqstPL;


public class ValidationUtilTest {
	
	@Test
	public void validateRqst_Recipe_Null() {
		Assert.assertNull(ValidationUtil.validateRqst(null));
	}
	
	@Test
	public void validateRqstTest_DishName_Null() {
		RecipeRqstPL requestPayload = new RecipeRqstPL(2, false, null, "boil", new ArrayList<>());
		Assert.assertNotNull(ValidationUtil.validateRqst(requestPayload));
		Assert.assertEquals("Enter valid Recipe name!", ValidationUtil.validateRqst(requestPayload));
	}
	
	@Test
	public void validateRqstTest_DishName_Empty() {
		RecipeRqstPL requestPayload = new RecipeRqstPL(2, false, "  ", "boil", new ArrayList<>());
		Assert.assertNotNull(ValidationUtil.validateRqst(requestPayload));
		Assert.assertEquals("Enter valid Recipe name!", ValidationUtil.validateRqst(requestPayload));
	}
	
	@Test
	public void validateRqstTest_DishName_LengthLessThan3() {
		RecipeRqstPL requestPayload = new RecipeRqstPL(2, false, "aa", "boil", new ArrayList<>());
		Assert.assertNotNull(ValidationUtil.validateRqst(requestPayload));
		Assert.assertEquals("Recipe name is either too long or too short!", ValidationUtil.validateRqst(requestPayload));
	}
	
	@Test
	public void validateRqstTest_DishName_LengthGreaterThan100() {
		RecipeRqstPL requestPayload = new RecipeRqstPL(2, false, "thisIsADummyDishNameHavingTooLongLengthUsedForTestPurpose", "boil", new ArrayList<>());
		Assert.assertNotNull(ValidationUtil.validateRqst(requestPayload));
		Assert.assertEquals("Recipe name is either too long or too short!", ValidationUtil.validateRqst(requestPayload));
	}
	
	@Test
	public void validateRqstTest_SuggestedServings_Zero() {
		RecipeRqstPL requestPayload = new RecipeRqstPL(0, false, "dummy", "boil", new ArrayList<>());
		Assert.assertNotNull(ValidationUtil.validateRqst(requestPayload));
		Assert.assertEquals("Enter value for number of serving!", ValidationUtil.validateRqst(requestPayload));
	}
	
	@Test
	public void validateRqstTest_SuggestedServings_GreaterThan50() {
		RecipeRqstPL requestPayload = new RecipeRqstPL(123, false, "dummy", "boil", new ArrayList<>());
		Assert.assertNotNull(ValidationUtil.validateRqst(requestPayload));
		Assert.assertEquals("Enter valid number of servings between 1 - 99!", ValidationUtil.validateRqst(requestPayload));
	}
	
	@Test
	public void validateRqstTest_Instructions_Null() {
		RecipeRqstPL requestPayload = new RecipeRqstPL(12, false, "dummy", null, new ArrayList<>());
		Assert.assertNotNull(ValidationUtil.validateRqst(requestPayload));
		Assert.assertEquals("Enter recipe Instructions!", ValidationUtil.validateRqst(requestPayload));
	}
	
	@Test
	public void validateRqstTest_Instructions_Empty() {
		RecipeRqstPL requestPayload = new RecipeRqstPL(12, false, "dummy", "  ", new ArrayList<>());
		Assert.assertNotNull(ValidationUtil.validateRqst(requestPayload));
		Assert.assertEquals("Enter recipe Instructions!", ValidationUtil.validateRqst(requestPayload));
	}
	
	@Test
	public void validateRqstTest_Instructions_Length_LessThan3() {
		RecipeRqstPL requestPayload = new RecipeRqstPL(12, false, "dummy", "ab", new ArrayList<>());
		Assert.assertNotNull(ValidationUtil.validateRqst(requestPayload));
		Assert.assertEquals("Recipe Instructions are either too long or too short!", ValidationUtil.validateRqst(requestPayload));
	}
	
	@Test
	public void validateRqstTest_DishName_Instructions_Length_GreaterThan1000() {
		String dummyInstructions = "ThisIsADummyInstruction!!ThisIsADummyInstruction!!ThisIsADummyInstruction!!ThisIsADummyInstruction!!ThisIsADummyInstruction!!ThisIsADummyInstruction!!ThisIsADummyInstruction!!ThisIsADummyInstruction!!ThisIsADummyInstruction!!ThisIsADummyInstruction!!ThisIsADummyInstruction!!ThisIsADummyInstruction!!ThisIsADummyInstruction!!ThisIsADummyInstruction!!ThisIsADummyInstruction!!ThisIsADummyInstruction!!ThisIsADummyInstruction!!ThisIsADummyInstruction!!ThisIsADummyInstruction!!ThisIsADummyInstruction!!ThisIsADummyInstruction!!";
		RecipeRqstPL requestPayload = new RecipeRqstPL(12, false, "dummy", dummyInstructions, new ArrayList<>());
		Assert.assertNotNull(ValidationUtil.validateRqst(requestPayload));
		Assert.assertEquals("Recipe Instructions are either too long or too short!", ValidationUtil.validateRqst(requestPayload));
	}

}