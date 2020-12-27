package se.lexicon.negar.jpaassignment.entity;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

@Entity
public class Recipe {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int recipe_id;


    private String recipe_name;
    private int instruction_id;

    @OneToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "instruction_id")
    private RecipeInstruction recipeInstruction;

    @ManyToMany(mappedBy = "recipes")
    private List<RecipeCategory> categories = new ArrayList<>();
    //Convenience Methods
    public void addRecipeCategory(RecipeCategory category){
        categories.add(category);
        category.getRecipes().add(this);
    }
    public void removeRecipeCategory(RecipeCategory category){
        categories.remove(category);
        category.getRecipes().remove(this);
    }

    public Recipe() {
    }

    public int getRecipe_id() {
        return recipe_id;
    }

    public String getRecipe_name() {
        return recipe_name;
    }

    public void setRecipe_name(String recipe_name) {
        this.recipe_name = recipe_name;
    }

    public int getInstruction_id() {
        return instruction_id;
    }

    public void setInstruction_id(int instruction_id) {
        this.instruction_id = instruction_id;
    }

    public RecipeInstruction getRecipeInstruction() {
        return recipeInstruction;
    }

    public void setRecipeInstruction(RecipeInstruction recipeInstruction) {
        this.recipeInstruction = recipeInstruction;
    }

    public List<RecipeCategory> getCategories() {
        return categories;
    }

    public void setCategories(List<RecipeCategory> categories) {
        this.categories = categories;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Recipe recipe = (Recipe) o;
        return recipe_id == recipe.recipe_id &&
                instruction_id == recipe.instruction_id &&
                Objects.equals(recipe_name, recipe.recipe_name) &&
                Objects.equals(recipeInstruction, recipe.recipeInstruction);
    }

    @Override
    public int hashCode() {
        return Objects.hash(recipe_id, recipe_name, instruction_id, recipeInstruction);
    }

    @Override
    public String toString() {
        return "Recipe{" +
                "recipe_id=" + recipe_id +
                ", recipe_name='" + recipe_name + '\'' +
                ", instruction_id=" + instruction_id +
                ", recipeInstruction=" + recipeInstruction +
                '}';
    }
}
