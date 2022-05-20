package bank;

import employees.Cashier;
import employees.Employee;
import employees.ManagingDirector;
import employees.Officer;

public class Main {
    public static void main(String[] args) {
        Bank bank = Bank.getInstance();

        bank.addEmployee(new ManagingDirector("MD"));
        bank.addEmployee(new Officer("S1"));
        bank.addEmployee(new Officer("S2"));

        for(int i = 1; i <= 5; i++) {
            bank.addEmployee(new Cashier("C" + i));
        }
    }
}
