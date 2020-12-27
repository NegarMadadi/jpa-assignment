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

    @OneToMany(cascade = {CascadeType.MERGE,CascadeType.PERSIST,CascadeType.DETACH,CascadeType.REFRESH},
            fetch = FetchType.LAZY)
    private List<RecipeIngredient> recipeIngredients;
    public boolean addRecipeIngredient(RecipeIngredient recipeIngredient){
        if(recipeIngredients == null)
            recipeIngredients = new ArrayList<>();
        if(recipeIngredient == null)
            throw new IllegalArgumentException("Recipe ingredient is null");
        if(!recipeIngredients.contains(recipeIngredient))
        {
            recipeIngredients.add(recipeIngredient);
            recipeIngredient.setRecipe(this);
            return true;
        }
        return false;
    }
    public boolean removeRecipeIngredient(RecipeIngredient recipeIngredient){
        if(recipeIngredients == null)
            recipeIngredients = new ArrayList<>();
        if(recipeIngredient == null)
            throw new IllegalArgumentException("Recipe ingredient is null");
        if(!recipeIngredients.contains(recipeIngredient))
        {
            return false;
        }
        recipeIngredients.remove(recipeIngredient);
        recipeIngredient.setRecipe(null);
        return true;
    }

    @OneToOne(cascade = {CascadeType.MERGE,CascadeType.PERSIST,CascadeType.DETACH,CascadeType.REFRESH},
                fetch = FetchType.EAGER)
    private RecipeInstruction recipeInstruction;

    @ManyToMany(cascade = {CascadeType.MERGE,CascadeType.PERSIST,CascadeType.DETACH,CascadeType.REFRESH},
            fetch = FetchType.LAZY)
    @JoinTable(name = "recipe_recipe_category"
            , joinColumns = @JoinColumn(name = "recipe_id")
            , inverseJoinColumns = @JoinColumn(name = "recipe_category_id"))
    private List<RecipeCategory> categories = new ArrayList<>();
    //Convenience Methods
    public boolean addRecipeCategory(RecipeCategory category){
        if(categories == null)
            categories = new ArrayList<>();
        if(category == null)
            throw new IllegalArgumentException("Category is null");
        if(!categories.contains(category))
        {
            categories.add(category);
            category.getRecipes().add(this);
            return true;
        }
        return false;
    }
    public boolean removeRecipeCategory(RecipeCategory category){
        if(categories == null)
            categories = new ArrayList<>();
        if(category == null)
            throw new IllegalArgumentException("Category is null");
        if(!categories.contains(category))
        {
            return false;
        }
        categories.remove(category);
        category.getRecipes().remove(this);
        return true;
    }

    public Recipe() {
    }

    public List<RecipeIngredient> getRecipeIngredients() {
        return recipeIngredients;
    }

    public void setRecipeIngredients(List<RecipeIngredient> recipeIngredients) {
        this.recipeIngredients = recipeIngredients;
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
                Objects.equals(recipe_name, recipe.recipe_name) &&
                Objects.equals(recipeInstruction, recipe.recipeInstruction);
    }

    @Override
    public int hashCode() {
        return Objects.hash(recipe_id, recipe_name, recipeInstruction);
    }

    @Override
    public String toString() {
        return "Recipe{" +
                "recipe_id=" + recipe_id +
                ", recipe_name='" + recipe_name + '\'' +
                ", recipeInstruction=" + recipeInstruction +
                '}';
    }
}
