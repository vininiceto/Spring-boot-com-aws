package FixacaoLista;

import FixacaoLista.entities.Employee;

import java.util.ArrayList;
import java.util.List;
import java.util.Locale;
import java.util.Scanner;

public class Program {

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in).useLocale(Locale.US);

        List<Employee> list = new ArrayList<>();
        System.out.print("How many employees will be registered? ");
        int x = sc.nextInt();

        for (int i = 0; i < x; i++) {
            System.out.println();
            System.out.println("Employee#" + (i + 1) + ": ");
            System.out.print("Id: ");
            Integer id = sc.nextInt();
            System.out.print("Name: ");
            sc.nextLine();
            String name = sc.nextLine();
            System.out.print("Salary: ");
            Double salary = sc.nextDouble();
            Employee emp = new Employee(id, name, salary);
            list.add(emp);
        }
        System.out.print("Enter the employee id that will have salary increase: ");
        int idSalary = sc.nextInt();
        Employee emp = list.stream().filter(y -> y.getId() == idSalary).findFirst().orElse(null);
        if (emp == null) {
            System.out.println("This id dont exist");
        } else {
            System.out.print("Enter the percentage: ");
            Double percentage = sc.nextDouble();
            emp.increaseSalary(percentage);
        }
        System.out.println();
        System.out.println("List of Employees: ");
        for (Employee e : list) {
            System.out.println(e);
        }
    }


}


