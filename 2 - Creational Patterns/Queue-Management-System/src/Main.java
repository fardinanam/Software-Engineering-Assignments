import builders.SystemBuilder;
import factories.ISystemFactory;
import factories.SystemFactory;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        ISystemFactory systemFactory = new SystemFactory();
        int input;
        String systemType = "";
        String communicationType = "";
        int numberOfDisplays = -1;

        System.out.println("Select the communication system of your choice");
        System.out.println("\t1. Deluxe: LCD panel with Raspberry Pi");
        System.out.println("\t2. Optimal: Arduino Mega with LED matrix");
        System.out.println("\t3. Poor: ATMega32 with LED matrix");


        while (scanner.hasNextInt()) {
            input = scanner.nextInt();

            if(input == 1) {
                systemType = "DELUXE";
                break;
            } else if (input == 2) {
                systemType = "OPTIMAL";
                break;
            } else if (input == 3) {
                systemType = "POOR";
                break;
            } else {
                System.out.println("Invalid input. Please select 1, 2 or 3");
            }
        }

        System.out.println("\nSelect the communication channel type");
        System.out.println("\t1. WiFi");
        System.out.println("\t2. Mobile service");

        while (scanner.hasNextInt()) {
            input = scanner.nextInt();

            if(input == 1) {
                communicationType = "WIFI";
                break;
            } else if (input == 2) {
                communicationType = "MOBILE_SERVICE";
                break;
            } else {
                System.out.println("Invalid input. Please select 1 or 2");
            }
        }

        System.out.println("\nNumber of displays: ");

        while (scanner.hasNextInt()) {
            numberOfDisplays = scanner.nextInt();
            if(numberOfDisplays <= 0)
                System.out.println("Invalid input. Please input a number greater than 0");
            else break;
        }


        SystemBuilder systemBuilder;
        try {
            systemBuilder = systemFactory.getSystemBuilder(systemType, numberOfDisplays, communicationType);
            systemBuilder.getProduct().show();
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
    }
}
