package actions;

import InterFaceUI.CreateInvoiceOrdersPageUI;
import InterFaceUI.BaseUI;
import cores.commons.BasePage;
import org.openqa.selenium.WebDriver;

public class CreateInvoiceOrdersPageObject extends BasePage {

    public CreateInvoiceOrdersPageObject(WebDriver driver) {
        super(driver);
    }


    public void clickToCreateOrderInvoice(){
        clickToElements(CreateInvoiceOrdersPageUI.CLICK_TO_CREATE_ORDER);
    }
    public SelectPicturePageObject takePicture(){
        clickToElements(CreateInvoiceOrdersPageUI.CLICK_ADD_PICTURES);
        clickToElements(BaseUI.DYNAMIC_WIDGET_BUTTON,"Đồng ý");
        clickToElements(BaseUI.DYNAMIC_WIDGET_BUTTON,"Allow");
        clickToElements(BaseUI.DYNAMIC_WIDGET_BUTTON,"Allow");
        return PageGeneralManager.openSelectPicturePage(driver);
    }

    public void inputInformationItems(String nameItems){
        sendKeysToElement(CreateInvoiceOrdersPageUI.INPUT_NAME_ITEM,nameItems);
    }

}
