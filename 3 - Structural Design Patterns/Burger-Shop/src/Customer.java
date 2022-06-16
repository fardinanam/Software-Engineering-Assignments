import decorators.*;
import items.BeefBurger;
import items.VeggiBurger;

import java.util.Scanner;

public class Customer {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.println("\t=========================== Food Menu ===========================\n");
        System.out.println("\t1. Beef burger with French fry and cheese");
        System.out.println("\t2. Veggi burger with onion rings and Bottle of Water");
        System.out.println("\t3. A combo meal with Veggi burger, French Fry and Coke");
        System.out.println("\t4. A combo meal with Veggi burger, Onion Rings, Coffee and Water");
        System.out.println("\t5. A Beef burger only\n");

        int option;

        while (scanner.hasNextInt()) {
            option = scanner.nextInt();

            switch (option) {
                case 1:
                    BeefBurger beefBurger = new BeefBurger();
                    CheeseBurger cheeseBurger = new CheeseBurger(beefBurger);
                    FrenchFries fries = new FrenchFries(cheeseBurger);

                    System.out.println(fries + "\t\tPrice: " + fries.getPrice() + " taka");
                    break;
                case 2:
                    VeggiBurger veggiBurger = new VeggiBurger();
                    OnionRings onionRings = new OnionRings(veggiBurger);
                    Water water = new Water(onionRings);

                    System.out.println(water + "\t\tPrice: " + water.getPrice() + " taka");
                    break;
                case 3:
                    VeggiBurger veggiBurger2 = new VeggiBurger();
                    FrenchFries fries2 = new FrenchFries(veggiBurger2);
                    Coke coke = new Coke(fries2);

                    System.out.println(coke + "\t\tPrice: " + coke.getPrice() + " taka");
                    break;
                case 4:
                    VeggiBurger veggiBurger3 = new VeggiBurger();
                    OnionRings onionRings2 = new OnionRings(veggiBurger3);
                    Coffee coffee = new Coffee(onionRings2);
                    Water water2 = new Water(coffee);

                    System.out.println(water2 + "\t\tPrice: " + water2.getPrice() + " taka");
                    break;
                case 5:
                    BeefBurger beefBurger2 = new BeefBurger();
                    System.out.println(beefBurger2 + "\t\tPrice: " + beefBurger2.getPrice() + " taka");
                    break;
                default:
                    System.out.println("Invalid input");
            }
        }
    }
}
