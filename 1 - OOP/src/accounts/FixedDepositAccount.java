package accounts;

import java.time.LocalDate;

public class FixedDepositAccount extends Account {
    private static double interestRateOnDeposit;

    public FixedDepositAccount(String name, double initialDeposit) {
        super(name);
        if(initialDeposit < 100000) {
            throw new IllegalArgumentException("Initial deposit of Fixed Deposit Account" +
                    " must be at least 100,000$");
        }

        this.balance = initialDeposit;
        interestRateOnDeposit = 15;
    }

    @Override
    public void deposit(double amount) {
        if(amount < 50000) {
            throw new IllegalArgumentException("Deposit amount for Fixed Deposit Account " +
                    "must be at least 50,000$");
        }

        balance += amount;
    }

    @Override
    public boolean withdraw(double amount) {
        if(elapsedYear < 1 || balance < amount) {
            return false;
        }

        balance -= amount;
        return true;
    }

    @Override
    public boolean validateLoan(double amount) {
        if(loan + amount > 100000) {
            System.out.println("Fixed deposit account holder can't get" +
                    "more loans than 100,000$");
            return false;
        }

        return true;
    }

    @Override
    public void increaseYear() {
        elapsedYear++;
        double newBalance = balance - loan;
        newBalance += newBalance * interestRateOnDeposit / 100 - serviceCharge -
                loan * interestRateOnLoan / 100;
        newBalance += loan;
        balance = newBalance;
    }

    public static void setInterestRateOnDeposit(double interestRateOnDeposit) {
        FixedDepositAccount.interestRateOnDeposit = interestRateOnDeposit;
    }
}
