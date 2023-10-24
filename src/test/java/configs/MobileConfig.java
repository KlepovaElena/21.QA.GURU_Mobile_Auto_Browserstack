package configs;

import org.aeonbits.owner.Config;

@Config.Sources({
        "classpath:${env}.properties"
})
public interface MobileConfig extends Config {

    @Key("appUrl")
    @DefaultValue("bs://sample.app")
    String getApp();

    @Key("device")
    @DefaultValue("Samsung Galaxy S22 Ultra")
    String getDevice();

    @Key("os_version")
    @DefaultValue("12.0")
    String getOsVersion();
}