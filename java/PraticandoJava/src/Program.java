import java.util.Locale;
import java.util.Scanner;

public class Program {

    public static void main(String[] args) {

        Scanner sc= new Scanner(System.in).useLocale(Locale.US);

        System.out.print("What is the dollar price? ");
        Double dollarPrice = sc.nextDouble();
        System.out.print("How many dollars will be bought? ");
        Double quantity = sc.nextDouble();
        CurrencyConverter cv = new CurrencyConverter(dollarPrice, quantity);
        cv.converter();

    }


}
