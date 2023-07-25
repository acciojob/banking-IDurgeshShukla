package com.driver;

import java.util.Random;

public class BankAccount {

    private String name;
    private double balance;
    private double minBalance;

    public BankAccount(String name, double balance, double minBalance) {
        this.name = name;
        this.balance = balance;
        this.minBalance = minBalance;
    }

    public double getBalance() {
        return balance;
    }

    public void setBalance(double balance) {
        this.balance = balance;
    }

    public double getMinBalance() {
        return minBalance;
    }

    public void setMinBalance(double minBalance) {
        this.minBalance = minBalance;
    }

    public BankAccount(String name, double balance) {
        this.name = name;
        this.balance = balance;
        this.minBalance = 5000;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String generateAccountNumber(int digits, int sum) throws Exception{
        //Each digit of an account number can lie between 0 and 9 (both inclusive)
        //Generate account number having given number of 'digits' such that the sum of digits is equal to 'sum'
        //If it is not possible, throw "Account Number can not be generated" exception
        Random rm = new Random();
        int LowerBound = (int)Math.pow(10,digits-1);
        int UpperBound = 9*LowerBound;

        String AccountNumber = LowerBound + rm.nextInt(UpperBound) +"";
        int maxAttempts = 1000;
        while (maxAttempts >0){
            int cursum = 0;
            for (int i = 0; i < AccountNumber.length(); i++){
                cursum += AccountNumber.charAt(i) - '0';
            }
            if (cursum == sum) return AccountNumber;
            AccountNumber = LowerBound + rm.nextInt(UpperBound) +"";
            maxAttempts--;
        }
        throw new Exception("Account Number can not be generated");
    }

    public void deposit(double amount) {
        //add amount to balance
        this.balance += amount;

    }

    public void withdraw(double amount) throws Exception {
        // Remember to throw "Insufficient Balance" exception, if the remaining amount would be less than minimum balance
        if (amount > this.minBalance){
            throw new Exception("Insufficient Balance") ;
        } else {
            this.balance -= amount;
        }
    }

}