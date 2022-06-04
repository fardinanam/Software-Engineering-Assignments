package factories;

import parts.CommunicationSystem;
import parts.MobileService;
import parts.WiFi;

/**
 * Abstract communication system factory
 */
public abstract class ICommunicationSystemFactory {
    public abstract CommunicationSystem getCommunicationSystem(String communicationSystemType) throws Exception;
}

