package factories;

import parts.LcdDisplay;
import parts.LedDisplay;
import parts.Part;

import java.util.LinkedList;

/**
 * Abstract display factory
 */
public abstract class IDisplayFactory {
    public abstract LinkedList<Part> getDisplays(String displayType, int amount) throws Exception;
}

