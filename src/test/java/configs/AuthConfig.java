package configs;

import org.aeonbits.owner.Config;

@Config.Sources({
        "classpath:auth.properties"
})

public interface AuthConfig extends Config {

    @Key("user")
    String getUser();

    @Key("key")
    String getKey();

    @Key("remoteUrl")
    @DefaultValue("https://hub.browserstack.com/wd/hub")
    String getRemoteUrl();

}