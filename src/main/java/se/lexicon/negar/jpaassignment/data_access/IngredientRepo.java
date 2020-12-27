package se.lexicon.negar.jpaassignment.data_access;

import org.springframework.data.repository.CrudRepository;
import se.lexicon.negar.jpaassignment.entity.Ingredient;

import java.util.List;
import java.util.Optional;

public interface IngredientRepo extends CrudRepository<Ingredient,Integer> {
    List<Ingredient> findAll();
}
