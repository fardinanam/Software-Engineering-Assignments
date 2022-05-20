package accounts;

public class LoanAccount extends Account {
    public LoanAccount(String name, double loan) {
        super(name);
        this.loan = loan;
        serviceCharge = 0;
    }

    @Override
    public void deposit(double amount) {
        loan -= amount;
    }

    @Override
    public boolean withdraw(double amount) {
        return false;
    }

    @Override
    public boolean validateLoan(double amount) {
        if(amount > (loan * 5) / 100) {
            System.out.println("Loan request denied. " +
                    "Loan Account holder can't get more than 5% of the current loan");
            return false;
        }

        return true;
    }

    @Override
    public void increaseYear() {
        // Requires to do nothing
    }
}
