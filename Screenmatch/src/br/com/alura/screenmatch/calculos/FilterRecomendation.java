package br.com.alura.screenmatch.calculos;

public class FilterRecomendation {

    private String recomendation;

    public void filter(Classific classification){
        if(classification.getClassification() >= 4){
            System.out.println("Preferido no momento");
        }
        if(classification.getClassification() >= 2){
            System.out.println("Bem avaliado");
        }
        else{
            System.out.println("Coloque na sua lista para assistir depois!");
        }
    }
}
