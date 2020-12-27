package se.lexicon.negar.jpaassignment.entity;
import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

@Entity
public class RecipeCategory {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int category_id;

    @ManyToMany(
            cascade = {CascadeType.MERGE,CascadeType.PERSIST,CascadeType.DETACH,CascadeType.REFRESH},
            fetch = FetchType.LAZY)
    @JoinTable(name = "recipe_recipe_category"
            , joinColumns = @JoinColumn(name = "recipe_category_id")
            , inverseJoinColumns = @JoinColumn(name = "recipe_id"))
    private List<Recipe> recipes = new ArrayList<>();
    //Convenience Methods
    public boolean addRecipe(Recipe recipe){
        if(recipes == null)
            recipes = new ArrayList<>();
        if(recipe == null)
            throw new IllegalArgumentException("Recipe is null");
        if(!recipes.contains(recipe))
        {
            recipes.add(recipe);
            recipe.getCategories().add(this);
            return true;
        }
        return false;
    }
    public boolean removeRecipe(Recipe recipe){
        if(recipes == null)
            recipes = new ArrayList<>();
        if(recipe == null)
            throw new IllegalArgumentException("Recipe is null");
        if(!recipes.contains(category))
        {
            return false;
        }
        recipes.remove(recipe);
        recipe.getCategories().remove(this);
        return true;
    }

    private String category;

    private RecipeCategory(){}

    public RecipeCategory(String categoryName){
        setCategory(categoryName);
    }

    public int getCategoryId() {
        return category_id;
    }

    public List<Recipe> getRecipes() {
        return recipes;
    }

    public void setRecipes(List<Recipe> recipes) {
        this.recipes = recipes;
    }

    public String getCategory() {
        return category;
    }

    public void setCategory(String category) {
        this.category = category;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        RecipeCategory that = (RecipeCategory) o;
        return category_id == that.category_id &&
                Objects.equals(recipes, that.recipes) &&
                Objects.equals(category, that.category);
    }

    @Override
    public int hashCode() {
        return Objects.hash(category_id, recipes, category);
    }

    @Override
    public String toString() {
        return "RecipeCategory{" +
                "categoryId=" + category_id +
                ", recipes=" + recipes +
                ", category='" + category + '\'' +
                '}';
    }
}