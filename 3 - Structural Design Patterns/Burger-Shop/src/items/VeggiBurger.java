package items;

public class VeggiBurger implements Item {
    @Override
    public double getPrice() {
        return 250;
    }

    @Override
    public String toString() {
        return "Veggi Burger";
    }
}
