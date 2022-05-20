package employees;

import accounts.Account;

public abstract class Employee {
    protected String name;

    public Employee(String name) {
        this.name = name;
    }

    public double lookUp(Account account) {
        return account.getBalance();
    }

    public abstract boolean approveLoan(Account account, Double amount);

    public boolean changeInterestRate(double newInterestRate, Account.AccountTypes accountType) {
        System.out.println("You don’t have permission for this operation");
        return false;
    }

    public boolean canSeeInternalFunds() {
        return false;
    }

    @Override
    public int hashCode() {
        return name.hashCode();
    }

    @Override
    public boolean equals(Object obj) {
        if(obj instanceof String) {
            return name.equals(obj);
        } else if (!(obj instanceof Employee)) {
            throw new ClassCastException("Object must be of String or Employee type");
        }

        return name.equals(((Employee) obj).name);
    }

    public String getName() {
        return name;
    }
}