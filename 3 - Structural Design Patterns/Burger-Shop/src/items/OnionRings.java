package items;

public class OnionRings extends Appetizer {
    double price;

    public OnionRings() {
        price = 100;
    }

    @Override
    public double getPrice() {
        return price;
    }

    @Override
    public String toString() {
        return "Onion Rings";
    }
}
