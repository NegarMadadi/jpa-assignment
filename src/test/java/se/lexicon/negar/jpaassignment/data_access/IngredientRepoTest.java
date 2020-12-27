package se.lexicon.negar.jpaassignment.data_access;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import se.lexicon.negar.jpaassignment.entity.Ingredient;

import static org.junit.jupiter.api.Assertions.*;

@DataJpaTest
class IngredientRepoTest {
    Ingredient testIngredient;

    @Autowired
    IngredientRepo ingredientRepo;

    @BeforeEach
    void setUp(){
        testIngredient = ingredientRepo.save(new Ingredient("Test"));
        ingredientRepo.save(new Ingredient("Second"));
        ingredientRepo.save(new Ingredient("Third"));
        ingredientRepo.save(new Ingredient("Forth"));
    }

    @Test
    void successfully_created(){
        assertNotNull(testIngredient);
        assertTrue(testIngredient.getIngredient_id() != 0);
        assertEquals("Test",testIngredient.getIngredientName());
    }

    @Test
    void findAll() {
        assertEquals(4,ingredientRepo.findAll().size());
    }
}