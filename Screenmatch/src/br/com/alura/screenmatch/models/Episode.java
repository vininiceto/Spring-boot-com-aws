package br.com.alura.screenmatch.models;

import br.com.alura.screenmatch.calculos.Classific;

public class Episode implements Classific {

    private Integer num;
    private String name;
    private Series serie;
    private int totalVisualization;

    public Integer getNum() {
        return num;
    }

    public void setNum(Integer num) {
        this.num = num;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Series getSerie() {
        return serie;
    }

    public void setSerie(Series serie) {
        this.serie = serie;
    }

    public int getTotalVisualization() {
        return totalVisualization;
    }

    public void setTotalVisualization(int totalVisualization) {
        this.totalVisualization = totalVisualization;
    }

    @Override
    public int getClassification() {
        if (totalVisualization > 100) {
            return 4;
        } else {
            return 2;
        }
    }


}
