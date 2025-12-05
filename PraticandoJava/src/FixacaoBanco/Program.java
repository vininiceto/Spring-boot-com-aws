package FixacaoBanco;

import FixacaoBanco.entities.Bank;

import java.util.Locale;
import java.util.Scanner;

public class Program {

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in).useLocale(Locale.US);

        System.out.print("Enter account number: ");
        Integer numberAccount = sc.nextInt();
        System.out.print("Enter account holder: ");
        sc.nextLine();
        String name = sc.nextLine();
        System.out.print("Is there a initial deposit (y/n)? ");
        char option = sc.next().charAt(0);
        double initialDeposit = 0.0;
        if (option == 'y') {
            System.out.print("Enter initial deposit value: ");
            initialDeposit = sc.nextDouble();

        }
        Bank account = new Bank(numberAccount, name, initialDeposit);


        System.out.println(account);

        System.out.print("Enter a deposit value: ");
        Double value = sc.nextDouble();
        account.deposit(value);
        System.out.println("Updated account data: \n " + account);

        System.out.print("Enter a withdraw value: ");
        Double withdrawValue = sc.nextDouble();
        account.withdraw(withdrawValue);
        System.out.println("Updated account data: \n " + account);


    }



}
