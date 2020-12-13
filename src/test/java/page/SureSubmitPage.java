package page;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class SureSubmitPage extends BasePage{
    public SureSubmitPage(WebDriver driver) {
        super(driver);
    }
    public WebElement getJs_pay_submitElement(){
        return getFindElement("js_pay_submit");
    }
}
