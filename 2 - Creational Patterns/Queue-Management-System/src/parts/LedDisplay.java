package parts;

public class LedDisplay extends Display {
    public LedDisplay() {
        price = 110;
    }

    @Override
    public String getDescription() {
        return "LED Matrix as display unit.";
    }
}
