package parts;

public class MobileService extends CommunicationSystem {
    public MobileService() {
        price = 30;
        yearlyCost = 25;
    }

    @Override
    public String getDescription() {
        return "Mobile Data with SIM card for communicating.";
    }
}
