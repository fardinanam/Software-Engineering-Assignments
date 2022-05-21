package bank;

import accounts.*;
import employees.Cashier;
import employees.Employee;
import employees.ManagingDirector;
import employees.Officer;
import kotlin.Pair;

import java.util.*;

class Bank {
    private static Bank bank = null;
    private final HashSet<Account> accounts;
    private final HashSet<Employee> employees;
    private final Queue<Pair<Account, Double>> loanRequests;
    private double internalFunds;
    private Employee loggedInEmployee;
    private Account loggedInAccount;
    private int elapsedYear;

    private Bank() {
        internalFunds = 1000000;
        accounts = new HashSet<>();
        employees = new HashSet<>();
        loanRequests = new LinkedList<>();
        loggedInEmployee = null;
        loggedInAccount = null;
    }

    public static Bank getInstance() {
        if(bank == null) {
            bank = new Bank();
        }

        return bank;
    }

    public boolean addEmployee(String name, Employee.EmployeeTypes employeeType) {
        Employee employee;

        if(employees.contains(new Officer(name)))
            return false;
        switch (employeeType) {
            case MANAGING_DIRECTOR:
                employee = new ManagingDirector(name);
                break;
            case OFFICER:
                employee = new Officer(name);
                break;
            case CASHIER:
                employee = new Cashier(name);
                break;
            default:
                return false;
        }

        employees.add(employee);
        return true;
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
                internalFunds -= 2 * initialAmount;
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

        internalFunds += initialAmount;
        loggedInAccount = account;
        accounts.add(account);
        return true;
    }

    /**
     * @param name of Employee or Account holder
     * @return Message to the user
     */
    public String login(String name) {
        loggedInAccount = getAccount(name);
        loggedInEmployee = getEmployee(name);
        StringBuilder message = new StringBuilder();

        if(loggedInEmployee != null) {
            message.append(loggedInEmployee.getName()).append(" active");
            if(hasPendingLoanRequests()) {
                message.append(", there are loan approvals pending");
            }
        } else if (loggedInAccount != null) {
            message.append("Welcome back, ").append(loggedInAccount.getName());
        } else {
            return "Invalid Name";
        }

        return message.toString();
    }

    public boolean hasPendingLoanRequests() {
        return !loanRequests.isEmpty();
    }

    /**
     * If there are loan requests in the queue, and an MD or Officer is logged in
     * then loans are approved based on the account types and available fund.
     * @return message on success
     */
    public String approveLoans() {
        StringBuilder message = new StringBuilder();

        if(loggedInEmployee == null) {
            return "Please login to an employee account first";
        }

        if(loanRequests.isEmpty())
            return "Currently there is no loan request";

        while (!loanRequests.isEmpty()) {
            Pair<Account, Double> request = loanRequests.peek();
            Account account = request.getFirst();
            double amount = request.getSecond();

            if(account instanceof LoanAccount && internalFunds - amount < 0) {
                continue;
            }

            if(loggedInEmployee.approveLoan(account, amount)) {
                message.append("Loan for ").append(account.getName()).append(" has been approved\n");
                loanRequests.remove();
            }
        }

        return message.toString();
    }

    public String changeInterestRate(double changingRate, Account.AccountTypes accountType) {
        if(loggedInEmployee == null) {
            return "Please login to an employee account first";
        }

        if(loggedInEmployee.changeInterestRate( changingRate, accountType)) {
            return "Interest rate of " + accountType.toString() + " accounts have been changed to " + changingRate;
        } else {
            return "You don't have permission for this operation";
        }
    }

    public String lookup(String name) {
        if(loggedInEmployee == null) {
            return "Please login to an employee account first";
        }

        Account account = getAccount(name);
        if(account == null) {
            return "There is no account of " + name;
        }

        return name + "'s current balance " + loggedInEmployee.lookUp(account) + '$';
    }

    public String increaseYear() {
        elapsedYear++;
        if(loggedInAccount != null || loggedInEmployee != null) {
            return "Logout first";
        }
        for(Account account : accounts) {
            account.increaseYear();
        }

        return elapsedYear + " year passed";
    }

    private Employee getEmployee(String name) {
        for(Employee employee : employees) {
            if(employee.getName().equals(name))
                return employee;
        }

        return null;
    }

    private Account getAccount(String name) {
        for(Account account : accounts) {
            if(account.getName().equals(name))
                return account;
        }

        return null;
    }

    /**
     * @param amount to be deposited into the logged in account
     * @return Confirmation message of successful or unsuccessful deposit
     */
    public String deposit(double amount) {
        if(loggedInAccount == null) {
            return "Please login to an account first.";
        }
        loggedInAccount.deposit(amount);
        internalFunds += amount;

        return amount + "$ deposited; Current balance " +
                loggedInAccount.getBalance() + '$';
    }

    /**
     * @param amount to be withdrawn
     * @return Confirmation message of successful or unsuccessful withdrawal
     */
    public String withdraw(double amount) {
        StringBuilder message = new StringBuilder();
        if(loggedInAccount == null) {
            message.append("Please login to an account first.");
            return message.toString();
        }

        if(loggedInAccount.withdraw(amount)) {
            internalFunds -= amount;
            message.append(amount).append("$ withdrawn; ");
        } else {
            message.append("Invalid Transaction; ");
        }

        message.append("Current balance ").append(loggedInAccount.getBalance()).append("$");
        return message.toString();
    }

    public String requestLoan(double amount) {
        if(loggedInAccount == null) {
            return "Please login to an account first.";
        }

        if(loggedInAccount.validateLoan(amount)) {
            loanRequests.add(new Pair<>(loggedInAccount, amount));
            return "Loan request successful, sent for approval";
        }

        return "Loan request unsuccessful";
    }

    public String[] getEmployeeNames() {
        int noOfEmployees = employees.size();
        String[] employeeNames = new String[noOfEmployees];

        int i = 0;
        for(Employee employee : employees) {
            employeeNames[i] = employee.getName();
            i++;
        }

        return employeeNames;
    }

    public String seeInternalFunds() {
        if(loggedInEmployee == null) {
            return "Please login to an employee account first";
        }

        if(loggedInEmployee.canSeeInternalFunds()) {
            return "Internal fund is " + internalFunds + '$';
        } else {
            return "You don’t have permission for this operation";
        }
    }

    public void query() {
        if(loggedInAccount == null) {
            System.out.println("Please login to an account first.");
        }

        loggedInAccount.query();
    }

    /**
     * Logs out currently logged in employee or account holder
     * @return message
     */
    public String logout() {
        String message = "Already not logged in";
        if(loggedInAccount != null) {
            message = "Transaction Closed for " + loggedInAccount.getName();
            loggedInAccount = null;
        } else if(loggedInEmployee != null) {
            message = "Operations for " + loggedInEmployee.getName() + " closed";
            loggedInEmployee = null;
        }

        return message;
    }
}
