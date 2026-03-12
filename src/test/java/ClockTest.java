

import org.BaseTest;
import org.junit.jupiter.api.BeforeEach; // הוספנו את זה
import org.junit.jupiter.api.Test;
import java.net.MalformedURLException;
import static org.junit.jupiter.api.Assertions.assertNotNull;

public class ClockTest extends BaseTest {

    @BeforeEach
    public void init() throws MalformedURLException {
        // כאן אנחנו קוראים לפונקציה מה-BaseTest ושולחים לה את נתוני השעון
        setUp("com.google.android.deskclock", "com.android.deskclock.DeskClock");
    }

    @Test
    public void testTimer() throws InterruptedException {
        ClockPage clockPage = new ClockPage(driver);

        // 1. ודאי שהדרייבר אותחל
        assertNotNull(driver, "הדרייבר לא אותחל!");

        // 2. לחצי על טיימר
        clockPage.goToTimer();

        // 3. הגדירי זמן
        clockPage.enterTime10Seconds();

        // 4. הדפסת הטקסט מהמסך
        System.out.println("הזמן שהוזן: " + clockPage.getDisplayText());

        // 5. לחצי על הפעלה
        clockPage.startTimer();

        // 6. המתנה של 30 שניות כנדרש
        System.out.println("ממתין 30 שניות...");
        Thread.sleep(30000);
    }
}