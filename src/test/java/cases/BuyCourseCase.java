package cases;

import handle.BuyCourseHandle;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class BuyCourseCase extends BaseCase {
    WebDriver driver;
    BuyCourseHandle buyCourseHandle;

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
        buyCourseHandle = new BuyCourseHandle(driver);
    }

    @BeforeMethod
    public void beforeMethod() {
        driver.get("https://coding.imooc.com/class/434.html");
    }

    @Test
    public void addShop() {
        int num = 0;
        int beforNum = 0;

        String title = driver.getTitle();
        System.out.println(title);
        boolean courseName = title.contains("从入门到熟练掌握");
        Assert.assertEquals(courseName, true);

        try {
            beforNum = buyCourseHandle.shopping_icon();
        } catch (Exception e) {
            System.out.println("购物车数量为0");
        }
        buyCourseHandle.Js_addcart();
        try {
            Thread.sleep(1000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        int afterNum = buyCourseHandle.shopping_icon();

        num = afterNum - beforNum;
        Assert.assertEquals(num, 1);
        /*if (num==0){
            System.out.println("添加购物车失败");
        }else {
            System.out.println("添加购物车成功");
        }*/
    }

    @Test
    public void BuyNow() {
        buyCourseHandle.buy_now();
        String title = driver.getTitle();
        boolean flag = title.contains("确认订单");
        Assert.assertEquals(flag, true);
    }

}
