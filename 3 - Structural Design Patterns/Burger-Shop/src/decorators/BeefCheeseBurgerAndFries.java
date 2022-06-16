package decorators;

import items.BeefBurger;
import items.FrenchFries;

public class BeefCheeseBurgerAndFries extends AbstractMealDecorator {
    @Override
    public double getPrice() {
        return super.getPrice();
    }

    public String getItems() {
        super.addItem(new CheeseBurgerDecorator(new BeefBurger()));
        super.addItem(new FrenchFries());

        return this.toString();
    }

    @Override
    public String toString() {
        return super.toString();
    }
}
