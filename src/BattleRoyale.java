import sample.AutoIncrement;
import sample.Game;

import java.util.Objects;

public class BattleRoyale extends Game {
    private static AutoIncrement autoIncrement = new AutoIncrement();
    @Deprecated
    private String name;
    @Deprecated
    private String streaming;

    public BattleRoyale(int id, String name, String streaming) {
        super(id);
        this.name = name;
        this.streaming = streaming;
    }
    public BattleRoyale(){
        super(autoIncrement.autoIncrement());

    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getStreaming() {
        return streaming;
    }

    public void setStreaming(String streaming) {
        this.streaming = streaming;
    }


    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        BattleRoyale battleRoyale = (BattleRoyale) o;
        return name == battleRoyale.name &&
                streaming == battleRoyale.streaming;
    }

    @Override
    public int hashCode() {
        return Objects.hash(name, streaming);
    }

    @Override
    public String toString() {
        return "BattleRoyale{" +
                "name=" + name +
                ", streaming=" + streaming +
                ", id=" + super.getId() +
                '}';
    }

}

