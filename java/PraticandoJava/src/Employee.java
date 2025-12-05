public class Employee {

    private String name;
    private Double grossSalary;
    private Double tax;

    public Employee(String name, Double grossSalary, Double tax){
        this.name = name;
        this.grossSalary = grossSalary;
        this.tax = tax;
    }

    public Double getTax(){
        return tax;
    }

    public String getName(){
        return name;
    }

    public Double getGrossSalary(){
        return grossSalary;
    }

    public void setName(String name){
        this.name = name;
    }

    public void setTax(Double tax) {
        this.tax = tax;
    }

    public void setGrossSalary(Double grossSalary){
        this.grossSalary = grossSalary;
    }

    public Double netSalary(){
        return getGrossSalary() - getTax();
    }

    public void increaseSalary(Double percentage){
        double result = getGrossSalary() * (percentage / 100);
        double totalSalary = netSalary() + result;
        setGrossSalary(totalSalary);
        System.out.println("Updated data: " + name + ", $ " + totalSalary);
    }

    public String toString(){
        return name + ", $ " + getGrossSalary();
    }




}
