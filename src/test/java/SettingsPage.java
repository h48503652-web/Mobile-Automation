

import io.appium.java_client.AppiumBy;
import io.appium.java_client.android.AndroidDriver;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

public class SettingsPage {
    AndroidDriver driver;

    public SettingsPage(AndroidDriver driver) {
        this.driver = driver;
    }

    // מזהים נפוצים (ייתכן ותצטרכי לעדכן לפי האינספקטור)
    By networkAndInternet = AppiumBy.xpath("//*[@text='Network & internet']");
    By wifiSwitch = AppiumBy.id("android:id/switch_widget");

    public void clickNetwork() {
        driver.findElement(networkAndInternet).click();
    }

    // פונקציית קסם לגלילה עד שמצאנו טקסט מסוים
    public void scrollToText(String text) {
        driver.findElement(AppiumBy.androidUIAutomator(
                "new UiScrollable(new UiSelector().scrollable(true))" +
                        ".scrollIntoView(new UiSelector().text(\"" + text + "\"))"));
    }
}