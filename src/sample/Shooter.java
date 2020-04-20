package sample;

public class Shooter extends Games {
    public double releaseDate;
    public String name;
    public String[] genre;



    @Override
    public double getReleaseDate() {
        return releaseDate;
    }

    @Override
    public String getName() {
        return name;
    }

    @Override
    public String[] getGenre() {
        return genre;
    }

    public Shooter(double releaseDate, String name, String[] genre){
        this.releaseDate = releaseDate;
        this.name = name;
        this.genre = genre;
    }
}
