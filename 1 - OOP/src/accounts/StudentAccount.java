package accounts;

public class StudentAccount extends Account{
    private static double interestRateOnDeposit;
    public StudentAccount(String name, double initialDeposit) {
        super(name);
        this.balance = initialDeposit;
        interestRateOnDeposit = 5;
    }

    @Override
    public boolean withdraw(double amount) {
        if(balance < amount) {
            return false;
        } else if (amount > 10000) {
            return false;
        }

        balance -= amount;
        return true;
    }

    @Override
    public boolean validateLoan(double amount) {
        if(loan + amount > 1000) {
            System.out.println("Student account holder can't get" +
                    "more loans than 1,000$");
            return false;
        }

        return true;
    }

    public static void setInterestRateOnDeposit(double interestRateOnDeposit) {
        StudentAccount.interestRateOnDeposit = interestRateOnDeposit;
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
