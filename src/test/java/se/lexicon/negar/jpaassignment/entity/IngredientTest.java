package se.lexicon.negar.jpaassignment.entity;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class IngredientTest {
    Ingredient testIngredient;
    @BeforeEach
    void setUp(){
        testIngredient = new Ingredient("Test");
    }

    @Test
    void successfully_created(){
        assertNotNull(testIngredient);
        assertTrue(testIngredient.getIngredient_id()==0);
        assertEquals("Test",testIngredient.getIngredient_name());
    }

    @Test
    void testHashCode() {
        Ingredient copy = new Ingredient("Test");

        assertEquals(copy.hashCode(),testIngredient.hashCode());
    }

    @Test
    void testToString() {
        String toString = testIngredient.toString();

        assertTrue(toString.contains(testIngredient.getIngredient_name()));
        assertTrue(toString.contains(testIngredient.getIngredient_id()+""));
    }
}