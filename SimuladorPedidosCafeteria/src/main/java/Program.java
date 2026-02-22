import entities.OrderEntity;

import java.util.Locale;
import java.util.Scanner;

public class Program {

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in).useLocale(Locale.US);

        System.out.println("Quantos itens: ");
        Integer x = sc.nextInt();

        String productName;
        Double price;
        Boolean clientRegistered;
        Double totalPrice = 0.0;

        OrderEntity oe = new OrderEntity();

        for (int i = 0; i < x; i++) {
            System.out.println("Informe o nome do item: ");
            productName = sc.next();
            System.out.println("Informe o valor do item: ");
            price = sc.nextDouble();
            System.out.println("Você possui cadastro? ");
            clientRegistered = sc.nextBoolean();

            oe.setProductName(productName);
            totalPrice += price;
            oe.setClientRegistered(clientRegistered);

            System.out.println(oe.totalOrder(totalPrice));
        }


    }

}
