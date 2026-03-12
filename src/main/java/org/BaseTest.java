package org;

import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.android.options.UiAutomator2Options;
import org.junit.jupiter.api.AfterEach;
import java.net.MalformedURLException;
import java.net.URL;
import java.time.Duration;

public class BaseTest {
    protected AndroidDriver driver;

    // פונקציה כללית שכל טסט יקרא לה עם הנתונים שלו
    public void setUp(String appPackage, String appActivity) throws MalformedURLException {
        UiAutomator2Options options = new UiAutomator2Options();
        options.setDeviceName("emulator-5554");
        options.setAutomationName("UiAutomator2");
        options.setPlatformName("Android");
        options.setPlatformVersion("9.0"); // ודאי שזה תואם לאמולטור שלך

        options.setAppPackage(appPackage);
        options.setAppActivity(appActivity);

        options.setNoReset(true);
        options.setNewCommandTimeout(Duration.ofSeconds(150));

        driver = new AndroidDriver(new URL("http://127.0.0.1:4723"), options);
    }

    @AfterEach
    public void tearDown() {
        if (driver != null) {
            driver.quit();
        }
    }
}