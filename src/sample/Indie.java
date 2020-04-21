package sample;

import java.util.Objects;

public class Indie extends Games{
    private String name;
    private String level;

    public Indie(int id, String name, String level) {
        super(id);
        this.name = name;
        this.level = level;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getLevel() {
        return level;
    }

    public void setLevel(String level) {
        this.level = level;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Indie indie = (Indie) o;
        return name == indie.name &&
                level == indie.level;
    }

    @Override
    public int hashCode() {
        return Objects.hash(name, level);
    }

    @Override
    public String toString() {
        return "Indie{" +
                "name=" + name +
                ", level=" + level +
                ", id=" + super.getId() +
                '}';
    }
}
