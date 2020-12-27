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
        recipeRepo.save(testRecipe);
    }

    @AfterEach
    void tearDown() {
    }

    @Test
    void successfully_created(){
        assertNotNull(testRecipe);
    }

    @Test
    void findAll() {
    }
}