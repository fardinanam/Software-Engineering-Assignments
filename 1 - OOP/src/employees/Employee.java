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

    public boolean approveLoan(Account account) {
        System.out.println("You don’t have permission for this operation");
        return false;
    }

    public boolean changeInterestRate(double newInterestRate, Account.AccountTypes accountType) {
        System.out.println("You don’t have permission for this operation");
        return false;
    }

    public void seeInternalFunds() {
        // TODO
    }

    public String getName() {
        return name;
    }
}