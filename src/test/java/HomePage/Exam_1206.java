package HomePage;

import cases.BaseDriver;
import com.google.gson.JsonArray;
import com.google.gson.JsonElement;
import com.google.gson.JsonObject;
import com.google.gson.JsonParser;
import handle.ExamHandle;
import integration.GetScore;
import org.openqa.selenium.*;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Optional;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;


import java.util.*;
import java.util.concurrent.TimeUnit;


public class Exam_1206 extends BaseDriver {
    public WebDriver driver;
    ExamHandle examHandle;
    HashMap<String, Map> formNameMap1 = null;
    HashMap<String, List> formNameMap = null;

    HashMap<String, String> convetMap = new HashMap<String, String>();

    WebElement element;
    List<WebElement> elements1;
    JavascriptExecutor js = null;

    @BeforeClass
    public void init() {
        System.out.println("hhh");
        driver = setBrowser("chrome");
//        driver.get("https://zledukstest.cailian.net/#/login");
        driver.get("https://zleduks.cailian.net/#/login");
        driver.manage().window().maximize();
        //隐式等待，等待5s
        driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
        examHandle = new ExamHandle(driver);
        convetMap.put("bank", "bankName");

    }
    //1206考zdh初级0305r

    //运行xml文件
    @Parameters({"user","password"})
    @Test
    public void login(String user,String password) {
        System.out.println("1");
        waitTime(2000);
        examHandle.usernameElement(user);
        examHandle.passwordElement(password);
        examHandle.loginElement();
        //确认&继续
        examHandle.continueOneElement();
        examHandle.continueTwoElement();
        //进入到考试页面
        examHandle.entenElement();
        //1226考（100分）上册 18题
        goodsAddForm(formNameMap, "goodsAddForm");

    }


    /**
     * 1206考 16题
     * 北京紫霖财税共享服务中心（以下简称“财税共享中心”）是一家为企业提供财税咨询和代理服务的专业公司，
     * 2019年11月26日与深圳市三清商贸有限公司（简称：三清商贸公司）签订了代理记账合同。
     * 三清商贸公司是一家从事日用百货批发与零售的公司，为增值税小规模纳税人。公司销售的主要产品为：
     * （1）垃圾桶（商品和服务税收分类：日用塑料制品），型号：脚踏式，计量单位：个，参考单价：25元，
     * 税率3%；（2）清洁球（商品和服务税收分类：清洁清扫类工具及其已加工材料），型号：手柄型，计量单位：
     * 个，参考单价：8元，税率3%；（3）玻璃擦（商品和服务税收分类：清洁清扫类工具及其已加工材料），
     * 型号：黄色，计量单位：个，参考单价：32元，税率3%。
     * 2019年12月6日三清商贸公司与北京众联合商贸有限责任公司签订了产品销售合同，销售垃圾桶（脚踏式）150个，
     * 不含税单价23元/个；清洁球（型号：手柄型）100个，不含税单价7元/个；玻璃擦（黄色）90个，不含税单价35元/个。
     * 货物已发出，款项已结清，北京众联合商贸有限责任公司要求开具一张纸质的增值税普通发票。
     * 客户相关信息：北京众联合商贸有限责任公司；纳税人识别号：91110108096392653A6，为增值税小规模纳税人；
     * 营业地址： 北京市海淀区上地三街F座701-6号；电话：010-36896242；开户银行：招商银行上地支行；银行账号：6214830120186983。
     * 要求：
     * <p>
     * （1）请在“票天下”领取发票（税控盘密码：88888888，领购日期：2019年12月6日）；
     * （2）根据业务需求增加商品服务档案和客户信息；
     * （3）请为三清商贸公司代开不含税增值税纸质普通发票。
     *
     * @param formNameMap
     * @param goodsAddForm
     */
    public void goodsAddForm(HashMap<String, List> formNameMap, String goodsAddForm) {
        String str2 = "[{\"id\":128,\"eventName\":\"票天下_商品信息新增编辑\",\"eventType\":1,\"eventUrl\":\"https://zledu-oss-sx.cailian.net/cjdd/course/20191220/4A232F1F-1576771830760.png\",\"eventParam\":\"platform=ptx&templateCode={001}&roles=3001\",\"eventTemplateUrl\":\"/#/ptx/home\",\"eventTemplatePic\":\"modelName=commodity_information_maintenance&modelType=formTemplate\",\"eventDesp\":\"https://ctxedudxapi.cailian.net\",\"roles\":null,\"modelType\":\"formTemplate\",\"modelName\":\"commodity_information_maintenance\",\"type\":true,\"dynmaicParamReqList\":[{\"id\":136304,\"questionId\":9029,\"eventId\":128,\"param\":\"platform\",\"value\":\"ptx\",\"type\":1,\"sort\":0},{\"id\":136305,\"questionId\":9029,\"eventId\":128,\"param\":\"templateCode\",\"value\":\"3038\",\"type\":1,\"sort\":0},{\"id\":136306,\"questionId\":9029,\"eventId\":128,\"param\":\"roles\",\"value\":\"3006\",\"type\":1,\"sort\":0}],\"value\":{\"name\":\"票天下_商品信息维护\",\"form\":{\"configure\":{\"formName\":\"goodsAddForm\",\"formMapper\":{\"goodName\":\"垃圾桶\"},\"goodName\":\"垃圾桶\",\"goodModel\":\"脚踏式\",\"goodUnit\":\"个\",\"goodPrice\":\"25.00\",\"taxRate\":\"0.03\"},\"weightMapper\":{\"goodName\":\"20\",\"goodModel\":\"20\",\"goodUnit\":\"20\",\"goodPrice\":\"20\",\"taxRate\":\"20\"},\"aggrementMapper\":{}},\"configureWidth\":\"250px\",\"scoreWidth\":\"70px\"},\"eventWeight\":10,\"standParseType\":0,\"sort\":0,\"versionStatus\":true},{\"id\":128,\"eventName\":\"票天下_商品信息新增编辑\",\"eventType\":1,\"eventUrl\":\"https://zledu-oss-sx.cailian.net/cjdd/course/20191220/4A232F1F-1576771830760.png\",\"eventParam\":\"platform=ptx&templateCode={001}&roles=3001\",\"eventTemplateUrl\":\"/#/ptx/home\",\"eventTemplatePic\":\"modelName=commodity_information_maintenance&modelType=formTemplate\",\"eventDesp\":\"https://ctxedudxapi.cailian.net\",\"roles\":null,\"modelType\":\"formTemplate\",\"modelName\":\"commodity_information_maintenance\",\"type\":true,\"dynmaicParamReqList\":[{\"id\":136307,\"questionId\":9029,\"eventId\":128,\"param\":\"platform\",\"value\":\"ptx\",\"type\":1,\"sort\":1},{\"id\":136308,\"questionId\":9029,\"eventId\":128,\"param\":\"templateCode\",\"value\":\"3038\",\"type\":1,\"sort\":1},{\"id\":136309,\"questionId\":9029,\"eventId\":128,\"param\":\"roles\",\"value\":\"3006\",\"type\":1,\"sort\":1}],\"value\":{\"name\":\"票天下_商品信息维护\",\"form\":{\"configure\":{\"formName\":\"goodsAddForm\",\"formMapper\":{\"goodName\":\"清洁球\"},\"goodName\":\"清洁球\",\"goodModel\":\"手柄型\",\"goodUnit\":\"个\",\"goodPrice\":\"8.00\",\"taxRate\":\"0.03\"},\"weightMapper\":{\"goodName\":\"20\",\"goodModel\":\"20\",\"goodUnit\":\"20\",\"goodPrice\":\"20\",\"taxRate\":\"20\"},\"aggrementMapper\":{}},\"configureWidth\":\"250px\",\"scoreWidth\":\"70px\"},\"eventWeight\":10,\"standParseType\":0,\"sort\":1,\"versionStatus\":true},{\"id\":128,\"eventName\":\"票天下_商品信息新增编辑\",\"eventType\":1,\"eventUrl\":\"https://zledu-oss-sx.cailian.net/cjdd/course/20191220/4A232F1F-1576771830760.png\",\"eventParam\":\"platform=ptx&templateCode={001}&roles=3001\",\"eventTemplateUrl\":\"/#/ptx/home\",\"eventTemplatePic\":\"modelName=commodity_information_maintenance&modelType=formTemplate\",\"eventDesp\":\"https://ctxedudxapi.cailian.net\",\"roles\":null,\"modelType\":\"formTemplate\",\"modelName\":\"commodity_information_maintenance\",\"type\":true,\"dynmaicParamReqList\":[{\"id\":136310,\"questionId\":9029,\"eventId\":128,\"param\":\"platform\",\"value\":\"ptx\",\"type\":1,\"sort\":2},{\"id\":136311,\"questionId\":9029,\"eventId\":128,\"param\":\"templateCode\",\"value\":\"3038\",\"type\":1,\"sort\":2},{\"id\":136312,\"questionId\":9029,\"eventId\":128,\"param\":\"roles\",\"value\":\"3006\",\"type\":1,\"sort\":2}],\"value\":{\"name\":\"票天下_商品信息维护\",\"form\":{\"configure\":{\"formName\":\"goodsAddForm\",\"formMapper\":{\"goodName\":\"玻璃擦\"},\"goodName\":\"玻璃擦\",\"goodModel\":\"黄色\",\"goodUnit\":\"个\",\"goodPrice\":\"32.00\",\"taxRate\":\"0.03\"},\"weightMapper\":{\"goodName\":\"20\",\"goodModel\":\"20\",\"goodUnit\":\"20\",\"goodPrice\":\"20\",\"taxRate\":\"20\"},\"aggrementMapper\":{}},\"configureWidth\":\"250px\",\"scoreWidth\":\"70px\"},\"eventWeight\":10,\"standParseType\":0,\"sort\":2,\"versionStatus\":true},{\"id\":130,\"eventName\":\"票天下_购方客户信息新增编辑\",\"eventType\":1,\"eventUrl\":\"https://zledu-oss-sx.cailian.net/cjdd/course/20191220/7FC2BC95-1576771962058.png\",\"eventParam\":\"platform=ptx&templateCode={001}&roles={3001}\",\"eventTemplateUrl\":\"/#/ptx/home\",\"eventTemplatePic\":\"modelName=ticketianxia_purchase_information&modelType=formTemplate\",\"eventDesp\":\"1203wang\",\"roles\":null,\"modelType\":\"formTemplate\",\"modelName\":\"ticketianxia_purchase_information\",\"type\":true,\"dynmaicParamReqList\":[{\"id\":136313,\"questionId\":9029,\"eventId\":130,\"param\":\"platform\",\"value\":\"ptx\",\"type\":1,\"sort\":3},{\"id\":136314,\"questionId\":9029,\"eventId\":130,\"param\":\"templateCode\",\"value\":\"3038\",\"type\":1,\"sort\":3},{\"id\":136315,\"questionId\":9029,\"eventId\":130,\"param\":\"roles\",\"value\":\"3006\",\"type\":1,\"sort\":3}],\"value\":{\"name\":\"票天下_购方信息（客户信息）\",\"form\":{\"configure\":{\"formName\":\"customerMsgForm\",\"formMapper\":{\"custName\":\"北京众联合商贸有限责任公司\"},\"custName\":\"北京众联合商贸有限责任公司\",\"taxPayerId\":\"91110108096392653A6\",\"taxPayerType\":\"2\",\"bankAccount\":\"6214830120186983\",\"address\":\"北京市海淀区上地三街F座701-6号\",\"telephone\":\"010-36896242\",\"bankName\":\"招商银行上地支行\"},\"weightMapper\":{\"custName\":\"20\",\"bankName\":\"15\",\"bankAccount\":\"14\",\"taxPayerType\":\"9\",\"taxPayerId\":\"14\",\"address\":\"14\",\"telephone\":\"14\"},\"aggrementMapper\":{}},\"configureWidth\":\"250px\",\"scoreWidth\":\"70px\"},\"eventWeight\":10,\"standParseType\":0,\"sort\":3,\"versionStatus\":true},{\"id\":160,\"eventName\":\"票天下_发_票_开_具\",\"eventType\":1,\"eventUrl\":\"https://zledu-oss-sx.cailian.net/cjdd/course/20191023/8395C495-1571764254362.jpg\",\"eventParam\":\"platform=ptx&templateCode={001}&roles=3003\",\"eventTemplateUrl\":\"/api-user/ctx/enter\",\"eventTemplatePic\":\"modelType=generalVote\",\"eventDesp\":\"&roles={001}\",\"roles\":null,\"type\":true,\"modelType\":\"generalVote\",\"dynmaicParamReqList\":[{\"id\":136316,\"questionId\":9029,\"eventId\":160,\"param\":\"platform\",\"value\":\"ptx\",\"type\":1,\"sort\":4},{\"id\":136317,\"questionId\":9029,\"eventId\":160,\"param\":\"templateCode\",\"value\":\"3038\",\"type\":1,\"sort\":4},{\"id\":136318,\"questionId\":9029,\"eventId\":160,\"param\":\"roles\",\"value\":\"3006\",\"type\":1,\"sort\":4}],\"eventWeight\":60,\"value\":{\"formName\":\"saveOrOpenForm\",\"formMapper\":{\"buyName\":\"北京众联合商贸有限责任公司\",\"sellName\":\"深圳市三清商贸有限公司\"},\"VtBillport\":\"\",\"tax\":false,\"invoiceType\":\"普通发票\",\"buyName\":\"北京众联合商贸有限责任公司\",\"buyNumber\":\"91110108096392653A6\",\"buyaddress\":\"北京市海淀区上地三街F座701-6号  010-36896242\",\"buybankacc\":\"招商银行上地支行 6214830120186983\",\"sellName\":\"深圳市三清商贸有限公司\",\"saleNum\":\"9144030064027016DQ\",\"saleTel\":\"深圳市龙岗区龙岗街道南联碧新路中肯大厦4楼404-D 0755-47838327\",\"saleBank\":\"深圳平安银行联碧新路支行 6221554797461064\",\"openDate\":\"2019-12-06\",\"remark\":\"\",\"payeepsn\":\"\",\"checker\":\"\",\"pk_psn\":\"\",\"list\":[{\"goodsName\":\"*塑料制品*垃圾桶\",\"goodsPrice\":\"23.00\",\"goodsNum\":\"150\",\"goodsAmount\":\"3450.00\",\"taxRate\":\"3%\",\"zerotaxflag\":\"\",\"taxAmt\":\"103.50\",\"model\":\"脚踏式\",\"company\":\"个\"},{\"goodsName\":\"*日用杂品*清洁球\",\"goodsPrice\":\"7.00\",\"goodsNum\":\"100\",\"goodsAmount\":\"700.00\",\"taxRate\":\"3%\",\"taxAmt\":\"21.00\",\"zerotaxflag\":\"\",\"model\":\"手柄型\",\"company\":\"个\"},{\"goodsName\":\"*日用杂品*玻璃擦\",\"goodsPrice\":\"35.00\",\"goodsNum\":\"90\",\"goodsAmount\":\"3150.00\",\"taxRate\":\"3%\",\"taxAmt\":\"94.50\",\"zerotaxflag\":\"\",\"model\":\"黄色\",\"company\":\"个\"}],\"weightMapper\":{\"listMapper\":{\"goodsName\":\"20\",\"model\":\"0\",\"company\":\"0\",\"goodsPrice\":\"20\",\"goodsNum\":20,\"goodsAmount\":20,\"taxRate\":\"20\",\"zerotaxflag\":\"0\",\"taxAmt\":0},\"invoiceType\":\"10\",\"tax\":\"10\",\"buyName\":\"10\",\"sellName\":\"10\",\"list\":\"60\",\"VtBillport\":\"0\",\"buyNumber\":\"0\",\"buyaddress\":\"0\",\"buybankacc\":\"0\",\"remark\":\"0\",\"saleNum\":\"0\",\"saleTel\":\"0\",\"saleBank\":\"0\",\"payeepsn\":\"0\",\"checker\":\"0\",\"pk_psn\":\"0\"},\"aggrementMapper\":{\"list\":91,\"tax\":101,\"invoiceType\":101,\"buyName\":101,\"sellName\":101}},\"standParseType\":1,\"sort\":4,\"versionStatus\":true}]";
        formNameMap = fetchData(str2);
        WebDriverWait wait = new WebDriverWait(driver, 3);
        removeAlert();
        //输入题目编号
        List<WebElement> elements = driver.findElements(By.cssSelector(".topic_num"));
        int size = elements.size();
        System.out.println("size： " + size);
        waitTime(3000);
        elements.get(15).click();

        //点击开始答题按钮
        examHandle.startAnsweringButton();
        WebElement iframeName = driver.findElement(By.name("ifinc"));
        driver.switchTo().frame(iframeName);
        waitTime(3000);
        driver.switchTo().defaultContent();
        papers();
//        //点击发票领购菜单
//        examHandle.clickMenuReceive();
//        System.out.println("step1点击发票领购菜单成功！");
//        //点击发票类型弹出下拉框
//        examHandle.clickBtnBox();
//        System.out.println("step2点击发票类型弹框成功！");
//
//        //move到弹框上
//        WebElement element1 = driver.findElement(By.xpath("/html/body/div[3]/div[1]/div[1]/ul"));
//        Actions actions = new Actions(driver);
//        actions.moveToElement(element1).perform();
//        System.out.println("step3move成功！");
//        try {
//            Thread.sleep(2000);
//        } catch (InterruptedException e) {
//            e.printStackTrace();
//        }
////        点击普通发票
//        WebElement element2 = driver.findElement(By.xpath("/html/body/div[3]/div[1]/div[1]/ul/li[2]/span"));
//        wait.until(ExpectedConditions.elementToBeClickable(element2)).click();
//        System.out.println("step4选择普通发票类型成功！");
//        try {
//            Thread.sleep(2000);
//        } catch (InterruptedException e) {
//            e.printStackTrace();
//        }
//
//        //点击领购按钮
//        List<WebElement> linggou2 = driver.findElements(By.cssSelector("[class=\"el-form-item__content\"] button"));
//        wait.until(ExpectedConditions.elementToBeClickable(linggou2.get(0))).click();
//        try {
//            Thread.sleep(1000);
//        } catch (InterruptedException e) {
//            e.printStackTrace();
//        }
////        输入88888888
//        wait.until(ExpectedConditions.elementToBeClickable(driver.findElement(By.cssSelector("span input[class=\"el-input__inner\"]")))).sendKeys("88888888");
//        List<WebElement> click2 = driver.findElements(By.cssSelector(".el-button.el-button--primary.el-button--small"));
//        wait.until(ExpectedConditions.elementToBeClickable(click2.get(1))).click();
//        try {
//            Thread.sleep(2000);
//        } catch (InterruptedException e) {
//            e.printStackTrace();
//        }
//
//
////        输入领购日期
//        List<WebElement> data4 = driver.findElements(By.cssSelector(".el-form-item__content .el-input__inner"));
//        wait.until(ExpectedConditions.elementToBeClickable(data4.get(3))).sendKeys("2019-12-16");
////        输入领购数量
//        wait.until(ExpectedConditions.elementToBeClickable(driver.findElement(By.cssSelector("div>div[class=\"el-input el-input--small\"]>input")))).sendKeys("25");
//        wait.until(ExpectedConditions.elementToBeClickable(driver.findElement(By.cssSelector("div>div[class=\"el-input el-input--small\"]>input")))).click();
//
////        点击确定按钮
//        List<WebElement> click4 = driver.findElements(By.cssSelector(".el-dialog__footer .el-button--small"));
//        wait.until(ExpectedConditions.elementToBeClickable(click4.get(3))).click();
//        System.out.println("step5领购普通发票25张成功！");
//        try {
//            Thread.sleep(2000);
//        } catch (InterruptedException e) {
//            e.printStackTrace();
//        }
//




    }

    /**
     * 交卷
     */
    public void papers() {
        WebDriverWait wait = new WebDriverWait(driver, 5000);
        WebElement element = driver.findElement(By.xpath("//span[text()='交卷']"));
        wait.until(ExpectedConditions.elementToBeClickable(element)).click();
        element = driver.findElement(By.xpath("//div[text()='确认交卷']"));
        wait.until(ExpectedConditions.elementToBeClickable(element)).click();
        element = driver.findElement(By.xpath("//div[text()='确认交卷']"));
        wait.until(ExpectedConditions.elementToBeClickable(element)).click();

        GetScore gs  = new GetScore();
        gs.scanQuestionScoreList("104275091001","10000587","ea04ee51-e3bc-453f-b265-a44e311bb980");
    }
    //去除考试过程中作弊弹框
    private void removeAlert() {
        Actions actions = new Actions(driver);
        actions.sendKeys(Keys.F12).perform();
        waitTime(2000);
        String js = "document.getElementById('dialog').remove();";
        ((JavascriptExecutor) driver).executeScript(js);

    }

    public HashMap<String, List> fetchData(String str) {
        HashMap<String, List> formNameMap = new HashMap<>();


        System.out.println("1");
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

            if (value.get("form") != null) {
                value = (JsonObject) value.get("form");
                value = (JsonObject) value.get("configure");
            }

            ArrayList list = new ArrayList();

            Set<Map.Entry<String, JsonElement>> setValue = value.entrySet();
            for (Map.Entry<String, JsonElement> nowSetValue : setValue) {
                //输出key
                String key = nowSetValue.getKey();
                System.out.println("key--->" + key);
                list.add(key);
            }
            Object o = list.get(1);
//            System.out.println(o);
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

    //等待时间
    public void waitTime(long wait) {
        try {
            Thread.sleep(wait);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
}