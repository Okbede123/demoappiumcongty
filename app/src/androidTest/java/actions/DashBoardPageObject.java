package actions;

import InterFaceUI.DashBoardPageUI;
import InterFaceUI.GlobalConstantUI;
import cores.commons.BasePage;
import org.openqa.selenium.WebDriver;

public class DashBoardPageObject extends BasePage {

    public DashBoardPageObject(WebDriver driver) {
        super(driver);
    }

    public void turnOffToolTip(){
        if(isElementDisplayed(GlobalConstantUI.DYNAMIC_WIDGET_TEXTVIEW,"Nhấn vào đây để thêm mới đơn hàng")){
            clickToElements(DashBoardPageUI.CLOSE_TOOLTIP);
        }
    }

    public boolean isDashBoardSaleDisplayed(){
        if(isElementDisplayed(DashBoardPageUI.TOP_SELLING_PRODUCTS) && isElementDisplayed(DashBoardPageUI.SALES)){
            return true;
        }
        else {
            return false;
        }
    }
}
