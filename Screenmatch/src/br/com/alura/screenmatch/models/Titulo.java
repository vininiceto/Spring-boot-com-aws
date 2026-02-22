package br.com.alura.screenmatch.models;


import com.google.gson.annotations.SerializedName;

public class Titulo implements Comparable<Titulo> {
    @SerializedName("Title")
    private String name;
    @SerializedName("Year")
    private Integer releaseYear;
    private Boolean includedPlan;
    private Double someAvaliation;
    private Integer totalAvaliation;
    private Integer durationMinutes;

    public Titulo(String name, Integer releaseYear, Boolean includedPlan, Double someAvaliation, Integer totalAvaliation, Integer durationMinutes) {
        this.name = name;
        this.releaseYear = releaseYear;
        this.includedPlan = includedPlan;
        this.someAvaliation = someAvaliation;
        this.totalAvaliation = totalAvaliation;
        this.durationMinutes = durationMinutes;
    }

    public Titulo() {
    }

    public Titulo(TitleOMDB meuTituloOMDB) {
        this.name = meuTituloOMDB.title();
        this.releaseYear = Integer.valueOf(meuTituloOMDB.year());
        this.durationMinutes = Integer.valueOf(meuTituloOMDB.runtime().substring(0, 2));
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Integer getReleaseYear() {
        return releaseYear;
    }

    public void setReleaseYear(Integer releaseYear) {
        this.releaseYear = releaseYear;
    }

    public Boolean getIncludedPlan() {
        return includedPlan;
    }

    public void setIncludedPlan(Boolean includedPlan) {
        this.includedPlan = includedPlan;
    }

    public Double getSomeAvaliation() {
        return someAvaliation;
    }

    public void setSomeAvaliation(Double someAvaliation) {
        this.someAvaliation = someAvaliation;
    }

    public Integer getTotalAvaliation() {
        return totalAvaliation;
    }

    public void setTotalAvaliation(Integer totalAvaliation) {
        this.totalAvaliation = totalAvaliation;
    }

    public Integer getDurationMinutes() {
        return durationMinutes;
    }

    public void setDurationMinutes(Integer durationMinutes) {
        this.durationMinutes = durationMinutes;
    }

    public void showTechnichRecord() {
        System.out.println("Nome do filme: " + getName());
        System.out.println("Ano de lançamento: " + getReleaseYear());
    }

    public void evaluate(double notice) {
        double total = 0.0;
        System.out.println(total += notice);
        this.totalAvaliation++;

    }

    public Double takeAverage() {
        return getSomeAvaliation() / getTotalAvaliation();
    }

    @Override
    public int compareTo(Titulo otherTitle) {
        return this.getName().compareTo(otherTitle.getName());
    }

    @Override
    public String toString() {
        return "Titulo{" +
                "name='" + name + '\'' +
                ", releaseYear=" + releaseYear +
                ", durationMinutes=" + durationMinutes +
                '}';
    }
}
