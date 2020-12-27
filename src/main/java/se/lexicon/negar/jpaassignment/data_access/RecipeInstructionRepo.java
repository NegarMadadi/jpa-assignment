package se.lexicon.negar.jpaassignment.data_access;

import org.springframework.data.repository.CrudRepository;
import se.lexicon.negar.jpaassignment.entity.RecipeInstruction;

import java.util.List;
import java.util.UUID;

public interface RecipeInstructionRepo extends CrudRepository<RecipeInstruction, UUID> {
    List<RecipeInstruction> findAll();
}
