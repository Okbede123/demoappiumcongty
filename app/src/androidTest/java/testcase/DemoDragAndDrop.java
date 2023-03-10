package testcase;

import cores.commons.GlobalConstant;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.android.AndroidElement;
import io.appium.java_client.android.AndroidTouchAction;
import org.openqa.selenium.By;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import java.net.MalformedURLException;
import java.net.URL;
import java.util.concurrent.TimeUnit;

public class DemoDragAndDrop {

    AndroidElement androidElement;
    AndroidDriver<AndroidElement> driver;
    AndroidTouchAction androidTouchAction;

    @BeforeMethod
    public void beforeMethod(){
        DesiredCapabilities d   = new DesiredCapabilities();
        d.setCapability("platformName","Android");
        d.setCapability("deviceName","emulator-5554");
        d.setCapability("appPackage","com.mobeta.android.demodslv");
        d.setCapability("appActivity","com.mobeta.android.demodslv.Launcher");
        try {
            driver = new AndroidDriver<>(new URL(GlobalConstant.LINK_APPIUM_HTTP),d);
            androidTouchAction = new AndroidTouchAction(driver);
        } catch (MalformedURLException e) {
            throw new RuntimeException(e);
        }
        driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
    }
    @Test
    public void TC_01(){
        AndroidElement goContinue = driver.findElement(By.xpath("//android.widget.Button["));
    }

}
