package cases;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

public class BaseDriver {
    public WebDriver driver;

    public WebDriver setBrowser(String browser) {
//        if (driver != null){
//            return driver;
//        }
        if (browser.equalsIgnoreCase("chrome")) {
            String path = BaseDriver.class.getResource("/").getPath();
            System.out.println("path = " + path);
//            System.setProperty("webdriver.chrome.driver", "C:\\Program Files\\Google\\Chrome\\Application\\chromedriver.exe");
            System.setProperty("webdriver.chrome.driver", "C:\\Users\\Lenovo\\AppData\\Local\\Google\\Chrome\\Application\\chromedriver.exe");
//            System.setProperty("webdriver.chrome.driver", path+"tools\\chromedriver.exe");
            driver = new ChromeDriver();

        } else {
            System.setProperty("webdriver.firefox.marionette", "C:\\Program Files (x86)\\Mozilla Firefox\\geckodriver.exe");
            driver = new FirefoxDriver();
        }
        return driver;
    }


}
