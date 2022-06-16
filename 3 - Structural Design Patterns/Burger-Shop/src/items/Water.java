package items;

public class Water extends Drinks {
    double price;

    public Water() {
        this.price = 20;
    }

    @Override
    public double getPrice() {
        return price;
    }

    @Override
    public String toString() {
        return "items.Water";
    }
}
