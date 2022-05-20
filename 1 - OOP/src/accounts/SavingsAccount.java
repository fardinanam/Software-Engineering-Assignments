package accounts;

public class SavingsAccount extends Account {
    private static double interestRateOnDeposit = 10;

    public SavingsAccount(String name, double initialDeposit) {
        super(name);
        this.balance = initialDeposit;
    }

    @Override
    public boolean withdraw(double amount) {
        if(balance < amount || balance - amount < 1000) {
            return false;
        }

        balance -= amount;
        return true;
    }

    @Override
    public boolean validateLoan(double amount) {
        if(loan + amount > 10000) {
            System.out.println("Savings account holder can't get" +
                    "more loans than 10,000$");
            return false;
        }

        return true;
    }

    public static void setInterestRateOnDeposit(double interestRateOnDeposit) {
        SavingsAccount.interestRateOnDeposit = interestRateOnDeposit;
    }

    @Override
    public void increaseYear() {
        elapsedYear++;
        double newBalance = balance - loan;
        newBalance += newBalance * (interestRateOnDeposit / 100) - serviceCharge -
                loan * (interestRateOnLoan / 100);
        newBalance += loan;
        balance = newBalance;
    }
}
