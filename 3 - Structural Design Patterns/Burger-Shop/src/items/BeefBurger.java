package items;

public class BeefBurger implements Item {
    @Override
    public double getPrice() {
        return 350;
    }

    @Override
    public String toString() {
        return "Beef Burger";
    }
}
