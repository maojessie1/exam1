package ITest;

import Util.IListenerShot;
import Util.ProUtil;

import org.apache.log4j.Logger;
import org.apache.log4j.PropertyConfigurator;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;


//@Listeners({IListenerShot.class})
public class LoginTest {
    public WebDriver driver;
    static Logger logger = Logger.getLogger(LoginTest.class);

    @BeforeClass
    public void init() {
        PropertyConfigurator.configure("F:\\Final exercise selenium\\log4j.properties");
        logger.debug("初始化浏览器");
        System.setProperty("webdriver.chrome.driver", "C:\\Program Files\\Google\\Chrome\\Application\\chromedriver.exe");
        driver = new ChromeDriver();
        logger.debug("输入地址");
        driver.get("https://www.imooc.com/user/newlogin");
        try {
            Thread.sleep(1000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }

    @AfterClass
    public void end() {
        driver.close();
    }

    @Test
    public void login() {
        ProUtil proUtil = new ProUtil("F:\\Final exercise selenium\\user.properties");
        int size = proUtil.size();
        String username;
        for (int i = 0; i < size; i++) {
            logger.error("用户名为: " + "user" + i);
            logger.debug("用户名为: " + "user" + i);
            String element = proUtil.getP("user" + i);
            username = element.split(">")[0];
            String passord = element.split(">")[1];
            getFindElement("username").sendKeys(username);
//        driver.findElement(element.name("email")).sendKeys("11111");
            driver.findElement(By.name("password")).sendKeys(passord);
            driver.findElement(By.className("moco-btn-red")).click();
//            Assert.assertEquals("1","2");
        }


    }

    private By getProElement(String key) {
        ProUtil p = new ProUtil("F:\\Final exercise selenium\\element.properties");
        String element = p.getP(key);
        String local = element.split(">")[0];
        String value = element.split(">")[1];
        if (local.equals("id")) {
            return By.id(value);
        } else if (local.equals("name")) {
            return By.name(value);
        } else if (local.equals("className")) {
            return By.className(value);
        } else {
            return By.xpath(value);
        }

    }

    private WebElement getFindElement(String key) {
        WebElement element = driver.findElement(getProElement(key));
        return element;
    }

}
