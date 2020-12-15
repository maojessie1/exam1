package handle;

import org.openqa.selenium.WebDriver;
import page.ExamPage;

public class ExamHandle {
    public WebDriver driver;
    ExamPage examPage;

    public ExamHandle(WebDriver driver) {
        examPage = new ExamPage(driver);
    }


    public void usernameElement() {
        examPage.getUsernameElement().sendKeys("201205000078");
    }

    public void passwordElement() {
        examPage.getPasswordElement().sendKeys("585554");
    }

    public void loginElement() {
        examPage.getloginElement().click();
    }

    public void continueOneElement() {
        examPage.getContinueElement().click();
    }

    public void continueTwoElement() {
        examPage.getcontinueTwoElement().click();
    }

    public void entenElement() {
        examPage.getEntenElement().click();
    }

    //开始答题按钮
    public void startAnsweringButton() {
        examPage.getstartAnsweringButton().click();
    }
    //点击票据采集菜单
    public void clickPJCJ() {
        examPage.getclickPJCJ().click();
    }

}
