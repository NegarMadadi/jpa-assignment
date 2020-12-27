package se.lexicon.negar.jpaassignment.data_access;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import se.lexicon.negar.jpaassignment.entity.RecipeInstruction;

import static org.junit.jupiter.api.Assertions.*;
@DataJpaTest
class RecipeInstructionRepoTest {
    RecipeInstruction testRecipeInstruction;

    @Autowired
    RecipeInstructionRepo recipeInstructionRepo;

    @BeforeEach
    void setUp(){
        testRecipeInstruction = recipeInstructionRepo.save(new RecipeInstruction("Instruction 1"));
        recipeInstructionRepo.save(new RecipeInstruction("Instruction 2"));
        recipeInstructionRepo.save(new RecipeInstruction("Instruction 3"));
        recipeInstructionRepo.save(new RecipeInstruction("Instruction 4"));
    }

    @Test
    void successfully_created(){
        assertNotNull(testRecipeInstruction);
        assertTrue(testRecipeInstruction.getInstruction_id() != null);
        assertEquals("Instruction 1",testRecipeInstruction.getInstructions());
    }

    @Test
    void findAll() {
        assertEquals(4,recipeInstructionRepo.findAll().size());
    }
}