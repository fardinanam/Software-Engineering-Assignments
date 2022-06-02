package parts;

public abstract class Display implements Part {

    protected int price;

    @Override
    public int getPrice() {
        return price;
    }
}