package products;

import parts.CommunicationSystem;
import parts.Part;

import java.util.LinkedList;

public class Product {
    private int totalCost;
    private int yearlyCost;
    private final LinkedList<Part> parts;

    public Product() {
        yearlyCost = 0;
        totalCost = 0;
        parts = new LinkedList<>();
    }

    public void add(Part part) {
        parts.add(part);
        totalCost += part.getPrice();

        if(part instanceof CommunicationSystem)
            yearlyCost += ((CommunicationSystem) part).getYearlyCost();
    }

    public void addAll(LinkedList<Part> parts) {
        for(Part part : parts) {
            add(part);
        }
    }

    public void show() {
        System.out.println("\nOrder is ready as follows:");

        for(int i = 0; i < parts.size(); i++) {
            Part part = parts.get(i);
            System.out.println(i + 1 + ". " + part.getDescription() +
                    "\tPrice: " + part.getPrice() + "$");
            if (part instanceof CommunicationSystem)
                System.out.println("\t\t\t\tYearly cost: " + ((CommunicationSystem) part).getYearlyCost() + "$");
        }

        System.out.println("-----------------------------------------");
        System.out.println("Total price:\t" + totalCost + "$");
        System.out.println("Total yearly cost:\t" + yearlyCost + "$");
    }
}
