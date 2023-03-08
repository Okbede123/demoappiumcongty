package actions;

import InterFaceUI.LoginPageUI;
import android.util.Log;
import org.openqa.selenium.WebDriver;

public class PageGeneralManager {

    public static OnboardingPageObject openOnBoardingPage(WebDriver driver){
        return new OnboardingPageObject(driver);
    }

    public static LoginPageObject openLoginPage(WebDriver driver){
        return new LoginPageObject(driver);
    }

    public static RegisterPageObject openRegisterPage(WebDriver driver){
        return new RegisterPageObject(driver);
    }

    public static DashBoardPageObject openDashBoardPage(WebDriver driver){
        return new DashBoardPageObject(driver);
    }

    public static CreateInvoiceOrdersPageObject openCreateInvoiceOrderPage(WebDriver driver){
        return new CreateInvoiceOrdersPageObject(driver);
    }
    public static SelectPicturePageObject openSelectPicturePage(WebDriver driver){
        return new SelectPicturePageObject(driver);
    }
}
