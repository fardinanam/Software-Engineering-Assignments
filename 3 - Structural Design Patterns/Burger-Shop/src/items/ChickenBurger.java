package items;

public class ChickenBurger extends Burger {
    private double price;

    public ChickenBurger() {
        price = 250;
    }

    @Override
    public double getPrice() {
        return price;
    }

    @Override
    public String toString() {
        return "Chicken items.Burger";
    }
}
