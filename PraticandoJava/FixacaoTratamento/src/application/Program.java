package application;

import model.entities.Account;

import java.util.Locale;
import java.util.Scanner;

public class Program {
    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in).useLocale(Locale.US);

        System.out.println("Enter account data: ");
        System.out.print("Number: ");
        Integer number = sc.nextInt();
        System.out.print("Holder: ");
        String holder = sc.next();
        System.out.print("Initial balance: ");
        Double balance = sc.nextDouble();
        System.out.print("Withdraw Limit: ");
        Double withdrawLimit = sc.nextDouble();

        Account acc = new Account(number, holder, balance, withdrawLimit);
        try {
            System.out.print("Enter amount for withdraw: ");
            Double amount = sc.nextDouble();

            acc.withdraw(amount);
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }


    }
}
