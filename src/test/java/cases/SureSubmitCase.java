package cases;

import handle.SureSubmitHandle;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import org.testng.annotations.*;

public class SureSubmitCase extends BaseCase {

    WebDriver driver;
    SureSubmitHandle sureSubmitHandle;

    @BeforeClass
    public void init() {
        driver = setBrowser("firefox");
        driver.get("https://www.imooc.com/user/newlogin");
        driver.findElement(By.name("email")).sendKeys("18500902030");
        driver.findElement(By.name("password")).sendKeys("winter09");
        driver.findElement(By.className("moco-btn-red")).click();
        try {
            Thread.sleep(3000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        sureSubmitHandle = new SureSubmitHandle(driver);
    }

    @BeforeMethod
    public void beforeMethod() {
        driver.get("https://order.imooc.com/pay/confirm/goods_ids/1-434");
    }

    @Test
    public void clickSubmit() {
        sureSubmitHandle.Js_pay_submit();
        try {
            Thread.sleep(1000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        String title = driver.getTitle();
        boolean flag = title.contains("支付中心");
        Assert.assertEquals(flag, true);
    }

    @AfterClass
    public void end() {
        driver.close();
    }

    @AfterMethod
    public void afterMethod() {
        System.out.println("case结束");
    }
}
