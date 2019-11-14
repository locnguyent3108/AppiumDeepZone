import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.android.AndroidElement;
import org.testng.annotations.Test;
import java.net.MalformedURLException;
import java.util.concurrent.TimeUnit;

public class FirstTest extends BaseTestSetup {

    @Test
    public void firstTestCase() throws MalformedURLException, InterruptedException {
        AndroidDriver<AndroidElement> driver = beforeTest();
        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
        //xpath id classnam, android
        Thread.sleep(2000);
//        driver.findElementByXPath("//android.widget.TextView[@text='Preference']").click();
//        driver.findElementByXPath("//android.widget.Button[@text='OK']").click();
        driver.findElementByXPath("//android.widget.TextView[@text='Preference']").click();

    }
}

