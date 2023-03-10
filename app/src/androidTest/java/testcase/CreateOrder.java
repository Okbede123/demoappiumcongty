package testcase;

import actions.*;
import com.aventstack.extentreports.Status;
import cores.commons.BaseTest;
import cores.reportconfig.ExtentManager;
import org.openqa.selenium.WebDriver;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

import java.lang.reflect.Method;

public class CreateOrder extends BaseTest {

    WebDriver driver;

    OnboardingPageObject onboardingPageObject;
    LoginPageObject loginPageObject;
    DashBoardPageObject dashBoardPageObject;
    CreateInvoiceOrdersPageObject createInvoiceOrdersPageObject;
    SelectPicturePageObject selectPicturePageObject;

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
        dashBoardPageObject = loginPageObject.inputNameStoreAndUserNameAndPassword("0563886668","0563886668","1");
        dashBoardPageObject.turnOffToolTip("Nhấn vào đây để thêm mới đơn hàng");
        createInvoiceOrdersPageObject = dashBoardPageObject.clickToCreateOrderInvoice();
        createInvoiceOrdersPageObject.turnOffToolTip("Nếu chưa có hàng hóa cần chọn, nhấn vào đây để thêm mới");
        createInvoiceOrdersPageObject.clickToCreateOrderInvoice();
        selectPicturePageObject = createInvoiceOrdersPageObject.takePicture();
        selectPicturePageObject.ChoosePicture();
        createInvoiceOrdersPageObject.inputInformationItems("hang test","check82","f","5000","10000","99");
    }
}
