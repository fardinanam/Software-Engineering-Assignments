package parts;

public abstract class CommunicationSystem implements Part {
    public enum Types {
        WIFI, MOBILE_SERVICE
    }
    protected int price;
    protected int yearlyCost;

    @Override
    public int getPrice() {
        return price;
    }

    public int getYearlyCost() {
        return yearlyCost;
    }
}

