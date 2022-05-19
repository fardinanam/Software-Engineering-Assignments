package accounts;

public class StudentAccount extends Account{
    public StudentAccount(String name, double initialDeposit) {
        super(name);
        this.balance = initialDeposit;
        this.interestRateOnDeposit = 5;
    }

    @Override
    public boolean withdraw(double amount) {
        if(balance < amount) {
            System.out.println("WITHDRAWAL FAILED: Insufficient Balance");
            return false;
        } else if (amount > 10000) {
            System.out.println("WITHDRAWAL FAILED: Withdrawal limit exceeded. (limit: 10,000$)");
            return false;
        }

        balance -= amount;
        return true;
    }

    @Override
    public boolean requestLoan(double amount) {
        if(loan + amount > 1000) {
            System.out.println("Student account holder can't get" +
                    "more loans than 1,000$");
            return false;
        }

        loan += amount;
        return true;
    }
}
