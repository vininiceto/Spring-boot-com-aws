package br.com.alura.screenmatch.models;

import br.com.alura.screenmatch.calculos.Classific;

public class Film  extends Titulo implements Classific {

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
    public int getClassification() {
        return 0;
    }
}
