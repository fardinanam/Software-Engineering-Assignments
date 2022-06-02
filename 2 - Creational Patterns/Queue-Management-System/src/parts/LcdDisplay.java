package parts;

public class LcdDisplay extends Display {
    public LcdDisplay() {
        price = 100;
    }

    @Override
    public String getDescription() {
        return "LCD display as display unit.";
    }
}
