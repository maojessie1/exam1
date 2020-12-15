package ITest;

import cases.BaseCase;
import com.alibaba.fastjson.JSON;
import com.google.gson.JsonArray;
import com.google.gson.JsonElement;
import com.google.gson.JsonObject;
import com.google.gson.JsonParser;
import org.openqa.selenium.*;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import java.time.Duration;
import java.util.*;
import java.util.concurrent.TimeUnit;


public class LoginLK extends BaseCase {
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
        driver.findElement(By.xpath("//*[@id=\"app\"]/div/div/div[3]/div/p[1]/input")).sendKeys("201205000076");
        driver.findElement(By.xpath("//*[@id=\"app\"]/div/div/div[3]/div/p[2]/input")).sendKeys("585554");
        driver.findElement(By.xpath("//*[@id=\"app\"]/div/div/div[3]/div/button/span")).click();
        driver.findElement(By.xpath("//*[@id=\"app\"]/div/div/div[3]/div/div[8]")).click();
        driver.findElement(By.xpath("//*[@id=\"app\"]/div/div/div[3]/div/p[2]/label/span[1]/s       pan")).click();
        //进入到考试页面
        driver.findElement(By.xpath("//*[@id=\"app\"]/div/div/div[3]/div/div[3]")).click();
        //点击开始答题按钮
        WebElement element = driver.findElement(By.xpath("//*[@id=\"wrapMain\"]/div[2]/div[1]/div/div[3]/button/span"));
        element.click();

        Actions actions = new Actions(driver);
        actions.sendKeys(Keys.F12).perform();
        String js = "document.getElementById(\"dialog\").remove();";
        ((JavascriptExecutor) driver).executeScript(js);



        HashMap<String, List> formNameMap  = fetchData();

        /**
         * 1.读取excel中的formName，查找那个方法是这个formname就跑哪个方法
         * 2.把formName对应的答案写到事项中。
         */
//        RegistrationForm();

//        RegisteByFormName(formNameMap,"taxForm");
        taxFormForm(formNameMap,"taxForm");
//        trainTicketForm(formNameMap,"taxForm");

    }

    /**
     * 仿真政务-软件著作
     */
    public void RegistrationForm(){
        WebElement iframeName = driver.findElement(By.name("ifinc"));
        driver.switchTo().frame(iframeName);
        driver.findElement(By.xpath("//*[@id=\"app\"]/div[1]/div/div/div/div[1]/div")).click();
        driver.findElement(By.xpath("//*[@id=\"app\"]/div[1]/div/div/div/div[2]/input[1]")).sendKeys("1");
        driver.findElement(By.xpath("//*[@id=\"app\"]/div[1]/div/div/div/div[2]/input[2]")).sendKeys("123456");
        driver.findElement(By.xpath("//*[@id=\"app\"]/div[1]/div/div/div/div[2]/div")).click();
        driver.findElement(By.xpath("//*[@id=\"app\"]/div[1]/div/div/div/div[3]/div[2]")).click();
        //进入到表单页面   计算机软件著作权登记申请表
        driver.findElement(By.xpath("//*[@id=\"app\"]/div[1]/div/div/div/div[4]/form/div[1]/div/div[1]/div[2]/div/input")).sendKeys("11");

        //获取input列表
        List<WebElement> elements = driver.findElements(By.className("el-input__inner"));
        int size = elements.size();
        System.out.println("size"+size);
        for (int i = 0; i < size; i++) {
            System.out.println("1111111"+elements.get(i).getTagName());
            System.out.println("222222222"+elements.get(i).getText());
            elements.get(i).sendKeys("22");
        }
    }

    public HashMap<String, List> fetchData(){
        HashMap<String, List> formNameMap = new HashMap<>();

        //获取formName值
//            String str2 = "[{\"id\":238,\"eventName\":\"仿真 - 计算机软件著作权登记申请表\",\"eventType\":0,\"eventUrl\":\"https://zledu-oss-sx.cailian.net/cjdd/course/20201113/DD4EDE1C-1605271306368.jpg\",\"eventParam\":\"platform=dummy&templateCode=001&roles=3032\",\"eventTemplateUrl\":\"https://dummyedusx.cailian.net/#/registration\",\"eventTemplatePic\":\"modelType=f_copyright_register\",\"eventDesp\":\"\",\"roles\":null,\"type\":true,\"modelType\":\"f_copyright_register\",\"dynmaicParamReqList\":[{\"id\":121886,\"questionId\":11427,\"eventId\":238,\"param\":\"platform\",\"value\":\"dummy\",\"type\":1,\"sort\":0},{\"id\":121887,\"questionId\":11427,\"eventId\":238,\"param\":\"templateCode\",\"value\":\"001\",\"type\":1,\"sort\":0},{\"id\":121888,\"questionId\":11427,\"eventId\":238,\"param\":\"roles\",\"value\":\"3001\",\"type\":1,\"sort\":0}],\"eventWeight\":100,\"timestamp\":1605938168584,\"value\":{\"formName\":\"RegistrationForm\",\"allname\":\"1\",\"forShort\":\"1\",\"classNumber\":\"系统软件类，操作系统 包括实时、分时、分布式、智能操作系统，系统使用程序，系统扩充程序 包括操作系统的扩充、汉化，网络系统软件，其他系统软件\",\"versionNumber\":\"1\",\"sslradio\":\"2\",\"dct\":\"2020-11-20T16:00:00.000Z\",\"PublishedState\":\"2\",\"Starting\":\"\",\"StartingPlace\":\"\",\"city\":\"\",\"exploit\":\"2\",\"acquire\":\"2\",\"Transplant\":\"11\",\"type\":[\"软件是否登记\",\"原登记是否做过变更或补充\"],\"originalNumber\":\"1\",\"change\":\"1\",\"interestField\":\"1\",\"publication\":[\"发表权\",\"署名权\",\"修改权\",\"复制权\",\"发行权\",\"出租权\",\"信息网络传播权\",\"翻译权\",\"应当由著作权人享有的其他权利\"],\"hardware\":\"范德萨发达\",\"software\":\"发范德萨的\",\"programme\":\"饭打饭打啊f\",\"sourceRoutine\":\"范德萨\",\"technicalFeature\":\"fd啊\",\"proposerList\":[{\"workNnits\":\"1\",\"category\":\"1\",\"nationality\":\"1\",\"province\":\"1\",\"site\":\"1\",\"documenttype\":\"1\",\"IDNumber\":\"1\",\"garden\":\"1\",\"Businesscategory\":\"1\"}],\"applicationlist\":[{\"Organization\":\"1\",\"Address\":\"1\",\"Postcode\":\"1\",\"linkman\":\"1\",\"phoneCode\":\"1\",\"email\":\"1\",\"phoneNumber\":\"1\",\"facsimile\":\"1\"}],\"proposer\":\"2\",\"covers\":\"1\",\"weightMapper\":{\"allname\":\"4\",\"forShort\":\"4\",\"classNumber\":\"4\",\"versionNumber\":\"4\",\"sslradio\":\"4\",\"dct\":\"4\",\"PublishedState\":\"4\",\"Starting\":\"4\",\"StartingPlace\":\"4\",\"city\":\"4\",\"exploit\":\"4\",\"acquire\":\"4\",\"Transplant\":\"4\",\"originalNumber\":\"4\",\"change\":\"4\",\"interestField\":\"4\",\"publication\":\"4\",\"hardware\":\"4\",\"software\":\"4\",\"programme\":\"4\",\"sourceRoutine\":\"4\",\"technicalFeature\":\"4\",\"proposerList\":\"4\",\"applicationlist\":\"4\",\"proposer\":\"4\"},\"aggrementMapper\":{\"originalNumber\":5,\"change\":5,\"hardware\":5,\"software\":5,\"programme\":5,\"sourceRoutine\":5,\"technicalFeature\":5,\"diversified\":5},\"applicant\":\"2\",\"publishedState\":\"2\",\"Deposit\":\"16\",\"onekind\":\"2\",\"diversified\":\"111111\",\"exception\":\"19\",\"pagination\":\"20\"},\"standParseType\":1,\"sort\":0}]";
        String str2 = "[{\"id\":152,\"eventName\":\"仿真-填写并领购发票\",\"eventType\":0,\"eventUrl\":\"https://zledu-oss-sx.cailian.net/cjdd/course/20200324/71271858-1585039487845.png\",\"eventParam\":\"platform=dummy&templateCode=001&roles=3032\",\"eventTemplateUrl\":\"https://dummyedusx.cailian.net/#/writeInvoice\",\"eventTemplatePic\":\"modelName=purchase_invoice&modelType=formTemplate\",\"eventDesp\":\"\",\"roles\":null,\"modelType\":\"formTemplate\",\"modelName\":\"purchase_invoice\",\"type\":true,\"dynmaicParamReqList\":[{\"param\":\"platform\",\"value\":\"dummy\",\"type\":\"1\"},{\"param\":\"templateCode\",\"value\":\"001\",\"type\":\"1\"},{\"param\":\"roles\",\"value\":\"3032\",\"type\":\"1\"}],\"value\":{\"name\":\"填写并领购发票\",\"form\":{\"configure\":{\"formName\":\"taxForm\",\"tableNum1\":\"1\",\"tableRemarks1\":\"2\",\"tableNum2\":\"3\",\"tableRemarks2\":\"4\",\"taxNumber\":\"5\",\"taxName\":\"6\",\"name\":\"7\",\"mobileNum\":\"8\",\"detailAddress\":\"9\",\"postalCode\":\"10\",\"remarks\":\"11\",\"address\":\"东城区\",\"isYourSelfGet\":\"0\"},\"weightMapper\":{\"taxNumber\":\"8\",\"taxName\":\"8\",\"name\":\"8\",\"mobileNum\":\"8\",\"address\":\"8\",\"detailAddress\":\"8\",\"postalCode\":\"8\",\"isYourSelfGet\":\"8\",\"remarks\":\"8\",\"tableNum1\":\"7\",\"tableNum2\":\"7\",\"tableRemarks1\":\"7\",\"tableRemarks2\":\"7\"}},\"configureWidth\":\"250px\",\"scoreWidth\":\"90px\"},\"eventWeight\":\"100\",\"version\":0,\"versionStatus\":true,\"timestamp\":1607261701754,\"standParseType\":0,\"sort\":0}]";
//           String str2 = "[{\"id\":179,\"eventName\":\"财天下_火车票信息采集\",\"eventType\":1,\"eventUrl\":\"https://cjddcloud-test.oss-cn-beijing.aliyuncs.com/cjdd/course/20191105/539C2648-1572923750454.jpg\",\"eventParam\":\"platform=ctx&templateCode={001}&roles=3001\",\"eventTemplateUrl\":\"/#/ctx/home\",\"eventTemplatePic\":\"modelName=trainTicketRecognition&modelType=formTemplate\",\"eventDesp\":\"/api/ctx-portal/v1/eduExam/into\",\"roles\":null,\"modelType\":\"formTemplate\",\"modelName\":\"trainTicketRecognition\",\"type\":true,\"dynmaicParamReqList\":[{\"param\":\"platform\",\"value\":\"ctx\",\"type\":\"1\"},{\"param\":\"templateCode\",\"value\":\"001\",\"type\":\"1\"},{\"param\":\"roles\",\"value\":\"3001\",\"type\":\"1\"}],\"value\":{\"name\":\"票天下 - 发票采集 - 火车票识别\",\"isOCR\":2,\"form\":{\"configure\":{\"formName\":\"trainTicketForm\",\"formMapper\":{\"startingStation\":\"枣庄站\",\"destinationStation\":\"北京南站\"},\"trainNum\":\"G158\",\"date\":\"2018-11-26\",\"ticketRate\":284,\"destinationStation\":\"北京南站\",\"startingStation\":\"枣庄站\"},\"weightMapper\":{\"trainNum\":\"0\",\"date\":\"10\",\"ticketRate\":\"50\",\"startingStation\":\"20\",\"destinationStation\":\"20\"},\"aggrementMapper\":{\"startingStation\":2,\"destinationStation\":2,\"ticketRate\":3}},\"configureWidth\":\"250px\",\"scoreWidth\":\"70px\"},\"eventWeight\":\"100\",\"version\":0,\"versionStatus\":true,\"timestamp\":1607334650897,\"standParseType\":0,\"sort\":0}]";
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
                System.out.println("key--->"+key);
                String allValue = "";
                if (nowSetValue.getValue() != null) {
                    //根据key获取value
                    allValue = nowSetValue.getValue().toString();
                }
                String nowValue = allValue.substring(1, allValue.length() - 1);
                if ("formName".equals(key)) {
                    formNameMap.put(nowValue, list);
                }
                System.out.println(nowSetValue.getKey() +":" + nowSetValue.getValue());
                list.add(nowValue);
            }

        }
        return formNameMap;
    }

    /**
     * 填写并领购发票
     * @param formNameMap
     * @param taxForm
     */

    public void taxFormForm(HashMap<String, List> formNameMap, String taxForm){
        List list =  formNameMap.get(taxForm);
        WebElement iframeName = driver.findElement(By.name("ifinc"));
        driver.switchTo().frame(iframeName);
        driver.findElement(By.cssSelector("#app .position-span")).click();
        List<WebElement> elements = driver.findElements(By.cssSelector("input.el-input__inner"));
        System.out.println("elements"+elements);
        elements.get(0).sendKeys("1");
        elements.get(1).sendKeys("123456");
        driver.findElement(By.cssSelector("#app .position-span")).click();
        driver.findElement(By.cssSelector("#app .position-span.write-span3")).click();
        driver.findElement(By.cssSelector("#app .position-span.write-span4")).click();



        elements = driver.findElements(By.cssSelector(".write-content input"));
        int valueIndex = 1;
        for (WebElement nowElement : elements) {
            String type = nowElement.getAttribute("type");
            if ("text".equals(type)) {
                nowElement.sendKeys(String.valueOf(list.get((valueIndex))));
//                nowElement.sendKeys(Keys.ENTER);
                valueIndex++;
            } else if ("radio".equals(type)) {

            }
        }

    }

    /**
     * 采集
     * @param formNameMap
     * @param taxForm
     */

    public void trainTicketForm(HashMap<String, List> formNameMap, String taxForm){
        List list =  formNameMap.get(taxForm);
        WebElement iframeName = driver.findElement(By.name("ifinc"));
        driver.switchTo().frame(iframeName);
        driver.findElement(By.cssSelector("#app .position-span")).click();
        List<WebElement> elements = driver.findElements(By.cssSelector("input.el-input__inner"));
        System.out.println("elements"+elements);
        elements.get(0).sendKeys("1");
        elements.get(1).sendKeys("123456");
        driver.findElement(By.cssSelector("#app .position-span")).click();
        driver.findElement(By.cssSelector("#app .position-span.write-span3")).click();
        driver.findElement(By.cssSelector("#app .position-span.write-span4")).click();



        elements = driver.findElements(By.cssSelector(".write-content input"));
        int valueIndex = 1;
        for (WebElement nowElement : elements) {
            String type = nowElement.getAttribute("type");
            if ("text".equals(type)) {
                nowElement.sendKeys(String.valueOf(list.get((valueIndex))));
//                nowElement.sendKeys(Keys.ENTER);
                valueIndex++;
            } else if ("radio".equals(type)) {

            }
        }

    }



    /**
     * 仿真政务-软件著作
     */
    public void RegisteByFormName( HashMap<String, List> formNameMap , String formName ){
        List list =  formNameMap.get(formName);
        WebElement iframeName = driver.findElement(By.name("ifinc"));
        driver.switchTo().frame(iframeName);
        driver.findElement(By.xpath("//*[@id=\"app\"]/div[1]/div/div/div/div[1]/div")).click();
        driver.findElement(By.xpath("//*[@id=\"app\"]/div[1]/div/div/div/div[2]/input[1]")).sendKeys("1");
        driver.findElement(By.xpath("//*[@id=\"app\"]/div[1]/div/div/div/div[2]/input[2]")).sendKeys("123456");
        driver.findElement(By.xpath("//*[@id=\"app\"]/div[1]/div/div/div/div[2]/div")).click();
        driver.findElement(By.xpath("//*[@id=\"app\"]/div[1]/div/div/div/div[3]/div[2]")).click();
        //进入到表单页面   计算机软件著作权登记申请表
        //读取excel中的数据填写到表单中
//        divriver.findElement(By.xpath("//*[@id=\"app\"]/div[1]/div/div/div/div[4]/form/div[1]/div/div[1]/div[2]/div/input")).sendKeys(list.get(1).toString());


        //获取input列表
//        List<WebElement> elements = driver.findElements(By.cssSelector(".border .el-row"));
        List<WebElement> elements = driver.findElements(By.cssSelector(".el-form .el-row"));

        int size = elements.size();
        System.out.println("size"+size);
        int valueIndex = 1;

        for (WebElement webElement : elements ) {
            List<WebElement> nowLineElements = webElement.findElements(By.tagName("input"));
            if ( nowLineElements == null || nowLineElements.size() > 0) {
                String lastType = "";
                for(WebElement nowElement : nowLineElements ){

                    String type = nowElement.getAttribute("type");
                    if( "text".equals(type) ){

                        nowElement.sendKeys(String.valueOf(list.get((valueIndex))));
                        nowElement.sendKeys(Keys.ENTER);
                        valueIndex++;
                        lastType = "";
                    }else if( "radio".equals(type) ) {
//                        String

                    }

                }
            }

        }


    }
}
