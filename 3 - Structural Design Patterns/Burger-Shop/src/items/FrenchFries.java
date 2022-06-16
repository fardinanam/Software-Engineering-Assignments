package items;

public class FrenchFries extends Appetizer {
    double price;

    public FrenchFries() {
        price = 70;
    }

    @Override
    public double getPrice() {
        return price;
    }

    @Override
    public String toString() {
        return "French Fries";
    }
}
