package com.driver;

public class SavingsAccount extends BankAccount{
    double rate;
    double maxWithdrawalLimit;

    public SavingsAccount(String name, double balance, double maxWithdrawalLimit, double rate) {
        // minimum balance is 0 by default
        super(name,balance);
        setMinBalance(0);
        this.maxWithdrawalLimit = maxWithdrawalLimit;
        this.rate = rate;

    }
    public void withdraw(double amount) throws Exception {
        // Might throw the following errors:
        // 1. "Maximum Withdraw Limit Exceed" : If the amount exceeds maximum withdrawal limit
        boolean invalid = false;
        try {
            if (amount > maxWithdrawalLimit) {
                Exception e =  new Exception("Maximum Withdraw Limit Exceed");
            }
        } catch (Exception e){
            invalid = true;
            System.out.println(e.getMessage());
        }
        // 2. "Insufficient Balance" : If the amount exceeds balance

        try{
            if (amount > getBalance()) {
                Exception e = new Exception("Insufficient Balance");
            }
        } catch (Exception e){
            invalid = true;
            System.out.println(e.getMessage());
        }
        if(!invalid)
             setBalance( getBalance() - amount);
    }

    public double getSimpleInterest(int years){
        // Return the final amount considering that bank gives simple interest on current amount
        return getBalance() + (getBalance()* rate * years)/100;
    }

    public double getRate() {
        return rate;
    }

    public void setRate(double rate) {
        this.rate = rate;
    }

    public double getMaxWithdrawalLimit() {
        return maxWithdrawalLimit;
    }

    public void setMaxWithdrawalLimit(double maxWithdrawalLimit) {
        this.maxWithdrawalLimit = maxWithdrawalLimit;
    }

    public double getCompoundInterest(int times, int years){
        // Return the final amount considering that bank gives compound interest on current amount given times per year
        return getBalance()*(Math.pow(1+ (rate/100),years));
    }

}
