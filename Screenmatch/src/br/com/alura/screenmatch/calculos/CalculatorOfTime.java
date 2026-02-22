package br.com.alura.screenmatch.calculos;

import br.com.alura.screenmatch.models.Titulo;

public class CalculatorOfTime {

    private int totalTime;

    public int getTotalTime() {
        return this.totalTime;
    }

//    public void inclui(Filme f) {
//        this.tempoTotal += f.getDuracaoEmMinutos();
//    }
//
//    public void inclui(Serie s) {
//        this.tempoTotal += s.getDuracaoEmMinutos();
//    }

    public void inclui(Titulo titulo) {
        System.out.println("Adicionando duração em minutos de " + titulo);
        this.totalTime += titulo.getDurationMinutes();
    }


}
