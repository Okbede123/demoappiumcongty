package cores.commons;



import io.appium.java_client.AppiumDriver;
import io.appium.java_client.android.AndroidDriver;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.remote.DesiredCapabilities;


import java.io.File;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.Random;
import java.util.concurrent.TimeUnit;

public class BaseTest {
    AppiumDriver driver;


    public AppiumDriver getAndroidDriver(String nameFile, String filePath, String platformName, String deviceName){

        File appTest = new File(filePath + "\\"+ nameFile);

        DesiredCapabilities d   = new DesiredCapabilities();
        d.setCapability("app",appTest);
        d.setCapability("platformName",platformName);
        d.setCapability("deviceName",deviceName);
        try {
            driver = new AndroidDriver(new URL(GlobalConstant.LINK_APPIUM_HTTP),d);
        } catch (MalformedURLException e) {
            throw new RuntimeException(e);
        }
        driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
        return  driver;
    }

    public WebDriver getDriver(){
        return driver;
    }



    public int getRandomNum(){
        Random rand = new Random();
        return rand.nextInt(10000);
    }

    public void sleepInTime(int time){
        try {
            Thread.sleep(time*1000);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
    }

    public void closeDriver(){
        if(driver != null){
            driver.quit();
        }
    }



}
