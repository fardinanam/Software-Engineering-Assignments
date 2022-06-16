package items;

public class Coke extends Drinks {
    double price;

    public Coke() {
        this.price = 30;
    }

    @Override
    public double getPrice() {
        return price;
    }

    @Override
    public String toString() {
        return "items.Coke";
    }
}
