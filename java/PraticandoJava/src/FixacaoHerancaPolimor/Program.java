package FixacaoHerancaPolimor;

import FixacaoHerancaPolimor.entities.ImportedProduct;
import FixacaoHerancaPolimor.entities.Product;
import FixacaoHerancaPolimor.entities.UsedProduct;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.List;
import java.util.Locale;
import java.util.Scanner;

public class Program {

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in).useLocale(Locale.US);

        DateTimeFormatter dtm = DateTimeFormatter.ofPattern("dd/MM/yyyy");

        System.out.print("Enter the number of products: ");
        int x = sc.nextInt();

        List<Product> list = new ArrayList<>();

        for (int i = 1; i <= x; i++) {
            System.out.printf("Product #%s data: ", i);
            System.out.print("Common, used or imported (c/u/i)? ");
            char y = sc.next().charAt(0);
            System.out.print("Name: ");
            String name = sc.next();
            System.out.print("Price: ");
            Double price = sc.nextDouble();
            if(y == 'i'){
                System.out.print("Customs fee: ");
                Double customsFee = sc.nextDouble();
                Product ip = new ImportedProduct(name,price,customsFee);
                list.add(ip);
            } else if (y == 'c') {
                Product pd = new Product(name, price);
                list.add(pd);
            }
            else if(y == 'u'){
                System.out.print("Manufacture date (DD/MM/YYYY): ");
                LocalDate date = LocalDate.parse(sc.next(), dtm);
                Product up = new UsedProduct(name,price,date);
                list.add(up);
            }

        }

        System.out.println("PRICE TAGS: ");
        for(Product product : list){
            System.out.println(product.priceTag());
        }

    }


}
