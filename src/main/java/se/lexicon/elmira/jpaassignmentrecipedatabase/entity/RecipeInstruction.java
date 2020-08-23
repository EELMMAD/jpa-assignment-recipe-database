package se.lexicon.elmira.jpaassignmentrecipedatabase.entity;

import java.util.Objects;

public class RecipeInstruction {
    private int id;
    private String instruction;

    public RecipeInstruction() {
    }

    public RecipeInstruction(String instruction) {
        this.instruction = instruction;
    }

    public int getId() {
        return id;
    }

    public String getInstruction() {
        return instruction;
    }

    public void setInstruction(String instruction) {
        this.instruction = instruction;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        RecipeInstruction that = (RecipeInstruction) o;
        return getId() == that.getId() &&
                Objects.equals(getInstruction(), that.getInstruction());
    }

    @Override
    public int hashCode() {
        return Objects.hash(getId(), getInstruction());
    }

    @Override
    public String toString() {
        return "RecipeInstruction{" +
                "id=" + id +
                ", instruction='" + instruction + '\'' +
                '}';
    }
}
