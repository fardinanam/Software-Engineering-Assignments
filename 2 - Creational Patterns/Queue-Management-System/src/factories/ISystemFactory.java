package factories;

import builders.SystemBuilder;

/**
 * Abstract Factory Method
 */
public abstract class ISystemFactory {
    public abstract SystemBuilder getSystemBuilder(String systemBuilderType,
           int numberOfDisplay, String communicationSystemType) throws Exception;
}

