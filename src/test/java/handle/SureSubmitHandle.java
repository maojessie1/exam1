package handle;

import org.openqa.selenium.WebDriver;
import page.SureSubmitPage;

public class SureSubmitHandle {
    WebDriver driver;
    SureSubmitPage sureSubmitPage;
    public SureSubmitHandle(WebDriver driver){
        sureSubmitPage = new SureSubmitPage(driver);
    }
    public void Js_pay_submit(){
        sureSubmitPage.getJs_pay_submitElement().click();
        try {
            Thread.sleep(2000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
}
