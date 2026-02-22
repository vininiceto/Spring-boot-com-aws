package entities;

public class Film  extends Titulo{

    private String director;

    public Film(String name, Integer releaseYear, Boolean includedPlan, Double someAvaliation, Integer totalAvaliation, Integer durationMinutes, String director) {
        super(name, releaseYear, includedPlan, someAvaliation, totalAvaliation, durationMinutes);
        this.director = director;
    }

    public Film() {
    }

    public String getDirector() {
        return director;
    }

    public void setDirector(String director) {
        this.director = director;
    }

    @Override
    public void showTechnichRecord() {
        super.showTechnichRecord();
    }

    @Override
    public void evaluate(double notice) {
        super.evaluate(notice);
    }

    @Override
    public Double takeAverage() {
        return super.takeAverage();
    }

}
