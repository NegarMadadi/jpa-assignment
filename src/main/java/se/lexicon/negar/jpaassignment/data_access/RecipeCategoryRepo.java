package se.lexicon.negar.jpaassignment.data_access;

import org.springframework.data.repository.CrudRepository;
import se.lexicon.negar.jpaassignment.entity.RecipeCategory;

import java.util.List;

public interface RecipeCategoryRepo extends CrudRepository<RecipeCategory,Integer> {
    List<RecipeCategory> findAl();
}