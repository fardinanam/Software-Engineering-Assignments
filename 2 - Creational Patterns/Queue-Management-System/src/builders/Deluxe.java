package builders;

import parts.*;
import products.Product;

/**
 * Concrete Builder
 */
public class Deluxe implements SystemBuilder {
    private final int numberOfDisplayUnits;
    private final String communicationSystemType;
    private final Product product;

    public Deluxe(int numberOfDisplayUnits, String communicationSystemType) {
        product = new Product();
        this.numberOfDisplayUnits = numberOfDisplayUnits;
        this.communicationSystemType = communicationSystemType;
    }

    @Override
    public void addDisplay() {
        for (int i = 0; i < numberOfDisplayUnits; i++) {
            product.add(new LcdDisplay());
        }
    }

    @Override
    public void addControlUnit() {
        product.add(new RaspberryPi());
    }

    @Override
    public void addCommunicationSystem() {
        if (communicationSystemType.equalsIgnoreCase("WIFI"))
            product.add(new WiFi());
        else if (communicationSystemType.equalsIgnoreCase("MOBILE_SERVICE"))
            product.add(new MobileService());
    }

    @Override
    public void addApplication() {
        product.add(new Application());
    }

    @Override
    public Product getProduct() {
        return product;
    }
}
