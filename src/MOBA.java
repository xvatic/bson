import sample.Games;

import java.util.Objects;

public class MOBA extends Games {
    private String name;
    private int heroes;

    public MOBA(int id, String name, int heroes) {
        super(id);
        this.name = name;
        this.heroes = heroes;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getHeroes() {
        return heroes;
    }

    public void setHeroes(int heroes) {
        this.heroes = heroes;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        MOBA moba = (MOBA) o;
        return name == moba.name &&
                heroes == moba.heroes;
    }

    @Override
    public int hashCode() {
        return Objects.hash(name, heroes);
    }

    @Override
    public String toString() {
        return "MOBA{" +
                "name=" + name +
                ", heroes=" + heroes +
                ", id=" + super.getId() +
                '}';
    }
}
