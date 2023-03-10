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
        dashBoardPageObject.turnOffToolTip("Nh???n v??o ????y ????? th??m m???i ????n h??ng");
        androidElement = (AndroidElement) driver.findElement(By.xpath(BaseUI.TAG_DYNAMIC_IMAGE_BUTTON+"[@resource-id = 'net.citigo.kol.free:id/fabAddInvoice']"));
        androidTouchAction.tap(ElementOption.element(androidElement)).perform();
    }

    //@Test
    public void TC_02_HandSwipeRightAndLeft(Method method){
        ExtentManager.startTest(method.getName(),"TC_01_HandSwipe");
        ExtentManager.getTest().log(Status.INFO,"test swipe");
        onboardingPageObject = PageGeneralManager.openOnBoardingPage(driver);
        AndroidElement androidElement_Swipe = driver.findElement(By.xpath("//android.widget.TextView[contains(@text,'KiotOnline gi??p b???n qu???n l??')]"));

        //scroll sang tr??i, ????? x l?? s??? ??m c?? th??? g???p ????i s??? hi???n t???i c???a element, v?? d??? element l?? x = 83, th?? c?? th??? ????? t???m -83 ho???c -100. ????? s??? c??ng ??m th?? c??ng scroll sang tr??i nhi???u
        androidTouchAction.press(ElementOption.element(androidElement_Swipe)).waitAction().moveTo(PointOption.point(-83,1336)).release().perform();
        sleepInTime(4);
        //scroll sang ph???i, ????? s??? d????ng, n???u ????? c??ng to, th?? scroll c??ng m???nh
        AndroidElement androidElement_Swipe_2 = driver.findElement(By.xpath("//android.widget.TextView[contains(@text,'Quy tr??nh kh??p k??n')]"));
        androidTouchAction.press(ElementOption.element(androidElement_Swipe_2)).waitAction().moveTo(PointOption.point(83,1336)).release().perform();

    }

    @Test
    public void TC_03_HandSwipeUpAndDown(Method method){
        ExtentManager.startTest(method.getName(),"TC_03_HandSwipeUpAndDown");
        ExtentManager.getTest().log(Status.INFO,"test swipe up and down");
        onboardingPageObject = PageGeneralManager.openOnBoardingPage(driver);


        loginPageObject = onboardingPageObject.clickToSkip();
        dashBoardPageObject = loginPageObject.inputNameStoreAndUserNameAndPassword("0563886668","0563886668","1");
        dashBoardPageObject.turnOffToolTip("Nh???n v??o ????y ????? th??m m???i ????n h??ng");
        //androidElement = (AndroidElement) driver.findElement(By.xpath(BaseUI.TAG_DYNAMIC_IMAGE_BUTTON+"[@resource-id = 'net.citigo.kol.free:id/fabAddInvoice']"));

        AndroidElement androidElement_Swipe = driver.findElement(By.xpath("//android.widget.TextView[@text='Theo s??? l?????ng']"));
        //scroll xu???ng th?? y ????? s??? ??m, c??ng l???n th?? scroll xu???ng c??ng m???nh
        androidTouchAction.press(ElementOption.element(androidElement_Swipe)).waitAction().moveTo(PointOption.point(412,-764)).release().perform();
        sleepInTime(5);
        //scroll l??n th?? y ????? s??? d????ng, c??ng l???n th?? scroll l??n c??ng m???nh
        AndroidElement androidElement_Swipe2 = driver.findElement(By.xpath("//android.view.ViewGroup[@resource-id='net.citigo.kol.free:id/lGuide']"));
        androidTouchAction.press(ElementOption.element(androidElement_Swipe2)).waitAction().moveTo(PointOption.point(0,668)).release().perform();

    }
}
