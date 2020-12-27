package se.lexicon.negar.jpaassignment.entity;
import org.hibernate.annotations.GenericGenerator;

import javax.persistence.*;
import java.util.Objects;

@Entity
public class RecipeIngredient {
    @Id
    @GeneratedValue(generator = "UUID")
    @GenericGenerator(
            name = "UUID",
            strategy = "org.hibernate.id.UUIDGenerator"
    )
    @Column(name = "recipe_ingredient_id", updatable = false, nullable = false)
    private String recipe_ingredient_id;

    @ManyToOne(
            cascade = {CascadeType.PERSIST,CascadeType.REFRESH,CascadeType.MERGE,CascadeType.DETACH},
            fetch = FetchType.LAZY)
    private Ingredient ingredient;

    @ManyToOne(
            cascade = {CascadeType.PERSIST,CascadeType.REFRESH,CascadeType.MERGE,CascadeType.DETACH},
            fetch = FetchType.EAGER)
    @JoinColumn(referencedColumnName = "recipe_id")
    private Recipe recipe;

    private double amount;
    private Measurement measurement;

    private RecipeIngredient(){}

    public RecipeIngredient(Ingredient ingredient,double amount,Measurement measurement){
        setAmount(amount);
        setIngredient(ingredient);
        setMeasurement(measurement);
    }

    public String getRecipeIngredientId() {
        return recipe_ingredient_id;
    }

    public Ingredient getIngredient() {
        return ingredient;
    }

    public void setIngredient(Ingredient ingredient) {
        this.ingredient = ingredient;
    }

    public Recipe getRecipe() {
        return recipe;
    }

    public void setRecipe(Recipe recipe) {
        this.recipe = recipe;
    }

    public double getAmount() {
        return amount;
    }

    public void setAmount(double amount) {
        this.amount = amount;
    }

    public Measurement getMeasurement() {
        return measurement;
    }

    public void setMeasurement(Measurement measurement) {
        this.measurement = measurement;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        RecipeIngredient that = (RecipeIngredient) o;
        return Double.compare(that.amount, amount) == 0 &&
                Objects.equals(recipe_ingredient_id, that.recipe_ingredient_id) &&
                Objects.equals(ingredient, that.ingredient) &&
                Objects.equals(recipe, that.recipe) &&
                measurement == that.measurement;
    }

    @Override
    public int hashCode() {
        return Objects.hash(recipe_ingredient_id, ingredient, recipe, amount, measurement);
    }

    @Override
    public String toString() {
        return "RecipeIngredient{" +
                "recipeIngredientId='" + recipe_ingredient_id + '\'' +
                ", ingredient=" + ingredient +
                ", recipe=" + recipe +
                ", amount=" + amount +
                ", measurement=" + measurement +
                '}';
    }
}