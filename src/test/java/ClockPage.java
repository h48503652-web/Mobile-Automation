

import io.appium.java_client.AppiumBy;
import io.appium.java_client.android.AndroidDriver;
import org.openqa.selenium.By;

public class ClockPage {
    AndroidDriver driver;

    public ClockPage(AndroidDriver driver) {
        this.driver = driver;
    }

    // מעודכן לפי הקוד של חברה שלך
    By timerTab = By.id("com.google.android.deskclock:id/tab_menu_timer");
    By digit3 = By.id("com.google.android.deskclock:id/timer_setup_digit_3"); // אצלה זה לחץ על 3
    By digit0 = By.id("com.google.android.deskclock:id/timer_setup_digit_0"); // ואז על 0 (סך הכל 30 שניות)
    By startButton = By.id("com.google.android.deskclock:id/fab");
    By timeDisplay = By.id("com.google.android.deskclock:id/timer_setup_time");

    public void goToTimer() {
        driver.findElement(timerTab).click();
    }

    // פונקציה מעודכנת להזנת הזמן
    public void enterTime() {
        driver.findElement(digit3).click();
        driver.findElement(digit0).click();
    }

    public void startTimer() {
        driver.findElement(startButton).click();
    }

    public String getDisplayText() {
        try {
            return driver.findElement(timeDisplay).getText();
        } catch (Exception e) {
            return "תצוגה לא נמצאה";
        }
    }
}