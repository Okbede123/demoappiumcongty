package com.example.myapplication;

import io.appium.java_client.android.AndroidDriver;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import java.io.File;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.List;
import java.util.concurrent.TimeUnit;

public class AppTest {

    WebDriver driver;

    String fileName = "appTest.apk";
    File appTest = new File("C:\\Users\\duc.vm4\\AppData\\Local\\Android\\Sdk\\platform-tools\\"+ fileName);


    @BeforeMethod
    public void beforeClass(){
        DesiredCapabilities d   = new DesiredCapabilities();
        d.setCapability("app",appTest);
        d.setCapability("platformName","Android");
        d.setCapability("deviceName","emulator-5554");
        try {
            driver = new AndroidDriver(new URL("http://127.0.0.1:4723/wd/hub"),d);
        } catch (MalformedURLException e) {
            throw new RuntimeException(e);
        }
        driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
    }

    @Test
    public void TC_01_SignIn(){
        driver.findElement(By.xpath("//android.widget.Button[@resource-id = 'com.Testing.karthik.extractionofuserid:id/signin']")).click();
        System.out.println(driver.findElement(By.xpath("//android.widget.EditText[@resource-id = 'com.Testing.karthik.extractionofuserid:id/email']")).getAttribute("text"));
        driver.findElement(By.xpath("//android.widget.EditText[@text = 'email']")).sendKeys("okbede");
        driver.findElement(By.xpath("//android.widget.EditText[@text = 'password']")).sendKeys("123123");
        driver.findElement(By.xpath("//android.widget.Button[@resource-id = 'com.Testing.karthik.extractionofuserid:id/signin']")).click();
    }

    //@Test
    public void TC_02_Register(){
        driver.findElement(By.xpath("//android.widget.Button[@resource-id = 'com.Testing.karthik.extractionofuserid:id/register']")).click();
    }

    @Test
    public void TC_03_DropDownList(){
        driver.findElement(By.xpath("//android.widget.Button[@resource-id = 'com.Testing.karthik.extractionofuserid:id/signin']")).click();
        driver.findElement(By.xpath("//android.widget.Spinner[@resource-id = 'com.Testing.karthik.extractionofuserid:id/country']")).click();
        sleepInTime(2);
        List<WebElement> arrayList = driver.findElements(By.xpath("//android.widget.CheckedTextView[@resource-id = 'android:id/text1']"));
        for (WebElement data:arrayList) {
            if(data.getText().contains("China CN")){
                data.click();
                break;
            }
        }

    }

    public void sleepInTime(int time){
        try {
            Thread.sleep(time*1000);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
    }
}
