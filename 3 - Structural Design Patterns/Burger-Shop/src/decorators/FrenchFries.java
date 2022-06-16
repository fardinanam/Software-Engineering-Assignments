package decorators;

import items.Item;

public class FrenchFries extends  ItemDecorator {
    public FrenchFries(Item item) {
        super(item);
    }

    @Override
    public double getPrice() {
        return super.getPrice() + 70;
    }

    @Override
    public String toString() {
        return super.toString() + ", French fries";
    }
}
