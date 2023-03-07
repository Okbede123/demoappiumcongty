package actions;

import InterFaceUI.GlobalConstantUI;
import InterFaceUI.OnboardingPageUI;
import cores.commons.BasePage;
import org.openqa.selenium.WebDriver;

public class OnboardingPageObject extends BasePage {


    public OnboardingPageObject(WebDriver driver) {
        super(driver);
    }

    public void clickToSkip(){
        clickToElements(GlobalConstantUI.DYNAMIC_WIDGET_TEXTVIEW,"Bỏ qua");
    }


    public void doubleClickToNextOnBoarding(){
        clickToElements(GlobalConstantUI.DYNAMIC_WIDGET_BUTTON,"Tiếp theo");
        clickToElements(GlobalConstantUI.DYNAMIC_WIDGET_BUTTON,"Tiếp theo");
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
