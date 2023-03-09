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

    public void inputInformationItems(String nameItems,String nameGroup,String chooseGroupParent,String priceSells,String priceCost,String onHand){
        sendKeysToElement(CreateInvoiceOrdersPageUI.INPUT_NAME_ITEM,nameItems);
        clickToElements(CreateInvoiceOrdersPageUI.INPUT_CATEGORY);
        clickToElements(CreateInvoiceOrdersPageUI.ADD_CATEGORY);
        sendKeysToElement(CreateInvoiceOrdersPageUI.INPUT_NAME_ITEM,nameGroup);
        clickToElements(CreateInvoiceOrdersPageUI.INPUT_CATEGORY);
        clickToElements(BaseUI.DYNAMIC_WIDGET_TEXTVIEW,chooseGroupParent);
        clickToElements(BaseUI.DYNAMIC_WIDGET_BUTTON,"Lưu");
        clickToElements(BaseUI.DYNAMIC_WIDGET_TEXTVIEW,chooseGroupParent);
        sendKeysToElement(CreateInvoiceOrdersPageUI.PRICE_SELL,priceSells);
        sendKeysToElement(CreateInvoiceOrdersPageUI.PRICE_SELL_COST,priceCost);
        sendKeysToElement(CreateInvoiceOrdersPageUI.ON_HAND,onHand);
        clickToElements(BaseUI.DYNAMIC_WIDGET_BUTTON,"Lưu");



    }

}
