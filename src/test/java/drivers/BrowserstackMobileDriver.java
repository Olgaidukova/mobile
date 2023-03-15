package drivers;

import com.codeborne.selenide.WebDriverProvider;
import org.openqa.selenium.Capabilities;
import org.openqa.selenium.MutableCapabilities;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.remote.RemoteWebDriver;

import javax.annotation.Nonnull;
import java.net.MalformedURLException;
import java.net.URL;

public class BrowserstackMobileDriver implements WebDriverProvider {

    @Nonnull
    @Override
    public WebDriver createDriver(@Nonnull Capabilities capabilities) {
        MutableCapabilities mutableCapabilities = new MutableCapabilities();
        mutableCapabilities.merge(capabilities);

        // Set your access credentials
        mutableCapabilities.setCapability("browserstack.user", "olga360");
        mutableCapabilities.setCapability("browserstack.key", "uiqXywsX6pYNgxHMUHji");

        // Set URL of the application under test
//        mutableCapabilities.setCapability("app", "bs://c700ce60cf13ae8ed97705a55b8e022f13c5827c");
        mutableCapabilities.setCapability("app", "bs://f7c874f21852ba57957a3fdc33f47514288c4ba4");
        /*            //caps.AddAdditionalCapability("id", "me.amitburst.HackerNewsiOS");
            caps.AddAdditionalCapability("app", "bs://444bd0308813ae0dc236f8cd461c02d3afa7901d"); */
        // Specify device and os_version for testing
//        mutableCapabilities.setCapability("device", "Google Pixel 3");
//        mutableCapabilities.setCapability("os_version", "9.0");

        mutableCapabilities.setCapability("device", "iPhone 13 Pro");
        mutableCapabilities.setCapability("os_version", "15.6");

        // Set other BrowserStack mutableCapabilities
        mutableCapabilities.setCapability("project", "First Java Project");
        mutableCapabilities.setCapability("build", "browserstack-build-1");
        mutableCapabilities.setCapability("name", "first_test");


        // Initialise the remote Webdriver using BrowserStack remote URL
        // and desired mutableCapabilities defined above
        try {
            return new RemoteWebDriver(
                    new URL("http://hub.browserstack.com/wd/hub"), mutableCapabilities);
        } catch (MalformedURLException e) {
            throw new RuntimeException(e);
        }
    }
}
