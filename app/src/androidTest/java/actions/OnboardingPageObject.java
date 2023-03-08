package actions;

import InterFaceUI.GlobalConstantUI;
import InterFaceUI.OnboardingPageUI;
import cores.commons.BasePage;
import org.openqa.selenium.WebDriver;

public class OnboardingPageObject extends BasePage {


    public OnboardingPageObject(WebDriver driver) {
        super(driver);
    }

    public LoginPageObject clickToSkip(){
        clickToElements(GlobalConstantUI.DYNAMIC_WIDGET_TEXTVIEW,"Bỏ qua");
        return PageGeneralManager.openLoginPage(driver);
    }


    public OnboardingPageObject doubleClickToNextOnBoarding(){
        clickToElements(GlobalConstantUI.DYNAMIC_WIDGET_BUTTON,"Tiếp theo");
        clickToElements(GlobalConstantUI.DYNAMIC_WIDGET_BUTTON,"Tiếp theo");
        return PageGeneralManager.openOnBoardingPage(driver);
    }

    public Object clickToNextOnBoardingThirdAndActionDynamic(String button){
        clickToElements(GlobalConstantUI.DYNAMIC_WIDGET_BUTTON,"Tiếp theo");
        if(button.equals("Đăng nhập")){
            clickToElements(GlobalConstantUI.DYNAMIC_WIDGET_BUTTON,button);
            return PageGeneralManager.openLoginPage(driver);
        }
        else if(button.equals("Đăng ký")){
            clickToElements(GlobalConstantUI.DYNAMIC_WIDGET_BUTTON,button);
            return PageGeneralManager.openRegisterPage(driver);
        }else {
            throw new RuntimeException();
        }

    }
}
