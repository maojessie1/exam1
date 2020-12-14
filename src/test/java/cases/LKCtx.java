package cases;

import com.google.gson.JsonArray;
import com.google.gson.JsonElement;
import com.google.gson.JsonObject;
import com.google.gson.JsonParser;
import org.openqa.selenium.*;
import org.openqa.selenium.interactions.Actions;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import java.util.*;
import java.util.concurrent.TimeUnit;

//copy
public class LKCtx extends BaseCase {
    public WebDriver driver;

    @BeforeClass
    public void init() {
        driver = setBrowser("chrome");
        driver.get("https://zledulk.cailian.net/#/login");

        driver.manage().window().maximize();
        //隐式等待，等待5s
        driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);

    }

    @Test
    public void login() {
        System.out.println("1");
        driver.findElement(By.xpath("//*[@id=\"app\"]/div/div/div[3]/div/p[1]/input")).sendKeys("201205000077");
        driver.findElement(By.xpath("//*[@id=\"app\"]/div/div/div[3]/div/p[2]/input")).sendKeys("585554");
        driver.findElement(By.xpath("//*[@id=\"app\"]/div/div/div[3]/div/button/span")).click();
        driver.findElement(By.xpath("//*[@id=\"app\"]/div/div/div[3]/div/div[8]")).click();
        driver.findElement(By.xpath("//*[@id=\"app\"]/div/div/div[3]/div/p[2]/label/span[1]/span")).click();
        //进入到考试页面
        driver.findElement(By.xpath("//*[@id=\"app\"]/div/div/div[3]/div/div[3]")).click();


        HashMap<String, List> formNameMap = fetchData();
        trainTicketForm(formNameMap, "trainTicketForm");

    }

    /**
     * 采集
     * @param formNameMap
     * @param taxForm
     */

    public void trainTicketForm(HashMap<String, List> formNameMap, String taxForm) {
        Actions actions = new Actions(driver);
        try {
            Thread.sleep(2000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        actions.sendKeys(Keys.F12).perform();
        String js = "document.getElementById(\"dialog\").remove();";
        ((JavascriptExecutor) driver).executeScript(js);

        List<WebElement> elements = driver.findElements(By.cssSelector(".topic_num"));
        int size = elements.size();
        System.out.println(size+"size。。。。。。。。。。");
        elements.get(1).click();


        //点击开始答题按钮
        WebElement element = driver.findElement(By.xpath("//*[@id=\"wrapMain\"]/div[2]/div[1]/div/div[3]/button/span"));
        element.click();



//        List list = formNameMap.get(taxForm);
        WebElement iframeName = driver.findElement(By.name("ifinc"));
        driver.switchTo().frame(iframeName);
        try {
            Thread.sleep(3000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        driver.findElement(By.xpath("//*[@id=\"app\"]/div[1]/div/div/section/section/aside/div[1]/ul/li[2]/div/span")).click();
        try {
            Thread.sleep(3000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        JavascriptExecutor js1 = (JavascriptExecutor)driver;
        js1.executeScript("return document.getElementsByClassName('el-button el-button--primary el-button--mini is-plain')[0].click();");

        try {
            Thread.sleep(2000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        js1.executeScript("return document.getElementsByClassName(\"el-checkbox__inner\")[0].click();");
        try {
            Thread.sleep(2000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        js1.executeScript("return document.getElementsByClassName(\"el-button el-button--primary el-button--small\")[0].click();");
    }

    public HashMap<String, List> fetchData() {
        HashMap<String, List> formNameMap = new HashMap<>();

        //获取formName值
        String str2 = "[{\"id\":179,\"eventName\":\"财天下_火车票信息采集\",\"eventType\":1,\"eventUrl\":\"https://cjddcloud-test.oss-cn-beijing.aliyuncs.com/cjdd/course/20191105/539C2648-1572923750454.jpg\",\"eventParam\":\"platform=ctx&templateCode={001}&roles=3001\",\"eventTemplateUrl\":\"/#/ctx/home\",\"eventTemplatePic\":\"modelName=trainTicketRecognition&modelType=formTemplate\",\"eventDesp\":\"/api/ctx-portal/v1/eduExam/into\",\"roles\":null,\"modelType\":\"formTemplate\",\"modelName\":\"trainTicketRecognition\",\"type\":true,\"dynmaicParamReqList\":[{\"param\":\"platform\",\"value\":\"ctx\",\"type\":\"1\"},{\"param\":\"templateCode\",\"value\":\"001\",\"type\":\"1\"},{\"param\":\"roles\",\"value\":\"3001\",\"type\":\"1\"}],\"value\":{\"name\":\"票天下 - 发票采集 - 火车票识别\",\"isOCR\":2,\"form\":{\"configure\":{\"formName\":\"trainTicketForm\",\"formMapper\":{\"startingStation\":\"枣庄站\",\"destinationStation\":\"北京南站\"},\"trainNum\":\"G158\",\"date\":\"2018-11-26\",\"ticketRate\":284,\"destinationStation\":\"北京南站\",\"startingStation\":\"枣庄站\"},\"weightMapper\":{\"trainNum\":\"0\",\"date\":\"10\",\"ticketRate\":\"50\",\"startingStation\":\"20\",\"destinationStation\":\"20\"},\"aggrementMapper\":{\"startingStation\":2,\"destinationStation\":2,\"ticketRate\":3}},\"configureWidth\":\"250px\",\"scoreWidth\":\"70px\"},\"eventWeight\":\"100\",\"version\":0,\"versionStatus\":true,\"timestamp\":1607334650897,\"standParseType\":0,\"sort\":0}]";
        JsonParser jp = new JsonParser();
        //将json字符串转化成json对象
        JsonArray ja = jp.parse(str2).getAsJsonArray();
        int size = ja.size();
        for (int i = 0; i < size; i++) {
            JsonObject jo = (JsonObject) ja.get(i);
            //取value的数组
            System.out.println(i + "--" + jo.get("value"));
            //把数组强转成json对象
            JsonObject value = (JsonObject) jo.get("value");
            value = (JsonObject) value.get("form");
            value = (JsonObject) value.get("configure");

            ArrayList list = new ArrayList();

            Set<Map.Entry<String, JsonElement>> setValue = value.entrySet();
            for (Map.Entry<String, JsonElement> nowSetValue : setValue) {
                //输出key
                String key = nowSetValue.getKey();
                System.out.println("key--->" + key);
                String allValue = "";
                if (nowSetValue.getValue() != null) {
                    //根据key获取value
                    allValue = nowSetValue.getValue().toString();
                }
                String nowValue = allValue.substring(1, allValue.length() - 1);
                if ("formName".equals(key)) {
                    formNameMap.put(nowValue, list);
                }
                System.out.println(nowSetValue.getKey() + ":" + nowSetValue.getValue());
                list.add(nowValue);
            }

        }
        return formNameMap;
    }
}
