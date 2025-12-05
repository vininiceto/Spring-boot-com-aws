import model.entities.Candidato;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.*;

public class Main {
    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in).useLocale(Locale.US);

        System.out.println("Digite o caminho do arquivo: ");
        String path = sc.nextLine();

        try (BufferedReader br = new BufferedReader(new FileReader(path))) {


            Map<String, Integer> map = new LinkedHashMap<>();

            String line = br.readLine();

            while (line != null) {

                String[] fields = line.split(",");
                String nome = fields[0];
                Integer qntVotos = Integer.parseInt(fields[1]);

                if (map.containsKey(nome)) {
                    int votes = map.get(nome);
                    map.put(nome, qntVotos + votes);
                } else {
                    map.put(nome, qntVotos);
                }
                line = br.readLine();

            }

            for (String key : map.keySet()) {
                System.out.println(key + ": " + map.get(key));
            }

            map.entrySet().stream()
                    .forEach(entry -> System.out.println(entry.getKey() + ": " + entry.getValue()));

        } catch (IOException e) {
            System.err.println("Caminho do arquivo inválido!");
        }


    }
}