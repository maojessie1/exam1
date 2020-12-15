package page;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import java.util.List;

public class ExamPage extends BasePage {
    public ExamPage(WebDriver driver) {
        super(driver);
    }

    public WebElement getUsernameElement() {
        return getFindElement("usernameElement");
    }

    public WebElement getPasswordElement() {
        return getFindElement("passwordElement");
    }

    public WebElement getloginElement() {
        return getFindElement("loginElement");
    }

    public WebElement getContinueElement() {
        return getFindElement("continueOne");
    }

    public WebElement getcontinueTwoElement() {
        return getFindElement("continueTwo");
    }

    public WebElement getEntenElement() {
        return getFindElement("enter");
    }

    public WebElement getstartAnsweringButton() {
        return getFindElement("startAnsweringButton");
    }

    //点击票据采集按钮
    public WebElement getclickPJCJ() {
        List<WebElement> clickPJCJ = getFindElements("clickPJCJ");
        WebElement webElement = clickPJCJ.get(1);
        return webElement;
    }

    //仿真政务--填写并领购发票

    public WebElement getpageOneElement() {
        return getFindElement("pageOne");
    }


    public WebElement getpageTwoElement() {
        return getFindElement("pageTwo");
    }

    public WebElement getpageThreeElement() {
        return getFindElement("pageThree");
    }

    public WebElement getpageFourElement() {
        return getFindElement("pageFour");
    }

    public WebElement getpageFiveElement() {
        return getFindElement("pageFive");
    }

    public WebElement getpageSixElement() {
        return getFindElement("pageSix");
    }

}
