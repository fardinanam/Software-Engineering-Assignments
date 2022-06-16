package decorators;

import items.Item;

import java.util.ArrayList;
import java.util.List;

public abstract class AbstractMealDecorator implements Item {
    protected List<Item> items;

    public AbstractMealDecorator() {
        items = new ArrayList<>();
    }

    public void addItem(Item item) {
        items.add(item);
    }

    @Override
    public double getPrice() {
        int totalPrice = 0;

        for (Item item : items)
            totalPrice += item.getPrice();

        return totalPrice;
    }

    @Override
    public String toString() {
        StringBuilder meal = new StringBuilder();

        for (int i = 0; i < items.size(); i++)
            meal.append(i + 1).append(". ").append(items.get(i)).append("\n");

        return null;
    }
}

