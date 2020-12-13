package ITest;

import com.sun.xml.internal.ws.api.addressing.OneWayFeature;
import org.apache.log4j.Logger;
import org.apache.log4j.PropertyConfigurator;
import org.checkerframework.checker.nullness.compatqual.NullableDecl;
import org.openqa.selenium.*;
import org.openqa.selenium.chrome.ChromeDriverService;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.firefox.FirefoxOptions;
import org.openqa.selenium.firefox.FirefoxProfile;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedCondition;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.TimeUnit;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Course {
    /**
     * 获取每个课程并且进入页面，比对外面的名称和课程名称是否一致。
     */
    WebDriver driver;
    Logger logger = Logger.getLogger(LoginTest.class);

    @BeforeClass
    public void init() {
        PropertyConfigurator.configure("F:\\Final exercise selenium\\log4j.properties");
        logger.debug("初始化浏览器");
//        System.setProperty("webdriver.chrome.driver", "C:\\Program Files\\Google\\Chrome\\Application\\chromedriver.exe");
        System.setProperty("webdriver.firefox.marionette", "C:\\Program Files (x86)\\Mozilla Firefox\\geckodriver.exe");
        driver = new FirefoxDriver();
//        driver = new ChromeDriver();
        logger.debug("输入地址");
        driver.get("https://coding.imooc.com/");
        driver.manage().window().maximize();
        FirefoxProfile firefoxProfile = new FirefoxProfile();
        FirefoxOptions firefoxOptions = new FirefoxOptions();
        firefoxOptions.setProfile(null);

        Cookie cookie = new Cookie("apsid",".imooc.com","/",null);
        driver.manage().addCookie(cookie);
        driver.manage().getCookieNamed("apsid");
        driver.manage().deleteAllCookies();

        JavascriptExecutor js = (JavascriptExecutor)driver;
        js.executeScript("");

//        隐形等待
        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
        driver.manage().timeouts().implicitlyWait(19,TimeUnit.SECONDS);

//        显性等待
        ((WebDriverWait)driver).until(new ExpectedCondition<Boolean>() {
            @NullableDecl
            @Override
            public Boolean apply(@NullableDecl WebDriver input) {
                return null;
            }
        });

        driver.manage().timeouts().implicitlyWait(10,TimeUnit.SECONDS);


        try {
            Thread.sleep(1000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }


        driver.findElement(By.className("js-close")).click();

        try {
            Thread.sleep(5000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

    }

    public void test1(){
        ((new WebDriverWait(driver,10))).until(new ExpectedCondition<WebElement>() {
            @NullableDecl
            @Override
            public WebElement apply(@NullableDecl WebDriver input) {
                return null;
            }
        });
        Select select = new Select(null);
        Actions actions = new Actions(driver);
        actions.dragAndDrop(null,null);




    }

    @AfterClass
    public void end() {
//        driver.close();
    }

    @Test
    public void testCourse() {
        List<Integer> numList = getPage();
        for (int j = 0; j < numList.size() - 1; j++) {
            List<WebElement> elements = driver.findElements(By.className("shizan-name"));
            for (int i = 0; i < elements.size(); i++) {
                String text = elements.get(i).getText();

                System.out.println(text);

                elements.get(i).click();
                driver.navigate().back();
                try {
                    Thread.sleep(1000);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
                driver.findElement(By.className("js-close")).click();
                elements = driver.findElements(By.className("shizan-name"));
            }
            driver.findElement(By.linkText("下一页")).click();
            try {
                Thread.sleep(1000);
            } catch (InterruptedException e) {
                // TODO Auto-generated catch block
                e.printStackTrace();
            }

        }


    }

    public List<Integer> getPage() {
        List<Integer> isNumList = new ArrayList<>();
        List<WebElement> elements = driver.findElement(By.className("page")).findElements(By.tagName("a"));

        for (WebElement num : elements) {
            String numText = num.getText();
            if (isNum(numText)==true){
                isNumList.add(Integer.valueOf(numText).intValue());
            }
        }
        return isNumList;
    }

    public boolean isNum(String num) {
        Pattern pattern = Pattern.compile("[0-9]*");
        Matcher matcher = pattern.matcher(num);
        if (matcher.matches()) {
            return true;
        }
        return false;
    }















/*
    public List<Integer> clickPage(){
        List<Integer> pageNumList = new ArrayList<>();
        List<WebElement> elements = driver.findElement(By.className("page")).findElements(By.tagName("a"));
        for (WebElement page:elements) {
            String text = page.getText();
            if (isNum(text)==true){
                int i = Integer.valueOf(text).intValue();
                System.out.println(i);
                pageNumList.add(i);

            }
        }
        return pageNumList;
    }

    public boolean isNum(String pageNum){
        Pattern pattern = Pattern.compile("[0-9]*");
        Matcher matcher = pattern.matcher(pageNum);
        if (matcher.matches()){
            return true;
        }
        return false;
    }





    private List<Integer> pageNumList() {
        List<Integer> pageNumList = new ArrayList<Integer>();
        List<WebElement> aElementList = driver.findElement(By.className("page")).findElements(By.tagName("a"));
        for (WebElement aElement : aElementList) {
            String pageNum = aElement.getText();
            if (isNumber(pageNum) == true) {
                pageNumList.add(Integer.valueOf(pageNum).intValue());
            }

        }
        return pageNumList;

    }

    private boolean isNumber(String pageNum) {
        Pattern pattern = Pattern.compile("[0-9]*");
        Matcher isNum = pattern.matcher(pageNum);
        if (isNum.matches()) {
            return true;
        }
        return false;
    }*/
}
