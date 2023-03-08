package testcase;

import cores.commons.GlobalConstant;
import io.appium.java_client.AppiumDriver;
import io.appium.java_client.MobileElement;
import io.appium.java_client.android.AndroidDriver;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.support.PageFactory;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

import java.io.File;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.concurrent.TimeUnit;

public class TestThu {
    AppiumDriver<MobileElement> driver;


    @BeforeClass
    public void beforeClass(){
        DesiredCapabilities capabilities = new DesiredCapabilities();
        capabilities.setCapability("os_version", "9.0");
        capabilities.setCapability("device", "Google Pixel 3");
        capabilities.setCapability("app", "bs://833b4fcb357f744723cbd2d95985527f3cb06cd7");


        try {
            URL url = new URL(GlobalConstant.BROWSER_STACK_URL);
            driver = new AndroidDriver(url,capabilities);
        } catch (MalformedURLException e) {
            throw new RuntimeException(e);
        }

        driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
    }

    @Test
    public void TC_01(){
        System.out.println("test");
    }
}
