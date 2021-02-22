package HomePage;

import cases.BaseDriver;
import com.google.gson.JsonArray;
import com.google.gson.JsonElement;
import com.google.gson.JsonObject;
import com.google.gson.JsonParser;
import handle.ExamHandle;
import org.openqa.selenium.*;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import java.time.Duration;
import java.util.*;
import java.util.concurrent.TimeUnit;


public class ExamTest extends BaseDriver {
    public WebDriver driver;
    ExamHandle examHandle;
    HashMap<String, Map> formNameMap1 = null;
    HashMap<String, List> formNameMap = null;

    HashMap<String, String> convetMap = new HashMap<String, String>();


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
        //仿真政务-填写领购发票
//        taxForm(formNameMap1, "taxForm");
        //仿真政务-人员在保登记
//        registrationPerson(formNameMap1, "personRegistrationForm");
        //采集
//        trainTicketForm(formNameMap, "trainTicketForm");
//       1226考（100分）上册 16题  领购发票、增加商品服务档案和客户信息、三金室内设计公司代开含税增值税纸质普通发票。
//        customerMsgForm(formNameMap, "customerMsgForm");
        //17题
        airplainTravelForm(formNameMap, "airplainTravelForm");

    }


    /**
     * 1226考 上册 第二题实操题，17
     * 北京紫霖财税共享服务中心（简称“财税共享中心”）是一家为企业提供财税咨询和代理服务的专业公司，
     * 2019年11月26日与北京四海家具有限公司（简称“四海家具公司”）签订了代理记账合同。
     * 四海家具公司是一家从事家具生产与销售的公司，为增值税一般纳税人。
     * 财税共享中心票据岗员工周明收到四海家具公司送来的12月份部分票据，为总经办人员外出开会发生的费用，
     * 公司差旅费报销采取凭票报销方式，无其他补助项目，需进行相关会计科目的税目明细辅助核算。
     * 要求：
     * （1）请为四海家具公司对相关票据进行采集、整理、审核（住宿发票、银行回单调整至其他票据类别）；
     * （2）根据相关票据采用“费用报销单”方式，编制1张记账凭证。
     */

    public void airplainTravelForm(HashMap<String, List> formNameMap, String airplainTravelForm) {
        String str2 = "[{\"id\":243,\"eventName\":\"财天下_飞机行程单票据采集\",\"eventType\":1,\"eventUrl\":\"https://zledu-oss-sx.cailian.net/cjdd/course/20191212/EC8B3DBA-1576149866401.jpg\",\"eventParam\":\"platform=ctx&templateCode={001}&roles=3001\",\"eventTemplateUrl\":\"/#/ctx/home\",\"eventTemplatePic\":\"modelName=itinerary_bill_information&modelType=formTemplate\",\"eventDesp\":\"\",\"roles\":null,\"modelType\":\"formTemplate\",\"modelName\":\"itinerary_bill_information\",\"type\":true,\"dynmaicParamReqList\":[{\"id\":136388,\"questionId\":9032,\"eventId\":243,\"param\":\"platform\",\"value\":\"ctx\",\"type\":1,\"sort\":0},{\"id\":136389,\"questionId\":9032,\"eventId\":243,\"param\":\"templateCode\",\"value\":\"3018\",\"type\":1,\"sort\":0},{\"id\":136390,\"questionId\":9032,\"eventId\":243,\"param\":\"roles\",\"value\":\"3006\",\"type\":1,\"sort\":0}],\"value\":{\"name\":\"票天下_行程单票据信息\",\"isOCR\":3,\"form\":{\"configure\":{\"formName\":\"airplainTravelForm\",\"formMapper\":{\"name\":\"周伟\",\"data\":\"2019-12-17\",\"ticketRates\":\"570\"},\"name\":\"周伟\",\"data\":\"2019-12-17\",\"ticketRates\":\"570\"},\"weightMapper\":{\"name\":\"33\",\"data\":\"33\",\"ticketRates\":\"34\"},\"aggrementMapper\":{}},\"configureWidth\":\"250px\",\"scoreWidth\":\"70px\"},\"eventWeight\":15,\"standParseType\":0,\"sort\":0,\"versionStatus\":true},{\"id\":243,\"eventName\":\"财天下_飞机行程单票据采集\",\"eventType\":1,\"eventUrl\":\"https://zledu-oss-sx.cailian.net/cjdd/course/20191212/EC8B3DBA-1576149866401.jpg\",\"eventParam\":\"platform=ctx&templateCode={001}&roles=3001\",\"eventTemplateUrl\":\"/#/ctx/home\",\"eventTemplatePic\":\"modelName=itinerary_bill_information&modelType=formTemplate\",\"eventDesp\":\"\",\"roles\":null,\"modelType\":\"formTemplate\",\"modelName\":\"itinerary_bill_information\",\"type\":true,\"dynmaicParamReqList\":[{\"id\":136391,\"questionId\":9032,\"eventId\":243,\"param\":\"platform\",\"value\":\"ctx\",\"type\":1,\"sort\":1},{\"id\":136392,\"questionId\":9032,\"eventId\":243,\"param\":\"templateCode\",\"value\":\"3018\",\"type\":1,\"sort\":1},{\"id\":136393,\"questionId\":9032,\"eventId\":243,\"param\":\"roles\",\"value\":\"3006\",\"type\":1,\"sort\":1}],\"value\":{\"name\":\"票天下_行程单票据信息\",\"isOCR\":3,\"form\":{\"configure\":{\"formName\":\"airplainTravelForm\",\"formMapper\":{\"name\":\"周伟\",\"data\":\"2019-12-20\",\"ticketRates\":\"530.00\"},\"name\":\"周伟\",\"data\":\"2019-12-20\",\"ticketRates\":\"530.00\"},\"weightMapper\":{\"name\":\"33\",\"data\":\"33\",\"ticketRates\":\"34\"},\"aggrementMapper\":{}},\"configureWidth\":\"250px\",\"scoreWidth\":\"70px\"},\"eventWeight\":15,\"standParseType\":0,\"sort\":1,\"versionStatus\":true},{\"id\":168,\"eventName\":\"财天下凭证记账分录\",\"eventType\":1,\"eventUrl\":\"https://zledu-oss-sx.cailian.net/cjdd/course/20191219/1653EB79-1576768309975.png\",\"eventParam\":\"platform=ctx&templateCode={001}&roles=3002\",\"eventTemplateUrl\":\"/#/ctx/home\",\"eventTemplatePic\":\"modelType=accountingVouchers\",\"eventDesp\":\"\",\"roles\":null,\"type\":true,\"modelType\":\"accountingVouchers\",\"dynmaicParamReqList\":[{\"id\":136394,\"questionId\":9032,\"eventId\":168,\"param\":\"platform\",\"value\":\"ctx\",\"type\":1,\"sort\":2},{\"id\":136395,\"questionId\":9032,\"eventId\":168,\"param\":\"templateCode\",\"value\":\"3018\",\"type\":1,\"sort\":2},{\"id\":136396,\"questionId\":9032,\"eventId\":168,\"param\":\"roles\",\"value\":\"3006\",\"type\":1,\"sort\":2}],\"eventWeight\":70,\"value\":{\"formName\":\"manualEvidenceForm\",\"formMapper\":[{\"accountId\":3925316080960653,\"amountDr\":\"2122.17000000\",\"amountCr\":\"\"},{\"accountId\":3925316080895019,\"amountDr\":\"90.83000000\",\"amountCr\":\"\"},{\"accountId\":3925316080829441,\"amountDr\":\"\",\"amountCr\":\"2213.00000000\"}],\"docType\":\"记\",\"docSourceTypeId\":105,\"attachedVoucherNum\":\"4\",\"voucherDate\":\"2019-12-21\",\"entrys\":[{\"summary\":\"报销差旅费\",\"accountId\":3925316080960653,\"amountDr\":\"2122.17000000\",\"amountCr\":\"\"},{\"summary\":\"报销差旅费\",\"accountId\":3925316080895019,\"amountDr\":\"90.83000000\",\"amountCr\":\"\",\"taxItemName\":\"旅客运输\"},{\"summary\":\"报销差旅费\",\"accountId\":3925316080829441,\"amountDr\":\"\",\"amountCr\":\"2213.00000000\"}],\"weightMapper\":{\"voucherDate\":\"15\",\"summary\":\"0\",\"entrys\":\"80\",\"attachedVoucherNum\":\"5\",\"docSourceTypeId\":\"0\"},\"aggrementMapper\":{\"entrys\":104,\"voucherDate\":1,\"docSourceTypeId\":90}},\"standParseType\":1,\"sort\":2,\"versionStatus\":true}]";
        formNameMap = fetchData(str2);
        removeAlert();

        //输入题目编号
        List<WebElement> elements = driver.findElements(By.cssSelector(".topic_num"));
        int size = elements.size();
        System.out.println(size + "size。。。。。。。。。。");
        elements.get(16).click();

        //点击开始答题按钮
        examHandle.startAnsweringButton();
        WebElement iframeName = driver.findElement(By.name("ifinc"));
        driver.switchTo().frame(iframeName);
        try {
            Thread.sleep(3000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        WebDriverWait wait = new WebDriverWait(driver, 3);
        WebElement element;
        List<WebElement> elements1;
        JavascriptExecutor js1 = null;
/*   --------------------------------------------------------------------------------->
        //点击票据采集菜单
        examHandle.clickPJCJ();
        try {
            Thread.sleep(2000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
       js1 = (JavascriptExecutor) driver;
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
        //采集页面--确定按钮
        js1.executeScript("return document.getElementsByClassName(\"el-button el-button--primary el-button--small\")[0].click();");
        System.out.println("采集页面-确定按钮成功！---采集成功");
        try {
            Thread.sleep(2000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        //点击进项发票项--调整发票类型为其他票据


       *//* //点击其他票据
        js1.executeScript("return document.getElementsByClassName('invoice-type-tab')[0].getElementsByClassName('classify-item actives')[0].click();");*//*
        //点击进项发票
        element = driver.findElement(By.xpath("//span[text()='进项发票']"));
        wait.until(ExpectedConditions.elementToBeClickable(element)).click();
        try {
            Thread.sleep(2000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        //2.点击调整发票类型按钮
        element = driver.findElement(By.xpath("//button/span[text()='调整发票类型']"));
        wait.until(ExpectedConditions.elementToBeClickable(element)).click();
        System.out.println("点击调整发票类型按钮成功！");
        try {
            Thread.sleep(2000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        //3.先点击列表
        element = driver.findElement(By.xpath("//div[@class='el-input el-input--mini el-input--suffix']/input"));
        wait.until(ExpectedConditions.elementToBeClickable(element)).click();
        try {
            Thread.sleep(2000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        //4.点击完列表后再move到列表上
        js1.executeScript("return document.getElementsByClassName('el-scrollbar__view el-select-dropdown__list')[2];");
        try {
            Thread.sleep(2000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        //选择其他票据类型并点击
        element = driver.findElement(By.xpath("/html/body/div[4]/div[1]/div[1]/ul/li[1]/span"));
        wait.until(ExpectedConditions.elementToBeClickable(element)).click();
        //4.点击确认按钮
        js1.executeScript("return document.getElementsByClassName(\"el-button el-button--primary el-button--small\")[1].click();");
        //5.点击//span[text()='中国工商银行回单']
        element = driver.findElement(By.xpath("//span[text()='中国工商银行回单']"));
        wait.until(ExpectedConditions.elementToBeClickable(element)).click();
        //6.---复用
        //2.点击调整发票类型按钮
        //2.点击调整发票类型按钮
        element = driver.findElement(By.xpath("//button/span[text()='调整发票类型']"));
        wait.until(ExpectedConditions.elementToBeClickable(element)).click();
        System.out.println("点击调整发票类型按钮成功！");
        try {
            Thread.sleep(2000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        //3.先点击列表
        element = driver.findElement(By.xpath("//div[@class='el-input el-input--mini el-input--suffix']/input"));
        wait.until(ExpectedConditions.elementToBeClickable(element)).click();
        try {
            Thread.sleep(2000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        //4.点击完列表后再move到列表上
        js1.executeScript("return document.getElementsByClassName('el-scrollbar__view el-select-dropdown__list')[2];");
        try {
            Thread.sleep(2000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        //选择其他票据类型并点击
        element = driver.findElement(By.xpath("/html/body/div[4]/div[1]/div[1]/ul/li[1]/span"));
        wait.until(ExpectedConditions.elementToBeClickable(element)).click();
        //4.点击确认按钮
        js1.executeScript("return document.getElementsByClassName(\"el-button el-button--primary el-button--small\")[1].click();");
        try {
            Thread.sleep(2000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        //7.审核-其他票据,点击其他票据tab
        element = driver.findElement(By.xpath("//span[@class='classify-item']/*[text()='其他票据']"));
        wait.until(ExpectedConditions.elementToBeClickable(element)).click();
        try {
            Thread.sleep(3000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        //8.循环当前票据，并每个票据进行点击操作
        //获取多个票据
        elements1 = driver.findElements(By.cssSelector(".img.undefined"));
        System.out.println("img undefined 的size：" + elements1.size());
        for (int i = 0; i < elements1.size(); i++) {
            elements1.get(i).click();
            try {
                Thread.sleep(1000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            element = driver.findElement(By.xpath("//span[text()='审核']"));
            wait.until(ExpectedConditions.elementToBeClickable(element)).click();
            element = driver.findElement(By.cssSelector(".el-button.el-button--default.el-button--small.el-button--primary"));
            wait.until(ExpectedConditions.elementToBeClickable(element)).click();
            try {
                Thread.sleep(2000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }

        //点击行程单
        js1.executeScript("return document.getElementsByClassName('title')[4].click();");
        try {
            Thread.sleep(1000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        elements1 = driver.findElements(By.cssSelector(".img.undefined"));
        System.out.println("img undefined 的size：" + elements1.size());
        for (int i = 0; i < elements1.size(); i++) {
            elements1.get(i).click();
            try {
                Thread.sleep(1000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            if (i == 0) {
                js1.executeScript("return document.getElementsByClassName('el-input__inner')[6].value=1040;");

            }else {
                js1.executeScript("return document.getElementsByClassName('el-input__inner')[6].value=1250;");
            }
            element = driver.findElement(By.xpath("//span[text()='保存']"));
            wait.until(ExpectedConditions.elementToBeClickable(element)).click();
            try {
                Thread.sleep(1000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            element = driver.findElement(By.xpath("//span[text()='审核']"));
            wait.until(ExpectedConditions.elementToBeClickable(element)).click();
            element = driver.findElement(By.cssSelector(".el-button.el-button--default.el-button--small.el-button--primary"));
            wait.until(ExpectedConditions.elementToBeClickable(element)).click();
            try {
                Thread.sleep(1000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }


        //点击票据制单菜单
        element = driver.findElement(By.cssSelector(".tab-text.active"));
        wait.until(ExpectedConditions.elementToBeClickable(element)).click();
        try {
            Thread.sleep(1000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        --------------------------------------------------------->
        */

        //费用报销单菜单
        element = driver.findElement(By.xpath("//span[text()='费用报销单']"));
        wait.until(ExpectedConditions.elementToBeClickable(element)).click();
        try {
            Thread.sleep(1000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        //选择费用类型
        element = driver.findElement(By.cssSelector(".content-container .charge-expend .el-table__body .el-table__row .el-table_1_column_5 .cell"));
        wait.until(ExpectedConditions.elementToBeClickable(element)).click();
        try {
            Thread.sleep(1000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        //move到请选择列上
        element = driver.findElement(By.cssSelector("[class='el-select-dropdown el-popper'] [class='el-select-dropdown__wrap el-scrollbar__wrap']"));
        Actions actions = new Actions(driver);
        actions.moveToElement(element).perform();

        //点击国内航空铁路旅客运输服务--项
        element = driver.findElement(By.xpath("//span[text()='国内航空铁路旅客运输服务']"));
        wait.until(ExpectedConditions.elementToBeClickable(element)).click();
        try {
            Thread.sleep(1000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        //点击发票类型的列表，展示列表
        element = driver.findElement(By.cssSelector(".content-container .charge-expend .el-table__body .el-table__row .el-table_1_column_10 .cell"));
        wait.until(ExpectedConditions.elementToBeClickable(element)).click();
        try {
            Thread.sleep(1000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        //move到请选择列上
        element = driver.findElement(By.cssSelector("[class='el-select-dropdown el-popper'] [class='el-select-dropdown__wrap el-scrollbar__wrap']"));
        actions.moveToElement(element).perform();
        //点击行程单
        element = driver.findElement(By.xpath("//span[text()='行程单']"));
        wait.until(ExpectedConditions.elementToBeClickable(element)).click();
        //点击附件下的upload按钮
        element = driver.findElement(By.cssSelector(".accessory .upload"));
        wait.until(ExpectedConditions.elementToBeClickable(element)).click();
        try {
            Thread.sleep(1000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        //定位行程单
        element = driver.findElement(By.cssSelector(".item-img.active-img .img"));
        //并双击
        actions.doubleClick(element).perform();
        //点击保存
        element = driver.findElement(By.cssSelector(".el-button.all-button-border-color.all-button-small.save.el-button--default.el-button--mini"));
        wait.until(ExpectedConditions.elementToBeClickable(element)).click();
        try {
            Thread.sleep(1000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        //添加第二条差旅费
        //点击+号
        element = driver.findElement(By.cssSelector("el-icon-circle-plus-outline"));
        wait.until(ExpectedConditions.elementToBeClickable(element)).click();
        try {
            Thread.sleep(1000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }


        System.out.println("-------------------------------------------->");



    }


    /**
     * 1226考（100分）上册 16题
     * 北京紫霖财税共享服务中心（简称“财税共享中心”）是一家为企业提供财税咨询和代理服务的专业公司，2019年11月20日与宁波三金室内设计有限公司（简称“三金室内设计公司”）签订了代理记账合同。
     * 三金室内设计公司是一家从事室内设计的公司，为增值税小规模纳税人。公司主要服务内容为：设计服务（商品和服务税收分类：其他设计服务），计量单位：次，参考单价：8000元，税率3%。
     * 2019年12月16日三金室内设计公司与杭州味美餐饮管理有限公司签订了室内设计合同，合同注明1次含税设计服务9000元。设计服务已结束，款项已结清，杭州味美餐饮管理有限公司要求开具一张增值税普通发票。
     * 客户相关信息：杭州味美餐饮管理有限公司，纳税人识别号：913300007434837872，为增值税小规模纳税人；营业地址：浙江省杭州市西湖区紫荆花路E座406号；电话：0571-81022890；开户银行：中国建设银行杭州支行；银行账号：6217002635478980768。
     * （1）请在“票天下”领取25张发票（税控盘密码：88888888，领购日期：2019年12月16日）；
     * （2）根据业务需求增加商品服务档案和客户信息；
     * （3）请为三金室内设计公司代开含税增值税纸质普通发票。
     *
     * @param formNameMap
     * @param customerMsgForm
     */
    public void customerMsgForm(HashMap<String, List> formNameMap, String customerMsgForm) {
        String str2 = "[{\"id\":128,\"eventName\":\"票天下_商品信息新增编辑\",\"eventType\":1,\"eventUrl\":\"https://zledu-oss-sx.cailian.net/cjdd/course/20191220/4A232F1F-1576771830760.png\",\"eventParam\":\"platform=ptx&templateCode={001}&roles=3001\",\"eventTemplateUrl\":\"/#/ptx/home\",\"eventTemplatePic\":\"modelName=commodity_information_maintenance&modelType=formTemplate\",\"eventDesp\":\"https://ctxedudxapi.cailian.net\",\"roles\":null,\"modelType\":\"formTemplate\",\"modelName\":\"commodity_information_maintenance\",\"type\":true,\"dynmaicParamReqList\":[{\"id\":156697,\"questionId\":9038,\"eventId\":128,\"param\":\"platform\",\"value\":\"ptx\",\"type\":1,\"sort\":0},{\"id\":156698,\"questionId\":9038,\"eventId\":128,\"param\":\"templateCode\",\"value\":\"3039\",\"type\":1,\"sort\":0},{\"id\":156699,\"questionId\":9038,\"eventId\":128,\"param\":\"roles\",\"value\":\"3006\",\"type\":1,\"sort\":0}],\"value\":{\"name\":\"票天下_商品信息维护\",\"form\":{\"configure\":{\"formName\":\"goodsAddForm\",\"formMapper\":{\"goodName\":\"设计服务\"},\"goodName\":\"设计服务\",\"goodPrice\":\"8000.00\",\"goodUnit\":\"次\",\"taxRate\":\"0.03\",\"goodModel\":\"\"},\"weightMapper\":{\"goodName\":\"20\",\"goodModel\":\"20\",\"goodUnit\":\"20\",\"goodPrice\":\"20\",\"taxRate\":\"20\"},\"aggrementMapper\":{}},\"configureWidth\":\"250px\",\"scoreWidth\":\"70px\"},\"eventWeight\":15,\"standParseType\":0,\"sort\":0,\"versionStatus\":true},{\"id\":130,\"eventName\":\"票天下_购方客户信息新增编辑\",\"eventType\":1,\"eventUrl\":\"https://zledu-oss-sx.cailian.net/cjdd/course/20191220/7FC2BC95-1576771962058.png\",\"eventParam\":\"platform=ptx&templateCode={001}&roles={3001}\",\"eventTemplateUrl\":\"/#/ptx/home\",\"eventTemplatePic\":\"modelName=ticketianxia_purchase_information&modelType=formTemplate\",\"eventDesp\":\"1203wang\",\"roles\":null,\"modelType\":\"formTemplate\",\"modelName\":\"ticketianxia_purchase_information\",\"type\":true,\"dynmaicParamReqList\":[{\"id\":156700,\"questionId\":9038,\"eventId\":130,\"param\":\"platform\",\"value\":\"ptx\",\"type\":1,\"sort\":1},{\"id\":156701,\"questionId\":9038,\"eventId\":130,\"param\":\"templateCode\",\"value\":\"3039\",\"type\":1,\"sort\":1},{\"id\":156702,\"questionId\":9038,\"eventId\":130,\"param\":\"roles\",\"value\":\"3006\",\"type\":1,\"sort\":1}],\"value\":{\"name\":\"票天下_购方信息（客户信息）\",\"form\":{\"configure\":{\"formName\":\"customerMsgForm\",\"formMapper\":{\"custName\":\"杭州味美餐饮管理有限公司\"},\"taxPayerType\":\"2\",\"custName\":\"杭州味美餐饮管理有限公司\",\"taxPayerId\":\"913300007434837872\",\"address\":\"浙江省杭州市西湖区紫荆花路E座406号\",\"telephone\":\"0571-81022890\",\"bankName\":\"中国建设银行杭州支行\",\"bankAccount\":\"6217002635478980768\"},\"weightMapper\":{\"custName\":\"20\",\"bankName\":\"15\",\"bankAccount\":\"20\",\"taxPayerType\":\"0\",\"taxPayerId\":\"17\",\"address\":\"14\",\"telephone\":\"14\"},\"aggrementMapper\":{}},\"configureWidth\":\"250px\",\"scoreWidth\":\"70px\"},\"eventWeight\":15,\"standParseType\":0,\"sort\":1,\"versionStatus\":true},{\"id\":160,\"eventName\":\"票天下_发_票_开_具\",\"eventType\":1,\"eventUrl\":\"https://zledu-oss-sx.cailian.net/cjdd/course/20191023/8395C495-1571764254362.jpg\",\"eventParam\":\"platform=ptx&templateCode={001}&roles=3003\",\"eventTemplateUrl\":\"/api-user/ctx/enter\",\"eventTemplatePic\":\"modelType=generalVote\",\"eventDesp\":\"&roles={001}\",\"roles\":null,\"type\":true,\"modelType\":\"generalVote\",\"dynmaicParamReqList\":[{\"id\":156703,\"questionId\":9038,\"eventId\":160,\"param\":\"platform\",\"value\":\"ptx\",\"type\":1,\"sort\":2},{\"id\":156704,\"questionId\":9038,\"eventId\":160,\"param\":\"templateCode\",\"value\":\"3039\",\"type\":1,\"sort\":2},{\"id\":156705,\"questionId\":9038,\"eventId\":160,\"param\":\"roles\",\"value\":\"3006\",\"type\":1,\"sort\":2}],\"eventWeight\":70,\"value\":{\"formName\":\"saveOrOpenForm\",\"formMapper\":{\"buyName\":\"杭州味美餐饮管理有限公司\",\"sellName\":\"宁波三金室内设计有限公司\"},\"VtBillport\":\"\",\"tax\":true,\"invoiceType\":\"普通发票\",\"buyName\":\"杭州味美餐饮管理有限公司\",\"buyNumber\":\"913300007434837872\",\"buyaddress\":\"浙江省杭州市西湖区紫荆花路E座406号 0571-81022890\",\"buybankacc\":\"中国建设银行杭州支行 6217002635478980768\",\"sellName\":\"宁波三金室内设计有限公司\",\"saleNum\":\"91330212772343855K\",\"saleTel\":\"浙江省宁波市鄞州区贺丞路500号 0574-87292733\",\"saleBank\":\"中国建设银行宁波支行 6217002635782312312\",\"openDate\":\"2019-12-16\",\"remark\":\"\",\"payeepsn\":\"\",\"checker\":\"\",\"pk_psn\":\"\",\"list\":[{\"goodsName\":\"*设计服务*设计服务\",\"goodsPrice\":9000,\"goodsNum\":\"1\",\"goodsAmount\":\"9000.00\",\"taxRate\":\"3%\",\"zerotaxflag\":\"\",\"taxAmt\":\"262.14\",\"company\":\"次\"}],\"weightMapper\":{\"listMapper\":{\"goodsName\":\"20\",\"model\":\"0\",\"company\":\"0\",\"goodsPrice\":\"20\",\"goodsNum\":20,\"goodsAmount\":20,\"taxRate\":\"20\",\"zerotaxflag\":\"0\",\"taxAmt\":0},\"invoiceType\":\"10\",\"tax\":\"10\",\"buyName\":\"10\",\"sellName\":\"10\",\"list\":\"60\",\"VtBillport\":\"0\",\"buyNumber\":\"0\",\"buyaddress\":\"0\",\"buybankacc\":\"0\",\"remark\":\"0\",\"saleNum\":\"0\",\"saleTel\":\"0\",\"saleBank\":\"0\",\"payeepsn\":\"0\",\"checker\":\"0\",\"pk_psn\":\"0\"},\"aggrementMapper\":{\"list\":91,\"tax\":101,\"invoiceType\":101,\"buyName\":101,\"sellName\":101}},\"standParseType\":1,\"sort\":2,\"versionStatus\":true}]";
        formNameMap = fetchData(str2);
        removeAlert();

        //输入题目编号
        List<WebElement> elements = driver.findElements(By.cssSelector(".topic_num"));
        int size = elements.size();
        System.out.println(size + "size。。。。。。。。。。");
        elements.get(15).click();

        //点击开始答题按钮
        examHandle.startAnsweringButton();
        WebElement iframeName = driver.findElement(By.name("ifinc"));
        driver.switchTo().frame(iframeName);
        try {
            Thread.sleep(3000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        WebDriverWait wait = new WebDriverWait(driver, 3);
        WebElement element;
        //点击发票领购菜单
        /*wait.until(ExpectedConditions.elementToBeClickable(driver.findElement(By.cssSelector("div~ul>li>i[class=\"el-icon-search\"]")))).click();
        System.out.println("step1点击发票领购菜单成功！");
//        点击发票类型弹出下拉框
        element = driver.findElement(By.xpath("//*[@id=\"app\"]/div[1]/div/div/div/div[2]/div[1]/div[2]/div/div[1]/div[1]/form/div[2]/div/div/div/input"));
        wait.until(ExpectedConditions.elementToBeClickable(element)).click();
        System.out.println("step2点击发票类型弹框成功！");
        try {
            Thread.sleep(2000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

//        move到弹框上
        WebElement element1 = driver.findElement(By.xpath("/html/body/div[3]/div[1]/div[1]/ul"));
        Actions actions = new Actions(driver);
        actions.moveToElement(element1).perform();
        System.out.println("step3move成功！");
        try {
            Thread.sleep(2000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
//        点击普通发票
        WebElement element2 = driver.findElement(By.xpath("/html/body/div[3]/div[1]/div[1]/ul/li[2]/span"));
        wait.until(ExpectedConditions.elementToBeClickable(element2)).click();
        System.out.println("step4选择普通发票类型成功！");
        try {
            Thread.sleep(2000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        //点击领购按钮
        List<WebElement> linggou2 = driver.findElements(By.cssSelector("[class=\"el-form-item__content\"] button"));
        wait.until(ExpectedConditions.elementToBeClickable(linggou2.get(0))).click();
        try {
            Thread.sleep(1000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
//        输入88888888
        wait.until(ExpectedConditions.elementToBeClickable(driver.findElement(By.cssSelector("span input[class=\"el-input__inner\"]")))).sendKeys("88888888");
        List<WebElement> click2 = driver.findElements(By.cssSelector(".el-button.el-button--primary.el-button--small"));
        wait.until(ExpectedConditions.elementToBeClickable(click2.get(1))).click();
        try {
            Thread.sleep(2000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }


//        输入领购日期
        List<WebElement> data4 = driver.findElements(By.cssSelector(".el-form-item__content .el-input__inner"));
        wait.until(ExpectedConditions.elementToBeClickable(data4.get(3))).sendKeys("2019-12-16");
//        输入领购数量
        wait.until(ExpectedConditions.elementToBeClickable(driver.findElement(By.cssSelector("div>div[class=\"el-input el-input--small\"]>input")))).sendKeys("25");
        wait.until(ExpectedConditions.elementToBeClickable(driver.findElement(By.cssSelector("div>div[class=\"el-input el-input--small\"]>input")))).click();

//        点击确定按钮
        List<WebElement> click4 = driver.findElements(By.cssSelector(".el-dialog__footer .el-button--small"));
        wait.until(ExpectedConditions.elementToBeClickable(click4.get(3))).click();
        System.out.println("step5领购普通发票25张成功！");
        try {
            Thread.sleep(2000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }*/

//        点击商品服务档案菜单
        WebElement element3 = driver.findElement(By.cssSelector(".el-icon-box"));
        wait.until(ExpectedConditions.elementToBeClickable(element3)).click();
        System.out.println("step1点击商品服务档案菜单成功！");
        try {
            Thread.sleep(2000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

//        输入关键字进行过滤
        WebElement element4 = driver.findElement(By.cssSelector("div[class=\"goods-main\"]>div input[type=\"text\"]"));
        wait.until(ExpectedConditions.elementToBeClickable(element4)).sendKeys("设计服务");
        System.out.println("输入设计服务关键字成功！");
        WebElement element5 = driver.findElement(By.xpath("//*[@id=\"app\"]/div[1]/div/div/div/div[2]/div[1]/div[2]/div/div[2]/div[1]/div[2]/div[2]/div[3]/div[2]/div[4]/div[2]/div[3]/div[2]/div[1]/div[2]/div[4]/div/span[2]"));
        wait.until(ExpectedConditions.elementToBeClickable(element5)).click();
        System.out.println("点击其他设计服务");
//        点击新增按钮
        WebElement element6 = driver.findElement(By.xpath("//*[@id=\"app\"]/div[1]/div/div/div/div[2]/div[1]/div[2]/div/div[1]/div[1]/button[2]"));
        wait.until(ExpectedConditions.elementToBeClickable(element6)).click();
        System.out.println("点击新增按钮成功！");
        try {
            Thread.sleep(2000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

//        弹出的新增商品页面---输入商品服务名称
//        WebElement element7 = driver.findElement(By.cssSelector("div[class=\"el-form-item is-error is-required el-form-item--small\"] input"));
        List<WebElement> elements1 = driver.findElements(By.cssSelector("[class=\"el-dialog__body\"] input[type=\"text\"]"));
        WebElement shangpinfuwuName = elements1.get(1);
        wait.until(ExpectedConditions.elementToBeClickable(shangpinfuwuName)).sendKeys("设计服务");
//        输入计量单位
        WebElement element8 = driver.findElement(By.xpath("//*[@id=\"app\"]/div[1]/div/div/div/div[2]/div[1]/div[2]/div/div[2]/div[2]/div[2]/div/div/div[2]/div/form/div[3]/div/div/input"));
        wait.until(ExpectedConditions.elementToBeClickable(element8)).sendKeys("台");
        System.out.println("输入计量单位成功！");

        WebElement element9 = driver.findElement(By.xpath("//*[@id=\"app\"]/div[1]/div/div/div/div[2]/div[1]/div[2]/div/div[2]/div[2]/div[2]/div/div/div[2]/div/form/div[5]/div/div[1]/input"));
        wait.until(ExpectedConditions.elementToBeClickable(element9)).sendKeys("8000");
        System.out.println("输入参考单价成功！");

        WebElement element10 = driver.findElement(By.xpath("//*[@id=\"app\"]/div[1]/div/div/div/div[2]/div[1]/div[2]/div/div[2]/div[2]/div[2]/div/div/div[2]/div/form/div[6]/div/div/div/input"));
        wait.until(ExpectedConditions.elementToBeClickable(element10)).sendKeys("3");
        System.out.println("输入税率成功");


        WebElement element11 = driver.findElement(By.xpath("//*[@id=\"app\"]/div[1]/div/div/div/div[2]/div[1]/div[2]/div/div[2]/div[2]/div[2]/div/div/div[3]/span/button[2]"));
        wait.until(ExpectedConditions.elementToBeClickable(element11)).click();
        System.out.println("新增商品页面输入完成，点击确定按钮成功！");

        try {
            Thread.sleep(2000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        //客户信息管理菜单
        element = driver.findElement(By.cssSelector("[class=\"el-icon-s-custom\"]"));
        wait.until(ExpectedConditions.elementToBeClickable(element)).click();
        System.out.println("点击客户信息管理菜单成功！");
        try {
            Thread.sleep(3000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
//        点击新增按钮
        element = driver.findElement(By.xpath("//*[@id=\"app\"]/div[1]/div/div/div/div[2]/div[1]/div[2]/div/div[1]/div[1]/div[1]/button[1]"));
        wait.until(ExpectedConditions.elementToBeClickable(element)).click();
        System.out.println("点击新增按钮成功！");

        List<WebElement> elements2 = driver.findElements(By.cssSelector("[class=\"customer-info\"] [class=\"el-input__inner\"]"));
        for (int i = 2; i < elements2.size(); i++) {
            if (i >= 3 && i < 13) {
                elements2.get(i).sendKeys("111111111111111");
            }
        }
        System.out.println("输入客户名称等信息成功!");

        element = driver.findElement(By.xpath("//*[@id=\"app\"]/div[1]/div/div/div/div[2]/div[1]/div[2]/div/div[2]/div/div[2]/form/div[4]/div/div/div/div/input"));
        wait.until(ExpectedConditions.elementToBeClickable(element)).clear();
        wait.until(ExpectedConditions.elementToBeClickable(element)).sendKeys("13212121212");

        element = driver.findElement(By.xpath("//*[@id=\"app\"]/div[1]/div/div/div/div[2]/div[1]/div[2]/div/div[2]/div/div[1]/button[1]"));
        wait.until(ExpectedConditions.elementToBeClickable(element)).click();
        System.out.println("点击保存按钮成功！");


//        点击发票开具菜单

        element = driver.findElement(By.cssSelector("i[class=\"el-icon-date\"]"));
        wait.until(ExpectedConditions.elementToBeClickable(element)).click();
        System.out.println("点击发票开具菜单成功！");
        try {
            Thread.sleep(2000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        //点击新增按钮
        element = driver.findElement(By.xpath("//*[@id=\"app\"]/div[1]/div/div/div/div[2]/div[1]/div[2]/div/div/div[1]/div[1]/button[1]"));
        wait.until(ExpectedConditions.elementToBeClickable(element)).click();
        System.out.println("点击新增按钮成功！");
        try {
            Thread.sleep(2000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        //点击名称和货物或应税劳务、服务名称
        List<WebElement> elements10 = driver.findElements(By.cssSelector("[class=\"row-input el-input el-input--mini el-input--suffix\"]>input"));
        wait.until(ExpectedConditions.elementToBeClickable(elements10.get(0))).click();

        element = driver.findElement(By.cssSelector(".buy-name-dialog .el-dialog__wrapper .el-dialog__body"));
        Actions actions = new Actions(driver);
        actions.moveToElement(element).perform();

        try {
            Thread.sleep(2000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        //选择客户
//        element = driver.findElement(By.cssSelector("[class='el-table__row']>[class='el-table_11_column_108 is-center']"));
        element = driver.findElement(By.xpath("//*[@id=\"app\"]/div[1]/div/div/div/div[2]/div[1]/div[2]/div/div/div/div[4]/div/div/div[2]/div/div[2]/div/div[3]/table/tbody/tr/td[2]/div"));
        wait.until(ExpectedConditions.elementToBeClickable(element)).click();

        try {
            Thread.sleep(2000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        //选择货物或应税劳务、服务名称
        wait.until(ExpectedConditions.elementToBeClickable(elements10.get(1))).click();
        try {
            Thread.sleep(2000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        element = driver.findElement(By.xpath("//*[@id=\"app\"]/div[1]/div/div/div/div[2]/div[1]/div[2]/div/div/div/div[5]/div/div/div[2]/div/div[2]/div[2]/div/div[3]/table/tbody/tr[2]/td[2]/div"));
        wait.until(ExpectedConditions.elementToBeClickable(element)).click();
        //输入数量
        element = driver.findElement(By.xpath("//*[@id=\"app\"]/div[1]/div/div/div/div[2]/div[1]/div[2]/div/div/div/div[3]/div/div/div[2]/div/div[3]/table/tbody/tr/td[5]/div/div/input"));
        wait.until(ExpectedConditions.elementToBeClickable(element)).sendKeys("2");
        System.out.println("输入数量成功");
        //点击暂存
        element = driver.findElement(By.xpath("//*[@id=\"app\"]/div[1]/div/div/div/div[2]/div[1]/div[2]/div/div/div/div[1]/button[1]"));
        wait.until(ExpectedConditions.elementToBeClickable(element)).click();
        System.out.println("点击暂存成功！");

        //刷新页面，回到答题首页
        driver.navigate().refresh();
        driver.manage().window().fullscreen();
        try {
            Thread.sleep(2000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        System.out.println("回到首页------》");

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

    public void test(HashMap<String, Map> formNameMap1, String taxForm) {
        String str2 = "[{\"id\":134,\"eventName\":\"仿真-信息公示-2-股东及出资信息\",\"eventType\":0,\"eventUrl\":\"https://cjddcloud-test.oss-cn-beijing.aliyuncs.com/cjdd/course/20191022/00309B4C-1571728914742.jpg\",\"eventParam\":\"platform=dummy&templateCode=001&roles=3001\",\"eventTemplateUrl\":\"https://dummyedutest.cailian.net/#/fillDeclare\",\"eventDesp\":\"王。\",\"roles\":null,\"modelType\":\"tableTemplate\",\"modelName\":\"contribution_information\",\"type\":true,\"dynmaicParamReqList\":[{\"param\":\"platform\",\"value\":\"dummy\",\"type\":\"1\"},{\"param\":\"templateCode\",\"value\":\"001\",\"type\":\"1\"},{\"param\":\"roles\",\"value\":\"3001\",\"type\":\"1\"}],\"value\":{\"name\":\"股东及出资信息\",\"model\":\"信息公示 - 股东及出资信息\",\"form\":{\"configure\":{\"formName\":\"ShareholdersContributionInformation_2\",\"tableList\":[]},\"weightMapper\":{\"tableList\":\"100\",\"tableListMapper\":{\"Shareholder\":\"15\",\"SubscribedCapitalContribution\":\"14\",\"SubscribedCapitalContributionTime\":\"14\",\"SubscribedCapitalContributionMode\":\"14\",\"PaidAdvance\":\"14\",\"PaidAdvanceTime\":\"14\",\"PaidAdvanceTimeMode\":\"15\"}},\"aggrementMapper\":{\"tableList\":95,\"SubscribedCapitalContributionMode\":6,\"PaidAdvanceTimeMode\":6}}},\"eventWeight\":\"10\",\"standParseType\":0,\"sort\":0},{\"id\":137,\"eventName\":\"仿真-信息公示-3-网站或网店信息\",\"eventType\":0,\"eventUrl\":\"https://cjddcloud-test.oss-cn-beijing.aliyuncs.com/cjdd/course/20191022/90269501-1571732065586.jpg\",\"eventParam\":\"platform=dummy&templateCode=001&roles=3001\",\"eventTemplateUrl\":\"https://dummyedutest.cailian.net/#/fillDeclare\",\"eventDesp\":\"王。\",\"roles\":null,\"modelType\":\"tableTemplate\",\"modelName\":\"shop_information\",\"type\":true,\"dynmaicParamReqList\":[{\"param\":\"platform\",\"value\":\"dummy\",\"type\":\"1\"},{\"param\":\"templateCode\",\"value\":\"001\",\"type\":\"1\"},{\"param\":\"roles\",\"value\":\"3001\",\"type\":\"1\"}],\"value\":{\"name\":\"网站或网店信息\",\"model\":\"信息公示 - 网站或网店信息\",\"form\":{\"configure\":{\"formName\":\"WebsiteShopInformation_3\",\"tableList\":[]},\"weightMapper\":{\"tableList\":\"100\",\"tableListMapper\":{\"type\":\"33\",\"name\":\"33\",\"Website\":\"34\"}},\"aggrementMapper\":{\"tableList\":95}}},\"eventWeight\":\"10\",\"standParseType\":0,\"sort\":1},{\"id\":139,\"eventName\":\"仿真-信息公示4 - 股权变更信息\",\"eventType\":0,\"eventUrl\":\"https://cjddcloud-test.oss-cn-beijing.aliyuncs.com/cjdd/course/20191022/CEEF425C-1571732154061.png\",\"eventParam\":\"platform=dummy&templateCode=001&roles=3001\",\"eventTemplateUrl\":\"https://dummyedutest.cailian.net/#/fillDeclare\",\"eventDesp\":\"王。\",\"roles\":null,\"modelType\":\"tableTemplate\",\"modelName\":\"stock_change\",\"type\":true,\"dynmaicParamReqList\":[{\"param\":\"platform\",\"value\":\"dummy\",\"type\":\"1\"},{\"param\":\"templateCode\",\"value\":\"001\",\"type\":\"1\"},{\"param\":\"roles\",\"value\":\"3001\",\"type\":\"1\"}],\"value\":{\"name\":\"股权变更信息\",\"model\":\"信息公示 - 股权变更信息\",\"form\":{\"configure\":{\"formName\":\"EquityChangeInformation_4\",\"tableList\":[]},\"weightMapper\":{\"tableList\":\"100\",\"tableListMapper\":{\"Shareholder\":\"25\",\"EquityRatioBeforeChange\":\"25\",\"DateEquityChange\":\"25\",\"EquityRatioAfterChange\":\"25\"}},\"aggrementMapper\":{\"tableList\":95}}},\"eventWeight\":\"10\",\"standParseType\":0,\"sort\":2},{\"id\":148,\"eventName\":\"仿真_信息公示-0-点击步骤\",\"eventType\":0,\"eventUrl\":\"https://cjddcloudtest.cailian.net/cjdd/course/20191206/35B9056A-1575637776254.png\",\"eventParam\":\"platform=dummy&templateCode=001&roles=3001\",\"eventTemplateUrl\":\"https://dummyedutest.cailian.net/#/fillDeclare\",\"eventDesp\":\"\",\"roles\":null,\"modelType\":\"formTemplate\",\"modelName\":\"informationPublicity\",\"type\":true,\"dynmaicParamReqList\":[{\"param\":\"platform\",\"value\":\"dummy\",\"type\":\"1\"},{\"param\":\"templateCode\",\"value\":\"001\",\"type\":\"1\"},{\"param\":\"roles\",\"value\":\"3001\",\"type\":\"1\"}],\"value\":{\"name\":\"信息公示 - 点击步骤\",\"form\":{\"configure\":{},\"step\":{},\"weightMapper\":{},\"stepWeight\":{\"fill_info\":\"16\",\"fill_beijing\":\"16\",\"fill_number\":\"17\",\"fill_login\":\"17\",\"fill_year\":\"17\",\"fill_confirm\":\"17\"},\"aggrementMapper\":{}},\"configureWidth\":\"250px\",\"scoreWidth\":\"60px\"},\"eventWeight\":\"10\",\"standParseType\":0,\"sort\":3},{\"id\":158,\"eventName\":\"仿真_信息公示-1-企业基本信息\",\"eventType\":0,\"eventUrl\":\"https://cjddcloud-test.oss-cn-beijing.aliyuncs.com/cjdd/course/20191022/369D7FDF-1571750751949.png\",\"eventParam\":\"platform=dummy&templateCode=001&roles=3001\",\"eventTemplateUrl\":\"https://dummyedutest.cailian.net/#/fillDeclare\",\"eventDesp\":\"\",\"roles\":null,\"modelType\":\"formTemplate\",\"modelName\":\"informationPublicityForm\",\"type\":true,\"dynmaicParamReqList\":[{\"param\":\"platform\",\"value\":\"dummy\",\"type\":\"1\"},{\"param\":\"templateCode\",\"value\":\"001\",\"type\":\"1\"},{\"param\":\"roles\",\"value\":\"3001\",\"type\":\"1\"}],\"value\":{\"name\":\"信息公示 - 企业基本信息\",\"form\":{\"configure\":{\"formName\":\"EnterpriseInformation_1\",\"ReportingYear\":\"\",\"EnterpriseName\":\"\",\"UnifiedSocietyCode\":\"\",\"CorporateMailingAddress\":\"\",\"PostalCode\":\"\",\"BusinessContactNumber\":\"\",\"email\":\"\",\"MainBusinessActivities\":\"\",\"NumberPeopleEngaged\":\"\",\"NumberPeopleEngagedIs\":\"\",\"NumberEmployedWomen\":\"\",\"NumberEmployedWomenIs\":\"\",\"BusinessStatus\":\"\",\"WomenBusinessStatus\":\"\",\"WomenBusinessStatusIs\":\"\",\"WhetherThereExternalGuarantee\":\"\",\"WhetherThereWebsiteOnlineShop\":\"\",\"ShareTransfer\":\"\",\"PurchaseEquity\":\"\",\"operator1\":\"\",\"HiredHands1\":\"\",\"operator2\":\"\",\"HiredHands2\":\"\",\"operator3\":\"\",\"HiredHands3\":\"\",\"operator4\":\"\",\"HiredHands4\":\"\"},\"weightMapper\":{\"ReportingYear\":\"3\",\"EnterpriseName\":\"4\",\"UnifiedSocietyCode\":\"4\",\"CorporateMailingAddress\":\"3\",\"PostalCode\":\"3\",\"BusinessContactNumber\":\"3\",\"email\":\"3\",\"MainBusinessActivities\":\"3\",\"NumberPeopleEngaged\":\"3\",\"NumberPeopleEngagedIs\":\"3\",\"NumberEmployedWomen\":\"4\",\"NumberEmployedWomenIs\":\"4\",\"BusinessStatus\":\"4\",\"WomenBusinessStatus\":\"4\",\"WomenBusinessStatusIs\":\"4\",\"WhetherThereExternalGuarantee\":\"4\",\"WhetherThereWebsiteOnlineShop\":\"4\",\"ShareTransfer\":\"4\",\"PurchaseEquity\":\"4\",\"operator1\":\"4\",\"HiredHands1\":\"4\",\"operator2\":\"4\",\"HiredHands2\":\"4\",\"operator3\":\"4\",\"HiredHands3\":\"4\",\"operator4\":\"4\",\"HiredHands4\":\"4\"},\"aggrementMapper\":{\"ReportingYear\":5,\"CorporateMailingAddress\":5,\"MainBusinessActivities\":5}},\"configureWidth\":\"250px\",\"scoreWidth\":\"60px\"},\"eventWeight\":\"10\",\"standParseType\":0,\"sort\":4},{\"id\":162,\"eventName\":\"仿真-信息公示5 - 对外投资信息\",\"eventType\":0,\"eventUrl\":\"https://cjddcloud-test.oss-cn-beijing.aliyuncs.com/cjdd/course/20191024/0422912F-1571885949397.jpg\",\"eventParam\":\"platform=dummy&templateCode=001&roles=3001\",\"eventTemplateUrl\":\"https://dummyedutest.cailian.net/#/fillDeclare\",\"eventDesp\":\"王。\",\"roles\":null,\"modelType\":\"tableTemplate\",\"modelName\":\"outbound_investment\",\"type\":true,\"dynmaicParamReqList\":[{\"param\":\"platform\",\"value\":\"dummy\",\"type\":\"1\"},{\"param\":\"templateCode\",\"value\":\"001\",\"type\":\"1\"},{\"param\":\"roles\",\"value\":\"3001\",\"type\":\"1\"}],\"value\":{\"name\":\"对外投资信息\",\"model\":\"信息公示 - 对外投资信息\",\"form\":{\"configure\":{\"formName\":\"ForeignInvestmentInformation_5\",\"tableList\":[]},\"weightMapper\":{\"tableList\":\"100\",\"tableListMapper\":{\"NameTheEnterpriseInvested\":\"50\",\"UnifiedSocialCreditCode\":\"50\"}},\"aggrementMapper\":{\"tableList\":95}}},\"eventWeight\":\"10\",\"standParseType\":0,\"sort\":5},{\"id\":163,\"eventName\":\"仿真-信息公示7 - 对外担保信息 \",\"eventType\":0,\"eventUrl\":\"https://cjddcloud-test.oss-cn-beijing.aliyuncs.com/cjdd/course/20191024/68169ACC-1571887711131.jpg\",\"eventParam\":\"platform=dummy&templateCode=001&roles=3001\",\"eventTemplateUrl\":\"https://dummyedutest.cailian.net/#/fillDeclare\",\"eventDesp\":\"王。\",\"roles\":null,\"modelType\":\"tableTemplate\",\"modelName\":\"external_guarantee\",\"type\":true,\"dynmaicParamReqList\":[{\"param\":\"platform\",\"value\":\"dummy\",\"type\":\"1\"},{\"param\":\"templateCode\",\"value\":\"001\",\"type\":\"1\"},{\"param\":\"roles\",\"value\":\"3001\",\"type\":\"1\"}],\"value\":{\"name\":\"对外担保信息\",\"model\":\"信息公示 - 对外担保信息\",\"form\":{\"configure\":{\"formName\":\"ExternalGuaranteeInformation_7\",\"tableList\":[]},\"weightMapper\":{\"tableList\":\"100\",\"tableListMapper\":{\"Creditor\":\"12.5\",\"Obligor\":\"12.5\",\"TypesPrincipalClaims\":\"12.5\",\"AmountPrincipalClaim\":\"12.5\",\"TermBankDebt\":\"12.5\",\"PeriodGuarantee\":\"12.5\",\"WayAssurance\":\"12.5\",\"ExternalGuaranteeInformationIs\":\"12.5\"}},\"aggrementMapper\":{\"tableList\":95}}},\"eventWeight\":\"10\",\"standParseType\":0,\"sort\":6},{\"id\":165,\"eventName\":\"仿真-信息公示6 - 资产状况信息\",\"eventType\":0,\"eventUrl\":\"https://cjddcloud-test.oss-cn-beijing.aliyuncs.com/cjdd/course/20191028/762F5500-1572262210634.jpg\",\"eventParam\":\"platform=dummy&templateCode=001&roles=3001\",\"eventTemplateUrl\":\"https://dummyedutest.cailian.net/#/fillDeclare\",\"eventDesp\":\"\",\"roles\":null,\"modelType\":\"formTemplate\",\"modelName\":\"assetStatus\",\"type\":true,\"dynmaicParamReqList\":[{\"param\":\"platform\",\"value\":\"dummy\",\"type\":\"1\"},{\"param\":\"templateCode\",\"value\":\"001\",\"type\":\"1\"},{\"param\":\"roles\",\"value\":\"3001\",\"type\":\"1\"}],\"value\":{\"name\":\"信息公示 - 资产状况信息\",\"form\":{\"configure\":{\"formName\":\"AssetStatusInformation_6\",\"TotalAssets\":\"\",\"TotalOwnerEquity\":\"\",\"Totalliabilities\":\"\",\"TotalOperatingIncome\":\"\",\"MainBusinessIncome\":\"\",\"TotalProfit\":\"\",\"NetProfit\":\"\",\"TotalTaxPayment\":\"\"},\"weightMapper\":{\"TotalAssets\":\"12\",\"TotalOwnerEquity\":\"12\",\"Totalliabilities\":\"12\",\"TotalOperatingIncome\":\"12\",\"MainBusinessIncome\":\"13\",\"TotalProfit\":\"13\",\"NetProfit\":\"13\",\"TotalTaxPayment\":\"13\"},\"stepWeight\":{}},\"configureWidth\":\"250px\",\"scoreWidth\":\"90px\"},\"eventWeight\":\"10\",\"standParseType\":0,\"sort\":7},{\"id\":189,\"eventName\":\"仿真-信息公示-8-党建信息\",\"eventType\":0,\"eventUrl\":\"https://cjddcloud-test.oss-cn-beijing.aliyuncs.com/cjdd/course/20191118/606DA928-1574056936829.jpg\",\"eventParam\":\"platform=dummy&templateCode=001&roles=3001\",\"eventTemplateUrl\":\"https://dummyedutest.cailian.net/#/fillDeclare\",\"eventDesp\":\"zz\",\"roles\":null,\"modelType\":\"formTemplate\",\"modelName\":\"PartyBuildingInfo\",\"type\":true,\"dynmaicParamReqList\":[{\"param\":\"platform\",\"value\":\"dummy\",\"type\":\"1\"},{\"param\":\"templateCode\",\"value\":\"001\",\"type\":\"1\"},{\"param\":\"roles\",\"value\":\"3001\",\"type\":\"1\"}],\"value\":{\"name\":\"信息公示 - 党建信息\",\"form\":{\"configure\":{\"formName\":\"PartyBuildingInformation_8\",\"NumberCPCMembers\":\"\",\"PartyOrganizationSystem\":\"\",\"ArePartyMembers\":\"\",\"PartySecretaryOrNot\":\"\",\"NumberLeagueMembers\":\"\",\"LeagueOrganizationSystem\":\"\",\"ArePartyMembers2\":\"\",\"PartySecretaryOrNot2\":\"\"},\"weightMapper\":{\"NumberCPCMembers\":\"12\",\"PartyOrganizationSystem\":\"12\",\"ArePartyMembers\":\"12\",\"PartySecretaryOrNot\":\"12\",\"NumberLeagueMembers\":\"13\",\"LeagueOrganizationSystem\":\"13\",\"ArePartyMembers2\":\"13\",\"PartySecretaryOrNot2\":\"13\"},\"stepWeight\":{}},\"configureWidth\":\"250px\",\"scoreWidth\":\"90px\"},\"eventWeight\":\"10\",\"standParseType\":0,\"sort\":8},{\"id\":191,\"eventName\":\"仿真-信息公示-9-社保信息\",\"eventType\":0,\"eventUrl\":\"https://cjddcloud-test.oss-cn-beijing.aliyuncs.com/cjdd/course/20191118/F5491A82-1574058761889.jpg\",\"eventParam\":\"platform=dummy&templateCode=001&roles=3001\",\"eventTemplateUrl\":\"https://dummyedutest.cailian.net/#/fillDeclare\",\"eventDesp\":\"zz\",\"roles\":null,\"modelType\":\"formTemplate\",\"modelName\":\"socialSecurityInfo\",\"type\":true,\"dynmaicParamReqList\":[{\"param\":\"platform\",\"value\":\"dummy\",\"type\":\"1\"},{\"param\":\"templateCode\",\"value\":\"001\",\"type\":\"1\"},{\"param\":\"roles\",\"value\":\"3001\",\"type\":\"1\"}],\"value\":{\"name\":\"信息公示 - 社保信息\",\"form\":{\"configure\":{\"formName\":\"SocialSecurityInformation_9\",\"EndowmentInsuranceUrbanEmployees\":\"\",\"UnemploymentInsurance\":\"\",\"MedicalInsurance\":\"\",\"IndustrialCommercialInsurance\":\"\",\"MaternityInsurance\":\"\",\"PaymentBaseEndowmentInsurance\":\"\",\"PaymentBaseBusinessInsurance\":\"\",\"PaymentBaseMedicalInsurance\":\"\",\"PaymentBaseMaternityInsurance\":\"\",\"UnitPaymentBaseIs\":\"\",\"ActualPaymentAmountEndowmentInsurance\":\"\",\"ActualPaymentAmountindustrialCommercialInsurance\":\"\",\"ActualPaymentAmountMedicalInsurance\":\"\",\"ActualPaymentAmountUnemploymentInsurance\":\"\",\"ActualPaymentAmountMaternityInsurance\":\"\",\"ActualPaymentAmountThisPeriodIs\":\"\",\"AccumulatedOverdueAmountUnitMedicalInsuranceEmployees\":\"\",\"AccumulatedOverdueAmountUnitUnemploymentInsurance\":\"\",\"AccumulatedOverdueAmountUnitMedicalInsurance\":\"\",\"AccumulatedOverdueAmountUnitEmploymentInjuryInsurance\":\"\",\"AccumulatedOverdueAmountUnitMaternityInsurance\":\"\",\"AccumulatedOverdueAmountUnitIs\":\"\"},\"weightMapper\":{\"EndowmentInsuranceUrbanEmployees\":\"4\",\"UnemploymentInsurance\":\"4\",\"MedicalInsurance\":\"4\",\"IndustrialCommercialInsurance\":\"4\",\"MaternityInsurance\":\"4\",\"PaymentBaseEndowmentInsurance\":\"4\",\"PaymentBaseBusinessInsurance\":\"4\",\"PaymentBaseMedicalInsurance\":\"4\",\"PaymentBaseMaternityInsurance\":\"4\",\"UnitPaymentBaseIs\":\"4\",\"ActualPaymentAmountEndowmentInsurance\":\"5\",\"ActualPaymentAmountindustrialCommercialInsurance\":\"5\",\"ActualPaymentAmountMedicalInsurance\":\"5\",\"ActualPaymentAmountUnemploymentInsurance\":\"5\",\"ActualPaymentAmountMaternityInsurance\":\"5\",\"ActualPaymentAmountThisPeriodIs\":\"5\",\"AccumulatedOverdueAmountUnitMedicalInsuranceEmployees\":\"5\",\"AccumulatedOverdueAmountUnitUnemploymentInsurance\":\"5\",\"AccumulatedOverdueAmountUnitMedicalInsurance\":\"5\",\"AccumulatedOverdueAmountUnitEmploymentInjuryInsurance\":\"5\",\"AccumulatedOverdueAmountUnitMaternityInsurance\":\"5\",\"AccumulatedOverdueAmountUnitIs\":\"5\"},\"step\":{},\"stepWeight\":{}},\"configureWidth\":\"250px\",\"scoreWidth\":\"90px\"},\"eventWeight\":\"5\",\"standParseType\":0,\"sort\":9},{\"id\":194,\"eventName\":\"仿真-信息公示10 - 报关信息\",\"eventType\":0,\"eventUrl\":\"https://cjddcloud-test.oss-cn-beijing.aliyuncs.com/cjdd/course/20191118/276B9F35-1574062958638.jpg\",\"eventParam\":\"platform=dummy&templateCode=001&roles=3001\",\"eventTemplateUrl\":\"https://dummyedutest.cailian.net/#/fillDeclare\",\"eventDesp\":\"zz\",\"roles\":null,\"modelType\":\"formTemplate\",\"modelName\":\"customsDeclarationInfo\",\"type\":true,\"dynmaicParamReqList\":[{\"param\":\"platform\",\"value\":\"dummy\",\"type\":\"1\"},{\"param\":\"templateCode\",\"value\":\"001\",\"type\":\"1\"},{\"param\":\"roles\",\"value\":\"3001\",\"type\":\"1\"}],\"value\":{\"name\":\"信息公示 - 报关信息\",\"form\":{\"configure\":{\"formName\":\"CustomsDeclarationInformation_10\",\"EnglishName\":\"\",\"EnglishAddress\":\"\",\"TypesECommerceEnterprises\":\"\",\"BankDeposit\":\"\",\"AccountOpeningAccount\":\"\",\"SpecialTradeArea\":\"\",\"EconomicRegion\":\"\",\"PersonChargeCustomsAffairsName\":\"\",\"PersonChargeCustomsAffairsIDType\":\"\",\"PersonChargeCustomsAffairsIDNumber\":\"\",\"PersonChargeCustomsAffairsFixedTelephone\":\"\",\"PersonChargeCustomsAffairsMobilePhone\":\"\",\"PersonChargeCustomsAffairsEmail\":\"\",\"HeadCustomsName\":\"\",\"HeadCustomsFixedTelephone\":\"\",\"HeadCustomsMobilePhone\":\"\",\"HeadCustomsEmail\":\"\",\"HeadCustomsFax\":\"\",\"NatureBusinessPlace\":\"\",\"ListedCompanyOrNot\":\"\",\"WhetherImplementAccountingComputerization\":\"\",\"ClearingMethod\":\"\",\"ContinuousLossInTheLastThreeYears\":\"\",\"Stock\":\"\",\"CurrentLiabilities\":\"\",\"CurrentAssets\":\"\",\"NetOperatingCashFlow\":\"\",\"OperatingProfit\":\"\",\"OwnersEquityBeginningYear\":\"\",\"WhetherInternalExternalauditCarriedYear\":\"\",\"ProblemsCustomsAdministration\":\"\",\"ConcreteProblems\":\"\"},\"weightMapper\":{\"EnglishName\":\"3\",\"EnglishAddress\":\"3\",\"TypesECommerceEnterprises\":\"3\",\"BankDeposit\":\"3\",\"AccountOpeningAccount\":\"3\",\"SpecialTradeArea\":\"3\",\"EconomicRegion\":\"3\",\"PersonChargeCustomsAffairsName\":\"3\",\"PersonChargeCustomsAffairsIDType\":\"3\",\"PersonChargeCustomsAffairsIDNumber\":\"3\",\"PersonChargeCustomsAffairsFixedTelephone\":\"3\",\"PersonChargeCustomsAffairsMobilePhone\":\"3\",\"PersonChargeCustomsAffairsEmail\":\"3\",\"HeadCustomsName\":\"3\",\"HeadCustomsFixedTelephone\":\"3\",\"HeadCustomsMobilePhone\":\"3\",\"HeadCustomsEmail\":\"3\",\"HeadCustomsFax\":\"3\",\"NatureBusinessPlace\":\"3\",\"ListedCompanyOrNot\":\"3\",\"WhetherImplementAccountingComputerization\":\"3\",\"ClearingMethod\":\"3\",\"ContinuousLossInTheLastThreeYears\":\"3\",\"Stock\":\"3\",\"CurrentLiabilities\":\"3\",\"CurrentAssets\":\"3\",\"NetOperatingCashFlow\":\"3\",\"OperatingProfit\":\"3\",\"OwnersEquityBeginningYear\":\"4\",\"WhetherInternalExternalauditCarriedYear\":\"4\",\"ProblemsCustomsAdministration\":\"4\",\"ConcreteProblems\":\"4\"},\"step\":{},\"stepWeight\":{}},\"configureWidth\":\"250px\",\"scoreWidth\":\"90px\"},\"eventWeight\":\"5\",\"standParseType\":0,\"sort\":10}]";


    }


    /**
     * 填写并领购发票---第一题 序号为0
     *
     * @param formNameMap1
     * @param taxForm
     */
    public void taxForm(HashMap<String, Map> formNameMap1, String taxForm) {
//        填写并领购发票
        String str2 = "[{\"id\":152,\"eventName\":\"仿真-填写并领购发票\",\"eventType\":0,\"eventUrl\":\"https://zledu-oss-sx.cailian.net/cjdd/course/20200324/71271858-1585039487845.png\",\"eventParam\":\"platform=dummy&templateCode=001&roles=3032\",\"eventTemplateUrl\":\"https://dummyedusx.cailian.net/#/writeInvoice\",\"eventTemplatePic\":\"modelName=purchase_invoice&modelType=formTemplate\",\"eventDesp\":\"\",\"roles\":null,\"modelType\":\"formTemplate\",\"modelName\":\"purchase_invoice\",\"type\":true,\"dynmaicParamReqList\":[{\"param\":\"platform\",\"value\":\"dummy\",\"type\":\"1\"},{\"param\":\"templateCode\",\"value\":\"001\",\"type\":\"1\"},{\"param\":\"roles\",\"value\":\"3032\",\"type\":\"1\"}],\"value\":{\"name\":\"填写并领购发票\",\"form\":{\"configure\":{\"formName\":\"taxForm\",\"tableNum1\":\"1\",\"tableRemarks1\":\"2\",\"tableNum2\":\"3\",\"tableRemarks2\":\"4\",\"taxNumber\":\"5\",\"taxName\":\"6\",\"name\":\"7\",\"mobileNum\":\"8\",\"detailAddress\":\"9\",\"postalCode\":\"10\",\"remarks\":\"11\",\"address\":\"朝阳区\",\"isYourSelfGet\":\"0\"},\"weightMapper\":{\"taxNumber\":\"8\",\"taxName\":\"8\",\"name\":\"8\",\"mobileNum\":\"8\",\"address\":\"8\",\"detailAddress\":\"8\",\"postalCode\":\"8\",\"isYourSelfGet\":\"8\",\"remarks\":\"8\",\"tableNum1\":\"7\",\"tableNum2\":\"7\",\"tableRemarks1\":\"7\",\"tableRemarks2\":\"7\"}},\"configureWidth\":\"250px\",\"scoreWidth\":\"90px\"},\"eventWeight\":\"100\",\"version\":0,\"versionStatus\":true,\"timestamp\":1607261701754,\"standParseType\":0,\"sort\":0}]";
//               信息公示
//                String str2 = "[{\"id\":134,\"eventName\":\"仿真-信息公示-2-股东及出资信息\",\"eventType\":0,\"eventUrl\":\"https://cjddcloud-test.oss-cn-beijing.aliyuncs.com/cjdd/course/20191022/00309B4C-1571728914742.jpg\",\"eventParam\":\"platform=dummy&templateCode=001&roles=3001\",\"eventTemplateUrl\":\"https://dummyedutest.cailian.net/#/fillDeclare\",\"eventDesp\":\"王。\",\"roles\":null,\"modelType\":\"tableTemplate\",\"modelName\":\"contribution_information\",\"type\":true,\"dynmaicParamReqList\":[{\"id\":40405,\"questionId\":6539,\"eventId\":134,\"param\":\"platform\",\"value\":\"dummy\",\"type\":1,\"sort\":0},{\"id\":40406,\"questionId\":6539,\"eventId\":134,\"param\":\"templateCode\",\"value\":\"001\",\"type\":1,\"sort\":0},{\"id\":40407,\"questionId\":6539,\"eventId\":134,\"param\":\"roles\",\"value\":\"3001\",\"type\":1,\"sort\":0}],\"value\":{\"name\":\"股东及出资信息\",\"model\":\"信息公示 - 股东及出资信息\",\"form\":{\"configure\":{\"formName\":\"ShareholdersContributionInformation_2\",\"tableList\":[{\"Shareholder\":\"股东\",\"SubscribedCapitalContribution\":\"100\",\"SubscribedCapitalContributionTime\":\"2021-02-01\",\"SubscribedCapitalContributionMode\":\"货币\",\"PaidAdvance\":\"100\",\"PaidAdvanceTime\":\"2021-02-01\",\"PaidAdvanceTimeMode\":\"货币\"}]},\"weightMapper\":{\"tableList\":\"100\",\"tableListMapper\":{\"Shareholder\":\"15\",\"SubscribedCapitalContribution\":\"14\",\"SubscribedCapitalContributionTime\":\"14\",\"SubscribedCapitalContributionMode\":\"14\",\"PaidAdvance\":\"14\",\"PaidAdvanceTime\":\"14\",\"PaidAdvanceTimeMode\":\"15\"}},\"aggrementMapper\":{\"tableList\":95,\"SubscribedCapitalContributionMode\":6,\"PaidAdvanceTimeMode\":6}}},\"eventWeight\":10,\"standParseType\":0,\"sort\":0},{\"id\":137,\"eventName\":\"仿真-信息公示-3-网站或网店信息\",\"eventType\":0,\"eventUrl\":\"https://cjddcloud-test.oss-cn-beijing.aliyuncs.com/cjdd/course/20191022/90269501-1571732065586.jpg\",\"eventParam\":\"platform=dummy&templateCode=001&roles=3001\",\"eventTemplateUrl\":\"https://dummyedutest.cailian.net/#/fillDeclare\",\"eventDesp\":\"王。\",\"roles\":null,\"modelType\":\"tableTemplate\",\"modelName\":\"shop_information\",\"type\":true,\"dynmaicParamReqList\":[{\"id\":40408,\"questionId\":6539,\"eventId\":137,\"param\":\"platform\",\"value\":\"dummy\",\"type\":1,\"sort\":1},{\"id\":40409,\"questionId\":6539,\"eventId\":137,\"param\":\"templateCode\",\"value\":\"001\",\"type\":1,\"sort\":1},{\"id\":40410,\"questionId\":6539,\"eventId\":137,\"param\":\"roles\",\"value\":\"3001\",\"type\":1,\"sort\":1}],\"value\":{\"name\":\"网站或网店信息\",\"model\":\"信息公示 - 网站或网店信息\",\"form\":{\"configure\":{\"formName\":\"WebsiteShopInformation_3\",\"tableList\":[{\"type\":\"类型1\",\"name\":\"名称1\",\"Website\":\"\"}]},\"weightMapper\":{\"tableList\":\"100\",\"tableListMapper\":{\"type\":\"33\",\"name\":\"33\",\"Website\":\"34\"}},\"aggrementMapper\":{\"tableList\":95}}},\"eventWeight\":10,\"standParseType\":0,\"sort\":1},{\"id\":139,\"eventName\":\"仿真-信息公示4 - 股权变更信息\",\"eventType\":0,\"eventUrl\":\"https://cjddcloud-test.oss-cn-beijing.aliyuncs.com/cjdd/course/20191022/CEEF425C-1571732154061.png\",\"eventParam\":\"platform=dummy&templateCode=001&roles=3001\",\"eventTemplateUrl\":\"https://dummyedutest.cailian.net/#/fillDeclare\",\"eventDesp\":\"王。\",\"roles\":null,\"modelType\":\"tableTemplate\",\"modelName\":\"stock_change\",\"type\":true,\"dynmaicParamReqList\":[{\"id\":40411,\"questionId\":6539,\"eventId\":139,\"param\":\"platform\",\"value\":\"dummy\",\"type\":1,\"sort\":2},{\"id\":40412,\"questionId\":6539,\"eventId\":139,\"param\":\"templateCode\",\"value\":\"001\",\"type\":1,\"sort\":2},{\"id\":40413,\"questionId\":6539,\"eventId\":139,\"param\":\"roles\",\"value\":\"3001\",\"type\":1,\"sort\":2}],\"value\":{\"name\":\"股权变更信息\",\"model\":\"信息公示 - 股权变更信息\",\"form\":{\"configure\":{\"formName\":\"EquityChangeInformation_4\",\"tableList\":[{\"Shareholder\":\"股东1\",\"EquityRatioBeforeChange\":\"80\",\"EquityRatioAfterChange\":\"100\",\"DateEquityChange\":\"2021-02-01\"}]},\"weightMapper\":{\"tableList\":\"100\",\"tableListMapper\":{\"Shareholder\":\"25\",\"EquityRatioBeforeChange\":\"25\",\"DateEquityChange\":\"25\",\"EquityRatioAfterChange\":\"25\"}},\"aggrementMapper\":{\"tableList\":95}}},\"eventWeight\":10,\"standParseType\":0,\"sort\":2},{\"id\":158,\"eventName\":\"仿真_信息公示-1-企业基本信息\",\"eventType\":0,\"eventUrl\":\"https://cjddcloud-test.oss-cn-beijing.aliyuncs.com/cjdd/course/20191022/369D7FDF-1571750751949.png\",\"eventParam\":\"platform=dummy&templateCode=001&roles=3001\",\"eventTemplateUrl\":\"https://dummyedutest.cailian.net/#/fillDeclare\",\"eventDesp\":\"\",\"roles\":null,\"modelType\":\"formTemplate\",\"modelName\":\"informationPublicityForm\",\"type\":true,\"dynmaicParamReqList\":[{\"id\":40417,\"questionId\":6539,\"eventId\":158,\"param\":\"platform\",\"value\":\"dummy\",\"type\":1,\"sort\":4},{\"id\":40418,\"questionId\":6539,\"eventId\":158,\"param\":\"templateCode\",\"value\":\"001\",\"type\":1,\"sort\":4},{\"id\":40419,\"questionId\":6539,\"eventId\":158,\"param\":\"roles\",\"value\":\"3001\",\"type\":1,\"sort\":4}],\"value\":{\"name\":\"信息公示 - 企业基本信息\",\"form\":{\"configure\":{\"formName\":\"EnterpriseInformation_1\",\"ReportingYear\":\"2019\",\"EnterpriseName\":\"企业名称1\",\"UnifiedSocietyCode\":\"123456789012345\",\"CorporateMailingAddress\":\"地址详情lababala\",\"PostalCode\":\"065500\",\"BusinessContactNumber\":\"010-3209898\",\"email\":\"1@qq.com\",\"MainBusinessActivities\":\"企业主营业务活动\",\"NumberPeopleEngaged\":\"20\",\"NumberPeopleEngagedIs\":\"公示\",\"NumberEmployedWomen\":\"1\",\"NumberEmployedWomenIs\":\"公示\",\"BusinessStatus\":\"开业\",\"WomenBusinessStatus\":\"国有控股\",\"WomenBusinessStatusIs\":\"公示\",\"WhetherThereExternalGuarantee\":\"是\",\"WhetherThereWebsiteOnlineShop\":\"是\",\"ShareTransfer\":\"是\",\"PurchaseEquity\":\"是\",\"operator1\":\"1\",\"HiredHands1\":\"1\",\"operator2\":\"1\",\"HiredHands2\":\"1\",\"operator3\":\"1\",\"HiredHands3\":\"1\",\"operator4\":\"1\",\"HiredHands4\":\"1\"},\"weightMapper\":{\"ReportingYear\":\"3\",\"EnterpriseName\":\"4\",\"UnifiedSocietyCode\":\"4\",\"CorporateMailingAddress\":\"3\",\"PostalCode\":\"3\",\"BusinessContactNumber\":\"3\",\"email\":\"3\",\"MainBusinessActivities\":\"3\",\"NumberPeopleEngaged\":\"3\",\"NumberPeopleEngagedIs\":\"3\",\"NumberEmployedWomen\":\"4\",\"NumberEmployedWomenIs\":\"4\",\"BusinessStatus\":\"4\",\"WomenBusinessStatus\":\"4\",\"WomenBusinessStatusIs\":\"4\",\"WhetherThereExternalGuarantee\":\"4\",\"WhetherThereWebsiteOnlineShop\":\"4\",\"ShareTransfer\":\"4\",\"PurchaseEquity\":\"4\",\"operator1\":\"4\",\"HiredHands1\":\"4\",\"operator2\":\"4\",\"HiredHands2\":\"4\",\"operator3\":\"4\",\"HiredHands3\":\"4\",\"operator4\":\"4\",\"HiredHands4\":\"4\"},\"aggrementMapper\":{}},\"configureWidth\":\"250px\",\"scoreWidth\":\"60px\"},\"eventWeight\":\"20\",\"standParseType\":0,\"sort\":3},{\"id\":162,\"eventName\":\"仿真-信息公示5 - 对外投资信息\",\"eventType\":0,\"eventUrl\":\"https://cjddcloud-test.oss-cn-beijing.aliyuncs.com/cjdd/course/20191024/0422912F-1571885949397.jpg\",\"eventParam\":\"platform=dummy&templateCode=001&roles=3001\",\"eventTemplateUrl\":\"https://dummyedutest.cailian.net/#/fillDeclare\",\"eventDesp\":\"王。\",\"roles\":null,\"modelType\":\"tableTemplate\",\"modelName\":\"outbound_investment\",\"type\":true,\"dynmaicParamReqList\":[{\"id\":40420,\"questionId\":6539,\"eventId\":162,\"param\":\"platform\",\"value\":\"dummy\",\"type\":1,\"sort\":5},{\"id\":40421,\"questionId\":6539,\"eventId\":162,\"param\":\"templateCode\",\"value\":\"001\",\"type\":1,\"sort\":5},{\"id\":40422,\"questionId\":6539,\"eventId\":162,\"param\":\"roles\",\"value\":\"3001\",\"type\":1,\"sort\":5}],\"value\":{\"name\":\"对外投资信息\",\"model\":\"信息公示 - 对外投资信息\",\"form\":{\"configure\":{\"formName\":\"ForeignInvestmentInformation_5\",\"tableList\":[{\"NameTheEnterpriseInvested\":\"或\",\"UnifiedSocialCreditCode\":\"1\"}]},\"weightMapper\":{\"tableList\":\"100\",\"tableListMapper\":{\"NameTheEnterpriseInvested\":\"50\",\"UnifiedSocialCreditCode\":\"50\"}},\"aggrementMapper\":{\"tableList\":95}}},\"eventWeight\":10,\"standParseType\":0,\"sort\":4},{\"id\":163,\"eventName\":\"仿真-信息公示7 - 对外担保信息 \",\"eventType\":0,\"eventUrl\":\"https://cjddcloud-test.oss-cn-beijing.aliyuncs.com/cjdd/course/20191024/68169ACC-1571887711131.jpg\",\"eventParam\":\"platform=dummy&templateCode=001&roles=3001\",\"eventTemplateUrl\":\"https://dummyedutest.cailian.net/#/fillDeclare\",\"eventDesp\":\"王。\",\"roles\":null,\"modelType\":\"tableTemplate\",\"modelName\":\"external_guarantee\",\"type\":true,\"dynmaicParamReqList\":[{\"id\":40423,\"questionId\":6539,\"eventId\":163,\"param\":\"platform\",\"value\":\"dummy\",\"type\":1,\"sort\":6},{\"id\":40424,\"questionId\":6539,\"eventId\":163,\"param\":\"templateCode\",\"value\":\"001\",\"type\":1,\"sort\":6},{\"id\":40425,\"questionId\":6539,\"eventId\":163,\"param\":\"roles\",\"value\":\"3001\",\"type\":1,\"sort\":6}],\"value\":{\"name\":\"对外担保信息\",\"model\":\"信息公示 - 对外担保信息\",\"form\":{\"configure\":{\"formName\":\"ExternalGuaranteeInformation_7\",\"tableList\":[{\"NameTheEnterpriseInvested\":\"\",\"UnifiedSocialCreditCode\":\"\",\"Creditor\":\"张三1\",\"Obligor\":\"李四1\",\"TypesPrincipalClaims\":\"贷款\",\"AmountPrincipalClaim\":\"100\",\"TermBankDebt\":\"2021-02-01/2021-02-02\",\"PeriodGuarantee\":\"期限\",\"WayAssurance\":\"一般保证\"}]},\"weightMapper\":{\"tableList\":\"100\",\"tableListMapper\":{\"Creditor\":\"12.5\",\"Obligor\":\"12.5\",\"TypesPrincipalClaims\":\"12.5\",\"AmountPrincipalClaim\":\"12.5\",\"TermBankDebt\":\"12.5\",\"PeriodGuarantee\":\"12.5\",\"WayAssurance\":\"12.5\",\"ExternalGuaranteeInformationIs\":\"12.5\"}},\"aggrementMapper\":{\"tableList\":95}}},\"eventWeight\":10,\"standParseType\":0,\"sort\":5},{\"id\":165,\"eventName\":\"仿真-信息公示6 - 资产状况信息\",\"eventType\":0,\"eventUrl\":\"https://cjddcloud-test.oss-cn-beijing.aliyuncs.com/cjdd/course/20191028/762F5500-1572262210634.jpg\",\"eventParam\":\"platform=dummy&templateCode=001&roles=3001\",\"eventTemplateUrl\":\"https://dummyedutest.cailian.net/#/fillDeclare\",\"eventDesp\":\"\",\"roles\":null,\"modelType\":\"formTemplate\",\"modelName\":\"assetStatus\",\"type\":true,\"dynmaicParamReqList\":[{\"id\":40426,\"questionId\":6539,\"eventId\":165,\"param\":\"platform\",\"value\":\"dummy\",\"type\":1,\"sort\":7},{\"id\":40427,\"questionId\":6539,\"eventId\":165,\"param\":\"templateCode\",\"value\":\"001\",\"type\":1,\"sort\":7},{\"id\":40428,\"questionId\":6539,\"eventId\":165,\"param\":\"roles\",\"value\":\"3001\",\"type\":1,\"sort\":7}],\"value\":{\"name\":\"信息公示 - 资产状况信息\",\"form\":{\"configure\":{\"formName\":\"AssetStatusInformation_6\",\"TotalAssets\":\"1\",\"TotalOwnerEquity\":\"1\",\"Totalliabilities\":\"1\",\"TotalOperatingIncome\":\"1\",\"MainBusinessIncome\":\"1\",\"TotalProfit\":\"1\",\"NetProfit\":\"1\",\"TotalTaxPayment\":\"1\",\"TotalOwnerEquityIs\":\"公示\",\"MainBusinessIncomeIs\":\"公示\",\"TotalTaxPaymentIs\":\"公示\",\"TotalAssetsIs\":\"公示\",\"TotalOperatingIncomeIs\":\"公示\",\"NetProfitIs\":\"公示\",\"TotalliabilitiesIs\":\"公示\",\"TotalProfitIs\":\"公示\"},\"weightMapper\":{\"TotalAssets\":\"12\",\"TotalOwnerEquity\":\"12\",\"Totalliabilities\":\"12\",\"TotalOperatingIncome\":\"12\",\"MainBusinessIncome\":\"13\",\"TotalProfit\":\"13\",\"NetProfit\":\"13\",\"TotalTaxPayment\":\"13\"},\"stepWeight\":{}},\"configureWidth\":\"250px\",\"scoreWidth\":\"90px\"},\"eventWeight\":10,\"standParseType\":0,\"sort\":6},{\"id\":189,\"eventName\":\"仿真-信息公示-8-党建信息\",\"eventType\":0,\"eventUrl\":\"https://cjddcloud-test.oss-cn-beijing.aliyuncs.com/cjdd/course/20191118/606DA928-1574056936829.jpg\",\"eventParam\":\"platform=dummy&templateCode=001&roles=3001\",\"eventTemplateUrl\":\"https://dummyedutest.cailian.net/#/fillDeclare\",\"eventDesp\":\"zz\",\"roles\":null,\"modelType\":\"formTemplate\",\"modelName\":\"PartyBuildingInfo\",\"type\":true,\"dynmaicParamReqList\":[{\"id\":40429,\"questionId\":6539,\"eventId\":189,\"param\":\"platform\",\"value\":\"dummy\",\"type\":1,\"sort\":8},{\"id\":40430,\"questionId\":6539,\"eventId\":189,\"param\":\"templateCode\",\"value\":\"001\",\"type\":1,\"sort\":8},{\"id\":40431,\"questionId\":6539,\"eventId\":189,\"param\":\"roles\",\"value\":\"3001\",\"type\":1,\"sort\":8}],\"value\":{\"name\":\"信息公示 - 党建信息\",\"form\":{\"configure\":{\"formName\":\"PartyBuildingInformation_8\",\"NumberCPCMembers\":\"1\",\"PartyOrganizationSystem\":\"未成立\",\"ArePartyMembers\":\"是\",\"PartySecretaryOrNot\":\"是\",\"NumberLeagueMembers\":\"1\",\"LeagueOrganizationSystem\":\"团委\",\"ArePartyMembers2\":\"是\",\"PartySecretaryOrNot2\":\"是\"},\"weightMapper\":{\"NumberCPCMembers\":\"12\",\"PartyOrganizationSystem\":\"12\",\"ArePartyMembers\":\"12\",\"PartySecretaryOrNot\":\"12\",\"NumberLeagueMembers\":\"13\",\"LeagueOrganizationSystem\":\"13\",\"ArePartyMembers2\":\"13\",\"PartySecretaryOrNot2\":\"13\"},\"stepWeight\":{}},\"configureWidth\":\"250px\",\"scoreWidth\":\"90px\"},\"eventWeight\":10,\"standParseType\":0,\"sort\":7},{\"id\":191,\"eventName\":\"仿真-信息公示-9-社保信息\",\"eventType\":0,\"eventUrl\":\"https://cjddcloud-test.oss-cn-beijing.aliyuncs.com/cjdd/course/20191118/F5491A82-1574058761889.jpg\",\"eventParam\":\"platform=dummy&templateCode=001&roles=3001\",\"eventTemplateUrl\":\"https://dummyedutest.cailian.net/#/fillDeclare\",\"eventDesp\":\"zz\",\"roles\":null,\"modelType\":\"formTemplate\",\"modelName\":\"socialSecurityInfo\",\"type\":true,\"dynmaicParamReqList\":[{\"id\":40432,\"questionId\":6539,\"eventId\":191,\"param\":\"platform\",\"value\":\"dummy\",\"type\":1,\"sort\":9},{\"id\":40433,\"questionId\":6539,\"eventId\":191,\"param\":\"templateCode\",\"value\":\"001\",\"type\":1,\"sort\":9},{\"id\":40434,\"questionId\":6539,\"eventId\":191,\"param\":\"roles\",\"value\":\"3001\",\"type\":1,\"sort\":9}],\"value\":{\"name\":\"信息公示 - 社保信息\",\"form\":{\"configure\":{\"formName\":\"SocialSecurityInformation_9\",\"EndowmentInsuranceUrbanEmployees\":\"1\",\"UnemploymentInsurance\":\"1\",\"MedicalInsurance\":\"1\",\"IndustrialCommercialInsurance\":\"1\",\"MaternityInsurance\":\"1\",\"PaymentBaseEndowmentInsurance\":\"1\",\"PaymentBaseBusinessInsurance\":\"1\",\"PaymentBaseMedicalInsurance\":\"1\",\"PaymentBaseMaternityInsurance\":\"1\",\"UnitPaymentBaseIs\":\"\",\"ActualPaymentAmountEndowmentInsurance\":\"1\",\"ActualPaymentAmountindustrialCommercialInsurance\":\"1\",\"ActualPaymentAmountMedicalInsurance\":\"1\",\"ActualPaymentAmountUnemploymentInsurance\":\"1\",\"ActualPaymentAmountMaternityInsurance\":\"\",\"ActualPaymentAmountThisPeriodIs\":\"选择公示\",\"AccumulatedOverdueAmountUnitMedicalInsuranceEmployees\":\"1\",\"AccumulatedOverdueAmountUnitUnemploymentInsurance\":\"11\",\"AccumulatedOverdueAmountUnitMedicalInsurance\":\"1\",\"AccumulatedOverdueAmountUnitEmploymentInjuryInsurance\":\"1\",\"AccumulatedOverdueAmountUnitMaternityInsurance\":\"1\",\"AccumulatedOverdueAmountUnitIs\":\"选择公示\"},\"weightMapper\":{\"EndowmentInsuranceUrbanEmployees\":\"4\",\"UnemploymentInsurance\":\"4\",\"MedicalInsurance\":\"4\",\"IndustrialCommercialInsurance\":\"4\",\"MaternityInsurance\":\"4\",\"PaymentBaseEndowmentInsurance\":\"4\",\"PaymentBaseBusinessInsurance\":\"4\",\"PaymentBaseMedicalInsurance\":\"4\",\"PaymentBaseMaternityInsurance\":\"4\",\"UnitPaymentBaseIs\":\"4\",\"ActualPaymentAmountEndowmentInsurance\":\"5\",\"ActualPaymentAmountindustrialCommercialInsurance\":\"5\",\"ActualPaymentAmountMedicalInsurance\":\"5\",\"ActualPaymentAmountUnemploymentInsurance\":\"5\",\"ActualPaymentAmountMaternityInsurance\":\"5\",\"ActualPaymentAmountThisPeriodIs\":\"5\",\"AccumulatedOverdueAmountUnitMedicalInsuranceEmployees\":\"5\",\"AccumulatedOverdueAmountUnitUnemploymentInsurance\":\"5\",\"AccumulatedOverdueAmountUnitMedicalInsurance\":\"5\",\"AccumulatedOverdueAmountUnitEmploymentInjuryInsurance\":\"5\",\"AccumulatedOverdueAmountUnitMaternityInsurance\":\"5\",\"AccumulatedOverdueAmountUnitIs\":\"5\"},\"step\":{},\"stepWeight\":{}},\"configureWidth\":\"250px\",\"scoreWidth\":\"90px\"},\"eventWeight\":5,\"standParseType\":0,\"sort\":8},{\"id\":194,\"eventName\":\"仿真-信息公示10 - 报关信息\",\"eventType\":0,\"eventUrl\":\"https://cjddcloud-test.oss-cn-beijing.aliyuncs.com/cjdd/course/20191118/276B9F35-1574062958638.jpg\",\"eventParam\":\"platform=dummy&templateCode=001&roles=3001\",\"eventTemplateUrl\":\"https://dummyedutest.cailian.net/#/fillDeclare\",\"eventDesp\":\"zz\",\"roles\":null,\"modelType\":\"formTemplate\",\"modelName\":\"customsDeclarationInfo\",\"type\":true,\"dynmaicParamReqList\":[{\"id\":40435,\"questionId\":6539,\"eventId\":194,\"param\":\"platform\",\"value\":\"dummy\",\"type\":1,\"sort\":10},{\"id\":40436,\"questionId\":6539,\"eventId\":194,\"param\":\"templateCode\",\"value\":\"001\",\"type\":1,\"sort\":10},{\"id\":40437,\"questionId\":6539,\"eventId\":194,\"param\":\"roles\",\"value\":\"3001\",\"type\":1,\"sort\":10}],\"value\":{\"name\":\"信息公示 - 报关信息\",\"form\":{\"configure\":{\"formName\":\"CustomsDeclarationInformation_10\",\"EnglishName\":\"11\",\"EnglishAddress\":\"1\",\"TypesECommerceEnterprises\":\"电子商务企业\",\"BankDeposit\":\"1\",\"AccountOpeningAccount\":\"1\",\"SpecialTradeArea\":\"1\",\"EconomicRegion\":\"1\",\"PersonChargeCustomsAffairsName\":\"1\",\"PersonChargeCustomsAffairsIDType\":\"\",\"PersonChargeCustomsAffairsIDNumber\":\"1\",\"PersonChargeCustomsAffairsFixedTelephone\":\"1\",\"PersonChargeCustomsAffairsMobilePhone\":\"1\",\"PersonChargeCustomsAffairsEmail\":\"1\",\"HeadCustomsName\":\"1\",\"HeadCustomsFixedTelephone\":\"1\",\"HeadCustomsMobilePhone\":\"1\",\"HeadCustomsEmail\":\"1\",\"HeadCustomsFax\":\"1\",\"NatureBusinessPlace\":\"1\",\"ListedCompanyOrNot\":\"是\",\"WhetherImplementAccountingComputerization\":\"是\",\"ClearingMethod\":\"1\",\"ContinuousLossInTheLastThreeYears\":\"是\",\"Stock\":\"1\",\"CurrentLiabilities\":\"1\",\"CurrentAssets\":\"1\",\"NetOperatingCashFlow\":\"1\",\"OperatingProfit\":\"1\",\"OwnersEquityBeginningYear\":\"1\",\"WhetherInternalExternalauditCarriedYear\":\"内部审计\",\"ProblemsCustomsAdministration\":\"是\",\"ConcreteProblems\":\"1\"},\"weightMapper\":{\"EnglishName\":\"3\",\"EnglishAddress\":\"3\",\"TypesECommerceEnterprises\":\"3\",\"BankDeposit\":\"3\",\"AccountOpeningAccount\":\"3\",\"SpecialTradeArea\":\"3\",\"EconomicRegion\":\"3\",\"PersonChargeCustomsAffairsName\":\"3\",\"PersonChargeCustomsAffairsIDType\":\"3\",\"PersonChargeCustomsAffairsIDNumber\":\"3\",\"PersonChargeCustomsAffairsFixedTelephone\":\"3\",\"PersonChargeCustomsAffairsMobilePhone\":\"3\",\"PersonChargeCustomsAffairsEmail\":\"3\",\"HeadCustomsName\":\"3\",\"HeadCustomsFixedTelephone\":\"3\",\"HeadCustomsMobilePhone\":\"3\",\"HeadCustomsEmail\":\"3\",\"HeadCustomsFax\":\"3\",\"NatureBusinessPlace\":\"3\",\"ListedCompanyOrNot\":\"3\",\"WhetherImplementAccountingComputerization\":\"3\",\"ClearingMethod\":\"3\",\"ContinuousLossInTheLastThreeYears\":\"3\",\"Stock\":\"3\",\"CurrentLiabilities\":\"3\",\"CurrentAssets\":\"3\",\"NetOperatingCashFlow\":\"3\",\"OperatingProfit\":\"3\",\"OwnersEquityBeginningYear\":\"4\",\"WhetherInternalExternalauditCarriedYear\":\"4\",\"ProblemsCustomsAdministration\":\"4\",\"ConcreteProblems\":\"4\"},\"step\":{},\"stepWeight\":{}},\"configureWidth\":\"250px\",\"scoreWidth\":\"90px\"},\"eventWeight\":5,\"standParseType\":0,\"sort\":9}]";
//        住房公积金办理
//        String str2 = "[{\"id\":155,\"eventName\":\"仿真住房公积金-2-单位登记开户\",\"eventType\":0,\"eventUrl\":\"https://cjddcloud-test.oss-cn-beijing.aliyuncs.com/cjdd/course/20191022/CD489BDA-1571750388650.png\",\"eventParam\":\"platform=dummy&templateCode=001&roles=3001\",\"eventTemplateUrl\":\"https://dummyedutest.cailian.net/#/houseHandle\",\"eventDesp\":\"\",\"roles\":null,\"modelType\":\"formTemplate\",\"modelName\":\"housing_open_account\",\"type\":true,\"dynmaicParamReqList\":[{\"id\":40498,\"questionId\":6547,\"eventId\":155,\"param\":\"platform\",\"value\":\"dummy\",\"type\":1,\"sort\":0},{\"id\":40499,\"questionId\":6547,\"eventId\":155,\"param\":\"templateCode\",\"value\":\"001\",\"type\":1,\"sort\":0},{\"id\":40500,\"questionId\":6547,\"eventId\":155,\"param\":\"roles\",\"value\":\"3001\",\"type\":1,\"sort\":0}],\"value\":{\"name\":\"住房公积金办理 - 单位登记开户\",\"form\":{\"configure\":{\"formName\":\"openForm\",\"unitCode\":\"1\",\"unitName\":\"1\",\"unitNumber\":\"1\",\"unitAddress\":\"1\",\"unitPerson\":\"1\",\"unitType\":\"中华人民共和国居民身份证\",\"unitCert\":\"1\",\"unitPerPhone\":\"1\",\"unitMail\":\"1\",\"unitNature\":\"0\",\"unitShip\":\"中央\",\"unitIndustry\":\"采矿业\",\"unitEcon\":\"有限公司（内资）\",\"unitDate\":\"2021-02-01\"},\"weightMapper\":{\"unitCode\":\"7\",\"unitName\":\"7\",\"unitNumber\":\"7\",\"unitAddress\":\"7\",\"unitPerson\":\"7\",\"unitType\":\"7\",\"unitCert\":\"7\",\"unitPerPhone\":\"7\",\"unitMail\":\"7\",\"unitNature\":\"7\",\"unitShip\":\"7\",\"unitIndustry\":\"7\",\"unitEcon\":\"8\",\"unitDate\":8},\"aggrementMapper\":{\"unitType\":5,\"unitIndustry\":5,\"unitEcon\":5}},\"configureWidth\":\"250px\",\"scoreWidth\":\"90px\"},\"eventWeight\":25,\"standParseType\":0,\"sort\":0},{\"id\":186,\"eventName\":\"仿真住房公积金-3-公积金单位开户申请\",\"eventType\":0,\"eventUrl\":\"https://cjddcloud-test.oss-cn-beijing.aliyuncs.com/cjdd/course/20191114/EA3E6FC6-1573705404716.jpg\",\"eventParam\":\"platform=dummy&templateCode=001&roles=3001\",\"eventTemplateUrl\":\"https://dummyedutest.cailian.net/#/houseHandle\",\"eventDesp\":\"\",\"roles\":null,\"modelType\":\"formTemplate\",\"modelName\":\"housing_accumulation_fund\",\"type\":true,\"dynmaicParamReqList\":[{\"id\":40501,\"questionId\":6547,\"eventId\":186,\"param\":\"platform\",\"value\":\"dummy\",\"type\":1,\"sort\":1},{\"id\":40502,\"questionId\":6547,\"eventId\":186,\"param\":\"templateCode\",\"value\":\"001\",\"type\":1,\"sort\":1},{\"id\":40503,\"questionId\":6547,\"eventId\":186,\"param\":\"roles\",\"value\":\"3001\",\"type\":1,\"sort\":1}],\"value\":{\"name\":\"住房公积金办理 - 公积金单位开户申请\",\"form\":{\"configure\":{\"formName\":\"registrationForm\",\"companyName\":\"2\",\"integrityCode\":\"2\",\"companyProperty\":\"0\",\"accName\":\"账户名称\",\"accMoney\":\"0\",\"accUnit\":\"是\",\"accCode\":\"单位预算代码\",\"accDepartment\":\"业务经办部门\",\"accPhone\":\"联系电话\",\"accDate\":\"1日\",\"fundDate\":\"2021-02\",\"fundMonth\":\"跨年清册核定月份\",\"fundOrgan\":\"西城区管理部\",\"fundModel\":\"精度模式\"},\"weightMapper\":{\"companyName\":\"8\",\"integrityCode\":\"8\",\"companyProperty\":\"7\",\"accName\":\"7\",\"accMoney\":\"7\",\"accUnit\":\"7\",\"accCode\":\"7\",\"accDepartment\":\"7\",\"accPhone\":\"7\",\"accDate\":\"7\",\"fundDate\":\"7\",\"fundMonth\":\"7\",\"fundOrgan\":\"7\",\"fundModel\":\"7\"},\"aggrementMapper\":{\"accUnit\":5}},\"configureWidth\":\"250px\",\"scoreWidth\":\"90px\"},\"eventWeight\":25,\"standParseType\":0,\"sort\":1},{\"id\":187,\"eventName\":\"仿真住房公积金-4-经办人信息\",\"eventType\":0,\"eventUrl\":\"https://cjddcloud-test.oss-cn-beijing.aliyuncs.com/cjdd/course/20191114/57082CB9-1573705485442.jpg\",\"eventParam\":\"platform=dummy&templateCode=001&roles=3001\",\"eventTemplateUrl\":\"https://dummyedutest.cailian.net/#/houseHandle\",\"eventDesp\":\"\",\"roles\":null,\"modelType\":\"formTemplate\",\"modelName\":\"housing_PersonInCharge\",\"type\":true,\"dynmaicParamReqList\":[{\"id\":40504,\"questionId\":6547,\"eventId\":187,\"param\":\"platform\",\"value\":\"dummy\",\"type\":1,\"sort\":2},{\"id\":40505,\"questionId\":6547,\"eventId\":187,\"param\":\"templateCode\",\"value\":\"001\",\"type\":1,\"sort\":2},{\"id\":40506,\"questionId\":6547,\"eventId\":187,\"param\":\"roles\",\"value\":\"3001\",\"type\":1,\"sort\":2}],\"value\":{\"name\":\"住房公积金办理 - 经办人信息\",\"form\":{\"configure\":{\"formName\":\"operatorForm\",\"operName\":\"经办人姓名\",\"operType\":\"中华人民共和国居民身份证\",\"operIder\":\"经办人证件号码\",\"operPhone\":\"经办人手机号码\",\"operNum\":\"经办人电话号码\",\"operEmail\":\"经办人邮箱\",\"twoName\":\"经办人姓名\",\"twoType\":\"中华人民共和国居民身份证\",\"twoIder\":\"经办人证件号码\",\"twoPhone\":\"经办人手机号码\",\"twoNum\":\"经办人电话号码\",\"twoEmail\":\"经办人邮箱\"},\"weightMapper\":{\"operName\":\"9\",\"operType\":\"9\",\"operIder\":\"9\",\"operPhone\":\"9\",\"operNum\":\"8\",\"operEmail\":\"8\",\"twoName\":\"8\",\"twoType\":\"8\",\"twoIder\":\"8\",\"twoPhone\":\"8\",\"twoNum\":\"8\",\"twoEmail\":\"8\"},\"aggrementMapper\":{\"operType\":5}},\"configureWidth\":\"250px\",\"scoreWidth\":\"90px\"},\"eventWeight\":25,\"standParseType\":0,\"sort\":2},{\"id\":188,\"eventName\":\"仿真住房公积金-5-委托收款信息\",\"eventType\":0,\"eventUrl\":\"https://cjddcloud-test.oss-cn-beijing.aliyuncs.com/cjdd/course/20191114/3E10A4AE-1573705524460.jpg\",\"eventParam\":\"platform=dummy&templateCode=001&roles=3001\",\"eventTemplateUrl\":\"https://dummyedutest.cailian.net/#/houseHandle\",\"eventDesp\":\"\",\"roles\":null,\"modelType\":\"formTemplate\",\"modelName\":\"housing_consignment_collection\",\"type\":true,\"dynmaicParamReqList\":[{\"id\":40507,\"questionId\":6547,\"eventId\":188,\"param\":\"platform\",\"value\":\"dummy\",\"type\":1,\"sort\":3},{\"id\":40508,\"questionId\":6547,\"eventId\":188,\"param\":\"templateCode\",\"value\":\"001\",\"type\":1,\"sort\":3},{\"id\":40509,\"questionId\":6547,\"eventId\":188,\"param\":\"roles\",\"value\":\"3001\",\"type\":1,\"sort\":3}],\"value\":{\"name\":\"住房公积金办理 - 委托收款信息\",\"form\":{\"configure\":{\"formName\":\"entrustForm\",\"entrustName\":\"委托收款信息账户名称\",\"entrustExchange\":\"银行交换号\",\"entrustSystem\":\"支付系统号\",\"entrustDate\":\"1日\",\"entrustMonth\":\"0\",\"entrustState\":\"启用\",\"entrustCollection\":\"2021-02-01\"},\"weightMapper\":{\"entrustName\":\"14\",\"entrustExchange\":\"14\",\"entrustSystem\":\"14\",\"entrustDate\":\"14\",\"entrustMonth\":\"14\",\"entrustState\":\"15\",\"entrustCollection\":\"15\"},\"step\":{},\"stepWeight\":{}},\"configureWidth\":\"250px\",\"scoreWidth\":\"90px\"},\"eventWeight\":25,\"standParseType\":0,\"sort\":3}]";
//        税务变更
//        String str2 = "[{\"id\":167,\"eventName\":\"仿真-税务变更-5- 附行业信息\",\"eventType\":0,\"eventUrl\":\"https://cjddcloud-test.oss-cn-beijing.aliyuncs.com/cjdd/course/20191030/2E1B48A0-1572419701564.jpg\",\"eventParam\":\"platform=dummy&templateCode=001&roles=3001\",\"eventTemplateUrl\":\"https://dummyedutest.cailian.net/#/taxChange\",\"eventDesp\":\"zz\",\"roles\":null,\"modelType\":\"tableTemplate\",\"modelName\":\"industry_information\",\"type\":true,\"dynmaicParamReqList\":[{\"id\":40480,\"questionId\":6545,\"eventId\":167,\"param\":\"platform\",\"value\":\"dummy\",\"type\":1,\"sort\":0},{\"id\":40481,\"questionId\":6545,\"eventId\":167,\"param\":\"templateCode\",\"value\":\"001\",\"type\":1,\"sort\":0},{\"id\":40482,\"questionId\":6545,\"eventId\":167,\"param\":\"roles\",\"value\":\"3001\",\"type\":1,\"sort\":0}],\"value\":{\"name\":\"附行业信息\",\"model\":\"税务变更 - 附行业信息\",\"form\":{\"configure\":{\"formName\":\"industryForm\",\"tableList\":[{\"industry\":\"行业\"}]},\"weightMapper\":{\"tableList\":\"100\",\"tableListMapper\":{\"industry\":\"100\"}},\"aggrementMapper\":{\"tableList\":95}}},\"eventWeight\":20,\"standParseType\":0,\"sort\":0},{\"id\":170,\"eventName\":\"仿真-税务变更 -4- 注册资本信息\",\"eventType\":0,\"eventUrl\":\"https://cjddcloud-test.oss-cn-beijing.aliyuncs.com/cjdd/course/20191031/CB802F2B-1572487385105.jpg\",\"eventParam\":\"platform=dummy&templateCode=001&roles=3001\",\"eventTemplateUrl\":\"https://dummyedutest.cailian.net/#/taxChange\",\"eventDesp\":\"zz\",\"roles\":null,\"modelType\":\"tableTemplate\",\"modelName\":\"registered_capital_info\",\"type\":true,\"dynmaicParamReqList\":[{\"id\":40483,\"questionId\":6545,\"eventId\":170,\"param\":\"platform\",\"value\":\"dummy\",\"type\":1,\"sort\":1},{\"id\":40484,\"questionId\":6545,\"eventId\":170,\"param\":\"templateCode\",\"value\":\"001\",\"type\":1,\"sort\":1},{\"id\":40485,\"questionId\":6545,\"eventId\":170,\"param\":\"roles\",\"value\":\"3001\",\"type\":1,\"sort\":1}],\"value\":{\"name\":\"注册资本信息\",\"model\":\"税务变更 - 注册资本信息\",\"form\":{\"configure\":{\"formName\":\"registereForm\",\"tableList\":[{\"inputCapital\":\"注册资本\",\"selectType\":\"人民币元\"}]},\"weightMapper\":{\"tableList\":\"100\",\"tableListMapper\":{\"inputCapital\":\"50\",\"selectType\":\"50\"}},\"aggrementMapper\":{\"tableList\":95}}},\"eventWeight\":20,\"standParseType\":0,\"sort\":1},{\"id\":178,\"eventName\":\"仿真-税务变更-3-投资总额信息\",\"eventType\":0,\"eventUrl\":\"https://cjddcloudtest.cailian.net/cjdd/course/20191206/948F5F99-1575638533592.png\",\"eventParam\":\"platform=dummy&templateCode=001&roles=3001\",\"eventTemplateUrl\":\"https://dummyedutest.cailian.net/#/taxChange\",\"eventDesp\":\"zz\",\"roles\":null,\"modelType\":\"tableTemplate\",\"modelName\":\"total_investment_info\",\"type\":true,\"dynmaicParamReqList\":[{\"id\":40486,\"questionId\":6545,\"eventId\":178,\"param\":\"platform\",\"value\":\"dummy\",\"type\":1,\"sort\":2},{\"id\":40487,\"questionId\":6545,\"eventId\":178,\"param\":\"templateCode\",\"value\":\"001\",\"type\":1,\"sort\":2},{\"id\":40488,\"questionId\":6545,\"eventId\":178,\"param\":\"roles\",\"value\":\"3001\",\"type\":1,\"sort\":2}],\"value\":{\"name\":\"投资总额信息\",\"model\":\"税务变更 - 投资总额信息\",\"form\":{\"configure\":{\"formName\":\"totalInvestorForm\",\"tableList\":[{\"investment\":\"投资总额\",\"selectTotal\":\"人民币元\"}]},\"weightMapper\":{\"tableList\":\"100\",\"tableListMapper\":{\"investment\":\"50\",\"selectTotal\":\"50\"}},\"aggrementMapper\":{\"tableList\":95}}},\"eventWeight\":20,\"standParseType\":0,\"sort\":2},{\"id\":192,\"eventName\":\"仿真-税务变更-2-投资方信息\",\"eventType\":0,\"eventUrl\":\"https://cjddcloud-test.oss-cn-beijing.aliyuncs.com/cjdd/course/20191118/71BC5B6A-1574059758517.jpg\",\"eventParam\":\"platform=dummy&templateCode=001&roles=3001\",\"eventTemplateUrl\":\"https://dummyedutest.cailian.net/#/taxChange\",\"eventDesp\":\"zz\",\"roles\":null,\"modelType\":\"tableTemplate\",\"modelName\":\"investor_information\",\"type\":true,\"dynmaicParamReqList\":[{\"id\":40489,\"questionId\":6545,\"eventId\":192,\"param\":\"platform\",\"value\":\"dummy\",\"type\":1,\"sort\":3},{\"id\":40490,\"questionId\":6545,\"eventId\":192,\"param\":\"templateCode\",\"value\":\"001\",\"type\":1,\"sort\":3},{\"id\":40491,\"questionId\":6545,\"eventId\":192,\"param\":\"roles\",\"value\":\"3001\",\"type\":1,\"sort\":3}],\"value\":{\"name\":\"投资方信息\",\"model\":\"税务变更 - 投资方信息\",\"form\":{\"configure\":{\"formName\":\"InvestorForm\",\"tableList\":[{\"InvestorName\":\"投资方名称\",\"nature\":\"投资方经济性质\",\"Investment\":\"1\",\"IdentificationName\":\"身份证证件号码\",\"nationality\":\"中华人民共和国\",\"address\":\"地址\",\"InvestmentInvestor\":\"投资方投资金\",\"paicker\":\"2021-02-01/2021-02-03\"}]},\"weightMapper\":{\"tableList\":\"100\",\"tableListMapper\":{\"InvestorName\":\"12\",\"nature\":\"12\",\"Investment\":\"12\",\"IdentificationName\":\"12\",\"nationality\":\"13\",\"address\":\"13\",\"InvestmentInvestor\":\"13\",\"paicker\":\"13\"}},\"aggrementMapper\":{\"tableList\":95}}},\"eventWeight\":20,\"standParseType\":0,\"sort\":3},{\"id\":193,\"eventName\":\"仿真-税务变更-1-税务变更登记表\",\"eventType\":0,\"eventUrl\":\"https://cjddcloud-test.oss-cn-beijing.aliyuncs.com/cjdd/course/20191118/111FE9B1-1574061932234.jpg\",\"eventParam\":\"platform=dummy&templateCode=001&roles=3001\",\"eventTemplateUrl\":\"https://dummyedutest.cailian.net/#/taxChange\",\"eventDesp\":\"zz\",\"roles\":null,\"modelType\":\"tableTemplate\",\"modelName\":\"tax_registration_form\",\"type\":true,\"dynmaicParamReqList\":[{\"id\":40492,\"questionId\":6545,\"eventId\":193,\"param\":\"platform\",\"value\":\"dummy\",\"type\":1,\"sort\":4},{\"id\":40493,\"questionId\":6545,\"eventId\":193,\"param\":\"templateCode\",\"value\":\"001\",\"type\":1,\"sort\":4},{\"id\":40494,\"questionId\":6545,\"eventId\":193,\"param\":\"roles\",\"value\":\"3001\",\"type\":1,\"sort\":4}],\"value\":{\"name\":\"税务变更登记表\",\"model\":\"税务变更 - 税务变更登记表\",\"form\":{\"configure\":{\"formName\":\"changeForm\",\"tableList\":[{\"selectVal\":\"批准设立证明或文件号\",\"PreviousContents\":\"变更前内容\",\"PostContents\":\"变更后内容\",\"organName\":\"批准机关名称\",\"Approval\":\"批准文件\"}]},\"weightMapper\":{\"tableList\":\"100\",\"tableListMapper\":{\"selectVal\":\"20\",\"PreviousContents\":\"20\",\"PostContents\":\"20\",\"organName\":\"20\",\"Approval\":\"20\"}},\"aggrementMapper\":{\"tableList\":95}}},\"eventWeight\":20,\"standParseType\":0,\"sort\":4}]";
//            税务登记
//        String str2 = "[{\"id\":156,\"eventName\":\"税务登记 -  纳税人存款账户账号报告表\",\"eventType\":0,\"eventUrl\":\"https://cjddcloud-test.oss-cn-beijing.aliyuncs.com/cjdd/course/20191022/91A22168-1571750467849.png\",\"eventParam\":\"platform=dummy&templateCode=001&roles=3001\",\"eventTemplateUrl\":\"https://dummyedutest.cailian.net/#/taxRegistration\",\"eventDesp\":\"zz 2019-11-26\",\"roles\":null,\"modelType\":\"tableTemplate\",\"modelName\":\"deposit_account_reportform\",\"type\":true,\"dynmaicParamReqList\":[{\"id\":40471,\"questionId\":6543,\"eventId\":156,\"param\":\"platform\",\"value\":\"dummy\",\"type\":1,\"sort\":0},{\"id\":40472,\"questionId\":6543,\"eventId\":156,\"param\":\"templateCode\",\"value\":\"001\",\"type\":1,\"sort\":0},{\"id\":40473,\"questionId\":6543,\"eventId\":156,\"param\":\"roles\",\"value\":\"3001\",\"type\":1,\"sort\":0}],\"value\":{\"name\":\"纳税人存款账户账号报告表\",\"model\":\"税务登记 - 纳税人存款账户账号报告表\",\"form\":{\"configure\":{\"formName\":\"depositReportForm\",\"tableData\":[{\"accountCharacter\":\"账号性质\",\"registerNumber\":\"银行开户登记证号\",\"grantDate\":\"2021-02-01\",\"administrativeDivision\":\"行政区划\",\"bankType\":\"银行行别\",\"openBank\":\"开户银行\",\"accountName\":\"账号名称\",\"accountNumber\":\"账号\",\"currency\":\"人民币\",\"firstpayTaxes\":\"首选缴税账号标识\",\"drawback\":\"一般退税账号标识\",\"openingDate\":\"2021-02-01\",\"ramarks\":\"备注\"}]},\"weightMapper\":{\"tableData\":\"100\",\"tableDataMapper\":{\"accountCharacter\":\"8\",\"registerNumber\":\"8\",\"grantDate\":\"7\",\"administrativeDivision\":\"8\",\"bankType\":\"8\",\"openBank\":\"8\",\"accountNumber\":\"8\",\"accountName\":\"8\",\"currency\":\"8\",\"firstpayTaxes\":\"8\",\"drawback\":\"7\",\"openingDate\":\"7\",\"ramarks\":\"7\"}},\"aggrementMapper\":{\"tableData\":95}}},\"eventWeight\":50,\"standParseType\":0,\"sort\":0},{\"id\":157,\"eventName\":\"仿真税务登记-2-信息采集\",\"eventType\":0,\"eventUrl\":\"https://cjddcloud-test.oss-cn-beijing.aliyuncs.com/cjdd/course/20191022/B19A3C93-1571750601822.png\",\"eventParam\":\"platform=dummy&templateCode=001&roles=3001\",\"eventTemplateUrl\":\"https://dummyedutest.cailian.net/#/taxRegistration\",\"eventDesp\":\"好了，wjl，20191122\",\"roles\":null,\"modelType\":\"formTemplate\",\"modelName\":\"registration_information_acquisition\",\"type\":true,\"dynmaicParamReqList\":[{\"id\":40474,\"questionId\":6543,\"eventId\":157,\"param\":\"platform\",\"value\":\"dummy\",\"type\":1,\"sort\":1},{\"id\":40475,\"questionId\":6543,\"eventId\":157,\"param\":\"templateCode\",\"value\":\"001\",\"type\":1,\"sort\":1},{\"id\":40476,\"questionId\":6543,\"eventId\":157,\"param\":\"roles\",\"value\":\"3001\",\"type\":1,\"sort\":1}],\"value\":{\"name\":\"税务登记 - 个体经营税务登记证信息采集\",\"form\":{\"configure\":{\"formName\":\"IndividualBusinessRegistration\",\"taxIdentNumber\":\"纳税人识别号\",\"taxIdentName\":\"纳税人名称\",\"registrationType\":\"登记注册类型\",\"establishmentDate\":\"2021-02-01\",\"organType\":\"批准设立机关类型\",\"organization\":\"批准设立机关\",\"certificationName\":\"证照名称\",\"certificationNumber\":\"证照号码\",\"organizationCode\":\"组织机构代码\",\"fileNumber\":\"批准设立证明或文件号\",\"OwnerName\":\"业主姓名\",\"OwnerTel\":\"业主固定电话\",\"OwnerPhone\":\"业主联系电话\",\"identityType\":\"中华人民共和国居民身份证\",\"identityNumber\":\"身份证件号码\",\"administrativeArea\":\"经营地址所在行政区\",\"businessPlaceTel\":\"生产经营地联系电话\",\"productionAddress\":\"生产经营地址\",\"industry\":\"国标行业(主)\",\"businessScope\":\"经营范围\",\"taxpayerTown\":\"纳税人所处街乡\",\"Affiliation\":\"隶属关系\",\"taxBureau\":\"主管税务局\"},\"weightMapper\":{\"taxIdentNumber\":\"5\",\"taxIdentName\":\"5\",\"registrationType\":\"5\",\"establishmentDate\":\"5\",\"organType\":\"5\",\"organization\":\"5\",\"certificationName\":\"5\",\"certificationNumber\":\"5\",\"organizationCode\":\"4\",\"fileNumber\":\"4\",\"OwnerName\":\"4\",\"OwnerTel\":\"4\",\"OwnerPhone\":\"4\",\"identityType\":\"4\",\"identityNumber\":\"4\",\"administrativeArea\":\"4\",\"businessPlaceTel\":\"4\",\"productionAddress\":\"4\",\"industry\":\"4\",\"businessScope\":\"4\",\"taxpayerTown\":\"4\",\"Affiliation\":\"4\",\"taxBureau\":\"4\"},\"step\":{},\"stepWeight\":{}},\"configureWidth\":\"250px\",\"scoreWidth\":\"90px\"},\"eventWeight\":50,\"standParseType\":0,\"sort\":1}]";
//        代开发票
//        String str2 = "[{\"id\":126,\"eventName\":\"税局_代开发票2--填写购买方表单\",\"eventType\":0,\"eventUrl\":\"https://cjddcloud-test.oss-cn-beijing.aliyuncs.com/cjdd/course/20191022/137AE62B-1571727040913.png\",\"eventParam\":\"platform=dummy&templateCode=001&roles=3001\",\"eventTemplateUrl\":\"https://dummyedutest.cailian.net/#/invoice\",\"eventDesp\":\"王。1\",\"roles\":null,\"modelType\":\"formTemplate\",\"modelName\":\"invoicing_purchaser\",\"type\":true,\"dynmaicParamReqList\":[{\"id\":40459,\"questionId\":6541,\"eventId\":126,\"param\":\"platform\",\"value\":\"dummy\",\"type\":1,\"sort\":0},{\"id\":40460,\"questionId\":6541,\"eventId\":126,\"param\":\"templateCode\",\"value\":\"001\",\"type\":1,\"sort\":0},{\"id\":40461,\"questionId\":6541,\"eventId\":126,\"param\":\"roles\",\"value\":\"3001\",\"type\":1,\"sort\":0}],\"value\":{\"name\":\"代开发票 - 购买方信息\",\"form\":{\"configure\":{\"formName\":\"buyForm\",\"companyName\":\"名称\",\"companyCode\":\"纳税人识别号\",\"companyAddress\":\"地址\",\"companyTelephone\":\"电话\",\"companyBank\":\"开户银行\",\"companyBankCode\":\"银行账号\"},\"weightMapper\":{\"companyName\":\"16\",\"companyCode\":\"16\",\"companyAddress\":\"17\",\"companyTelephone\":\"17\",\"companyBank\":\"17\",\"companyBankCode\":\"17\"},\"aggrementMapper\":{}},\"configureWidth\":\"250px\",\"scoreWidth\":\"90px\"},\"eventWeight\":30,\"standParseType\":0,\"sort\":0},{\"id\":127,\"eventName\":\"税局_代开发票4--增值税开票信息填报\",\"eventType\":0,\"eventUrl\":\"https://cjddcloud-test.oss-cn-beijing.aliyuncs.com/cjdd/course/20191022/4A970F5A-1571727119749.png\",\"eventParam\":\"platform=dummy&templateCode=001&roles=3001\",\"eventTemplateUrl\":\"https://dummyedutest.cailian.net/#/invoice\",\"eventDesp\":\"王。1\",\"roles\":null,\"type\":true,\"modelType\":\"invoicingDeclaration\",\"dynmaicParamReqList\":[{\"id\":40462,\"questionId\":6541,\"eventId\":127,\"param\":\"platform\",\"value\":\"dummy\",\"type\":1,\"sort\":1},{\"id\":40463,\"questionId\":6541,\"eventId\":127,\"param\":\"templateCode\",\"value\":\"001\",\"type\":1,\"sort\":1},{\"id\":40464,\"questionId\":6541,\"eventId\":127,\"param\":\"roles\",\"value\":\"3001\",\"type\":1,\"sort\":1}],\"eventWeight\":30,\"value\":{\"formName\":\"taxInvoiceForm\",\"taxationChineseMoney\":\"壹拾壹元叁角叁分\",\"taxationMoney\":11.33,\"AllnoTaxTotal\":\"11.00\",\"AlltaxMoney\":\"0.33\",\"data\":[{\"type\":\"应税货物与劳务\",\"typeDetail\":\"\",\"serviceName\":\"1\",\"serviceType\":\"\",\"unit\":\"\",\"taxTotal\":11.33,\"number\":\"1\",\"price\":\"11\",\"noTaxTotal\":11,\"rate\":0.03,\"taxMoney\":\"0.33\"}],\"weightMapper\":{\"data\":\"100\"},\"aggrementMapper\":{\"data\":105}},\"standParseType\":1,\"sort\":1},{\"id\":173,\"eventName\":\"税局_代开发票3--填写销售方信息\",\"eventType\":0,\"eventUrl\":\"https://cjddcloud-test.oss-cn-beijing.aliyuncs.com/cjdd/course/20191103/1169E5D8-1572761548344.jpg\",\"eventParam\":\"platform=dummy&templateCode=001&roles=3001\",\"eventTemplateUrl\":\"https://dummyedutest.cailian.net/#/invoice\",\"eventDesp\":\"王。1\",\"roles\":null,\"modelType\":\"formTemplate\",\"modelName\":\"invoicing_seller\",\"type\":true,\"dynmaicParamReqList\":[{\"id\":40465,\"questionId\":6541,\"eventId\":173,\"param\":\"platform\",\"value\":\"dummy\",\"type\":1,\"sort\":2},{\"id\":40466,\"questionId\":6541,\"eventId\":173,\"param\":\"templateCode\",\"value\":\"001\",\"type\":1,\"sort\":2},{\"id\":40467,\"questionId\":6541,\"eventId\":173,\"param\":\"roles\",\"value\":\"3001\",\"type\":1,\"sort\":2}],\"value\":{\"name\":\"代开发票 - 销售方信息\",\"form\":{\"configure\":{\"formName\":\"saleForm\",\"companyName\":\"名称\",\"companyCode\":\"纳税人识别号\",\"companyAddress\":\"地址\",\"companyTelephone\":\"电话\",\"companyBank\":\"开户银行\",\"companyBankCode\":\"银行账号\"},\"weightMapper\":{\"companyName\":\"16\",\"companyCode\":\"16\",\"companyAddress\":\"17\",\"companyTelephone\":\"17\",\"companyBank\":\"17\",\"companyBankCode\":\"17\"},\"aggrementMapper\":{}},\"configureWidth\":\"250px\",\"scoreWidth\":\"90px\"},\"eventWeight\":40,\"standParseType\":0,\"sort\":2}]";
//        企业设立登记-zdh
//        String str2 = "[{\"id\":131,\"eventName\":\"&#x4F01;&#x4E1A;&#x8BBE;&#x7ACB;&#x767B;&#x8BB0;-1-&#x70B9;&#x51FB;&#x4E8B;&#x9879;\",\"eventType\":0,\"eventUrl\":\"https://cjddcloud-test.oss-cn-beijing.aliyuncs.com/cjdd/course/20191022/6A2B6856-1571728724741.jpg\",\"eventParam\":\"platform=dummy&templateCode=001&roles=3001\",\"eventTemplateUrl\":\"https://dummyedutest.cailian.net/#/businessRegister\",\"eventDesp\":\"&#x738B;&#x3002;1\",\"roles\":null,\"modelType\":\"formTemplate\",\"modelName\":\"enterprise_establishment_registration\",\"type\":true,\"dynmaicParamReqList\":[{\"id\":40438,\"questionId\":6540,\"eventId\":131,\"param\":\"platform\",\"value\":\"dummy\",\"type\":1,\"sort\":0},{\"id\":40439,\"questionId\":6540,\"eventId\":131,\"param\":\"templateCode\",\"value\":\"001\",\"type\":1,\"sort\":0},{\"id\":40440,\"questionId\":6540,\"eventId\":131,\"param\":\"roles\",\"value\":\"3001\",\"type\":1,\"sort\":0}],\"value\":{\"name\":\"&#x4F01;&#x4E1A;&#x8BBE;&#x7ACB;&#x767B;&#x8BB0; - &#x70B9;&#x51FB;&#x6B65;&#x9AA4;\",\"form\":{\"configure\":{},\"step\":{},\"weightMapper\":{},\"stepWeight\":{\"business_personal\":\"11\",\"business_login\":\"11\",\"business_company\":\"11\",\"business_establish\":\"11\",\"business_window\":\"11\",\"business_euser\":\"11\",\"business_handle\":\"11\",\"business_open\":\"11\",\"business_apply\":\"12\"},\"aggrementMapper\":{}},\"configureWidth\":\"250px\",\"scoreWidth\":\"60px\"},\"eventWeight\":10,\"standParseType\":0,\"sort\":0},{\"id\":132,\"eventName\":\"&#x4F01;&#x4E1A;&#x8BBE;&#x7ACB;&#x767B;&#x8BB0;-6-&#x4EBA;&#x5458;&#x4FE1;&#x606F;\",\"eventType\":0,\"eventUrl\":\"https://cjddcloud-test.oss-cn-beijing.aliyuncs.com/cjdd/course/20191022/EE85CEF4-1571728765317.jpg\",\"eventParam\":\"platform=dummy&templateCode=001&roles=3001\",\"eventTemplateUrl\":\"https://dummyedutest.cailian.net/#/businessRegister\",\"eventDesp\":\"zz\",\"roles\":null,\"type\":true,\"modelType\":\"basicPersonnelInfo\",\"dynmaicParamReqList\":[{\"id\":40441,\"questionId\":6540,\"eventId\":132,\"param\":\"platform\",\"value\":\"dummy\",\"type\":1,\"sort\":1},{\"id\":40442,\"questionId\":6540,\"eventId\":132,\"param\":\"templateCode\",\"value\":\"001\",\"type\":1,\"sort\":1},{\"id\":40443,\"questionId\":6540,\"eventId\":132,\"param\":\"roles\",\"value\":\"3001\",\"type\":1,\"sort\":1}],\"eventWeight\":20,\"value\":{\"formName\":\"perInfoForm\",\"directorList\":[{\"directorName\":\"&#x59D3;&#x540D;\",\"directorEnglish\":\"&#x59D3;&#x540D;(&#x82F1;&#x6587;)\",\"directorType\":\"&#x4E2D;&#x534E;&#x4EBA;&#x6C11;&#x5171;&#x548C;&#x56FD;&#x5C45;&#x6C11;&#x8EAB;&#x4EFD;&#x8BC1;\",\"directorIdNum\":\"&#x8BC1;&#x4EF6;&#x53F7;&#x7801;\",\"directorArea\":\"&#x4E2D;&#x56FD;\",\"directorSex\":3,\"directorPhone\":\"&#x8054;&#x7CFB;&#x7535;&#x8BDD;\",\"directorDegree\":\"0\",\"directorNation\":\"&#x6C49;&#x65CF;\",\"directorOutlook\":\"0\",\"directorDate\":\"2021-02-01\",\"directorPost\":\"&#x804C;&#x52A1;\",\"directorStart\":\"2021-02-01\",\"directorEnd\":\"2021-02-01\",\"directorMode\":\"&#x59D4;&#x6D3E;\",\"directorTerm\":\"0\",\"directorAddress1\":\"&#x6237;&#x7C4D;&#x767B;&#x8BB0;\"}],\"managerList\":[],\"supervisorList\":[],\"other1List\":[{\"otherName\":\"&#x59D3;&#x540D;\",\"otherType\":\"&#x4E2D;&#x534E;&#x4EBA;&#x6C11;&#x5171;&#x548C;&#x56FD;&#x5C45;&#x6C11;&#x8EAB;&#x4EFD;&#x8BC1;\",\"otherIdNum\":\"&#x8BC1;&#x4EF6;&#x53F7;&#x7801;\",\"otherPhone\":\"&#x79FB;&#x52A8;&#x7535;&#x8BDD;\",\"otherTel\":\"&#x56FA;&#x5B9A;&#x7535;&#x8BDD;\",\"otherEmail\":\"&#x7535;&#x5B50;&#x90AE;&#x7BB1;\",\"otherStart\":\"2021-02-01\",\"otherEnd\":\"2021-02-03\"}],\"other2List\":[{\"otherName\":\"&#x59D3;&#x540D;\",\"otherType\":\"&#x4E2D;&#x534E;&#x4EBA;&#x6C11;&#x5171;&#x548C;&#x56FD;&#x5C45;&#x6C11;&#x8EAB;&#x4EFD;&#x8BC1;\",\"otherIdNum\":\"&#x8BC1;&#x4EF6;&#x53F7;&#x7801;\",\"otherPhone\":\"&#x79FB;&#x52A8;&#x7535;&#x8BDD;\",\"otherTel\":\"&#x56FA;&#x5B9A;&#x7535;&#x8BDD;\",\"otherEmail\":\"&#x7535;&#x5B50;&#x90AE;&#x7BB1;\",\"otherStart\":\"2021-02-01\",\"otherEnd\":\"2021-02-03\"}],\"other3List\":[{\"otherName\":\"&#x59D3;&#x540D;\",\"otherType\":\"&#x4E2D;&#x534E;&#x4EBA;&#x6C11;&#x5171;&#x548C;&#x56FD;&#x5C45;&#x6C11;&#x8EAB;&#x4EFD;&#x8BC1;\",\"otherIdNum\":\"&#x8BC1;&#x4EF6;&#x53F7;&#x7801;\",\"otherPhone\":\"&#x79FB;&#x52A8;&#x7535;&#x8BDD;\",\"otherTel\":\"&#x56FA;&#x5B9A;&#x7535;&#x8BDD;\",\"otherEmail\":\"&#x7535;&#x5B50;&#x90AE;&#x7BB1;\",\"otherStart\":\"2021-02-01\",\"otherEnd\":\"2021-02-02\"}],\"other4List\":[{\"otherName\":\"&#x59D3;&#x540D;\",\"otherType\":\"&#x4E2D;&#x534E;&#x4EBA;&#x6C11;&#x5171;&#x548C;&#x56FD;&#x5C45;&#x6C11;&#x8EAB;&#x4EFD;&#x8BC1;\",\"otherIdNum\":\"&#x8BC1;&#x4EF6;&#x53F7;&#x7801;\",\"otherPhone\":\"&#x79FB;&#x52A8;&#x7535;&#x8BDD;\",\"otherTel\":\"&#x56FA;&#x5B9A;&#x7535;&#x8BDD;\",\"otherEmail\":\"&#x7535;&#x5B50;&#x90AE;&#x7BB1;\",\"otherStart\":\"2021-02-01\",\"otherEnd\":\"2021-02-02\"}],\"other5List\":[{\"otherName\":\"&#x59D3;&#x540D;\",\"otherType\":\"&#x4E2D;&#x534E;&#x4EBA;&#x6C11;&#x5171;&#x548C;&#x56FD;&#x5C45;&#x6C11;&#x8EAB;&#x4EFD;&#x8BC1;\",\"otherIdNum\":\"&#x8BC1;&#x4EF6;&#x53F7;&#x7801;\",\"otherPhone\":\"&#x79FB;&#x52A8;&#x7535;&#x8BDD;\",\"otherTel\":\"&#x56FA;&#x5B9A;&#x7535;&#x8BDD;\",\"otherEmail\":\"&#x7535;&#x5B50;&#x90AE;&#x7BB1;\",\"otherStart\":\"2021-02-01\",\"otherEnd\":\"2021-02-03\"}],\"other6List\":[{\"otherName\":\"&#x59D3;&#x540D;\",\"otherType\":\"&#x4E2D;&#x534E;&#x4EBA;&#x6C11;&#x5171;&#x548C;&#x56FD;&#x5C45;&#x6C11;&#x8EAB;&#x4EFD;&#x8BC1;\",\"otherIdNum\":\"&#x8BC1;&#x4EF6;&#x53F7;&#x7801;\",\"otherPhone\":\"&#x79FB;&#x52A8;&#x7535;&#x8BDD;\",\"otherTel\":\"&#x56FA;&#x5B9A;&#x7535;&#x8BDD;\",\"otherEmail\":\"&#x7535;&#x5B50;&#x90AE;&#x7BB1;\",\"otherStart\":\"2021-02-01\",\"otherEnd\":\"2021-02-03\"}],\"weightMapper\":{\"directorList\":\"9\",\"managerList\":\"9\",\"supervisorList\":\"9\",\"legalTel\":\"8\",\"legalPhone\":\"8\",\"legalName\":\"8\",\"other1List\":\"8\",\"other2List\":\"8\",\"other3List\":\"8\",\"other4List\":\"8\",\"other5List\":\"8\",\"other6List\":\"9\",\"directorListMapper\":{\"directorName\":\"5\",\"directorEnglish\":\"5\",\"directorType\":\"5\",\"directorIdNum\":\"5\",\"directorArea\":\"5\",\"directorSex\":\"5\",\"directorPhone\":\"6\",\"directorDegree\":\"6\",\"directorNation\":\"6\",\"directorOutlook\":\"6\",\"directorDate\":\"6\",\"directorPost\":\"6\",\"directorStart\":\"6\",\"directorEnd\":\"6\",\"directorMode\":\"6\",\"directorTerm\":\"6\",\"directorAddress1\":\"10\"},\"managerListMapper\":{\"directorName\":\"5\",\"directorEnglish\":\"5\",\"directorType\":\"5\",\"directorIdNum\":\"5\",\"directorArea\":\"5\",\"directorSex\":\"5\",\"directorPhone\":\"6\",\"directorDegree\":\"6\",\"directorNation\":\"6\",\"directorOutlook\":\"6\",\"directorDate\":\"6\",\"directorPost\":\"6\",\"directorStart\":\"6\",\"directorEnd\":\"6\",\"directorMode\":\"6\",\"directorTerm\":\"6\",\"directorAddress1\":\"10\"},\"supervisorListMapper\":{\"directorName\":\"5\",\"directorEnglish\":\"5\",\"directorType\":\"5\",\"directorIdNum\":\"5\",\"directorArea\":\"5\",\"directorSex\":\"5\",\"directorPhone\":\"6\",\"directorDegree\":\"6\",\"directorNation\":\"6\",\"directorOutlook\":\"6\",\"directorDate\":\"6\",\"directorPost\":\"6\",\"directorStart\":\"6\",\"directorEnd\":\"6\",\"directorMode\":\"6\",\"directorTerm\":\"6\",\"directorAddress1\":\"10\"},\"other1ListMapper\":{\"otherName\":\"13\",\"otherType\":\"13\",\"otherIdNum\":\"13\",\"otherPhone\":\"13\",\"otherTel\":\"12\",\"otherEmail\":\"12\",\"otherStart\":\"12\",\"otherEnd\":\"12\"},\"other2ListMapper\":{\"otherName\":\"13\",\"otherType\":\"13\",\"otherIdNum\":\"13\",\"otherPhone\":\"13\",\"otherTel\":\"12\",\"otherEmail\":\"12\",\"otherStart\":\"12\",\"otherEnd\":\"12\"},\"other3ListMapper\":{\"otherName\":\"13\",\"otherType\":\"13\",\"otherIdNum\":\"13\",\"otherPhone\":\"13\",\"otherTel\":\"12\",\"otherEmail\":\"12\",\"otherStart\":\"12\",\"otherEnd\":\"12\"},\"other4ListMapper\":{\"otherName\":\"13\",\"otherType\":\"13\",\"otherIdNum\":\"13\",\"otherPhone\":\"13\",\"otherTel\":\"12\",\"otherEmail\":\"12\",\"otherStart\":\"12\",\"otherEnd\":\"12\"},\"other5ListMapper\":{\"otherName\":\"13\",\"otherType\":\"13\",\"otherIdNum\":\"13\",\"otherPhone\":\"13\",\"otherTel\":\"12\",\"otherEmail\":\"12\",\"otherStart\":\"12\",\"otherEnd\":\"12\"},\"other6ListMapper\":{\"otherName\":\"13\",\"otherType\":\"13\",\"otherIdNum\":\"13\",\"otherPhone\":\"13\",\"otherTel\":\"12\",\"otherEmail\":\"12\",\"otherStart\":\"12\",\"otherEnd\":\"12\"}},\"aggrementMapper\":{\"directorList\":99,\"managerList\":99,\"supervisorList\":99,\"other1List\":97,\"other2List\":97,\"other3List\":97,\"other4List\":97,\"other5List\":97,\"other6List\":97}},\"standParseType\":1,\"sort\":1},{\"id\":133,\"eventName\":\"&#x4F01;&#x4E1A;&#x8BBE;&#x7ACB;&#x767B;&#x8BB0;-4-&#x4F01;&#x4E1A;&#x57FA;&#x672C;&#x4FE1;&#x606F;&#x8868;&#x5355; \",\"eventType\":0,\"eventUrl\":\"https://cjddcloud-test.oss-cn-beijing.aliyuncs.com/cjdd/course/20191022/03F20D18-1571728815150.jpg\",\"eventParam\":\"platform=dummy&templateCode=001&roles=3001\",\"eventTemplateUrl\":\"https://dummyedutest.cailian.net/#/businessRegister\",\"eventDesp\":\"&#x738B;&#x3002;1\",\"roles\":null,\"modelType\":\"formTemplate\",\"modelName\":\"basic_information_enterprise\",\"type\":true,\"dynmaicParamReqList\":[{\"id\":40444,\"questionId\":6540,\"eventId\":133,\"param\":\"platform\",\"value\":\"dummy\",\"type\":1,\"sort\":2},{\"id\":40445,\"questionId\":6540,\"eventId\":133,\"param\":\"templateCode\",\"value\":\"001\",\"type\":1,\"sort\":2},{\"id\":40446,\"questionId\":6540,\"eventId\":133,\"param\":\"roles\",\"value\":\"3001\",\"type\":1,\"sort\":2}],\"value\":{\"name\":\"&#x4F01;&#x4E1A;&#x8BBE;&#x7ACB;&#x767B;&#x8BB0; - &#x4F01;&#x4E1A;&#x57FA;&#x672C;&#x4FE1;&#x606F;&#x8868;&#x5355;\",\"form\":{\"configure\":{\"formName\":\"infoForm\",\"jycs\":\"&#x4F4F;&#x6240;(&#x7ECF;&#x8425;&#x573A;&#x6240;)\",\"scjyd\":\"&#x751F;&#x4EA7;&#x7ECF;&#x8425;&#x5730;\",\"zssyqx\":\"&#x4F4F;&#x6240;&#x4F7F;&#x7528;&#x671F;&#x9650;(&#x5E74;)\",\"yymj\":\"\",\"fwyt\":\"&#x623F;&#x5C4B;&#x7528;&#x9014;\",\"zscqr\":\"&#x4F4F;&#x6240;(&#x4EA7;&#x6743;&#x4EBA;)\",\"zscqlx\":\"&#x6709;&#x623F;&#x4EA7;&#x8BC1;\",\"zstgfs\":\"&#x81EA;&#x6709;\",\"yyqx\":\"3\",\"zzfbs\":\"5\",\"isweizhi\":\"&#x662F;\"},\"weightMapper\":{\"jycs\":\"9\",\"scjyd\":\"9\",\"zssyqx\":\"9\",\"yymj\":\"9\",\"fwyt\":\"9\",\"zscqr\":\"9\",\"zscqlx\":\"9\",\"zstgfs\":\"9\",\"yyqx\":\"9\",\"zzfbs\":\"9\",\"isweizhi\":\"10\"},\"aggrementMapper\":{\"zstgfs\":5,\"isweizhi\":5,\"zscqlx\":5}},\"configureWidth\":\"250px\",\"scoreWidth\":\"60px\"},\"eventWeight\":20,\"standParseType\":0,\"sort\":2},{\"id\":135,\"eventName\":\"&#x4F01;&#x4E1A;&#x8BBE;&#x7ACB;&#x767B;&#x8BB0;-7-&#x7A0E;&#x52A1;&#x4FE1;&#x606F;&#x786E;&#x8BA4;\",\"eventType\":0,\"eventUrl\":\"https://cjddcloud-test.oss-cn-beijing.aliyuncs.com/cjdd/course/20191022/E7D339D7-1571728965500.jpg\",\"eventParam\":\"platform=dummy&templateCode=001&roles=3001\",\"eventTemplateUrl\":\"https://dummyedutest.cailian.net/#/businessRegister\",\"eventDesp\":\"&#x738B;&#x3002;\",\"roles\":null,\"modelType\":\"formTemplate\",\"modelName\":\"tax_information_confirmation\",\"type\":true,\"dynmaicParamReqList\":[{\"id\":40447,\"questionId\":6540,\"eventId\":135,\"param\":\"platform\",\"value\":\"dummy\",\"type\":1,\"sort\":3},{\"id\":40448,\"questionId\":6540,\"eventId\":135,\"param\":\"templateCode\",\"value\":\"001\",\"type\":1,\"sort\":3},{\"id\":40449,\"questionId\":6540,\"eventId\":135,\"param\":\"roles\",\"value\":\"3001\",\"type\":1,\"sort\":3}],\"value\":{\"name\":\"&#x4F01;&#x4E1A;&#x8BBE;&#x7ACB;&#x767B;&#x8BB0; - &#x7A0E;&#x52A1;&#x4FE1;&#x606F;&#x786E;&#x8BA4;\",\"form\":{\"configure\":{\"formName\":\"taxationInfoForm\",\"taxName\":\"&#x59D3;&#x540D;\",\"taxEmail\":\"&#x7535;&#x5B50;&#x90AE;&#x7BB1;\",\"taxType\":\"&#x8BC1;&#x4EF6;&#x7C7B;&#x578B;\",\"taxIdNum\":\"&#x8BC1;&#x4EF6;&#x53F7;&#x7801;\",\"taxTel\":\"&#x79FB;&#x52A8;&#x53F7;&#x7801;\",\"project1\":\"&#x9879;&#x76EE;&#x7C7B;&#x522B;\",\"project2\":\"&#x7ECF;&#x8425;&#x5927;&#x7C7B;\",\"project3\":\"&#x7ECF;&#x8425;&#x660E;&#x7EC6;\",\"project4\":\"&#x884C;&#x4E1A;&#x540D;&#x79F0;\",\"project5\":\"&#x9884;&#x8BA1;&#x7ECF;&#x8425;&#x5360;&#x6BD4;\"},\"weightMapper\":{\"taxName\":\"10\",\"taxEmail\":\"10\",\"taxType\":\"10\",\"taxIdNum\":\"10\",\"taxTel\":\"10\",\"project1\":\"10\",\"project2\":\"10\",\"project3\":\"10\",\"project4\":\"10\",\"project5\":\"10\"},\"aggrementMapper\":{}},\"configureWidth\":\"250px\",\"scoreWidth\":\"60px\"},\"eventWeight\":20,\"standParseType\":0,\"sort\":3},{\"id\":184,\"eventName\":\"&#x4F01;&#x4E1A;&#x8BBE;&#x7ACB;&#x767B;&#x8BB0;-3-&#x81EA;&#x7136;&#x4EBA;&#x80A1;&#x4E1C;&#x4FE1;&#x606F;\",\"eventType\":0,\"eventUrl\":\"https://cjddcloud-test.oss-cn-beijing.aliyuncs.com/cjdd/course/20191112/D5611119-1573543192430.jpg\",\"eventParam\":\"platform=dummy&templateCode=001&roles=3001\",\"eventTemplateUrl\":\"https://dummyedutest.cailian.net/#/businessRegister\",\"eventDesp\":\"zz\",\"roles\":null,\"type\":true,\"modelType\":\"naturalPerson\",\"dynmaicParamReqList\":[{\"id\":40450,\"questionId\":6540,\"eventId\":184,\"param\":\"platform\",\"value\":\"dummy\",\"type\":1,\"sort\":4},{\"id\":40451,\"questionId\":6540,\"eventId\":184,\"param\":\"templateCode\",\"value\":\"001\",\"type\":1,\"sort\":4},{\"id\":40452,\"questionId\":6540,\"eventId\":184,\"param\":\"roles\",\"value\":\"3001\",\"type\":1,\"sort\":4}],\"eventWeight\":20,\"value\":{\"formName\":\"shareholderForm\",\"natural\":[{\"ruleName\":\"&#x59D3;&#x540D;\",\"ruleType\":\"&#x8EAB;&#x4EFD;&#x8BC1;&#x53F7;&#x7801;\",\"ruleNation\":\"&#x6C49;&#x65CF;\",\"ruleInvestor\":\"&#x81EA;&#x7136;&#x4EBA;&#x80A1;&#x4E1C;\",\"city\":\"&#x5317;&#x4EAC;&#x5E02;\",\"area\":\"&#x6237;&#x7C4D;&#x767B;&#x8BB0;&#x5730;\",\"detail\":\"&#x6237;&#x7C4D;&#x767B;&#x8BB0;&#x5730;\",\"date1\":\"2021-02-01\",\"date2\":\"2021-02-02\",\"tableData\":[{\"cze\":\"1\",\"czfs\":\"0\",\"czrq\":\"2021-02-01\"}],\"totalCze\":1}],\"notNatural\":[{\"ruleName\":\"&#x5355;&#x4F4D;&#x540D;&#x79F0;\",\"ruleType\":\"&#x6CD5;&#x4EBA;&#x80A1;&#x4E1C;\",\"ruleLicence\":\"&#x4F01;&#x4E1A;&#x6CD5;&#x4EBA;&#x8425;&#x4E1A;&#x6267;&#x7167;\",\"ruleLicenceNum\":\"&#x8BC1;&#x4EF6;&#x53F7;&#x7801;\",\"ruleLegal\":\"&#x6CD5;&#x5B9A;&#x4EE3;&#x8868;&#x4EBA;\",\"ruleLegalType\":\"&#x4E2D;&#x534E;&#x4EBA;&#x6C11;&#x5171;&#x548C;&#x56FD;&#x5C45;&#x6C11;&#x8EAB;&#x4EFD;&#x8BC1;\",\"city\":\"&#x5317;&#x4EAC;&#x5E02;\",\"area\":\"&#x4F4F;&#x6240;\",\"detail\":\"&#x4F4F;&#x6240;\",\"tableData\":[{\"cze\":\"1\",\"czfs\":\"0\",\"czrq\":\"2021-02-01\"}],\"totalCze\":1,\"date1\":\"2021-02-01\",\"date2\":\"2021-02-03\",\"ruleArea\":\"&#x4E2D;&#x56FD;\"}],\"weightMapper\":{\"natural\":\"50\",\"notNatural\":\"50\",\"naturalMapper\":{\"ruleName\":\"10\",\"ruleType\":\"10\",\"ruleNation\":\"10\",\"ruleInvestor\":\"10\",\"city\":\"4\",\"area\":\"3\",\"detail\":\"3\",\"date1\":\"10\",\"date2\":\"10\",\"totalCze\":\"30\"},\"notNaturalMapper\":{\"ruleName\":\"8\",\"ruleType\":\"8\",\"ruleLicence\":\"8\",\"ruleLicenceNum\":\"8\",\"ruleLegal\":\"8\",\"ruleLegalType\":\"8\",\"city\":\"3\",\"area\":\"3\",\"detail\":\"2\",\"totalCze\":\"20\",\"date1\":\"8\",\"date2\":\"8\",\"ruleArea\":\"8\"}},\"aggrementMapper\":{\"natural\":99,\"notNatural\":99}},\"standParseType\":1,\"sort\":4},{\"id\":185,\"eventName\":\"&#x4F01;&#x4E1A;&#x8BBE;&#x7ACB;&#x767B;&#x8BB0;-2-&#x4F01;&#x4E1A;&#x8D77;&#x540D;\",\"eventType\":0,\"eventUrl\":\"https://cjddcloud-test.oss-cn-beijing.aliyuncs.com/cjdd/course/20191114/F4517E0E-1573698043313.jpg\",\"eventParam\":\"platform=dummy&templateCode=001&roles=3001\",\"eventTemplateUrl\":\"https://dummyedutest.cailian.net/#/businessRegister\",\"eventDesp\":\"&#x738B;&#x3002;\",\"roles\":null,\"modelType\":\"formTemplate\",\"modelName\":\"shareholder_naming\",\"type\":true,\"dynmaicParamReqList\":[{\"id\":40453,\"questionId\":6540,\"eventId\":185,\"param\":\"platform\",\"value\":\"dummy\",\"type\":1,\"sort\":5},{\"id\":40454,\"questionId\":6540,\"eventId\":185,\"param\":\"templateCode\",\"value\":\"001\",\"type\":1,\"sort\":5},{\"id\":40455,\"questionId\":6540,\"eventId\":185,\"param\":\"roles\",\"value\":\"3001\",\"type\":1,\"sort\":5}],\"value\":{\"name\":\"&#x4F01;&#x4E1A;&#x8BBE;&#x7ACB;&#x767B;&#x8BB0; - &#x516C;&#x53F8;&#x8D77;&#x540D;\",\"form\":{\"configure\":{\"formName\":\"setNameForm\",\"zihao\":\"&#x5B57;&#x53F7;\",\"hytd\":\"&#x5546;&#x8D38;(&#x4E3B;&#x8425;&#x4E1A;&#x52A1;&#xFF1A;&#x6797;&#x4E1A;&#x4EA7;&#x54C1;&#x6279;&#x53D1;)\",\"zzxs\":\"&#x6709;&#x9650;&#x516C;&#x53F8;\",\"scztszd\":\"&#x897F;&#x57CE;&#x533A;\"},\"step\":{},\"weightMapper\":{\"zihao\":\"25\",\"hytd\":\"25\",\"zzxs\":\"25\",\"scztszd\":\"25\"},\"stepWeight\":{},\"aggrementMapper\":{\"mainBusiness\":5}},\"configureWidth\":\"250px\",\"scoreWidth\":\"60px\"},\"eventWeight\":5,\"standParseType\":0,\"sort\":5},{\"id\":190,\"eventName\":\"&#x4F01;&#x4E1A;&#x8BBE;&#x7ACB;&#x767B;&#x8BB0;-5-&#x7ECF;&#x8425;&#x8303;&#x56F4;\",\"eventType\":0,\"eventUrl\":\"https://cjddcloud-test.oss-cn-beijing.aliyuncs.com/cjdd/course/20191118/B93E9822-1574058471627.jpg\",\"eventParam\":\"platform=dummy&templateCode=001&roles=3001\",\"eventTemplateUrl\":\"https://dummyedutest.cailian.net/#/businessRegister\",\"eventDesp\":\"&#x738B;&#x3002;\",\"roles\":null,\"type\":true,\"modelType\":\"businessScope\",\"dynmaicParamReqList\":[{\"id\":40456,\"questionId\":6540,\"eventId\":190,\"param\":\"platform\",\"value\":\"dummy\",\"type\":1,\"sort\":6},{\"id\":40457,\"questionId\":6540,\"eventId\":190,\"param\":\"templateCode\",\"value\":\"001\",\"type\":1,\"sort\":6},{\"id\":40458,\"questionId\":6540,\"eventId\":190,\"param\":\"roles\",\"value\":\"3001\",\"type\":1,\"sort\":6}],\"eventWeight\":5,\"value\":{\"formName\":\"busiScopeForm\",\"checkList\":[\"0\"],\"businessScope\":\"\",\"weightMapper\":{\"checkList\":\"80\",\"businessScope\":\"20\"},\"aggrementMapper\":{\"checkList\":98}},\"standParseType\":1,\"sort\":6}]";
//        formNameMap = fetchData(str2);


        formNameMap1 = fetchMapData(str2);
        removeAlert();

        List<WebElement> elements1 = driver.findElements(By.cssSelector(".topic_num"));

        int size = elements1.size();
        System.out.println("size--------->" + size);
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
                // 需要根据类型处理
                if (allelements.size() == 0) continue;

                String classAttribute = allelements.get(0).getAttribute("class");
                System.out.println("-------------------------->" + classAttribute);

                if ("el-radio-group".equals(classAttribute)) {
                    WebElement radioElement = allelements.get(0);
                    List<WebElement> subRadioElements = radioElement.findElements(By.cssSelector("label"));
                    for (WebElement subRadio : subRadioElements) {
                        WebElement input = subRadio.findElement(By.cssSelector("input"));
                        if (input.getAttribute("value").equals(nowSetValue.getValue())) {
                            subRadio.findElement(By.cssSelector(".el-radio__input")).click();
                            break;
                        }
                    }
                    continue;
                }
                if (allelements.size() == 1) {
                    allelements.get(0).sendKeys(nowSetValue.getValue());
                } else {
                    WebElement typeElement = allelements.get(0);
                    driver.findElement(By.cssSelector("div>.el-input--small>.el-input__inner~span")).click();
                    try {
                        Thread.sleep(2000);
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }

                    for (int i = 0; i < allelements.size(); i++) {
                        WebElement element = allelements.get(i);
                        WebElement elements2 = element.findElement(By.cssSelector("span"));
                        if (elements2 == null) {
                            continue;
                        }

                        if (elements2.getText().equals(nowSetValue.getValue())) {
                            element.click();
                            break;
                        }
                    }
                }
            } catch (Exception e) {

            }
        }
        driver.findElement(By.cssSelector(".el-button.el-button--primary.el-button--small")).click();
        try {
            Thread.sleep(2000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        driver.navigate().refresh();
        driver.manage().window().fullscreen();
        try {
            Thread.sleep(2000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }

    public void registrationPerson(HashMap<String, Map> formNameMap1, String personRegistrationForm) {
//        String str2 = "[{\"id\":175,\"eventName\":\"仿真人员在保登记-2 - 新参保人员登记\",\"eventType\":0,\"eventUrl\":\"https://cjddcloud-test.oss-cn-beijing.aliyuncs.com/cjdd/course/20191103/9DF25730-1572781263892.jpg\",\"eventParam\":\"platform=dummy&templateCode=001&roles=3001\",\"eventTemplateUrl\":\"https://dummyedutest.cailian.net/#/personRegistration\",\"eventDesp\":\"王。\",\"roles\":null,\"modelType\":\"formTemplate\",\"modelName\":\"newRegistration\",\"type\":true,\"dynmaicParamReqList\":[{\"id\":40243,\"questionId\":6531,\"eventId\":175,\"param\":\"platform\",\"value\":\"dummy\",\"type\":1,\"sort\":0},{\"id\":40244,\"questionId\":6531,\"eventId\":175,\"param\":\"templateCode\",\"value\":\"001\",\"type\":1,\"sort\":0},{\"id\":40245,\"questionId\":6531,\"eventId\":175,\"param\":\"roles\",\"value\":\"3001\",\"type\":1,\"sort\":0}],\"value\":{\"name\":\"人员在保登记 - 新参保人员登记\",\"form\":{\"configure\":{\"formName\":\"personRegistrationForm\",\"formMapper\":{\"gmsfzh\":\"110101199003072172\"},\"cjxz\":[\"基本养老保险\",\"失业保险\",\"工伤保险\",\"生育保险\",\"基本医疗保险\"],\"name\":\"张三\",\"gmsfzh\":\"110101199003072172\",\"xb\":\"男\",\"csrq\":\"2021-01-28\",\"mz\":\"汉族\",\"gjdq\":\"中国\",\"grsf\":\"工人\",\"cjgzrq\":\"2021-01-30\",\"hkszjx\":\"1\",\"jfrylb\":\"本市城镇职工\",\"hkszd\":\"1\",\"hkszyzbm\":\"065500\",\"jzdlxdz\":\"1\",\"jzdlxdzyzba\":\"065500\",\"hqdzdfs\":\"网上查询\",\"dzyjdz\":\"11@qq.com\",\"whcd\":\"博士研究生\",\"xzyjshbxdzddz\":\"1\",\"dzddzyzbm\":\"1\",\"cbrdh\":\"13212121212\",\"cbrsj\":\"13212121212\",\"sbyjgzsr\":\"1000\",\"wtdfyhmc\":\"中国工商银行\",\"wtdfyhzh\":\"1\",\"hkxz\":\"农业户口\",\"ylcbrylb\":\"本市城镇职工\",\"ddyljg_1\":\"1\",\"ddyljg_2\":\"1\",\"ddyljg_3\":\"1\",\"ddyljg_4\":\"1\",\"ddyljg_5\":\"1\",\"hyzk\":\"未婚\",\"tsbs\":\"有\",\"lxrxm\":\"1\",\"lxrdh\":\"13212121212\",\"bjgzjzzbm\":\"1\",\"yxjzrq\":\"2021-01-30\",\"nzgbjdwmc\":\"1\",\"pzzdrq\":\"2021-01-30\",\"nzflx\":\"机关事业单位职工农转非\",\"xbgrjfyy\":\"外区转\",\"sxgrxfyy\":\"新参统\"},\"weightMapper\":{\"cjxz\":\"2\",\"name\":\"2\",\"gmsfzh\":\"2\",\"xb\":\"2\",\"csrq\":\"2\",\"mz\":\"2\",\"gjdq\":\"2\",\"grsf\":\"2\",\"cjgzrq\":\"2\",\"hkszjx\":\"2\",\"jfrylb\":\"2\",\"hkszd\":\"2\",\"hkszyzbm\":\"2\",\"jzdlxdz\":\"2\",\"jzdlxdzyzba\":\"2\",\"hqdzdfs\":\"2\",\"dzyjdz\":\"2\",\"whcd\":\"2\",\"xzyjshbxdzddz\":\"2\",\"dzddzyzbm\":\"2\",\"cbrdh\":\"2\",\"cbrsj\":\"2\",\"sbyjgzsr\":\"2\",\"wtdfyhmc\":\"2\",\"wtdfyhzh\":\"2\",\"hkxz\":\"2\",\"ylcbrylb\":\"2\",\"ddyljg_1\":\"2\",\"ddyljg_2\":\"2\",\"ddyljg_3\":\"3\",\"ddyljg_4\":\"3\",\"ddyljg_5\":\"3\",\"hyzk\":\"3\",\"tsbs\":\"3\",\"lxrxm\":\"3\",\"lxrdh\":\"3\",\"bjgzjzzbm\":\"3\",\"yxjzrq\":\"3\",\"nzgbjdwmc\":\"3\",\"pzzdrq\":\"3\",\"nzflx\":\"3\",\"xbgrjfyy\":\"3\",\"sxgrxfyy\":\"3\"},\"aggrementMapper\":{\"mz\":5,\"gjdq\":5,\"cjxz\":6}},\"configureWidth\":\"250px\",\"scoreWidth\":\"90px\"},\"eventWeight\":100,\"standParseType\":0,\"sort\":0}]";
//        formNameMap = fetchData(str2);
//        企业设立登记-zdh
        String str2 = "[{\"id\":131,\"eventName\":\"企业设立登记-1-点击事项\",\"eventType\":0,\"eventUrl\":\"https://cjddcloud-test.oss-cn-beijing.aliyuncs.com/cjdd/course/20191022/6A2B6856-1571728724741.jpg\",\"eventParam\":\"platform=dummy&templateCode=001&roles=3001\",\"eventTemplateUrl\":\"https://dummyedutest.cailian.net/#/businessRegister\",\"eventDesp\":\"王。1\",\"roles\":null,\"modelType\":\"formTemplate\",\"modelName\":\"enterprise_establishment_registration\",\"type\":true,\"dynmaicParamReqList\":[{\"id\":40438,\"questionId\":6540,\"eventId\":131,\"param\":\"platform\",\"value\":\"dummy\",\"type\":1,\"sort\":0},{\"id\":40439,\"questionId\":6540,\"eventId\":131,\"param\":\"templateCode\",\"value\":\"001\",\"type\":1,\"sort\":0},{\"id\":40440,\"questionId\":6540,\"eventId\":131,\"param\":\"roles\",\"value\":\"3001\",\"type\":1,\"sort\":0}],\"value\":{\"name\":\"企业设立登记 - 点击步骤\",\"form\":{\"configure\":{},\"step\":{},\"weightMapper\":{},\"stepWeight\":{\"business_personal\":\"11\",\"business_login\":\"11\",\"business_company\":\"11\",\"business_establish\":\"11\",\"business_window\":\"11\",\"business_euser\":\"11\",\"business_handle\":\"11\",\"business_open\":\"11\",\"business_apply\":\"12\"},\"aggrementMapper\":{}},\"configureWidth\":\"250px\",\"scoreWidth\":\"60px\"},\"eventWeight\":10,\"standParseType\":0,\"sort\":0},{\"id\":132,\"eventName\":\"企业设立登记-6-人员信息\",\"eventType\":0,\"eventUrl\":\"https://cjddcloud-test.oss-cn-beijing.aliyuncs.com/cjdd/course/20191022/EE85CEF4-1571728765317.jpg\",\"eventParam\":\"platform=dummy&templateCode=001&roles=3001\",\"eventTemplateUrl\":\"https://dummyedutest.cailian.net/#/businessRegister\",\"eventDesp\":\"zz\",\"roles\":null,\"type\":true,\"modelType\":\"basicPersonnelInfo\",\"dynmaicParamReqList\":[{\"id\":40441,\"questionId\":6540,\"eventId\":132,\"param\":\"platform\",\"value\":\"dummy\",\"type\":1,\"sort\":1},{\"id\":40442,\"questionId\":6540,\"eventId\":132,\"param\":\"templateCode\",\"value\":\"001\",\"type\":1,\"sort\":1},{\"id\":40443,\"questionId\":6540,\"eventId\":132,\"param\":\"roles\",\"value\":\"3001\",\"type\":1,\"sort\":1}],\"eventWeight\":20,\"value\":{\"formName\":\"perInfoForm\",\"directorList\":[{\"directorName\":\"姓名\",\"directorEnglish\":\"姓名(英文)\",\"directorType\":\"中华人民共和国居民身份证\",\"directorIdNum\":\"证件号码\",\"directorArea\":\"中国\",\"directorSex\":3,\"directorPhone\":\"联系电话\",\"directorDegree\":\"0\",\"directorNation\":\"汉族\",\"directorOutlook\":\"0\",\"directorDate\":\"2021-02-01\",\"directorPost\":\"职务\",\"directorStart\":\"2021-02-01\",\"directorEnd\":\"2021-02-01\",\"directorMode\":\"委派\",\"directorTerm\":\"0\",\"directorAddress1\":\"户籍登记\"}],\"managerList\":[],\"supervisorList\":[],\"other1List\":[{\"otherName\":\"姓名\",\"otherType\":\"中华人民共和国居民身份证\",\"otherIdNum\":\"证件号码\",\"otherPhone\":\"移动电话\",\"otherTel\":\"固定电话\",\"otherEmail\":\"电子邮箱\",\"otherStart\":\"2021-02-01\",\"otherEnd\":\"2021-02-03\"}],\"other2List\":[{\"otherName\":\"姓名\",\"otherType\":\"中华人民共和国居民身份证\",\"otherIdNum\":\"证件号码\",\"otherPhone\":\"移动电话\",\"otherTel\":\"固定电话\",\"otherEmail\":\"电子邮箱\",\"otherStart\":\"2021-02-01\",\"otherEnd\":\"2021-02-03\"}],\"other3List\":[{\"otherName\":\"姓名\",\"otherType\":\"中华人民共和国居民身份证\",\"otherIdNum\":\"证件号码\",\"otherPhone\":\"移动电话\",\"otherTel\":\"固定电话\",\"otherEmail\":\"电子邮箱\",\"otherStart\":\"2021-02-01\",\"otherEnd\":\"2021-02-02\"}],\"other4List\":[{\"otherName\":\"姓名\",\"otherType\":\"中华人民共和国居民身份证\",\"otherIdNum\":\"证件号码\",\"otherPhone\":\"移动电话\",\"otherTel\":\"固定电话\",\"otherEmail\":\"电子邮箱\",\"otherStart\":\"2021-02-01\",\"otherEnd\":\"2021-02-02\"}],\"other5List\":[{\"otherName\":\"姓名\",\"otherType\":\"中华人民共和国居民身份证\",\"otherIdNum\":\"证件号码\",\"otherPhone\":\"移动电话\",\"otherTel\":\"固定电话\",\"otherEmail\":\"电子邮箱\",\"otherStart\":\"2021-02-01\",\"otherEnd\":\"2021-02-03\"}],\"other6List\":[{\"otherName\":\"姓名\",\"otherType\":\"中华人民共和国居民身份证\",\"otherIdNum\":\"证件号码\",\"otherPhone\":\"移动电话\",\"otherTel\":\"固定电话\",\"otherEmail\":\"电子邮箱\",\"otherStart\":\"2021-02-01\",\"otherEnd\":\"2021-02-03\"}],\"weightMapper\":{\"directorList\":\"9\",\"managerList\":\"9\",\"supervisorList\":\"9\",\"legalTel\":\"8\",\"legalPhone\":\"8\",\"legalName\":\"8\",\"other1List\":\"8\",\"other2List\":\"8\",\"other3List\":\"8\",\"other4List\":\"8\",\"other5List\":\"8\",\"other6List\":\"9\",\"directorListMapper\":{\"directorName\":\"5\",\"directorEnglish\":\"5\",\"directorType\":\"5\",\"directorIdNum\":\"5\",\"directorArea\":\"5\",\"directorSex\":\"5\",\"directorPhone\":\"6\",\"directorDegree\":\"6\",\"directorNation\":\"6\",\"directorOutlook\":\"6\",\"directorDate\":\"6\",\"directorPost\":\"6\",\"directorStart\":\"6\",\"directorEnd\":\"6\",\"directorMode\":\"6\",\"directorTerm\":\"6\",\"directorAddress1\":\"10\"},\"managerListMapper\":{\"directorName\":\"5\",\"directorEnglish\":\"5\",\"directorType\":\"5\",\"directorIdNum\":\"5\",\"directorArea\":\"5\",\"directorSex\":\"5\",\"directorPhone\":\"6\",\"directorDegree\":\"6\",\"directorNation\":\"6\",\"directorOutlook\":\"6\",\"directorDate\":\"6\",\"directorPost\":\"6\",\"directorStart\":\"6\",\"directorEnd\":\"6\",\"directorMode\":\"6\",\"directorTerm\":\"6\",\"directorAddress1\":\"10\"},\"supervisorListMapper\":{\"directorName\":\"5\",\"directorEnglish\":\"5\",\"directorType\":\"5\",\"directorIdNum\":\"5\",\"directorArea\":\"5\",\"directorSex\":\"5\",\"directorPhone\":\"6\",\"directorDegree\":\"6\",\"directorNation\":\"6\",\"directorOutlook\":\"6\",\"directorDate\":\"6\",\"directorPost\":\"6\",\"directorStart\":\"6\",\"directorEnd\":\"6\",\"directorMode\":\"6\",\"directorTerm\":\"6\",\"directorAddress1\":\"10\"},\"other1ListMapper\":{\"otherName\":\"13\",\"otherType\":\"13\",\"otherIdNum\":\"13\",\"otherPhone\":\"13\",\"otherTel\":\"12\",\"otherEmail\":\"12\",\"otherStart\":\"12\",\"otherEnd\":\"12\"},\"other2ListMapper\":{\"otherName\":\"13\",\"otherType\":\"13\",\"otherIdNum\":\"13\",\"otherPhone\":\"13\",\"otherTel\":\"12\",\"otherEmail\":\"12\",\"otherStart\":\"12\",\"otherEnd\":\"12\"},\"other3ListMapper\":{\"otherName\":\"13\",\"otherType\":\"13\",\"otherIdNum\":\"13\",\"otherPhone\":\"13\",\"otherTel\":\"12\",\"otherEmail\":\"12\",\"otherStart\":\"12\",\"otherEnd\":\"12\"},\"other4ListMapper\":{\"otherName\":\"13\",\"otherType\":\"13\",\"otherIdNum\":\"13\",\"otherPhone\":\"13\",\"otherTel\":\"12\",\"otherEmail\":\"12\",\"otherStart\":\"12\",\"otherEnd\":\"12\"},\"other5ListMapper\":{\"otherName\":\"13\",\"otherType\":\"13\",\"otherIdNum\":\"13\",\"otherPhone\":\"13\",\"otherTel\":\"12\",\"otherEmail\":\"12\",\"otherStart\":\"12\",\"otherEnd\":\"12\"},\"other6ListMapper\":{\"otherName\":\"13\",\"otherType\":\"13\",\"otherIdNum\":\"13\",\"otherPhone\":\"13\",\"otherTel\":\"12\",\"otherEmail\":\"12\",\"otherStart\":\"12\",\"otherEnd\":\"12\"}},\"aggrementMapper\":{\"directorList\":99,\"managerList\":99,\"supervisorList\":99,\"other1List\":97,\"other2List\":97,\"other3List\":97,\"other4List\":97,\"other5List\":97,\"other6List\":97}},\"standParseType\":1,\"sort\":1},{\"id\":133,\"eventName\":\"企业设立登记-4-企业基本信息表单 \",\"eventType\":0,\"eventUrl\":\"https://cjddcloud-test.oss-cn-beijing.aliyuncs.com/cjdd/course/20191022/03F20D18-1571728815150.jpg\",\"eventParam\":\"platform=dummy&templateCode=001&roles=3001\",\"eventTemplateUrl\":\"https://dummyedutest.cailian.net/#/businessRegister\",\"eventDesp\":\"王。1\",\"roles\":null,\"modelType\":\"formTemplate\",\"modelName\":\"basic_information_enterprise\",\"type\":true,\"dynmaicParamReqList\":[{\"id\":40444,\"questionId\":6540,\"eventId\":133,\"param\":\"platform\",\"value\":\"dummy\",\"type\":1,\"sort\":2},{\"id\":40445,\"questionId\":6540,\"eventId\":133,\"param\":\"templateCode\",\"value\":\"001\",\"type\":1,\"sort\":2},{\"id\":40446,\"questionId\":6540,\"eventId\":133,\"param\":\"roles\",\"value\":\"3001\",\"type\":1,\"sort\":2}],\"value\":{\"name\":\"企业设立登记 - 企业基本信息表单\",\"form\":{\"configure\":{\"formName\":\"infoForm\",\"jycs\":\"住所(经营场所)\",\"scjyd\":\"生产经营地\",\"zssyqx\":\"住所使用期限(年)\",\"yymj\":\"\",\"fwyt\":\"房屋用途\",\"zscqr\":\"住所(产权人)\",\"zscqlx\":\"有房产证\",\"zstgfs\":\"自有\",\"yyqx\":\"3\",\"zzfbs\":\"5\",\"isweizhi\":\"是\"},\"weightMapper\":{\"jycs\":\"9\",\"scjyd\":\"9\",\"zssyqx\":\"9\",\"yymj\":\"9\",\"fwyt\":\"9\",\"zscqr\":\"9\",\"zscqlx\":\"9\",\"zstgfs\":\"9\",\"yyqx\":\"9\",\"zzfbs\":\"9\",\"isweizhi\":\"10\"},\"aggrementMapper\":{\"zstgfs\":5,\"isweizhi\":5,\"zscqlx\":5}},\"configureWidth\":\"250px\",\"scoreWidth\":\"60px\"},\"eventWeight\":20,\"standParseType\":0,\"sort\":2},{\"id\":135,\"eventName\":\"企业设立登记-7-税务信息确认\",\"eventType\":0,\"eventUrl\":\"https://cjddcloud-test.oss-cn-beijing.aliyuncs.com/cjdd/course/20191022/E7D339D7-1571728965500.jpg\",\"eventParam\":\"platform=dummy&templateCode=001&roles=3001\",\"eventTemplateUrl\":\"https://dummyedutest.cailian.net/#/businessRegister\",\"eventDesp\":\"王。\",\"roles\":null,\"modelType\":\"formTemplate\",\"modelName\":\"tax_information_confirmation\",\"type\":true,\"dynmaicParamReqList\":[{\"id\":40447,\"questionId\":6540,\"eventId\":135,\"param\":\"platform\",\"value\":\"dummy\",\"type\":1,\"sort\":3},{\"id\":40448,\"questionId\":6540,\"eventId\":135,\"param\":\"templateCode\",\"value\":\"001\",\"type\":1,\"sort\":3},{\"id\":40449,\"questionId\":6540,\"eventId\":135,\"param\":\"roles\",\"value\":\"3001\",\"type\":1,\"sort\":3}],\"value\":{\"name\":\"企业设立登记 - 税务信息确认\",\"form\":{\"configure\":{\"formName\":\"taxationInfoForm\",\"taxName\":\"姓名\",\"taxEmail\":\"电子邮箱\",\"taxType\":\"证件类型\",\"taxIdNum\":\"证件号码\",\"taxTel\":\"移动号码\",\"project1\":\"项目类别\",\"project2\":\"经营大类\",\"project3\":\"经营明细\",\"project4\":\"行业名称\",\"project5\":\"预计经营占比\"},\"weightMapper\":{\"taxName\":\"10\",\"taxEmail\":\"10\",\"taxType\":\"10\",\"taxIdNum\":\"10\",\"taxTel\":\"10\",\"project1\":\"10\",\"project2\":\"10\",\"project3\":\"10\",\"project4\":\"10\",\"project5\":\"10\"},\"aggrementMapper\":{}},\"configureWidth\":\"250px\",\"scoreWidth\":\"60px\"},\"eventWeight\":20,\"standParseType\":0,\"sort\":3},{\"id\":184,\"eventName\":\"企业设立登记-3-自然人股东信息\",\"eventType\":0,\"eventUrl\":\"https://cjddcloud-test.oss-cn-beijing.aliyuncs.com/cjdd/course/20191112/D5611119-1573543192430.jpg\",\"eventParam\":\"platform=dummy&templateCode=001&roles=3001\",\"eventTemplateUrl\":\"https://dummyedutest.cailian.net/#/businessRegister\",\"eventDesp\":\"zz\",\"roles\":null,\"type\":true,\"modelType\":\"naturalPerson\",\"dynmaicParamReqList\":[{\"id\":40450,\"questionId\":6540,\"eventId\":184,\"param\":\"platform\",\"value\":\"dummy\",\"type\":1,\"sort\":4},{\"id\":40451,\"questionId\":6540,\"eventId\":184,\"param\":\"templateCode\",\"value\":\"001\",\"type\":1,\"sort\":4},{\"id\":40452,\"questionId\":6540,\"eventId\":184,\"param\":\"roles\",\"value\":\"3001\",\"type\":1,\"sort\":4}],\"eventWeight\":20,\"value\":{\"formName\":\"shareholderForm\",\"natural\":[{\"ruleName\":\"姓名\",\"ruleType\":\"身份证号码\",\"ruleNation\":\"汉族\",\"ruleInvestor\":\"自然人股东\",\"city\":\"北京市\",\"area\":\"户籍登记地\",\"detail\":\"户籍登记地\",\"date1\":\"2021-02-01\",\"date2\":\"2021-02-02\",\"tableData\":[{\"cze\":\"1\",\"czfs\":\"0\",\"czrq\":\"2021-02-01\"}],\"totalCze\":1}],\"notNatural\":[{\"ruleName\":\"单位名称\",\"ruleType\":\"法人股东\",\"ruleLicence\":\"企业法人营业执照\",\"ruleLicenceNum\":\"证件号码\",\"ruleLegal\":\"法定代表人\",\"ruleLegalType\":\"中华人民共和国居民身份证\",\"city\":\"北京市\",\"area\":\"住所\",\"detail\":\"住所\",\"tableData\":[{\"cze\":\"1\",\"czfs\":\"0\",\"czrq\":\"2021-02-01\"}],\"totalCze\":1,\"date1\":\"2021-02-01\",\"date2\":\"2021-02-03\",\"ruleArea\":\"中国\"}],\"weightMapper\":{\"natural\":\"50\",\"notNatural\":\"50\",\"naturalMapper\":{\"ruleName\":\"10\",\"ruleType\":\"10\",\"ruleNation\":\"10\",\"ruleInvestor\":\"10\",\"city\":\"4\",\"area\":\"3\",\"detail\":\"3\",\"date1\":\"10\",\"date2\":\"10\",\"totalCze\":\"30\"},\"notNaturalMapper\":{\"ruleName\":\"8\",\"ruleType\":\"8\",\"ruleLicence\":\"8\",\"ruleLicenceNum\":\"8\",\"ruleLegal\":\"8\",\"ruleLegalType\":\"8\",\"city\":\"3\",\"area\":\"3\",\"detail\":\"2\",\"totalCze\":\"20\",\"date1\":\"8\",\"date2\":\"8\",\"ruleArea\":\"8\"}},\"aggrementMapper\":{\"natural\":99,\"notNatural\":99}},\"standParseType\":1,\"sort\":4},{\"id\":185,\"eventName\":\"企业设立登记-2-企业起名\",\"eventType\":0,\"eventUrl\":\"https://cjddcloud-test.oss-cn-beijing.aliyuncs.com/cjdd/course/20191114/F4517E0E-1573698043313.jpg\",\"eventParam\":\"platform=dummy&templateCode=001&roles=3001\",\"eventTemplateUrl\":\"https://dummyedutest.cailian.net/#/businessRegister\",\"eventDesp\":\"王。\",\"roles\":null,\"modelType\":\"formTemplate\",\"modelName\":\"shareholder_naming\",\"type\":true,\"dynmaicParamReqList\":[{\"id\":40453,\"questionId\":6540,\"eventId\":185,\"param\":\"platform\",\"value\":\"dummy\",\"type\":1,\"sort\":5},{\"id\":40454,\"questionId\":6540,\"eventId\":185,\"param\":\"templateCode\",\"value\":\"001\",\"type\":1,\"sort\":5},{\"id\":40455,\"questionId\":6540,\"eventId\":185,\"param\":\"roles\",\"value\":\"3001\",\"type\":1,\"sort\":5}],\"value\":{\"name\":\"企业设立登记 - 公司起名\",\"form\":{\"configure\":{\"formName\":\"setNameForm\",\"zihao\":\"字号\",\"hytd\":\"商贸(主营业务：林业产品批发)\",\"zzxs\":\"有限公司\",\"scztszd\":\"西城区\"},\"step\":{},\"weightMapper\":{\"zihao\":\"25\",\"hytd\":\"25\",\"zzxs\":\"25\",\"scztszd\":\"25\"},\"stepWeight\":{},\"aggrementMapper\":{\"mainBusiness\":5}},\"configureWidth\":\"250px\",\"scoreWidth\":\"60px\"},\"eventWeight\":5,\"standParseType\":0,\"sort\":5},{\"id\":190,\"eventName\":\"企业设立登记-5-经营范围\",\"eventType\":0,\"eventUrl\":\"https://cjddcloud-test.oss-cn-beijing.aliyuncs.com/cjdd/course/20191118/B93E9822-1574058471627.jpg\",\"eventParam\":\"platform=dummy&templateCode=001&roles=3001\",\"eventTemplateUrl\":\"https://dummyedutest.cailian.net/#/businessRegister\",\"eventDesp\":\"王。\",\"roles\":null,\"type\":true,\"modelType\":\"businessScope\",\"dynmaicParamReqList\":[{\"id\":40456,\"questionId\":6540,\"eventId\":190,\"param\":\"platform\",\"value\":\"dummy\",\"type\":1,\"sort\":6},{\"id\":40457,\"questionId\":6540,\"eventId\":190,\"param\":\"templateCode\",\"value\":\"001\",\"type\":1,\"sort\":6},{\"id\":40458,\"questionId\":6540,\"eventId\":190,\"param\":\"roles\",\"value\":\"3001\",\"type\":1,\"sort\":6}],\"eventWeight\":5,\"value\":{\"formName\":\"busiScopeForm\",\"checkList\":[\"0\"],\"businessScope\":\"\",\"weightMapper\":{\"checkList\":\"80\",\"businessScope\":\"20\"},\"aggrementMapper\":{\"checkList\":98}},\"standParseType\":1,\"sort\":6}]";
        formNameMap1 = fetchMapData(str2);

        //调用去掉考试作弊弹框方法
        removeAlert();
        List<WebElement> elements1 = driver.findElements(By.cssSelector(".topic_num"));

        int size = elements1.size();
        System.out.println("size--------->" + size);
        elements1.get(1).click();

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
        Map<String, String> map = formNameMap1.get(personRegistrationForm);
        WebDriverWait wait = new WebDriverWait(driver, 3000);
        wait.until(ExpectedConditions.elementToBeClickable(driver.findElement(By.cssSelector(".click_span")))).click();
        wait.until(ExpectedConditions.elementToBeClickable(driver.findElement(By.cssSelector(".click_span")))).click();
        wait.until(ExpectedConditions.elementToBeClickable(driver.findElement(By.cssSelector(".input_box>.input_name input")))).sendKeys("1");
        wait.until(ExpectedConditions.elementToBeClickable(driver.findElement(By.cssSelector(".input_box>div~div input")))).sendKeys("123456");
        wait.until(ExpectedConditions.elementToBeClickable(driver.findElement(By.cssSelector(".click_span")))).click();
        String gmsfzh = map.get("gmsfzh");
        wait.until(ExpectedConditions.elementToBeClickable(driver.findElement(By.cssSelector(".el-input__inner")))).sendKeys(gmsfzh);
        wait.until(ExpectedConditions.elementToBeClickable(driver.findElement(By.cssSelector("div>button.el-button--mini")))).click();


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

    //去除考试过程中作弊弹框
    private void removeAlert() {
        Actions actions = new Actions(driver);
        try {
            Thread.sleep(2000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        actions.sendKeys(Keys.F12).perform();
        String js = "document.getElementById(\"dialog\").remove();";
        ((JavascriptExecutor) driver).executeScript(js);

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