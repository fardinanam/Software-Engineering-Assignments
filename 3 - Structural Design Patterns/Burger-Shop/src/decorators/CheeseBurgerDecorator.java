package decorators;

import items.Burger;

public class CheeseBurgerDecorator extends Burger {
    private Burger burger;
    private double price;

    public CheeseBurgerDecorator(Burger burger) {
        this.burger = burger;
        price = 50 + this.burger.getPrice();
    }

    @Override
    public double getPrice() {
        return price;
    }

    @Override
    public String toString() {
        return burger + " with cheese";
    }
}
