

import org.BaseTest;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import java.net.MalformedURLException;
import static org.junit.jupiter.api.Assertions.assertNotNull;

public class ClockTest extends BaseTest {

    @BeforeEach
    public void init() throws MalformedURLException {
        setUp("com.google.android.deskclock", "com.android.deskclock.DeskClock");
    }

    @Test
    public void testTimer() throws InterruptedException {
        ClockPage clockPage = new ClockPage(driver);

        assertNotNull(driver, "הדרייבר לא אותחל!");

        clockPage.goToTimer();
        clockPage.enterTime(); // עודכן כאן
        System.out.println("הזמן שהוזן: " + clockPage.getDisplayText());
        clockPage.startTimer();

        System.out.println("ממתין 30 שניות...");
        Thread.sleep(30000); // 30 שניות המתנה כנדרש
    }
}