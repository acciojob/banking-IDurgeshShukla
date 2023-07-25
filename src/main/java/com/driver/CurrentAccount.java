package com.driver;

import java.util.Arrays;

public class CurrentAccount extends BankAccount{
    String tradeLicenseId; //consists of Uppercase English characters only
    double balance ;
    public CurrentAccount(String name, double balance, String tradeLicenseId) throws Exception {
        // minimum balance is 5000 by default. If balance is less than 5000, throw "Insufficient Balance" exception
        super(name,balance);
        if (balance < 5000) throw new Exception("Insufficient Balance");
        setMinBalance(5000);
        this.tradeLicenseId = tradeLicenseId;
    }

    public void validateLicenseId() throws Exception {
        // A trade license Id is said to be valid if no two consecutive characters are same
        boolean valid = true;
        for (int i = 0; i< tradeLicenseId.length() - 1; i++){
            if(tradeLicenseId.charAt(i) == tradeLicenseId.charAt(i+1)){
                valid = false;
            }
        }
        // If the license Id is valid, do nothing
        // If the characters of the license Id can be rearranged to create any valid license Id
        // find index where two consecutive are same then from here go and found a new index where characters are
        // same in case you reached end it means license can not be generated if index is found then swap first
        // character with next possible character
        char arr[] = tradeLicenseId.toCharArray();
        int n = arr.length;
        for (int i = 1; i< n ; i++){
            if (arr[i] == arr[i-1]){
                // find next invalid
                int j = i + 1;
                while (j < n && arr[i] == arr[j]){
                    j++;
                }
                // If it is not possible, throw "Valid License can not be generated" Exception
                if (j == n) throw new Exception("Valid License can not be generated");
                else
                {
                    //swap
                    char temp = arr[i];
                    arr[i] = arr[j];
                    arr[j] = temp;
                }
            }
        }
       this.tradeLicenseId = Arrays.toString(arr);
    }

}
