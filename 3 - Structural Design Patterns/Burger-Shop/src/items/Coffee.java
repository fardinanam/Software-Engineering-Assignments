package items;

public class Coffee extends Drinks {
    double price;

    public Coffee() {
        this.price = 150;
    }

    @Override
    public double getPrice() {
        return price;
    }

    @Override
    public String toString() {
        return "items.Coffee";
    }
}
