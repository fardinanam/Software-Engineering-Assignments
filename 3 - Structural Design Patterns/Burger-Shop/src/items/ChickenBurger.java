package items;

public class ChickenBurger implements Item {
    @Override
    public double getPrice() {
        return 300;
    }

    @Override
    public String toString() {
        return "Chicken Burger";
    }
}
