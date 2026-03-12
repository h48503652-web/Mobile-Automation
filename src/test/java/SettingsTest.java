

import org.BaseTest;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.net.MalformedURLException;

public class SettingsTest extends BaseTest {

    @BeforeEach
    public void init() throws MalformedURLException {
        // פותח את ההגדרות
        setUp("com.android.settings", "com.android.settings.Settings");
    }

    @Test
    public void testWifiToggle() {
        // הערה: אם ה-BaseTest שלך מכוון לשעון, נצטרך לעשות "טריק" קטן
        // כדי לעבור לאפליקציית ההגדרות
        driver.activateApp("com.android.settings");

        SettingsPage settingsPage = new SettingsPage(driver);

        // 1. חיפוש וגלילה עד ל-"Display" או "Network" (לפי המשימה שלך)
        settingsPage.scrollToText("Network & internet");

        // 2. לחיצה על האפשרות
        settingsPage.clickNetwork();

        System.out.println("נכנסנו להגדרות רשת!");
    }
}