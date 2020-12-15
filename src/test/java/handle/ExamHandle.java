package handle;

import org.openqa.selenium.WebDriver;
import page.ExamPage;

public class ExamHandle {
    public WebDriver driver;
    ExamPage examPage;

    public ExamHandle(WebDriver driver) {
        examPage = new ExamPage(driver);
    }


    public void usernameElement(){
        String text = examPage.getUsernameElement().getText();
        System.out.println("text = " + text);
        examPage.getUsernameElement().sendKeys("201205000078");
    }
}
