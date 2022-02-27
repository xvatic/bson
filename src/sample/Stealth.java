package sample;

import java.util.Objects;

public class Stealth extends Game {
    private String name;
    private String hero;

    public Stealth(int id, String name, String hero) {
        super(id);
        this.name = name;
        this.hero = hero;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getHero() {
        return hero;
    }

    public void setHero(String hero) {
        this.hero = hero;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Stealth stealth = (Stealth) o;
        return name == stealth.name &&
                hero == stealth.hero;
    }

    @Override
    public int hashCode() {
        return Objects.hash(name, hero);
    }

    @Override
    public String toString() {
        return "Stealth{" +
                "name=" + name +
                ", hero=" + hero +
                ", id=" + super.getId() +
                '}';
    }
}
