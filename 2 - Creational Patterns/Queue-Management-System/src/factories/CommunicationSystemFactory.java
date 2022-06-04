package factories;

import parts.CommunicationSystem;
import parts.MobileService;
import parts.WiFi;

/**
 * Concrete communication system factory
 */
public class CommunicationSystemFactory extends ICommunicationSystemFactory {
    @Override
    public CommunicationSystem getCommunicationSystem(String communicationSystemType) throws Exception {
        if (communicationSystemType.equalsIgnoreCase("WIFI"))
            return new WiFi();
        else if (communicationSystemType.equalsIgnoreCase("MOBILE_SERVICE"))
            return new MobileService();
        else
            throw new Exception(communicationSystemType + " is not available");
    }
}
