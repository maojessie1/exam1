package handle;

import Util.ProUtil;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.Parameters;
import page.ExamPage;

import javax.xml.crypto.Data;
import java.time.Duration;

public class ExamHandle {
    public WebDriver driver;
    ExamPage examPage;
//    WebDriverWait wait = new WebDriverWait(driver,10);
    ProUtil proUtil = new ProUtil("cardNum.properties");
    String elementKey = proUtil.getP("user4");
    String local = elementKey.split(">")[0];
    String value = elementKey.split(">")[1];

    public ExamHandle(WebDriver driver) {
        examPage = new ExamPage(driver);
    }

//    @Parameters({"user"})
//    public void usernameElement(String user) {
//        examPage.getUsernameElement().sendKeys(user);
//    }
//    @Parameters({"password"})
//    public void passwordElement(String password) {
//        examPage.getPasswordElement().sendKeys(password);
//    }

    public void usernameElement(String user) {
        examPage.getUsernameElement().sendKeys(user);
    }

    public void passwordElement(String password) {
        examPage.getPasswordElement().sendKeys(password);
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

    //仿真政务-填写并领购发票

    public void pageOneElement() {
        //#app .position-span
        examPage.getpageOneElement().click();
    }
/*

    public void pageTwoElement(){
        //input.el-input__inner
        examPage.getpageTwoElement()
    }
*/

    public void pageThreeElement() {
        examPage.getpageThreeElement().click();
    }

    public void pageFourElement() {
        examPage.getpageFourElement().click();
    }

    public void pageFiveElement() {
        examPage.getpageFiveElement().click();
    }


    public void pageSixElement() {
        examPage.getpageSixElement().click();
    }

    //--------------------------------------------------------------------
    //@FindBy...is beginning



    public void clickMenuReceive(){
        try {
            Thread.sleep(2000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        examPage.receive.click();
    }

    public void clickBtnBox(){
        examPage.receive1.click();
    }

}
