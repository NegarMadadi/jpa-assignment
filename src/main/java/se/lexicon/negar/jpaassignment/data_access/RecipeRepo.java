package se.lexicon.negar.jpaassignment.data_access;

import org.springframework.data.repository.CrudRepository;
import se.lexicon.negar.jpaassignment.entity.Recipe;

import java.util.List;

public interface RecipeRepo extends CrudRepository<Recipe,Integer> {
    List<Recipe> findAll();
    List<Recipe> findAllByRecipeIngredients_Ingredient_IngredientNameIgnoreCase(String name);
}
