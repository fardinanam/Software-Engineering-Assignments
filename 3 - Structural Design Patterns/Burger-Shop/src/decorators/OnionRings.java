package decorators;

import items.Item;

public class OnionRings extends ItemDecorator {
    public OnionRings(Item item) {
        super(item);
    }

    @Override
    public double getPrice() {
        return super.getPrice() + 80;
    }

    @Override
    public String toString() {
        return super.toString() + ", Onion rings";
    }
}
