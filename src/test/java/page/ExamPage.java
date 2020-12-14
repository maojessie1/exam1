package page;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class ExamPage extends BasePage {
    public ExamPage(WebDriver driver) {
        super(driver);
    }

    public WebElement getUsernameElement() {
        return getFindElement("usernameElement");
    }

    public WebElement getPasswordElement(String key) {
        return getFindElement("username");
    }

    public WebElement getEntenElement(String key) {
        return getFindElement("username");
    }
}
