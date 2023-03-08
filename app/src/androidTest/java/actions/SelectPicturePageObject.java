package actions;

import InterFaceUI.BaseUI;
import InterFaceUI.SelectPicturePageUI;
import cores.commons.BasePage;
import org.openqa.selenium.WebDriver;

public class SelectPicturePageObject extends BasePage {

    public SelectPicturePageObject(WebDriver driver) {
        super(driver);
    }

    public void ChoosePicture(){
        clickToElements(SelectPicturePageUI.CLICK_TO_PICTURES);
        clickToElements(BaseUI.DYNAMIC_WIDGET_TEXTVIEW,"Xong");
    }

}
