package model.entities;

import model.exception.WithdrawException;

public class Account {

    private Integer number;
    private String holder;
    private Double balance;
    private Double withdrawLimit;

    public Account(){};

    public Account(Integer number, String holder, Double balance, Double withdrawLimit){
        this.number = number;
        this.holder = holder;
        this.balance = balance;
        this.withdrawLimit = withdrawLimit;
    }

    public Integer getNumber(){
        return number;
    }

    public void setNumber(Integer number){
        this.number = number;
    }

    public String getHolder(){
        return holder;
    }

    public void setHolder(String holder){
        this.holder = holder;
    }

    public Double getBalance(){
        return balance;
    }

    public void setBalance(Double balance){
        this.balance = balance;
    }

    public Double getWithdrawLimit(){
        return withdrawLimit;
    }

    public void setWithdrawLimit(Double withdrawLimit){
        this.withdrawLimit = withdrawLimit;
    }

    public void deposit(Double amount){
        balance += amount;
    }

    public void withdraw(Double amount){
        if(amount > withdrawLimit){
            throw new WithdrawException("Withdraw Error: The amount exceeds withdraw limit");
        }
        else if(amount > getBalance()){
            throw new WithdrawException("Withdraw Error: Not enough balance");
        }
        else{
            balance -= amount;
            System.out.println("New balance: " + getBalance());
        }

    }







}
