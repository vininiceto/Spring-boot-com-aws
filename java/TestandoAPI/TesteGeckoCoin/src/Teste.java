import java.io.IOException;
import java.net.URI;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;
import java.util.Locale;
import java.util.Scanner;

public class Teste {

    public static void main(String[] args) throws IOException, InterruptedException {

        Scanner sc = new Scanner(System.in).useLocale(Locale.US);


        String API = "&x_cg_demo_api_key=CG-Gm8FcmbJiFRuZdE1nfuFNdnW";
        String criptomoeda = sc.next();
        String endereco = "https://api.coingecko.com/api/v3/simple/price?vs_currencies=brl&ids=" + criptomoeda + API;


        HttpClient http = HttpClient.newHttpClient();
        HttpRequest req = HttpRequest.newBuilder()
                .uri(URI.create(endereco))
                .build();

        HttpResponse<String> response = http.send(req, HttpResponse.BodyHandlers.ofString());

        System.out.println(response.body());

    }

}
