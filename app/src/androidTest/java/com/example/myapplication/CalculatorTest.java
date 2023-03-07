package com.example.myapplication;

import io.appium.java_client.android.AndroidDriver;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.testng.Assert;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import java.io.File;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.concurrent.TimeUnit;

public class CalculatorTest {

    WebDriver driver;
    String fileName = "calculator.apk";
    File calculatorApp = new File("C:\\Users\\duc.vm4\\" + fileName);

    @BeforeTest
    public void beforeTest() throws MalformedURLException {
        DesiredCapabilities cap = new DesiredCapabilities();
        cap.setCapability("app", calculatorApp);
        // khai báo platform
        cap.setCapability("platformName", "ANDROID");
        // khai báo deviceName
        cap.setCapability("deviceName", "emulator-5554");
        // Tìm app và cài đặt app
        driver = new AndroidDriver(new URL("http://127.0.0.1:4723/wd/hub"), cap);
        driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
    }

    @Test
    public void addTest() {
        WebElement button_2 = driver.findElement(By.xpath("//android.widget.Button[@resource-id = 'com.google.android.calculator:id/digit_2']"));

        WebElement button_9 = driver.findElement(By.xpath("//android.widget.Button[@resource-id = 'com.google.android.calculator:id/digit_9']"));
        WebElement op_mul = driver.findElement(By.xpath("//android.widget.Button[@resource-id = 'com.google.android.calculator:id/op_mul']"));
        WebElement button_equal = driver.findElement(By.xpath("//android.widget.Button[@resource-id = 'com.google.android.calculator:id/eq']"));

        button_2.click();
        op_mul.click();
        button_9.click();
        button_equal.click();

        sleepInTime((short) 2);

        Assert.assertEquals(driver.findElement(By.xpath("//android.widget.TextView[@resource-id = 'com.google.android.calculator:id/result']")).getText(), "18");
    }

    @Test
    public void mulTest() {
        driver.findElement(By.xpath("//android.widget.Button[@resource-id = 'com.google.android.calculator:id/clr']")).click();
        driver.findElement(By.xpath("//android.widget.Button[@resource-id = 'com.google.android.calculator:id/digit_5']")).click();
        driver.findElement(By.xpath("//android.widget.Button[@resource-id = 'com.google.android.calculator:id/op_add']")).click();
        driver.findElement(By.xpath("//android.widget.Button[@resource-id = 'com.google.android.calculator:id/digit_7']")).click();
        driver.findElement(By.xpath("//android.widget.Button[@resource-id = 'com.google.android.calculator:id/eq']")).click();
    }

    @Test
    public void testNew(){
        driver.findElement(By.xpath("//android.view.ViewGroup[@resource-id = 'com.google.android.calculator:id/pad_advanced']")).click();
        driver.findElement(By.xpath("//android.widget.Button[@resource-id = 'com.google.android.calculator:id/fun_log']")).click();
    }

    public void sleepInTime(short time){
        try {
            Thread.sleep(time*1000);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
    }

    @AfterTest
    public void afterTest() {
        //driver.quit();
    }

}
