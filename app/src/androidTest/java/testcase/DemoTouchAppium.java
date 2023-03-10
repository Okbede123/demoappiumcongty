package testcase;

import InterFaceUI.BaseUI;
import actions.*;
import com.aventstack.extentreports.Status;
import cores.commons.BaseTest;
import cores.commons.GlobalConstant;
import cores.reportconfig.ExtentManager;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.android.AndroidElement;
import io.appium.java_client.android.AndroidTouchAction;
import io.appium.java_client.touch.offset.ElementOption;
import io.appium.java_client.touch.offset.PointOption;
import org.openqa.selenium.By;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import java.lang.reflect.Method;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.concurrent.TimeUnit;

public class DemoTouchAppium extends BaseTest {


    AndroidElement androidElement;
    AndroidDriver<AndroidElement> driver;
    AndroidTouchAction androidTouchAction;

    OnboardingPageObject onboardingPageObject;
    LoginPageObject loginPageObject;
    DashBoardPageObject dashBoardPageObject;
    CreateInvoiceOrdersPageObject createInvoiceOrdersPageObject;
    SelectPicturePageObject selectPicturePageObject;


    @BeforeMethod
    public void beforeMethod(){

        DesiredCapabilities d   = new DesiredCapabilities();
        d.setCapability("platformName","Android");
        d.setCapability("deviceName","emulator-5554");
        d.setCapability("appPackage","net.citigo.kol.free");
        d.setCapability("appActivity","net.citigo.kiotviet.pos.fb.ui.MainActivity");
        try {
             driver = new AndroidDriver<>(new URL(GlobalConstant.LINK_APPIUM_HTTP),d);
            androidTouchAction = new AndroidTouchAction(driver);
        } catch (MalformedURLException e) {
            throw new RuntimeException(e);
        }
        driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);


    }

    //@Test
    public void TC_01_HandTap(Method method){
        ExtentManager.startTest(method.getName(),"TC_01_HandTap");
        ExtentManager.getTest().log(Status.INFO,"test tap");
        onboardingPageObject = PageGeneralManager.openOnBoardingPage(driver);

        loginPageObject = onboardingPageObject.clickToSkip();
        dashBoardPageObject = loginPageObject.inputNameStoreAndUserNameAndPassword("0563886668","0563886668","1");
        dashBoardPageObject.turnOffToolTip("Nhấn vào đây để thêm mới đơn hàng");
        androidElement = (AndroidElement) driver.findElement(By.xpath(BaseUI.TAG_DYNAMIC_IMAGE_BUTTON+"[@resource-id = 'net.citigo.kol.free:id/fabAddInvoice']"));
        androidTouchAction.tap(ElementOption.element(androidElement)).perform();
    }

    //@Test
    public void TC_02_HandSwipeRightAndLeft(Method method){
        ExtentManager.startTest(method.getName(),"TC_01_HandSwipe");
        ExtentManager.getTest().log(Status.INFO,"test swipe");
        onboardingPageObject = PageGeneralManager.openOnBoardingPage(driver);
        AndroidElement androidElement_Swipe = driver.findElement(By.xpath("//android.widget.TextView[contains(@text,'KiotOnline giúp bạn quản lý')]"));

        //scroll sang trái, để x là số âm có thể gấp đôi số hiện tại của element, ví dụ element là x = 83, thì có thể để tầm -83 hoặc -100. để số càng âm thì càng scroll sang trái nhiều
        androidTouchAction.press(ElementOption.element(androidElement_Swipe)).waitAction().moveTo(PointOption.point(-83,1336)).release().perform();
        sleepInTime(4);
        //scroll sang phải, để số dương, nếu để càng to, thì scroll càng mạnh
        AndroidElement androidElement_Swipe_2 = driver.findElement(By.xpath("//android.widget.TextView[contains(@text,'Quy trình khép kín')]"));
        androidTouchAction.press(ElementOption.element(androidElement_Swipe_2)).waitAction().moveTo(PointOption.point(83,1336)).release().perform();

    }

    @Test
    public void TC_03_HandSwipeUpAndDown(Method method){
        ExtentManager.startTest(method.getName(),"TC_03_HandSwipeUpAndDown");
        ExtentManager.getTest().log(Status.INFO,"test swipe up and down");
        onboardingPageObject = PageGeneralManager.openOnBoardingPage(driver);


        loginPageObject = onboardingPageObject.clickToSkip();
        dashBoardPageObject = loginPageObject.inputNameStoreAndUserNameAndPassword("0563886668","0563886668","1");
        dashBoardPageObject.turnOffToolTip("Nhấn vào đây để thêm mới đơn hàng");
        //androidElement = (AndroidElement) driver.findElement(By.xpath(BaseUI.TAG_DYNAMIC_IMAGE_BUTTON+"[@resource-id = 'net.citigo.kol.free:id/fabAddInvoice']"));

        AndroidElement androidElement_Swipe = driver.findElement(By.xpath("//android.widget.TextView[@text='Theo số lượng']"));
        //scroll xuống thì y để số âm, càng lớn thì scroll xuống càng mạnh
        androidTouchAction.press(ElementOption.element(androidElement_Swipe)).waitAction().moveTo(PointOption.point(412,-764)).release().perform();
        sleepInTime(5);
        //scroll lên thì y để số dương, càng lớn thì scroll lên càng mạnh
        AndroidElement androidElement_Swipe2 = driver.findElement(By.xpath("//android.view.ViewGroup[@resource-id='net.citigo.kol.free:id/lGuide']"));
        androidTouchAction.press(ElementOption.element(androidElement_Swipe2)).waitAction().moveTo(PointOption.point(0,668)).release().perform();

    }
}
