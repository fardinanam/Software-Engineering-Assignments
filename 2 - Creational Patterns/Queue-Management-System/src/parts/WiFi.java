package parts;

public class WiFi extends CommunicationSystem {
    public WiFi() {
        price = 40;
        yearlyCost = 15;
    }

    @Override
    public String getDescription() {
        return "WiFi service with WiFi module to communicate with the base station.";
    }
}
