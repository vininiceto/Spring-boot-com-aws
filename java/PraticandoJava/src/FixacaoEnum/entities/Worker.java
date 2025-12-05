package FixacaoEnum.entities;

import java.time.LocalDate;
import java.time.YearMonth;
import java.time.ZoneId;
import java.util.ArrayList;
import java.util.List;

public class Worker {

    private String name;
    private Worker_Level level;
    private Double baseSalary;
    private Departament department;
    private List<HourContract> contracts = new ArrayList<>();

    public Worker(){

    }

    public Worker(String name, Worker_Level level, Double baseSalary, Departament department){
        this.name = name;
        this.level = level;
        this.baseSalary = baseSalary;
        this.department = department;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Worker_Level getLevel() {
        return level;
    }

    public void setLevel(Worker_Level level) {
        this.level = level;
    }

    public Double getBaseSalary() {
        return baseSalary;
    }

    public void setBaseSalary(Double baseSalary) {
        this.baseSalary = baseSalary;
    }

    public Departament getDepartment() {
        return department;
    }

    public void setDepartment(Departament department) {
        this.department = department;
    }

    public List<HourContract> getContracts() {
        return contracts;
    }

    public void addContract(HourContract contract){
        contracts.add(contract);
    }


    public void removeContract(HourContract contract){
        contracts.remove(contract);
    }

    public Double income(Integer year, Integer month){
        double sum = baseSalary;
        YearMonth ym = YearMonth.of(year, month);

        for (HourContract c : contracts) {
            LocalDate data = c.getDate().toInstant()
                    .atZone(ZoneId.systemDefault())
                    .toLocalDate();

            YearMonth contractYM = YearMonth.from(data);

            if (contractYM.equals(ym)) {
                sum += c.totalValue();
            }
        }
        return sum;
    }



}
