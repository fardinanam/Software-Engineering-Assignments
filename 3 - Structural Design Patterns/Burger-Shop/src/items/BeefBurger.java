package items;

public class BeefBurger extends Burger {
    private double price;

    public BeefBurger() {
        price = 350;
    }

    @Override
    public double getPrice() {
        return price;
    }

    @Override
    public String toString() {
        return "Beef items.Burger";
    }
}
