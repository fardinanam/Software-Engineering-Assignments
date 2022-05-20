package employees;

import accounts.Account;

public class Officer extends Employee {
    public Officer(String name) {
        super(name);
    }

    @Override
    public boolean approveLoan(Account account, Double amount) {
        account.addLoan(amount);
        return true;
    }
}
