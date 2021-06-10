package com.recipe.RecipeHandler.service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.recipe.RecipeHandler.repository.RecipeRepository;
import com.recipe.RecipeHandler.service.RecipeService;
import com.recipe.RecipeHandler.util.*;
import com.recipe.RecipeHandler.convertor.*;
import com.recipe.RecipeHandler.model.*;
import com.recipe.RecipeHandler.payload.*;

//defining the business logic 
@Service
public class RecipeService {
	private final RecipeRqstPLToRecipe recipeRequest = new RecipeRqstPLToRecipe();
	private final RecipeToRecipeRspPL recipeResponse = new RecipeToRecipeRspPL();
	@Autowired
	RecipeRepository recipeRepo;

	public RecipeRspPL addRecipe(RecipeRqstPL rqstRecipe) {
		String errMsg = ValidationUtil.validateRqst(rqstRecipe);
		if (errMsg != null)
			throw new RuntimeException(errMsg);
		Recipe recipe = recipeRequest.convert(rqstRecipe);
		return recipeResponse.convert(recipeRepo.save(recipe));
	}

	public RecipeRspPL changeRecipe(RecipeRqstPL rqstRecipe, int id) {
		String errMsg = ValidationUtil.validateRqst(rqstRecipe);
		if (errMsg != null)
			throw new RuntimeException(errMsg);

		Optional<Recipe> recipeAvl = recipeRepo.findById(id);
		if (recipeAvl.isEmpty())
			throw new RuntimeException("No recipe found");
		Recipe recipe = recipeAvl.get();

		Recipe updatedRecipe = recipeRequest.convert(rqstRecipe);
		recipeRepo.delete(recipe);
		return recipeResponse.convert(recipeRepo.save(updatedRecipe));

	}

	public String removeRecipe(int id) {
		String conf = null;
		Optional<Recipe> recipeOpt = recipeRepo.findById(id);
		if (recipeOpt.isPresent()) {
			Recipe recipe = recipeOpt.get();
			if (recipe != null) {
				recipeRepo.delete(recipe);
				conf = "RECIPE REMOVED";
			}
		} else {
			conf = "RECIPE NOT FOUND";
		}
		return conf;
	}

	public RecipeRspPL queryById(int id) {
		Optional<Recipe> recipe = recipeRepo.findById(id);
		if (recipe.isPresent())
			return (recipeResponse.convert(recipe.get()));
		return null;
	}

	public List<RecipeRspPL> getAllRecipes() {

		List<Recipe> recipes = new ArrayList<>();
		List<Recipe> repoRecipes = recipeRepo.findAll();
		repoRecipes.iterator().forEachRemaining(recipes::add);

		List<RecipeRspPL> repoRecipe = new ArrayList<>();
		recipes.forEach((temp) -> {
			repoRecipe.add(recipeResponse.convert(temp));
		});
		return repoRecipe;

	}
}
