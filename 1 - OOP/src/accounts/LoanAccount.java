package accounts;

public class LoanAccount extends Account {
    public LoanAccount(String name, double loan) {
        super(name);
        this.loan = loan;
        serviceCharge = 0;
    }

    @Override
    public boolean withdraw(double amount) {
        System.out.println("Cannot withdraw money from Loan Account");
        return false;
    }

    @Override
    public boolean requestLoan(double amount) {
        if(amount > (loan * 5) / 100) {
            System.out.println("Loan request denied. " +
                    "Loan Account holder can't get more than 5% of the current loan");
            return false;
        }

        loan += amount;
        return true;
    }
}
