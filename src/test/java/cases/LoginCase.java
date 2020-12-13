package cases;

import Util.IListenerShot;
import handle.LoginHandle;
import org.apache.log4j.Logger;
import org.apache.log4j.PropertyConfigurator;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;



@Listeners({IListenerShot.class})
public class LoginCase extends BaseCase {
    public WebDriver driver;
    LoginHandle loginHandle;

    Logger logger = Logger.getLogger(LoginCase.class);
    @BeforeClass
    public void init(){
        PropertyConfigurator.configure("F:\\Final exercise selenium\\log4j.properties");
        logger.debug("初始化浏览器 ------------");
        driver = setBrowser("firefox");
        driver.get("https://www.imooc.com/");
        driver.findElement(By.id("js-signin-btn")).click();
        try {
            Thread.sleep(1000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        loginHandle = new LoginHandle(driver);
    }
    @Test
    public void login(){
        logger.error("login------------------->");
        loginHandle.username();
        loginHandle.password();
        loginHandle.loginButton();
        loginHandle.header_user_card();
        String s = loginHandle.text_ellipsis();
        Assert.assertEquals(s,"weibo_吃了呆呆果实的呆呆小_0");
    }
}
