import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.android.AndroidElement;
import org.testng.annotations.Test;

import java.net.MalformedURLException;
import java.util.concurrent.TimeUnit;

public class AndroidUIAutomator extends BaseTestSetup {
    @Test
    public void demo() throws MalformedURLException {
        AndroidDriver<AndroidElement> driver = beforeTest();
        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
        driver.findElementByAndroidUIAutomator("text(\"Views\")").click();

    }
}
