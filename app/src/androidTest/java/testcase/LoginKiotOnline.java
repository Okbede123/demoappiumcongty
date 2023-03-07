package testcase;

import actions.*;
import com.aventstack.extentreports.Status;
import cores.commons.BaseTest;
import cores.commons.GlobalConstant;
import cores.reportconfig.ExtentManager;
import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import org.testng.annotations.*;

import java.lang.reflect.Method;

public class LoginKiotOnline extends BaseTest {


    WebDriver driver;

    OnboardingPageObject onboardingPageObject;
    LoginPageObject loginPageObject;
    RegisterPageObject registerPageObject;
    DashBoardPageObject dashBoardPageObject;


    @Parameters({"nameFile","PathFile","platformName","deviceName"})
    @BeforeMethod
    public void beforeMethod(String nameFile,String pathFile,String platFromName,String deviceName){
        driver = getAndroidDriver(nameFile,pathFile,platFromName,deviceName);
        onboardingPageObject = PageGeneralManager.openOnBoardingPage(driver);
    }

    //@Test
    public void TC_01(Method method){
        ExtentManager.startTest(method.getName(),"TC_01");
        ExtentManager.getTest().log(Status.INFO,"test dang ky");

        onboardingPageObject.doubleClickToNextOnBoarding();
        registerPageObject = (RegisterPageObject) onboardingPageObject.clickToNextOnBoardingThirdAndActionDynamic("Đăng ký");
    }

    @Test
    public void TC_02(Method method){
        ExtentManager.startTest(method.getName(),"TC_01");
        ExtentManager.getTest().log(Status.INFO,"test dang ky");
        onboardingPageObject.doubleClickToNextOnBoarding();
        loginPageObject = (LoginPageObject) onboardingPageObject.clickToNextOnBoardingThirdAndActionDynamic("Đăng nhập");
        dashBoardPageObject = loginPageObject.inputNameStoreAndUserNameAndPassword("0563886668","0563886668","1");
        dashBoardPageObject.turnOffToolTip();
        System.out.println(GlobalConstant.GETLINK_PROJECT + "/app/src/androidTest/java/report/ExtentReport.html");
        Assert.assertFalse(dashBoardPageObject.isDashBoardSaleDisplayed());
    }


}
