package bank;

import accounts.Account;
import employees.Employee;

import java.util.ArrayList;
import java.util.HashSet;

class Bank {
    private static Bank bank = null;
    private HashSet<Account> accounts;
    private ArrayList<Employee> employees;
    private double fund;

    private Bank() {
        fund = 1000000;
        accounts = new HashSet<>();
        employees = new ArrayList<>();
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

    public void addAccount(Account account) {
        if(accounts.contains(account)) {
            System.out.println("You already have an account");
            return;
        }

        accounts.add(account);
    }
}
