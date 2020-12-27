package se.lexicon.negar.jpaassignment.entity;

import java.util.Objects;

public class Ingredient {
    private int ingredient_id;
    private String ingredient_name;

    public Ingredient(){}
    public Ingredient(String ingredientName){
        setIngredient_name(ingredientName);
    }

    public int getIngredient_id() {
        return ingredient_id;
    }

    public String getIngredient_name() {
        return ingredient_name;
    }

    public void setIngredient_name(String ingredient_name) {
        this.ingredient_name = ingredient_name;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Ingredient that = (Ingredient) o;
        return ingredient_id == that.ingredient_id &&
                Objects.equals(ingredient_name, that.ingredient_name);
    }

    @Override
    public int hashCode() {
        return Objects.hash(ingredient_id, ingredient_name);
    }

    @Override
    public String toString() {
        return "Ingredient{" +
                "ingredient_id=" + ingredient_id +
                ", ingredient_name='" + ingredient_name + '\'' +
                '}';
    }
}
