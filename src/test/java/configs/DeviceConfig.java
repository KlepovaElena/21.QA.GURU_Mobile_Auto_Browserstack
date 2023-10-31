package configs;

import org.aeonbits.owner.Config;

@Config.Sources({"classpath:${platform}.properties"})

public interface DeviceConfig extends Config {

    @Key("device")
    @DefaultValue("Google Pixel 3")
    String getDeviceName();

    @Key("osVersion")
    @DefaultValue("9.0")
    String getOsVersion();
}