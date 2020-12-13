package handle;

import org.openqa.selenium.WebDriver;
import page.BuyCoursePage;

public class BuyCourseHandle {
    WebDriver driver;
    BuyCoursePage buyCoursePage;
    public BuyCourseHandle(WebDriver driver){
        buyCoursePage = new BuyCoursePage(driver);
    }

    public void Js_addcart(){
        buyCoursePage.getJs_addcartElement().click();
    }
    public int shopping_icon(){
        String text = buyCoursePage.getshopping_iconElement().getText();
        int shopNum = Integer.parseInt(text);
        return shopNum;
    }
    public void buy_now(){
        buyCoursePage.getbuy_nowElement().click();
        try {
            Thread.sleep(2000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
}
