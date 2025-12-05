package FixacaoLista.entities;

import java.util.ArrayList;
import java.util.List;

public class Employee {

    private Integer id;
    private String name;
    private Double salary;

    public Employee(Integer id, String name, Double salary){
        this.id = id;
        this.name = name;
        this.salary= salary;
    }

    public Integer getId(){
        return id;
    }

    public void setId(Integer id){
        this.id = id;
    }

    public String getName(){
        return name;
    }

    public void setName(String name){
        this.name = name;
    }

    public Double getSalary(){
        return salary;
    }

    public Double setSalary(Double salary){
        this.salary = salary;
        return salary;
    }


    public void increaseSalary(Double percentage){
        salary +=  salary * percentage / 100.0;

    }

    @Override
    public String toString() {
        return id +
                ", name='" + name + '\'' +
                ", salary=" + salary;
    }
}
