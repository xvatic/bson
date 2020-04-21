package sample;

import java.util.Objects;

public class Shooter extends Games {

    private String name;

    public Shooter(int id, String name) {
        super(id);
        this.name = name;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Shooter shooter = (Shooter) o;
        return name == shooter.name;
    }

    @Override
    public int hashCode() {
        return Objects.hash(name);
    }

    @Override
    public String toString() {
        return "Shooter{" +
                "name=" + name +
                "id=" + super.getId() +
                '}';
    }
}

