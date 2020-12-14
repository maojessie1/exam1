package handle;

import org.openqa.selenium.WebDriver;
import page.ExamPage;

public class ExamHandle {
    WebDriver driver;
    ExamPage examPage;

    public ExamHandle(WebDriver driver) {
        examPage = new ExamPage(driver);
    }


    public void UsernameElement(){
        examPage.getUsernameElement().sendKeys("201205000073");
    }
}
