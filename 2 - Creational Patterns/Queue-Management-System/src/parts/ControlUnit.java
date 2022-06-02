package parts;

public abstract class ControlUnit implements Part{
    protected int price;

    @Override
    public int getPrice() {
        return price;
    }
}

