package parts;

public class ATMega32 extends ControlUnit {
    public ATMega32() {
        price = 50;
    }

    @Override
    public String getDescription() {
        return "ATMega32 for receiving and processing data from \n" +
                "web-based control unit.";
    }
}
