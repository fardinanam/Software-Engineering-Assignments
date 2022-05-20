package accounts;

public abstract class Account {
    protected String name;
    protected double balance;
    protected double loan;
    protected double serviceCharge;
    protected static double interestRateOnLoan;
    protected int elapsedYear;

    public enum AccountTypes {
        FIXED, STUDENT, SAVINGS, LOAN;

        @Override
        public String toString() {
            switch (this) {
                case LOAN: return "LOAN";
                case FIXED: return "FIXED";
                case SAVINGS: return "SAVINGS";
                case STUDENT: return "STUDENT";
            }
            return null;
        }
    }

    public Account(String name) {
        this.name = name;
        this.balance = 0;
        this.loan = 0;
        this.serviceCharge = 500;
        interestRateOnLoan = 10;
        this.elapsedYear = 0;
    }

    public void deposit(double amount) {
        balance += amount;
    }

    /**
     * @param amount withdrawal amount
     * @return true for successful withdrawal. False for failure.
     */
    public abstract boolean withdraw(double amount);

    // TODO: keep track of multiple loans in an array
    /**
     * @param amount requested loan amount
     * @return true, if successful. False, if unsuccessful
     */
    public abstract boolean validateLoan(double amount);

    public void query() {
        System.out.print("Current balance " + balance + '$');
        if(loan > 0) {
            System.out.print(", loan " + loan + "$");
        }

        System.out.println();
    }

    public void addLoan(double amount) {
        balance += amount;
        loan += amount;
    }

    public abstract void increaseYear();

    @Override
    public int hashCode() {
        return name.hashCode();
    }

    @Override
    public boolean equals(Object obj) {
        if(obj instanceof String) {
            return this.name.equals(obj);
        } else if(!(obj instanceof Account)) {
            throw new ClassCastException("Class must be of String or Account type");
        }
        
        return this.name.equals(((Account) obj).name);
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public double getBalance() {
        return balance;
    }
}
