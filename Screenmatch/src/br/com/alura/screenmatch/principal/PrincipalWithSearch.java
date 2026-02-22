package br.com.alura.screenmatch.principal;

import br.com.alura.screenmatch.models.TitleOMDB;
import br.com.alura.screenmatch.models.Titulo;
import com.google.gson.FieldNamingPolicy;
import com.google.gson.Gson;
import com.google.gson.GsonBuilder;

import java.io.IOException;
import java.net.URI;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;
import java.util.Scanner;


public class PrincipalWithSearch {

    public static void main(String[] args) throws IOException, InterruptedException {

        Scanner sc = new Scanner(System.in);
        Gson gson = new GsonBuilder().setFieldNamingPolicy(FieldNamingPolicy.UPPER_CAMEL_CASE).setPrettyPrinting().create();

        String API_KEY = "&apikey=7316b439";
        var filme = sc.next();
        StringBuilder sb = new StringBuilder(filme);

        for (int i = 0; i < sb.length(); i++) {
            if (sb.charAt(i) == ' ') {
                sb.setCharAt(i, '+');
            }
        }

        String endereco = "https://www.omdbapi.com/?t=" + sb + API_KEY;

        HttpClient http = HttpClient.newHttpClient();
        HttpRequest req = HttpRequest.newBuilder()
                .uri(URI.create(endereco))
                .build();

        HttpResponse<String> response = http.send(req, HttpResponse.BodyHandlers.ofString());

        //System.out.println(response.body());

        String json = response.body();
        System.out.println(json);

        //Titulo meuTitulo = gson.fromJson(json, Titulo.class);
        TitleOMDB meuTituloOMDB = gson.fromJson(json, TitleOMDB.class);
        System.out.println(meuTituloOMDB);

        try{
            Titulo meuTitulo = new Titulo(meuTituloOMDB);
            System.out.println(meuTitulo);

        }
        catch(NumberFormatException e){
            System.err.println(e.getMessage());
        }
        System.out.println("Finalizou!");
    }
}
