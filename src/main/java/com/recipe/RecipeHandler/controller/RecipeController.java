package com.recipe.RecipeHandler.controller;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;
import com.recipe.RecipeHandler.controller.RecipeController;
import com.recipe.RecipeHandler.service.RecipeService;
import com.recipe.RecipeHandler.payload.*;

//mark class as Controller  
@RestController
public class RecipeController {

	// autowire the RecipeService class
	@Autowired
	RecipeService recipeService;

	@PostMapping("/add")
	public ResponseEntity<RecipeRspPL> saveOrUpdate(@RequestBody RecipeRqstPL recipe) {

		RecipeRspPL newRecipe = recipeService.addRecipe(recipe);
		return new ResponseEntity<>(newRecipe, HttpStatus.CREATED);
	}

	@PutMapping("/update/{recipeId}")
	public ResponseEntity<RecipeRspPL> update(@RequestBody RecipeRqstPL recipe,
			@PathVariable(value = "recipeId") int recipeId) {

		RecipeRspPL updatedRecipe = recipeService.changeRecipe(recipe, recipeId);
		return new ResponseEntity<>(updatedRecipe, HttpStatus.CREATED);
	}

	@DeleteMapping("/remove/{recipeId}")
	public ResponseEntity<String> delete(@PathVariable("recipeId") int id) {
		String confirmDel = recipeService.removeRecipe(id);
		return new ResponseEntity<>(confirmDel, HttpStatus.OK);
	}

	@GetMapping("/getById/{recipeId}")
	public ResponseEntity<RecipeRspPL> getQueryById(@PathVariable(value = "recipeId") int recipeId) {
		RecipeRspPL queryRecipe = recipeService.queryById(recipeId);
		return new ResponseEntity<>(queryRecipe, HttpStatus.OK);
	}

	@GetMapping("/getAll")
	public ResponseEntity<List<RecipeRspPL>> allRecipes() {
		List<RecipeRspPL> allRecipeRsp = recipeService.getAllRecipes();
		return new ResponseEntity<>(allRecipeRsp, HttpStatus.OK);
	}
}
