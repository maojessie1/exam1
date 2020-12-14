package page;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class BuyCoursePage extends BasePage {

    public BuyCoursePage(WebDriver driver) {
        super(driver);
    }

    public WebElement getJs_addcartElement() {
        return getFindElement("js_addcart");
    }

    public WebElement getshopping_iconElement() {
        return getFindElement("shopping_icon");
    }

    public WebElement getbuy_nowElement() {
        return getFindElement("buy_now");
    }

}
