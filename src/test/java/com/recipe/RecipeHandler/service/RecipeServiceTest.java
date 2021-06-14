package com.recipe.RecipeHandler.service;

import static org.junit.Assert.assertNotNull;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.times;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.junit.Assert;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import org.mockito.junit.MockitoJUnitRunner;

import com.recipe.RecipeHandler.convertor.RecipeRqstPLToRecipe;
import com.recipe.RecipeHandler.convertor.RecipeToRecipeRspPL;
import com.recipe.RecipeHandler.model.Ingredient;
import com.recipe.RecipeHandler.model.Recipe;
import com.recipe.RecipeHandler.payload.RecipeRspPL;
import com.recipe.RecipeHandler.repository.IngredientRepository;
import com.recipe.RecipeHandler.repository.RecipeRepository;

@RunWith(MockitoJUnitRunner.class)
public class RecipeServiceTest {

	@InjectMocks
	RecipeService recipeService;
	@Mock
	RecipeRepository recipeRepository;
	@Mock
	RecipeToRecipeRspPL recipeResponse;
	@Mock
	RecipeRqstPLToRecipe recipeRequest;
	@Mock
	IngredientRepository ingredientRepository;

	@BeforeEach
	public void initSet() {
		MockitoAnnotations.initMocks(this);
		recipeRepository = mock(RecipeRepository.class);
		recipeResponse = mock(RecipeToRecipeRspPL.class);
		ingredientRepository = mock(IngredientRepository.class);
		recipeRequest = mock(RecipeRqstPLToRecipe.class);
		recipeService = new RecipeService();
	}
	
	
	@Test
    public void getAllRecipesTest()
    {
		List<Recipe> repoRecipes = getRecipes();
		when(recipeRepository.findAll()).thenReturn(repoRecipes);
		when(recipeResponse.convert(repoRecipes.get(0))).thenReturn(mock(RecipeRspPL.class));
		List<RecipeRspPL> response = recipeService.getAllRecipes();
		assertNotNull(response);
		verify(recipeRepository, times(1)).findAll();
    }

	private List<Recipe> getRecipes() {
	Ingredient i1 = new Ingredient();
	i1.setId(0);i1.setName("i1");i1.setQuantity(12L);i1.setUnit("gram");
	Ingredient i2 = new Ingredient();
	i2.setId(1);i2.setName("i1");i2.setQuantity(12L);i2.setUnit("gram");
	List<Ingredient> ingredients = new ArrayList<>();
	ingredients.add(i1);
	ingredients.add(i2);
	Recipe demoRecipe = new Recipe(121,12,true,"chicken teriyaki","cook for 10m","13-06-2021 13:20",ingredients);
	List<Recipe> recipes = new ArrayList<>();
	recipes.add(demoRecipe);
	return recipes;
}
	
	@Test
    public void deleteRecipesTest_Available()
    {
		List<Recipe> repoRecipes = getRecipes();
		Recipe recipe=repoRecipes.get(0);
		when(recipeRepository.findById(0)).thenReturn(Optional.of(recipe));
		Assert.assertNotNull(recipeService.removeRecipe(recipe.getId()));
		Assert.assertEquals("RECIPE NOT FOUND",recipeService.removeRecipe(recipe.getId()));
    }

}
