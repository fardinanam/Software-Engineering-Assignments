package decorators;

import items.Item;

public class Water extends ItemDecorator {
    public Water(Item item) {
        super(item);
    }

    @Override
    public double getPrice() {
        return super.getPrice() + 20;
    }

    @Override
    public String toString() {
        return super.toString() + ", water";
    }
}
