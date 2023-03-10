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

    @Test
    public void TC_02_HandSwipe(Method method){
        ExtentManager.startTest(method.getName(),"TC_01_HandSwipe");
        ExtentManager.getTest().log(Status.INFO,"test swipe");
        onboardingPageObject = PageGeneralManager.openOnBoardingPage(driver);
        AndroidElement androidElement_Swipe = driver.findElement(By.className("android.view.ViewGroup"));
        androidTouchAction.press(ElementOption.element(androidElement_Swipe)).waitAction().moveTo(PointOption.point(-690,371)).release().perform();
//
//        loginPageObject = onboardingPageObject.clickToSkip();
//        dashBoardPageObject = loginPageObject.inputNameStoreAndUserNameAndPassword("0563886668","0563886668","1");
//        dashBoardPageObject.turnOffToolTip("Nhấn vào đây để thêm mới đơn hàng");
//        androidElement = (AndroidElement) driver.findElement(By.xpath(BaseUI.TAG_DYNAMIC_IMAGE_BUTTON+"[@resource-id = 'net.citigo.kol.free:id/fabAddInvoice']"));
//
//        AndroidElement androidElement_Swipe = driver.findElement(By.xpath("//android.widget.ImageView[@resource-id='net.citigo.kol.free:id/ivThumbnail']"));
//        androidTouchAction.press(ElementOption.element(androidElement_Swipe)).waitAction().moveTo(PointOption.point(320,1966)).release().perform();
    }
}
