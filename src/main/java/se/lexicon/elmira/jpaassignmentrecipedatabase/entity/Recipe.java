package se.lexicon.elmira.jpaassignmentrecipedatabase.entity;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

public class Recipe {

    private int id;
    private String name;
    private List<RecipeIngredient> recipeIngredients;
    private RecipeInstruction recipeInstruction;
    private List<RecipeCategory> recipeCategories;

    public Recipe() {
    }

    public Recipe(String name, List<RecipeIngredient> recipeIngredients, RecipeInstruction recipeInstruction, List<RecipeCategory> recipeCategories) {
        setName(name);
        setRecipeIngredients(recipeIngredients);
        setRecipeInstruction(recipeInstruction);
        setRecipeCategories(recipeCategories);
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

    public List<RecipeIngredient> getRecipeIngredients() {
        return recipeIngredients;
    }

    public void setRecipeIngredients(List<RecipeIngredient> recipeIngredients) {
        this.recipeIngredients = recipeIngredients;
    }

    public RecipeInstruction getRecipeInstruction() {
        return recipeInstruction;
    }

    public void setRecipeInstruction(RecipeInstruction recipeInstruction) {
        this.recipeInstruction = recipeInstruction;
    }

    public List<RecipeCategory> getRecipeCategories() {
        return recipeCategories;
    }

    public void setRecipeCategories(List<RecipeCategory> recipeCategories) {
        this.recipeCategories = recipeCategories;
    }

    public boolean addRecipeIngredient(RecipeIngredient recipeIngredient){
        boolean added = false;

        if (recipeIngredients == null)
            recipeIngredients = new ArrayList<>();

        if (recipeIngredient == null)
            throw new IllegalArgumentException();

        if (!recipeIngredients.contains(recipeIngredient)){
            added = recipeIngredients.add(recipeIngredient);
            recipeIngredient.setRecipe(this);
        }
        return added;
    }

    public boolean removeRecipeIngredient(RecipeIngredient recipeIngredient){
        boolean removed = false;
        if (recipeIngredients == null)
            recipeIngredients = new ArrayList<>();

        if (recipeIngredient == null)
            throw new IllegalArgumentException();

        if (recipeIngredients.contains(recipeIngredient)){
            removed = recipeIngredients.remove(recipeIngredient);
            recipeIngredient.setRecipe(null);
        }
        return removed;
    }


    public boolean addToRecipeCategory(RecipeCategory recipeCategory){
        boolean added = false;
        if (recipeCategories == null)
            recipeCategories = new ArrayList<>();
        if (recipeCategory == null)
            throw new IllegalArgumentException();
        if (!recipeCategories.contains(recipeCategory)){
            added = recipeCategories.add(recipeCategory);
            recipeCategory.addRecipe(this);
        }
        return added;
    }

    public boolean removeFromRecipeCategory(RecipeCategory recipeCategory){
        boolean removed = false;
        if (recipeCategories == null)
            recipeCategories = new ArrayList<>();
        if (recipeCategory == null)
            throw new IllegalArgumentException();
        if (recipeCategories.contains(recipeCategory)) {
            removed = recipeCategories.remove(recipeCategory);
            recipeCategory.removeRecipe(this);
        }
        return removed;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Recipe recipe = (Recipe) o;
        return getId() == recipe.getId() &&
                Objects.equals(getName(), recipe.getName()) &&
                Objects.equals(getRecipeIngredients(), recipe.getRecipeIngredients()) &&
                Objects.equals(getRecipeInstruction(), recipe.getRecipeInstruction()) &&
                Objects.equals(getRecipeCategories(), recipe.getRecipeCategories());
    }

    @Override
    public int hashCode() {
        return Objects.hash(getId(), getName(), getRecipeIngredients(), getRecipeInstruction(), getRecipeCategories());
    }

    @Override
    public String toString() {
        return "Recipe{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", recipeIngredients=" + recipeIngredients +
                ", recipeInstruction=" + recipeInstruction +
                ", recipeCategories=" + recipeCategories +
                '}';
    }
}
