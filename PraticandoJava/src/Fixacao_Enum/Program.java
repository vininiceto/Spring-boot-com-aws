package Fixacao_Enum;

import Fixacao_Enum.entities.*;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Locale;
import java.util.Scanner;

public class Program {


    public static void main(String[] args) throws ParseException {
        Scanner sc = new Scanner(System.in).useLocale(Locale.US);

        SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");

        System.out.println("Enter cliente data: ");
        System.out.print("Name: ");
        String name = sc.nextLine();
        System.out.print("Email: ");
        String email = sc.nextLine();
        System.out.print("Birth date (DD/MM/YYYY): ");
        Date birthDay = sdf.parse(sc.nextLine());
        Client client = new Client(name, email, birthDay);

        System.out.println("Enter order data:");
        System.out.print("Status: ");
        OrderStatus status = OrderStatus.valueOf(sc.next());

        Order order = new Order(new Date(), status, client);
        System.out.print("How many items to this order? ");
        int quantityOrder = sc.nextInt();
        for (int i = 1; i <= quantityOrder; i++) {
            System.out.println("Enter #" + i + " item data: ");
            System.out.print("Product name: ");
            sc.nextLine();
            String productName = sc.nextLine();
            System.out.print("Product price: ");
            Double price = sc.nextDouble();

            Product product = new Product(productName, price);

            System.out.print("Quantity: ");
            Integer quantity = sc.nextInt();

            OrderItem ot = new OrderItem(quantity, price, product);

            order.addItem(ot);
        }

        System.out.println();
        System.out.println("ORDER SUMMARY:");
        System.out.println(order);

    }

}


