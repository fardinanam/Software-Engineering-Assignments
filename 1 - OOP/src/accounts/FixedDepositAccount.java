package accounts;

import java.time.LocalDate;

public class FixedDepositAccount extends Account {
    public FixedDepositAccount(String name, double initialDeposit) {
        super(name);
        if(initialDeposit < 100000) {
            throw new IllegalArgumentException("Initial deposit of Fixed Deposit Account" +
                    " must be at least 100,000$");
        }

        this.balance = initialDeposit;
        this.interestRateOnDeposit = 15;
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
        if(LocalDate.now().isBefore(dateOfCreation.plusYears(1))) {
            System.out.println("WITHDRAWAL FAILED: Fixed Account" +
                    "is not yet matured to withdraw money");
            return false;
        } else if (balance < amount) {
            System.out.println("WITHDRAWAL FAILED: Insufficient Balance");
            return false;
        }

        balance -= amount;
        return true;
    }

    @Override
    public boolean requestLoan(double amount) {
        if(loan + amount > 100000) {
            System.out.println("Fixed deposit account holder can't get" +
                    "more loans than 100,000$");
            return false;
        }

        loan += amount;
        return true;
    }
}
