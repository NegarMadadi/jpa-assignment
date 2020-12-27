package se.lexicon.negar.jpaassignment.entity;
import org.hibernate.annotations.GenericGenerator;

import javax.persistence.*;
import java.util.Objects;
import java.util.UUID;

@Entity
public class RecipeInstruction {
    @Id
    @GeneratedValue(generator = "UUID")
    @GenericGenerator(
            name = "UUID",
            strategy = "org.hibernate.id.UUIDGenerator"
    )
    @Column(name = "instruction_id", updatable = false, nullable = false)
    private UUID instruction_id;

    private String instructions;

    @OneToOne(
            mappedBy = "instruction_id"
            , cascade = {CascadeType.PERSIST, CascadeType.MERGE}
    )
    private Recipe recipe;

    private RecipeInstruction() {
    }

    public RecipeInstruction(String instructions) {
        this.instructions = instructions;
    }

    public Recipe getRecipe() {
        return recipe;
    }

    public void setRecipe(Recipe recipe) {
        this.recipe = recipe;
    }

    public UUID getInstruction_id() {
        return instruction_id;
    }

    public String getInstructions() {
        return instructions;
    }

    public void setInstructions(String instructions) {
        this.instructions = instructions;
    }

    @Override
    public String toString() {
        return "RecipeInstruction{" +
                "instructionId=" + instruction_id +
                ", instructions='" + instructions + '\'' +
                '}';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        RecipeInstruction that = (RecipeInstruction) o;
        return instruction_id.equals(that.instruction_id) &&
                instructions.equals(that.instructions);
    }

    @Override
    public int hashCode() {
        return Objects.hash(instruction_id, instructions);
    }
}
