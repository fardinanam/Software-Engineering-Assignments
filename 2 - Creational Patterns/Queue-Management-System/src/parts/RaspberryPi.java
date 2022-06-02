package parts;

public class RaspberryPi extends ControlUnit {
    public RaspberryPi() {
        price = 60;
    }

    @Override
    public String getDescription() {
        return "Raspberry Pi for receiving and processing data from \n" +
                "web-based control unit.";
    }
}
