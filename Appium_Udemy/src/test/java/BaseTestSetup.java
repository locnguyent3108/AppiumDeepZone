import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.android.AndroidElement;
import io.appium.java_client.remote.AndroidMobileCapabilityType;
import io.appium.java_client.remote.MobileCapabilityType;
import org.openqa.selenium.remote.CapabilityType;
import org.openqa.selenium.remote.DesiredCapabilities;

import java.io.File;
import java.net.MalformedURLException;
import java.net.URL;

public class BaseTestSetup {

    public static AndroidDriver<AndroidElement> beforeTest() throws MalformedURLException {
        AndroidDriver<AndroidElement>  driver;

        File appDir = new File("src/test");
        File app = new File(appDir,"ApiDemos-debug.apk");
        String localHost = "http://127.0.0.1:4723/wd/hub";
        DesiredCapabilities cap = new DesiredCapabilities();
        cap.setCapability(MobileCapabilityType.DEVICE_NAME,"Pixel2");
//        cap.setCapability(MobileCapabilityType.AUTOMATION_NAME,"uiautomator2");
        cap.setCapability("noReset", true);
        cap.setCapability(AndroidMobileCapabilityType.APP_WAIT_PACKAGE, "io.appium.android.apis");
//        cap.setCapability(AndroidMobileCapabilityType.APP_ACTIVITY, ".ApiDemos");
//        cap.setCapability(AndroidMobileCapabilityType.AUTO_GRANT_PERMISSIONS, true);
        cap.setCapability(AndroidMobileCapabilityType.APP_WAIT_ACTIVITY,".ApiDemos");


        cap.setCapability(MobileCapabilityType.APP,app.getAbsolutePath());
        driver = new AndroidDriver<AndroidElement>(new URL(localHost), cap);

        return driver;
    }
}
