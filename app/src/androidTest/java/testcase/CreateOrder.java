package testcase;

import actions.DashBoardPageObject;
import actions.LoginPageObject;
import actions.OnboardingPageObject;
import actions.PageGeneralManager;
import com.aventstack.extentreports.Status;
import cores.commons.BaseTest;
import cores.reportconfig.ExtentManager;
import org.openqa.selenium.WebDriver;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;
import org.testng.xml.dom.Tag;

import java.lang.reflect.Method;

public class CreateOrder extends BaseTest {

    WebDriver driver;

    OnboardingPageObject onboardingPageObject;
    LoginPageObject loginPageObject;
    DashBoardPageObject dashBoardPageObject;

    @Parameters({"package","activity","platformName","deviceName"})
    @BeforeClass
    public void beforeClass(String packAge,String activity,String platformName,String device){
        driver = getAndroidActivityDriver(platformName,device,packAge,activity);
        onboardingPageObject = PageGeneralManager.openOnBoardingPage(driver);
    }

    @Test
    public void TC_01_CreateOrder(Method method){
        ExtentManager.startTest(method.getName(),"TC_01");
        ExtentManager.getTest().log(Status.INFO,"test dang ky");
       loginPageObject = onboardingPageObject.clickToSkip();
       loginPageObject.inputNameStoreAndUserNameAndPassword("0563886668","0563886668","1");

    }
}
