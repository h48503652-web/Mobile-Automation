

import io.appium.java_client.AppiumBy;
import org.BaseTest;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.Assertions;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.net.MalformedURLException;
import java.time.Duration;

public class SettingsTest extends BaseTest {

    @BeforeEach
    public void init() throws MalformedURLException {
        setUp("com.android.settings", "com.android.settings.Settings");
    }

    @Test
    public void testSettingsTask() {
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(15));

        // שלב א': לחיצה על System
        driver.findElement(AppiumBy.androidUIAutomator(
                "new UiScrollable(new UiSelector().scrollable(true)).scrollIntoView("
                        + "new UiSelector().text(\"System\"))")).click();

        System.out.println("נכנסנו לתפריט System.");

        // שלב ב': חזרה אחורה לתפריט הראשי
        driver.navigate().back();
        System.out.println("חוזרים למסך ההגדרות הראשי...");

        // שלב ג': חיפוש וכניסה ל- About
        WebElement aboutButton = wait.until(ExpectedConditions.presenceOfElementLocated(
                AppiumBy.androidUIAutomator("new UiScrollable(new UiSelector().scrollable(true)).scrollIntoView("
                        + "new UiSelector().textContains(\"About\"))")));

        aboutButton.click();
        System.out.println("נכנסנו ל-About Device.");

        // שלב ד': אימות סופי
        WebElement aboutHeader = wait.until(ExpectedConditions.visibilityOfElementLocated(
                AppiumBy.androidUIAutomator("new UiSelector().textContains(\"device\")")));

        Assertions.assertTrue(aboutHeader.isDisplayed(), "כותרת דף ה-About לא נמצאה!");
        System.out.println("משימה 2 הושלמה ואומתה בהצלחה!");
    }
}