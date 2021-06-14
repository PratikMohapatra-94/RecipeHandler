package com.recipe.RecipeHandler.util;
import org.junit.Assert;
import org.junit.jupiter.api.Test;
public class TimeUtilTest {

	
	@Test
	public void TimeUtilTest_Null() {
		Assert.assertNotNull(TimeUtil.getTime());
	}
}
