package bank;

import accounts.Account;
import employees.Cashier;
import employees.Employee;
import employees.ManagingDirector;
import employees.Officer;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        Bank bank = Bank.getInstance();
        System.out.print("Bank Created; ");

        bank.addEmployee(new ManagingDirector("MD"));
        bank.addEmployee(new Officer("S1"));
        bank.addEmployee(new Officer("S2"));

        for(int i = 1; i <= 5; i++) {
            bank.addEmployee(new Cashier("C" + i));
        }

        HashSet<Employee> employees = bank.getEmployees();
        for(Employee e : employees) {
            System.out.print(e.getName() + ',');
        }

        System.out.print(" created\n");

        Account currentAccount = null;
        Employee currentEmployee = null;
        boolean hasPendingLoans = false;

        while(true) {
            String input = scanner.nextLine();
            String[] command = input.split(" ");
            String request = command[0].toLowerCase();

            if(request.equals("create") && command.length == 4) {
                String name = command[1];
                Account.AccountTypes accountType;
                double initialAmount;

                try {
                    accountType = Account.AccountTypes.valueOf(command[2].toUpperCase());
                    initialAmount = Double.parseDouble(command[3]);
                } catch (NumberFormatException e) {
                    System.out.println("Invalid Amount");
                    continue;
                } catch (IllegalArgumentException e) {
                    System.out.println("Invalid Account type name");
                    continue;
                }

                if(bank.createAccount(name, accountType, initialAmount)) {
                    System.out.println(accountType + " account for " + name + " Created; " +
                            "Initial balance " + initialAmount + '$');
                    currentAccount = bank.getAccount(name);
                }
            } else if (request.equals("open") && command.length == 2) {
                String name = command[1];
                currentAccount = bank.getAccount(name);
                currentEmployee = bank.getEmployee(name);

                if(currentEmployee != null) {
                    System.out.print(currentEmployee.getName() + " active");
                    hasPendingLoans = bank.hasPendingLoanRequests();
                    if(hasPendingLoans) {
                        System.out.print(", there are loan approvals pending\n");
                    }
                } else if (currentAccount != null) {
                    System.out.println("Welcome back, " + currentAccount.getName());
                }
            } else if (request.equals("deposit") && command.length == 2) {
                if(currentAccount == null) {
                    System.out.println("Please login to an account first.");
                    continue;
                }

                double depositAmount;

                try {
                    depositAmount = Double.parseDouble(command[1]);
                } catch (NumberFormatException e) {
                    System.out.println("Invalid Deposit Amount");
                    continue;
                }

                bank.deposit(currentAccount, depositAmount);
                System.out.println(depositAmount + "$ deposited; Current balance " +
                        currentAccount.getBalance() + '$');
            } else if (request.equals("withdraw") && command.length == 2) {
                if(currentAccount == null) {
                    System.out.println("Please login to an account first.");
                    continue;
                }

                double withdrawalAmount;

                try {
                    withdrawalAmount = Double.parseDouble(command[1]);
                } catch (NumberFormatException e) {
                    System.out.println("Invalid withdrawal Amount");
                    continue;
                }

                if(bank.withdraw(currentAccount, withdrawalAmount)) {
                    System.out.print(withdrawalAmount + "$ withdrawn; ");
                } else {
                    System.out.print("Invalid Transaction; ");
                }

                System.out.print("Current balance " + currentAccount.getBalance() + "$\n");
            } else if (request.equals("request") && command.length == 2) {
                if(currentAccount == null) {
                    System.out.println("Please login to an account first.");
                    continue;
                }

                double loanAmount;

                try {
                    loanAmount = Double.parseDouble(command[1]);
                } catch (NumberFormatException e) {
                    System.out.println("Invalid Loan Amount");
                    continue;
                }

                if(bank.requestLoan(currentAccount, loanAmount)) {
                    System.out.println("Loan request successful, sent for approval");
                } else {
                    System.out.println("Loan request unsuccessful");
                }
            } else if (request.equals("approve") && command.length == 2 &&
                    command[1].equalsIgnoreCase("loan")) {
                if(currentEmployee == null) {
                    System.out.println("Please login to an employee account first");
                    continue;
                }

                ArrayList<Account> approvedLoanAccounts = bank.approveLoans(currentEmployee);
                hasPendingLoans = bank.hasPendingLoanRequests();
                for(Account account : approvedLoanAccounts) {
                    System.out.println("Loan for " + account.getName() + " has been approved");
                }
            } else if (request.equals("change") && command.length == 3) {
                if(currentEmployee == null) {
                    System.out.println("Please login to an employee account first");
                    continue;
                }

                Account.AccountTypes accountType = Account.AccountTypes.valueOf(command[1].toUpperCase());
                double changedRate;

                try {
                    changedRate = Double.parseDouble(command[2]);
                } catch (NumberFormatException e) {
                    System.out.println("Invalid changed Loan Amount");
                    continue;
                }

                currentEmployee.changeInterestRate(changedRate, accountType);
            } else if (request.equals("lookup") && command.length == 2) {
                if(currentEmployee == null) {
                    System.out.println("Please login to an employee account first");
                    continue;
                }

                String name = command[1];
                Account account = bank.getAccount(name);
                if(account == null) {
                    System.out.println("There is no account of " + name);
                    continue;
                }

                System.out.println(name + "'s current balance " + currentEmployee.lookUp(account) + '$');
            } else if (request.equals("see") && command.length == 1) {
                if(currentEmployee == null) {
                    System.out.println("Please login to an employee account first");
                    continue;
                }

                bank.seeInternalFunds(currentEmployee);
            } else if (request.equals("query") && command.length == 1) {
                if(currentAccount == null) {
                    System.out.println("Please login to an account first.");
                    continue;
                }

                currentAccount.query();
            } else if (request.equals("inc") && command.length == 1) {
                if(currentAccount != null || currentEmployee != null) {
                    System.out.println("Logout first");
                    continue;
                }
                bank.increaseYear();
            } else if (request.equals("close") && command.length == 1) {
                if(currentAccount != null) {
                    System.out.println("Transaction Closed for " + currentAccount.getName());
                    currentAccount = null;
                } else if(currentEmployee != null) {
                    System.out.println("Operations for " + currentEmployee.getName() + " closed");
                    currentEmployee = null;
                    hasPendingLoans = false;
                }
            } else {
                System.out.println("Invalid Input");
            }
        }
    }
}
