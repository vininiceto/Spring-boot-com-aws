import java.util.Locale;
import java.util.Scanner;


public class Pratice {


    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in).useLocale(Locale.US);

        System.out.print("Name: ");
        String name = sc.nextLine();
        System.out.print("Gross salary: ");
        Double salary = sc.nextDouble();
        System.out.print("Tax: ");
        Double tax = sc.nextDouble();

        Employee emp = new Employee(name, salary, tax);

        System.out.print("Employee: " + emp);

        System.out.print("\nWhich percentage to increase salary? ");
        Double percentage = sc.nextDouble();

        emp.increaseSalary(percentage);

    }


}
