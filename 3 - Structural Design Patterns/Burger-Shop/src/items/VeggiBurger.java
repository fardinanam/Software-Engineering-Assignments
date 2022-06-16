package items;

public class VeggiBurger extends Burger {
    private double price;

    public VeggiBurger() {
        price = 250;
    }

    @Override
    public double getPrice() {
        return price;
    }

    @Override
    public String toString() {
        return "Veggi items.Burger";
    }
}
