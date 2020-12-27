package se.lexicon.negar.jpaassignment.data_access;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import se.lexicon.negar.jpaassignment.entity.*;
import static org.junit.jupiter.api.Assertions.*;
import java.util.List;

@DataJpaTest
class RecipeRepoTest {

    Recipe testRecipe;
    List<RecipeIngredient> testRecipeIngredients;

    List<RecipeCategory> testRecipeCategories;
    RecipeIngredient testRecipeFirstIngredient;
    RecipeIngredient testRecipeSecondIngredient;
    RecipeIngredient testRecipeThirdIngredient;
    RecipeIngredient testRecipeForthIngredient;

    @Autowired
    RecipeRepo recipeRepo;

    @BeforeEach
    void setUp() {
        testRecipe = new Recipe();
        testRecipe.setRecipe_name("Test recipe");
        testRecipe.setRecipeInstruction(new RecipeInstruction("Instruction of test recipe"));
        testRecipeFirstIngredient = new RecipeIngredient(new Ingredient("Ingredient 1"),2,Measurement.KG);
        testRecipeSecondIngredient = new RecipeIngredient(new Ingredient("Ingredient 2"),10,Measurement.ML);
        testRecipeThirdIngredient = new RecipeIngredient(new Ingredient("Ingredient 3"),5,Measurement.CL);
        testRecipe.addRecipeIngredient(testRecipeFirstIngredient);
        testRecipe.addRecipeIngredient(testRecipeSecondIngredient);
        testRecipe.addRecipeIngredient(testRecipeThirdIngredient);
        recipeRepo.save(testRecipe);
    }

    @AfterEach
    void tearDown() {
    }

    @Test
    void successfully_created(){
        assertNotNull(testRecipe);
        assertEquals("Test recipe",testRecipe.getRecipe_name());
        assertEquals("Instruction of test recipe",testRecipe.getRecipeInstruction().getInstructions());
        assertEquals(3,testRecipe.getRecipeIngredients().size());
    }

    @Test
    void findAll() {
        assertEquals(1,recipeRepo.findAll().size());
    }

    @Test
    void findAllByRecipeIngredients_Ingredient_IngredientNameIgnoreCase() {
        assertEquals(1,recipeRepo.findAllByRecipeIngredients_Ingredient_IngredientNameIgnoreCase("iNgReDiEnt 2").size());
    }
}