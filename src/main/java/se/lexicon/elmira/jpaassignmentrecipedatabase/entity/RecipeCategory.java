package se.lexicon.elmira.jpaassignmentrecipedatabase.entity;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

public class RecipeCategory {

    private int id;
    private String name;
    private List<Recipe> recipes;

    public RecipeCategory() {
    }

    public RecipeCategory(String category, List<Recipe> recipes) {
        this.name = category;
        this.recipes = recipes;
    }

    public boolean addRecipe(Recipe recipe){
        boolean added = false;
        if (recipes == null)
            recipes = new ArrayList<>();

        if (recipe == null)
            throw new IllegalArgumentException();

        if (!recipes.contains(recipe)){
            added = recipes.add(recipe);
            recipe.getRecipeCategories().add(this);
        }
        return added;
    }

    public boolean removeRecipe(Recipe recipe){
        boolean removed = false;
        if (recipes == null)
            recipes = new ArrayList<>();

        if (recipe == null)
            throw new IllegalArgumentException();

        if (recipes.contains(recipe)){
            removed = recipes.add(recipe);
            recipe.getRecipeCategories().remove(this);
        }
        return removed;
    }

    public int getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public List<Recipe> getRecipes() {
        return recipes;
    }

    public void setRecipes(List<Recipe> recipes) {
        this.recipes = recipes;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        RecipeCategory that = (RecipeCategory) o;
        return getId() == that.getId() &&
                Objects.equals(getName(), that.getName()) &&
                Objects.equals(getRecipes(), that.getRecipes());
    }

    @Override
    public int hashCode() {
        return Objects.hash(getId(), getName(), getRecipes());
    }

    @Override
    public String toString() {
        return "RecipeCategory{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", recipes=" + recipes +
                '}';
    }
}
