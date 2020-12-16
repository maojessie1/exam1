package handle;

import Util.ProUtil;
import org.openqa.selenium.WebDriver;
import page.ExamPage;

public class ExamHandle {
    public WebDriver driver;
    ExamPage examPage;

    ProUtil proUtil = new ProUtil("cardNum.properties");
    String elementKey = proUtil.getP("user2");
    String local = elementKey.split(">")[0];
    String value = elementKey.split(">")[1];

    public ExamHandle(WebDriver driver) {
        examPage = new ExamPage(driver);
    }


    public void usernameElement() {
        examPage.getUsernameElement().sendKeys(local);
    }

    public void passwordElement() {
        examPage.getPasswordElement().sendKeys(value);
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

    public void pageOneElement(){
        //#app .position-span
        examPage.getpageOneElement().click();
    }
/*

    public void pageTwoElement(){
        //input.el-input__inner
        examPage.getpageTwoElement()
    }
*/

    public void pageThreeElement(){
        examPage.getpageThreeElement().click();
    }

    public void pageFourElement(){
        examPage.getpageFourElement().click();
    }

    public void pageFiveElement(){
        examPage.getpageFiveElement().click();
    }


    public void pageSixElement(){
        examPage.getpageSixElement().click();
    }
}
