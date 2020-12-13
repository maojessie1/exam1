package handle;

import org.openqa.selenium.WebDriver;
import page.LoginPage;

public class LoginHandle {
    LoginPage loginPage;
    public LoginHandle(WebDriver driver){
        loginPage = new LoginPage(driver);
    }
    public void username(){
        loginPage.getUsernameElement().sendKeys("18500902030");
    }
    public void password(){
        loginPage.getPasswordElement().sendKeys("winter09");
    }
    public void loginButton(){
        loginPage.getLoginButtonElement().click();
        try {
            Thread.sleep(3000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
    public void header_user_card(){
        loginPage.moveElement("header_user_card");
    }

    public String text_ellipsis(){
        String text = loginPage.gettext_ellipsisElement().getText();
        return text;
    }
}
