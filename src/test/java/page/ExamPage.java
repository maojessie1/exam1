package page;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import java.util.List;

public class ExamPage extends BasePage {
    WebDriver driver;

    public ExamPage(WebDriver driver) {
        super(driver);
        PageFactory.initElements(driver, this);
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


/*    public WebElement getpageTwoElement() {
        List<WebElement> pageTwo = getFindElements("pageTwo");
        WebElement webElement = pageTwo.get(0);
    }*/

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


    //--------------------------------------------------------------------
    //@FindBy...is beginning

    @FindBy(css = "div~ul>li>i[class=\"el-icon-search\"]")
    public WebElement receive;
    //选择发票类型：点击下拉框
    @FindBy(xpath = "//*[@id=\"app\"]/div[1]/div/div/div/div[2]/div[1]/div[2]/div/div[1]/div[1]/form/div[2]/div/div/div/input")
    public WebElement receive1;

}
