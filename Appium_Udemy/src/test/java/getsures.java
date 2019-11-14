import io.appium.java_client.TouchAction;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.android.AndroidElement;
import io.appium.java_client.touch.LongPressOptions;
import io.appium.java_client.touch.TapOptions;
import io.appium.java_client.touch.offset.ElementOption;
import io.appium.java_client.touch.offset.PointOption;
import org.aspectj.weaver.ast.And;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.annotations.Test;

import javax.swing.text.html.parser.Element;
import java.net.MalformedURLException;
import java.time.Duration;
import java.util.List;
import java.util.concurrent.TimeUnit;

import static io.appium.java_client.touch.offset.ElementOption.element;

public class getsures extends BaseTestSetup{

    @Test
    public void getsureTest() throws MalformedURLException {
        AndroidDriver<AndroidElement> driver = beforeTest();
        driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
        driver.findElementByXPath(".//android.widget.TextView[@text='Views']").click();

        //Tap
        TouchAction touchAction = new TouchAction(driver);
        WebElement expandableBtn = driver.findElementByXPath(".//android.widget.TextView[@text='Expandable Lists']");
        touchAction.tap(TapOptions.tapOptions()
                            .withElement(element(expandableBtn)))
                            .perform();

        //long press
        driver.findElementByXPath(".//android.widget.TextView[@text='1. Custom Adapter']").click();
        WebElement peopleName = driver.findElementByXPath(".//android.widget.TextView[@text='People Names']");
        touchAction.longPress(LongPressOptions.longPressOptions()
                            .withElement(element(peopleName))
                            .withDuration(Duration.ofSeconds(5)))
                .perform();

        System.out.println(driver.findElementByXPath(".//android.widget.TextView[@text='Sample menu']").isDisplayed());
    }

    @Test
    public void swipeTest() throws MalformedURLException {
        AndroidDriver<AndroidElement> driver = beforeTest();

        driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
        driver.findElementByXPath(".//android.widget.TextView[@text='Views']").click();
        driver.findElementByXPath(".//android.widget.TextView[@text='Date Widgets']").click();
        driver.findElementByXPath(".//android.widget.TextView[@text='2. Inline']").click();
        driver.findElementByXPath(".//*[@content-desc='9']").click();
        WebElement number9 = driver.findElementByXPath(".//*[@content-desc='15']");
        WebElement number45 = driver.findElementByXPath(".//*[@content-desc='45']");

        // Swipe from 15 to 45
        TouchAction t = new TouchAction(driver);

        t.longPress(LongPressOptions.longPressOptions().withElement(element(number9)).withDuration(Duration.ofSeconds(2)))
                                        .moveTo(element(number45))
                                        .release()
                                        .perform();
    }

    @Test
    public void scrolling() throws MalformedURLException {
        AndroidDriver<AndroidElement> driver = beforeTest();
        driver.findElementByXPath("//android.widget.TextView[@text='Views']").click();
        driver.findElementByAndroidUIAutomator("new UiScrollable(new UiSelector()).scrollIntoView(new UiSelector().text(\"WebView\"));");
    }

    @Test
    public void dragAndDrop() throws  MalformedURLException {
        AndroidDriver<AndroidElement> driver = beforeTest();
        driver.findElementByXPath("//android.widget.TextView[@text='Views']").click();
        driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
        driver.findElementByXPath("//android.widget.TextView[@content-desc='Drag and Drop']").click();

        List<AndroidElement> element = driver.findElements(By.className("android.view.View"));
        AndroidElement source = element.get(0);
        AndroidElement dest = element.get(1);

        TouchAction t = new TouchAction(driver);
        t.longPress(LongPressOptions.longPressOptions().withElement(element(source)).withDuration(Duration.ofSeconds(3)))
                .moveTo(element(dest))
                .release()
                .perform();
    }
}
