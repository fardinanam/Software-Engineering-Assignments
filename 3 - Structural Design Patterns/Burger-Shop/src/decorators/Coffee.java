package decorators;

import items.Item;

public class Coffee extends ItemDecorator {
    public Coffee(Item item) {
        super(item);
    }

    @Override
    public double getPrice() {
        return super.getPrice() + 150;
    }

    @Override
    public String toString() {
        return super.toString() + ", coffee";
    }
}
