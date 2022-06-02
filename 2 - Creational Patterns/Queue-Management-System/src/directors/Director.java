package directors;

import builders.SystemBuilder;

public class Director {
    private SystemBuilder systemBuilder;

    public void construct(SystemBuilder systemBuilder) {
        this.systemBuilder = systemBuilder;
        this.systemBuilder.addDisplay();
        this.systemBuilder.addControlUnit();
        this.systemBuilder.addCommunicationSystem();
        this.systemBuilder.addApplication();
    }
}
