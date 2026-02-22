package br.com.vininiceto.screenmatch.principal;

import br.com.vininiceto.screenmatch.model.DadosSerie;
import br.com.vininiceto.screenmatch.service.ConsumoApi;
import br.com.vininiceto.screenmatch.service.ConverteDados;
import br.com.vininiceto.screenmatch.service.IConverteDados;

import java.util.Locale;
import java.util.Scanner;

public class Principal {

    Scanner sc = new Scanner(System.in).useLocale(Locale.US);

    private ConsumoApi consumo = new ConsumoApi();
    private ConverteDados cd = new ConverteDados();

    private final static String ENDERECO = "https://www.omdbapi.com/?t=";

    private final String API_KEY = "&apikey=7316b439";

    public void menu(){
        System.out.println("Informe o serie que deseja verificar: ");
        var nomeSerie = sc.next();
        String jsonSerie = consumo.obterDados(ENDERECO.replace(" ", "+") + nomeSerie + API_KEY);

        var dadosSerie = cd.converteDados(jsonSerie, DadosSerie.class);
        System.out.println(dadosSerie);




    }

}
