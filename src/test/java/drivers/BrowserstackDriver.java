package drivers;

import com.codeborne.selenide.WebDriverProvider;
import configs.ConfigReader;
import configs.MobileConfig;
import org.aeonbits.owner.ConfigFactory;
import org.openqa.selenium.Capabilities;
import org.openqa.selenium.MutableCapabilities;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.remote.RemoteWebDriver;

import javax.annotation.Nonnull;
import java.net.MalformedURLException;
import java.net.URL;

import configs.AuthConfig;

public class BrowserstackDriver implements WebDriverProvider {

    @Nonnull
    @Override
    public WebDriver createDriver(@Nonnull Capabilities capabilities) {

        AuthConfig authConfig = ConfigReader.Instance.getAuthConfig();
        MobileConfig mobileConfig = ConfigReader.Instance.getMobileConfig();

        MutableCapabilities mutableCapabilities = new MutableCapabilities();


        // Set your access credentials
        mutableCapabilities.setCapability("browserstack.user", authConfig.getUser());
        mutableCapabilities.setCapability("browserstack.key", authConfig.getKey());

        // Set URL of the application under test
        mutableCapabilities.setCapability("app", mobileConfig.getApp());

        // Specify device and os_version for testing
        mutableCapabilities.setCapability("device", mobileConfig.getDevice());
        mutableCapabilities.setCapability("os_version", mobileConfig.getOsVersion());

        // Set other BrowserStack capabilities
        mutableCapabilities.setCapability("project", "First Java Project");
        mutableCapabilities.setCapability("build", "browserstack-build-1");
        mutableCapabilities.setCapability("name", "first_test");

        // Initialise the remote Webdriver using BrowserStack remote URL
        // and desired capabilities defined above
        try {
            return new RemoteWebDriver(
                    new URL(authConfig.getRemoteUrl()), mutableCapabilities);
        } catch (MalformedURLException e) {
            throw new RuntimeException(e);
        }
    }
}