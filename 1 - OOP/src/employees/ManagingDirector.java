package employees;

import accounts.Account;
import accounts.FixedDepositAccount;
import accounts.SavingsAccount;
import accounts.StudentAccount;

public class ManagingDirector extends Employee {
    public ManagingDirector(String name) {
        super(name);
    }

    @Override
    public boolean approveLoan(Account account) {
    // TODO
        return false;
    }

    @Override
    public boolean changeInterestRate(double newInterestRate, Account.AccountTypes accountType) {
        if(accountType == Account.AccountTypes.FIXED) {
            FixedDepositAccount.setInterestRateOnDeposit(newInterestRate);
            return true;
        } else if (accountType == Account.AccountTypes.SAVINGS) {
            SavingsAccount.setInterestRateOnDeposit(newInterestRate);
            return true;
        } else if (accountType == Account.AccountTypes.STUDENT) {
            StudentAccount.setInterestRateOnDeposit(newInterestRate);
            return true;
        }

        return false;
    }

    @Override
    public void seeInternalFunds() {
        // TODO
    }
}
