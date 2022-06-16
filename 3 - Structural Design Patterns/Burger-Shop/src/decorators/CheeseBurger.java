package decorators;

import items.Item;

public class CheeseBurger extends ItemDecorator {
    public CheeseBurger(Item item) {
        super(item);
    }

    @Override
    public double getPrice() {
        return super.getPrice() + 50;
    }

    @Override
    public String toString() {
        return super.toString() + " with cheese";
    }
}
