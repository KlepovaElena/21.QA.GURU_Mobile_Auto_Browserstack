package configs;

import org.aeonbits.owner.Config;

@Config.Sources({"classpath:credentials.properties"})

public interface AuthConfig extends Config {

    @Key("user")
    String getUser();

    @Key("key")
    String getKey();

    @Key("url")
    @DefaultValue("https://hub.browserstack.com/wd/hub")
    String getURL();
}