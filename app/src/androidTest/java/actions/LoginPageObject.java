package actions;

import InterFaceUI.GlobalConstantUI;
import InterFaceUI.LoginPageUI;
import cores.commons.BasePage;
import org.openqa.selenium.WebDriver;

public class LoginPageObject extends BasePage {

    public LoginPageObject(WebDriver driver) {
        super(driver);
    }

    public DashBoardPageObject inputNameStoreAndUserNameAndPassword(String nameStore,String userName,String passWord){
        sendKeysToElement(LoginPageUI.INPUT_TEXTBOX_LOGIN,nameStore,"Tên gian hàng");
        sendKeysToElement(LoginPageUI.INPUT_TEXTBOX_LOGIN,userName,"Tên đăng nhập");
        sendKeysToElement(LoginPageUI.INPUT_TEXTBOX_LOGIN,passWord,"Mật khẩu");
        clickToElements(GlobalConstantUI.DYNAMIC_WIDGET_BUTTON,"Đăng nhập");
        return PageGeneralManager.openDashBoardPage(driver);
    }

}
