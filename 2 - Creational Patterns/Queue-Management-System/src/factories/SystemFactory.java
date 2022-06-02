package factories;

import builders.Deluxe;
import builders.Optimal;
import builders.Poor;
import builders.SystemBuilder;
import directors.Director;
import factories.ISystemFactory;

/**
 * Concrete Factory Method
 */
public class SystemFactory extends ISystemFactory {
    @Override
    public SystemBuilder getSystemBuilder(String systemBuilderType, int numberOfDisplay, String communicationSystemType) throws Exception {
        Director director = new Director();
        SystemBuilder systemBuilder;

        if (systemBuilderType.equalsIgnoreCase("DELUXE")) {
            systemBuilder = new Deluxe(numberOfDisplay, communicationSystemType);
        } else if (systemBuilderType.equalsIgnoreCase("OPTIMAL")) {
            systemBuilder = new Optimal(numberOfDisplay, communicationSystemType);
        } else if (systemBuilderType.equalsIgnoreCase("POOR")) {
            systemBuilder = new Poor(numberOfDisplay, communicationSystemType);
        } else {
            throw new Exception("Invalid system type");
        }

        director.construct(systemBuilder);
        return systemBuilder;
    }
}
