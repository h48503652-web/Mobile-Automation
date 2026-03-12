import io.appium.java_client.AppiumBy;
import io.appium.java_client.android.AndroidDriver;
import org.openqa.selenium.By;

public class ClockPage {
    AndroidDriver driver;

    // קונסטרקטור
    public ClockPage(AndroidDriver driver) {
        this.driver = driver;
    }

    // מזהים (Locators) - ייתכן ותצטרכי לעדכן אותם אחרי הרצה באינספקטור
    By timerTab = AppiumBy.accessibilityId("Timer");
    By digitOne = AppiumBy.id("com.google.android.deskclock:id/timer_setup_digit_1");
    By digitZero = AppiumBy.id("com.google.android.deskclock:id/timer_setup_digit_0");
    By startButton = AppiumBy.id("com.google.android.deskclock:id/fab");
    By displayArea = AppiumBy.id("com.google.android.deskclock:id/timer_setup_digit_display");

    public void goToTimer() {
        driver.findElement(timerTab).click();
    }

    public void enterTime10Seconds() {
        driver.findElement(digitOne).click();
        driver.findElement(digitZero).click();
        driver.findElement(digitZero).click();
    }

    public String getDisplayText() {
        return driver.findElement(displayArea).getText();
    }

    public void startTimer() {
        driver.findElement(startButton).click();
    }
}
