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

    @ManyToMany
    @JoinTable(name = "recipe_recipe_category"
            , joinColumns = @JoinColumn(name = "category_id")
            , inverseJoinColumns = @JoinColumn(name = "recipe_id"))
    private List<Recipe> recipes = new ArrayList<>();
    //Convenience Methods
    public void addRecipe(Recipe recipe){
        recipes.add(recipe);
        recipe.getCategories().add(this);
    }
    public void removeRecipe(Recipe recipe){
        recipes.remove(recipe);
        recipe.getCategories().remove(this);
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