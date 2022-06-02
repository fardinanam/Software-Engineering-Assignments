package parts;

public class Application implements Part {
    private int price;

    public Application() {
        price = 100;
    }

    @Override
    public int getPrice() {
        return price;
    }

    @Override
    public String getDescription() {
        return "Web based controller application. " +
                "Controls the display units over the Internet.";
    }
}
