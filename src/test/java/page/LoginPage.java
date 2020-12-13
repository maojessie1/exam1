package page;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class LoginPage extends BasePage {

    public LoginPage(WebDriver driver) {
        super(driver);
    }

    public WebElement getUsernameElement(){
        return getFindElement("username");
    }
    public WebElement getPasswordElement(){
        return getFindElement("password");
    }

    public WebElement getLoginButtonElement(){
        return getFindElement("moco_btn_red");
    }


    public WebElement getheader_user_cardElement(){
        return getFindElement("header_user_card");
    }

    public WebElement gettext_ellipsisElement(){
        return getFindElement("text_ellipsis");
    }

}
