package FixacaoBanco.entities;

public class Bank {

    private Integer numberAccount;
    private String accountOwner;
    private Double balance;
    private final Double TAX = 5.00;

    public Bank(Integer numberAccount, String accountOwner, Double balance){
        this.numberAccount = numberAccount;
        this.accountOwner = accountOwner;
        this.balance =balance;
    }

    public Integer getNumberAccount() {
        return numberAccount;
    }

    public void setNumberAccount(Integer numberAccount) {
        this.numberAccount = numberAccount;
    }

    public String getAccountOwner() {
        return accountOwner;
    }

    public void setAccountOwner(String accountOwner) {
        this.accountOwner = accountOwner;
    }

    public Double getBalance() {
        return balance;
    }

    public Double setBalance(Double balance) {
        this.balance = balance;
        return balance;
    }

    public void changeAccountOwnerName(String name){
        setAccountOwner(name);
        System.out.println("Nome do titular da conta alterado para: " + name);
    }

    public Double deposit(Double value) {
        double novoSaldo = getBalance() + value;
        return setBalance(novoSaldo);
    }

    public Double withdraw(Double value){
        double novoSaldo = getBalance() - (value + TAX);
        return setBalance(novoSaldo);
    }

    public void balanceStatus(){
        System.out.println("Seu saldo atual é: $" + getBalance());
    }

    public String toString(){
        return "Account " + getNumberAccount() +
                ", Holder: " + getAccountOwner() +
                ", Balance: $ " + getBalance();
    }



}
