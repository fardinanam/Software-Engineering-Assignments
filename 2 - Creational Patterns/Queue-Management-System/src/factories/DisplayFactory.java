package factories;

import parts.LcdDisplay;
import parts.LedDisplay;
import parts.Part;

import java.util.LinkedList;

/**
 * Concrete display factory
 */
public class DisplayFactory extends IDisplayFactory {
    @Override
    public LinkedList<Part> getDisplays(String displayType, int amount) throws Exception {
        LinkedList<Part> displays = new LinkedList<>();

        if(amount <= 0)
            throw new Exception("Invalid number of display");

        for (int i = 0; i < amount; i++) {
            if (displayType.equalsIgnoreCase("LCD"))
                displays.add(new LcdDisplay());
            else if (displayType.equalsIgnoreCase("LED"))
                displays.add(new LedDisplay());
            else throw new Exception(displayType + " is not available");
        }

        return displays;
    }
}
