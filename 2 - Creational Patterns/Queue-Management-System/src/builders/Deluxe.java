package builders;

import factories.CommunicationSystemFactory;
import factories.DisplayFactory;
import factories.ICommunicationSystemFactory;
import factories.IDisplayFactory;
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
    public void addDisplay() throws Exception {
        IDisplayFactory displayFactory = new DisplayFactory();
        product.addAll(displayFactory.getDisplays("LCD", numberOfDisplayUnits));
    }

    @Override
    public void addControlUnit() {
        product.add(new RaspberryPi());
    }

    @Override
    public void addCommunicationSystem() throws Exception {
        ICommunicationSystemFactory communicationSystemFactory = new CommunicationSystemFactory();
        product.add(communicationSystemFactory.getCommunicationSystem(communicationSystemType));
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
