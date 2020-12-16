package ksCases;

import cases.BaseCase;
import com.google.gson.JsonArray;
import com.google.gson.JsonElement;
import com.google.gson.JsonObject;
import com.google.gson.JsonParser;
import handle.ExamHandle;
import org.openqa.selenium.*;
import org.openqa.selenium.interactions.Actions;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import java.util.*;
import java.util.concurrent.TimeUnit;


public class ExamTest extends BaseCase {
    public WebDriver driver;
    ExamHandle examHandle;
    HashMap<String, Map> formNameMap1 = null;

    @BeforeClass
    public void init() {
        System.out.println("hhh");
        driver = setBrowser("chrome");
        driver.get("https://zledulktest.cailian.net/#/login");
        driver.manage().window().maximize();
        //隐式等待，等待5s
        driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
        examHandle = new ExamHandle(driver);
    }

    @Test
    public void login() {
        System.out.println("1");
        try {
            Thread.sleep(2000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        examHandle.usernameElement();
        examHandle.passwordElement();
        examHandle.loginElement();
        //确认&继续
        examHandle.continueOneElement();
        examHandle.continueTwoElement();
        //进入到考试页面
        examHandle.entenElement();
//        HashMap<String, List> formNameMap = null;
        //仿真政务-填写领购发票
        taxForm(formNameMap1, "taxForm");
        //采集
//        trainTicketForm(formNameMap, "trainTicketForm");
    }

    /**
     * 采集
     *
     * @param formNameMap
     * @param taxForm
     */

    public void trainTicketForm(HashMap<String, List> formNameMap, String taxForm) {
        String str2 = "[{\"id\":179,\"eventName\":\"财天下_火车票信息采集\",\"eventType\":1,\"eventUrl\":\"https://cjddcloud-test.oss-cn-beijing.aliyuncs.com/cjdd/course/20191105/539C2648-1572923750454.jpg\",\"eventParam\":\"platform=ctx&templateCode={001}&roles=3001\",\"eventTemplateUrl\":\"/#/ctx/home\",\"eventTemplatePic\":\"modelName=trainTicketRecognition&modelType=formTemplate\",\"eventDesp\":\"/api/ctx-portal/v1/eduExam/into\",\"roles\":null,\"modelType\":\"formTemplate\",\"modelName\":\"trainTicketRecognition\",\"type\":true,\"dynmaicParamReqList\":[{\"param\":\"platform\",\"value\":\"ctx\",\"type\":\"1\"},{\"param\":\"templateCode\",\"value\":\"001\",\"type\":\"1\"},{\"param\":\"roles\",\"value\":\"3001\",\"type\":\"1\"}],\"value\":{\"name\":\"票天下 - 发票采集 - 火车票识别\",\"isOCR\":2,\"form\":{\"configure\":{\"formName\":\"trainTicketForm\",\"formMapper\":{\"startingStation\":\"枣庄站\",\"destinationStation\":\"北京南站\"},\"trainNum\":\"G158\",\"date\":\"2018-11-26\",\"ticketRate\":284,\"destinationStation\":\"北京南站\",\"startingStation\":\"枣庄站\"},\"weightMapper\":{\"trainNum\":\"0\",\"date\":\"10\",\"ticketRate\":\"50\",\"startingStation\":\"20\",\"destinationStation\":\"20\"},\"aggrementMapper\":{\"startingStation\":2,\"destinationStation\":2,\"ticketRate\":3}},\"configureWidth\":\"250px\",\"scoreWidth\":\"70px\"},\"eventWeight\":\"100\",\"version\":0,\"versionStatus\":true,\"timestamp\":1607334650897,\"standParseType\":0,\"sort\":0}]";
        formNameMap = fetchData(str2);
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
        System.out.println(size + "size。。。。。。。。。。");
        elements.get(1).click();

        //点击开始答题按钮
        examHandle.startAnsweringButton();
        WebElement iframeName = driver.findElement(By.name("ifinc"));
        driver.switchTo().frame(iframeName);
        try {
            Thread.sleep(3000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        //点击票据采集菜单
        examHandle.clickPJCJ();
        try {
            Thread.sleep(2000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        JavascriptExecutor js1 = (JavascriptExecutor) driver;
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


    /**
     * 正式环境-填写并领购发票
     *
     * @param formNameMap1
     * @param taxForm
     */

    public void taxForm(HashMap<String, Map> formNameMap1, String taxForm) {
        String str2 = "[{\"id\":152,\"eventName\":\"仿真-填写并领购发票\",\"eventType\":0,\"eventUrl\":\"https://zledu-oss-sx.cailian.net/cjdd/course/20200324/71271858-1585039487845.png\",\"eventParam\":\"platform=dummy&templateCode=001&roles=3032\",\"eventTemplateUrl\":\"https://dummyedusx.cailian.net/#/writeInvoice\",\"eventTemplatePic\":\"modelName=purchase_invoice&modelType=formTemplate\",\"eventDesp\":\"\",\"roles\":null,\"modelType\":\"formTemplate\",\"modelName\":\"purchase_invoice\",\"type\":true,\"dynmaicParamReqList\":[{\"param\":\"platform\",\"value\":\"dummy\",\"type\":\"1\"},{\"param\":\"templateCode\",\"value\":\"001\",\"type\":\"1\"},{\"param\":\"roles\",\"value\":\"3032\",\"type\":\"1\"}],\"value\":{\"name\":\"填写并领购发票\",\"form\":{\"configure\":{\"formName\":\"taxForm\",\"tableNum1\":\"1\",\"tableRemarks1\":\"2\",\"tableNum2\":\"3\",\"tableRemarks2\":\"4\",\"taxNumber\":\"5\",\"taxName\":\"6\",\"name\":\"7\",\"mobileNum\":\"8\",\"detailAddress\":\"9\",\"postalCode\":\"10\",\"remarks\":\"11\",\"address\":\"东城区\",\"isYourSelfGet\":\"0\"},\"weightMapper\":{\"taxNumber\":\"8\",\"taxName\":\"8\",\"name\":\"8\",\"mobileNum\":\"8\",\"address\":\"8\",\"detailAddress\":\"8\",\"postalCode\":\"8\",\"isYourSelfGet\":\"8\",\"remarks\":\"8\",\"tableNum1\":\"7\",\"tableNum2\":\"7\",\"tableRemarks1\":\"7\",\"tableRemarks2\":\"7\"}},\"configureWidth\":\"250px\",\"scoreWidth\":\"90px\"},\"eventWeight\":\"100\",\"version\":0,\"versionStatus\":true,\"timestamp\":1607261701754,\"standParseType\":0,\"sort\":0}]";
//        formNameMap = fetchData(str2);

        formNameMap1 = fetchMapData(str2);
        Actions actions = new Actions(driver);
        try {
            Thread.sleep(2000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        actions.sendKeys(Keys.F12).perform();
        String js = "document.getElementById(\"dialog\").remove();";
        ((JavascriptExecutor) driver).executeScript(js);

        List<WebElement> elements1 = driver.findElements(By.cssSelector(".topic_num"));

        int size = elements1.size();
        System.out.println(size + "size。。。。。。。。。。");
        elements1.get(0).click();

        //点击开始答题按钮
        examHandle.startAnsweringButton();
//        List list = formNameMap.get(taxForm);
        WebElement iframeName = driver.findElement(By.name("ifinc"));
        driver.switchTo().frame(iframeName);
        try {
            Thread.sleep(3000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        examHandle.pageOneElement();
        List<WebElement> elements = driver.findElements(By.cssSelector("input.el-input__inner"));
        System.out.println("elements" + elements);
        elements.get(0).sendKeys("1");
        elements.get(1).sendKeys("123456");

        driver.findElement(By.cssSelector("#app .position-span")).click();
        examHandle.pageFourElement();
        examHandle.pageFiveElement();

        Map<String, String> map = formNameMap1.get(taxForm);

        for (Map.Entry<String, String> nowSetValue : map.entrySet()) {
            try {
                List<WebElement> allelements = driver.findElements(By.id(nowSetValue.getKey()));
                // 需要根据类型处理  TODO
                if (allelements.size() == 0) continue;

                if (allelements.size() == 1) {
                    allelements.get(0).sendKeys(nowSetValue.getValue());
                } else {
                    driver.findElement(By.xpath("//*[@id=\"app\"]/div[1]/div/div/div/div/div/div[3]/div[2]/div[2]/form/div[3]/div[1]/div/div/div/input")).click();
                    try {
                        Thread.sleep(3000);
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                    WebElement element = driver.findElement(By.cssSelector(".el-select-dropdown__list"));
                    try {
                        Thread.sleep(2000);
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                    allelements.get(0).click();
                }

            } catch (Exception e) {

            }

        }
    }

    public HashMap<String, List> fetchData(String str) {
        HashMap<String, List> formNameMap = new HashMap<>();

        //获取formName值
        JsonParser jp = new JsonParser();
        //将json字符串转化成json对象
        JsonArray ja = jp.parse(str).getAsJsonArray();
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
                list.add(key);
            }
            Object o = list.get(1);
            System.out.println(o);
        }
        return null;
    }


    public HashMap<String, Map> fetchMapData(String str) {
        formNameMap1 = new HashMap<>();
        //获取formName值
        JsonParser jp = new JsonParser();
        //将json字符串转化成json对象
        JsonArray ja = jp.parse(str).getAsJsonArray();
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
            Map map = new HashMap();

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
                    formNameMap1.put(nowValue, map);
                }
                System.out.println(nowSetValue.getKey() + ":" + nowSetValue.getValue());
                map.put(key, nowValue);
            }

        }
        return formNameMap1;
    }
    /**
     * 读取json并解析json答案
     *
     * @return
     */
   /* public HashMap<String, List> fetchData(String str) {
        HashMap<String, List> formNameMap = new HashMap<>();

        //获取formName值
        JsonParser jp = new JsonParser();
        //将json字符串转化成json对象
        JsonArray ja = jp.parse(str).getAsJsonArray();
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
*/


}