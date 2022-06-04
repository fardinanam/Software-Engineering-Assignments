package builders;

import products.Product;

/**
 * Abstract Builder
 */
public interface SystemBuilder {
    void addDisplay() throws Exception;
    void addControlUnit();
    void addCommunicationSystem() throws Exception;
    void addApplication();
    Product getProduct();
}

