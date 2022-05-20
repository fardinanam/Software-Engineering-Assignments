package accounts;

public class SavingsAccount extends Account {
    private static double interestRateOnDeposit;

    public SavingsAccount(String name, double initialDeposit) {
        super(name);
        this.balance = initialDeposit;
        interestRateOnDeposit = 10;
    }

    @Override
    public boolean withdraw(double amount) {
        if(balance < amount) {
            System.out.println("WITHDRAWAL FAILED: Insufficient Balance");
            return false;
        } else if(balance - amount < 1000) {
            System.out.println("WITHDRAWAL FAILED: Balance of Savings Account " +
                    "should at least be 1,000");
            return false;
        }

        balance -= amount;
        return true;
    }

    @Override
    public boolean requestLoan(double amount) {
        if(loan + amount > 10000) {
            System.out.println("Savings account holder can't get" +
                    "more loans than 10,000$");
            return false;
        }

        loan += amount;
        return true;
    }

    public static void setInterestRateOnDeposit(double interestRateOnDeposit) {
        SavingsAccount.interestRateOnDeposit = interestRateOnDeposit;
    }
}
