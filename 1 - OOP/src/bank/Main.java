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

        bank.addEmployee("MD", Employee.EmployeeTypes.MANAGING_DIRECTOR);
        bank.addEmployee("S1", Employee.EmployeeTypes.OFFICER);
        bank.addEmployee("S2", Employee.EmployeeTypes.OFFICER);

        for(int i = 1; i <= 5; i++) {
            bank.addEmployee("C" + i, Employee.EmployeeTypes.CASHIER);
        }

        String[] employeeNames = bank.getEmployeeNames();
        for(String name : employeeNames) {
            System.out.print(name + ',');
        }

        System.out.print(" created\n");

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
                }
            } else if (request.equals("open") && command.length == 2) {
                String name = command[1];
                System.out.println(bank.login(name));
            } else if (request.equals("deposit") && command.length == 2) {
                double depositAmount;

                try {
                    depositAmount = Double.parseDouble(command[1]);
                } catch (NumberFormatException e) {
                    System.out.println("Invalid Deposit Amount");
                    continue;
                }

                System.out.println(bank.deposit(depositAmount));
            } else if (request.equals("withdraw") && command.length == 2) {
                double withdrawalAmount;

                try {
                    withdrawalAmount = Double.parseDouble(command[1]);
                } catch (NumberFormatException e) {
                    System.out.println("Invalid withdrawal Amount");
                    continue;
                }

                System.out.println(bank.withdraw(withdrawalAmount));
            } else if (request.equals("request") && command.length == 2) {
                double loanAmount;

                try {
                    loanAmount = Double.parseDouble(command[1]);
                } catch (NumberFormatException e) {
                    System.out.println("Invalid Loan Amount");
                    continue;
                }

                System.out.println(bank.requestLoan(loanAmount));
            } else if (request.equals("approve") && command.length == 2 &&
                    command[1].equalsIgnoreCase("loan")) {

                System.out.println(bank.approveLoans());
            } else if (request.equals("change") && command.length == 3) {
                Account.AccountTypes accountType = Account.AccountTypes.valueOf(command[1].toUpperCase());
                double changedRate;

                try {
                    changedRate = Double.parseDouble(command[2]);
                } catch (NumberFormatException e) {
                    System.out.println("Invalid changed Loan Amount");
                    continue;
                }

                System.out.println(bank.changeInterestRate(changedRate, accountType));
            } else if (request.equals("lookup") && command.length == 2) {
                String name = command[1];
                System.out.println(bank.lookup(name));
            } else if (request.equals("see") && command.length == 1) {
                System.out.println(bank.seeInternalFunds());
            } else if (request.equals("query") && command.length == 1) {
                bank.query();
            } else if (request.equals("inc") && command.length == 1) {
                System.out.println(bank.increaseYear());
            } else if (request.equals("close") && command.length == 1) {
                System.out.println(bank.logout());
            } else {
                System.out.println("Invalid Input");
            }
        }
    }
}
