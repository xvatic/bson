package sample;

import java.util.Objects;

public class Racing extends Games{
    private String name;
    private int carsAmount;

    public Racing(int id, String name, int carsAmount) {
        super(id);
        this.name = name;
        this.carsAmount = carsAmount;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getCarsAmount() {
        return carsAmount;
    }

    public void setCarsAmount(int carsAmount) {
        this.carsAmount = carsAmount;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Racing racing = (Racing) o;
        return name == racing.name &&
                carsAmount == racing.carsAmount;
    }

    @Override
    public int hashCode() {
        return Objects.hash(name, carsAmount);
    }

    @Override
    public String toString() {
        return "Racing{" +
                "name=" + name +
                ", carsAmount=" + carsAmount +
                ", id=" + super.getId() +
                '}';
    }
}


