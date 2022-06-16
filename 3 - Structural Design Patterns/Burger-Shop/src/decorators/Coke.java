package decorators;

import items.Item;

public class Coke extends ItemDecorator {
    public Coke(Item item) {
        super(item);
    }

    @Override
    public double getPrice() {
        return super.getPrice() + 30;
    }

    @Override
    public String toString() {
        return super.toString() + ", coke";
    }
}
