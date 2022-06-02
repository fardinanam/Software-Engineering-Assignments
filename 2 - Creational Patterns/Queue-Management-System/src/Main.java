import builders.SystemBuilder;
import factories.ISystemFactory;
import factories.SystemFactory;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) throws Exception {
        Scanner scanner = new Scanner(System.in);
        ISystemFactory systemFactory = new SystemFactory();
        int input;
        String systemType;
        String communicationType;
        int numberOfDisplays;

        System.out.println("Select the communication system of your choice");
        System.out.println("\t1. Deluxe: LCD panel with Raspberry Pi");
        System.out.println("\t2. Optimal: Arduino Mega with LED matrix");
        System.out.println("\t3. Poor: ATMega32 with LED matrix");

        input = scanner.nextInt();
        switch (input) {
            case 1:
                systemType = "DELUXE";
                break;
            case 2:
                systemType = "OPTIMAL";
                break;
            case 3:
                systemType = "POOR";
                break;
            default:
                throw new Exception("Invalid input");
        }

        System.out.println("\nSelect the communication channel type");
        System.out.println("\t1. WiFi");
        System.out.println("\t2. Mobile service");

        input = scanner.nextInt();
        switch (input) {
            case 1:
                communicationType = "WIFI";
                break;
            case 2:
                communicationType = "MOBILE_SERVICE";
                break;
            default:
                throw new Exception("Invalid input");
        }

        System.out.println("\nNumber of displays: ");
        numberOfDisplays = scanner.nextInt();


        SystemBuilder systemBuilder = systemFactory.getSystemBuilder(
                systemType, numberOfDisplays, communicationType);
        systemBuilder.getProduct().show();
    }
}
