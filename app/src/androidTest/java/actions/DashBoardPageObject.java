package actions;

import InterFaceUI.DashBoardPageUI;
import cores.commons.BasePage;
import org.openqa.selenium.WebDriver;

public class DashBoardPageObject extends BasePage {

    public DashBoardPageObject(WebDriver driver) {
        super(driver);
    }



    public boolean isDashBoardSaleDisplayed(){
        if(isElementDisplayed(DashBoardPageUI.TOP_SELLING_PRODUCTS) && isElementDisplayed(DashBoardPageUI.SALES)){
            return true;
        }
        else {
            return false;
        }
    }

    public CreateInvoiceOrdersPageObject clickToCreateOrderInvoice(){
        clickToElements(DashBoardPageUI.CLICK_TO_CREATE_ORDER_INVOICES);
        return PageGeneralManager.openCreateInvoiceOrderPage(driver);
    }
}
