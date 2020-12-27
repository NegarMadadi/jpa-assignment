package se.lexicon.negar.jpaassignment.data_access;

import org.springframework.data.repository.CrudRepository;
import se.lexicon.negar.jpaassignment.entity.RecipeIngredient;
import java.util.List;
import java.util.UUID;

public interface RecipeIngredientRepo extends CrudRepository<RecipeIngredient, UUID> {
    List<RecipeIngredient> findAll();
}
