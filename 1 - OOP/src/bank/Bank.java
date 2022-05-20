package bank;

import accounts.*;
import employees.Cashier;
import employees.Employee;
import kotlin.Pair;

import java.util.*;

class Bank {
    private static Bank bank = null;
    private final HashSet<Account> accounts;
    private final HashSet<Employee> employees;
    private final LinkedList<Pair<Account, Double>> loanRequests;
    private double fund;

    private Bank() {
        fund = 1000000;
        accounts = new HashSet<>();
        employees = new HashSet<>();
        loanRequests = new LinkedList<>();
    }

    public static Bank getInstance() {
        if(bank == null) {
            bank = new Bank();
        }

        return bank;
    }

    public void addEmployee(Employee employee) {
        employees.add(employee);
    }

    public boolean createAccount(String name, Account.AccountTypes accountType, double initialAmount) {
        Account account;

        if(employees.contains(new Cashier(name))) {
            System.out.println("Invalid Name");
            return false;
        }

        switch (accountType) {
            case SAVINGS:
                account = new SavingsAccount(name, initialAmount);
                break;
            case STUDENT:
                account = new StudentAccount(name, initialAmount);
                break;
            case LOAN:
                account = new LoanAccount(name, initialAmount);
                fund -= initialAmount;
                break;
            default:
                try {
                    account = new FixedDepositAccount(name, initialAmount);
                } catch (IllegalArgumentException e) {
                    System.out.println(e.getMessage());
                    return false;
                }
                break;
        }

        if(accounts.contains(account)) {
            System.out.println("You already have an account");
            return false;
        }

        fund += initialAmount;
        accounts.add(account);
        return true;
    }

    public boolean hasPendingLoanRequests() {
        return !loanRequests.isEmpty();
    }

    public ArrayList<Account> approveLoans(Employee employee) {
        ArrayList<Account> approvedLoanAccounts = new ArrayList<>();
        ListIterator<Pair<Account, Double>> iterator = loanRequests.listIterator();

        while (iterator.hasNext()) {
            Pair<Account, Double> it = iterator.next();
            Account account = it.getFirst();
            double amount = it.getSecond();
            if(employee.approveLoan(account, amount)) {
                approvedLoanAccounts.add(account);
                iterator.remove();
            }
        }

        return approvedLoanAccounts;
    }

    public void increaseYear() {
        for(Account account : accounts) {
            account.increaseYear();
        }
    }

    public Employee getEmployee(String name) {
        for(Employee employee : employees) {
            if(employee.getName().equals(name))
                return employee;
        }

        return null;
    }

    public HashSet<Employee> getEmployees() {
        return employees;
    }

    public Account getAccount(String name) {
        for(Account account : accounts) {
            if(account.getName().equals(name))
                return account;
        }

        return null;
    }

    public HashSet<Account> getAccounts() {
        return accounts;
    }

    public void deposit(Account account, double amount) {
        account.deposit(amount);
        fund += amount;
    }

    public boolean withdraw(Account account, double amount) {
        if(account.withdraw(amount)) {
            fund -= amount;
            return true;
        }

        return false;
    }

    public boolean requestLoan(Account account, double amount) {
        if(account.validateLoan(amount)) {
            loanRequests.add(new Pair<>(account, amount));
            return true;
        }

        return false;
    }

    public void seeInternalFunds(Employee employee) {
        if(employee.canSeeInternalFunds()) {
            System.out.println("Internal fund is " + fund + '$');
        } else {
            System.out.println("You don’t have permission for this operation");
        }
    }
}
