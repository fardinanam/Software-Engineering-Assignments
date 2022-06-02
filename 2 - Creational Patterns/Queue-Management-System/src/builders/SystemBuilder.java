package builders;

import products.Product;

/**
 * Abstract Builder
 */
public interface SystemBuilder {
    void addDisplay();
    void addControlUnit();
    void addCommunicationSystem();
    void addApplication();
    Product getProduct();
}

