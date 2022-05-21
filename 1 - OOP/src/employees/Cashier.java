package employees;

import accounts.Account;

public class Cashier extends Employee {
    public Cashier(String name) {
        super(name);
    }

    @Override
    public boolean approveLoan(Account account, Double amount) {
        System.out.println("You don’t have permission for this operation");
        return false;
    }
}
