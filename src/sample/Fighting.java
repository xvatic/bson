package sample;

import java.util.Objects;

public class Fighting extends Games {
    private String name;
    private int prizePool;

    public Fighting(int id, String name, int prizePool) {
        super(id);
        this.name = name;
        this.prizePool = prizePool;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getPrizePool() {
        return prizePool;
    }

    public void setPrizePool(int prizePool) {
        this.prizePool = prizePool;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Fighting fighting = (Fighting) o;
        return name == fighting.name &&
                prizePool == fighting.prizePool;
    }

    @Override
    public int hashCode() {
        return Objects.hash(name, prizePool);
    }

    @Override
    public String toString() {
        return "Racing{" +
                "name=" + name +
                ", carsAmount=" + prizePool +
                ", id=" + super.getId() +
                '}';
    }
}
