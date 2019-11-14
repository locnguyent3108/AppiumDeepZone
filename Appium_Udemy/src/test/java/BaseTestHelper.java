import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.android.AndroidElement;

public class BaseTestHelper {

    public int validateClickAbleButton(AndroidDriver<AndroidElement> driver, String locator) {
        return driver.findElementsByAndroidUIAutomator("new UiSelector().clickable(true)").size();
    }
}
