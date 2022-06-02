package parts;

public class Arduino extends ControlUnit {
    public Arduino() {
        price = 55;
    }

    @Override
    public String getDescription() {
        return "Arduino for receiving and processing data from \n" +
                "web-based control unit.";
    }
}
