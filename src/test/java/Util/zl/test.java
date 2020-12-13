package Util.zl;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONArray;
import com.alibaba.fastjson.JSONObject;
import com.google.gson.JsonArray;
import com.google.gson.JsonElement;
import com.google.gson.JsonObject;
import com.google.gson.JsonParser;
import jxl.Workbook;
import jxl.write.Label;
import jxl.write.WritableSheet;
import jxl.write.WritableWorkbook;

import java.io.File;
import java.io.IOException;
import java.util.*;

public class test {
    public static void main1(String[] args) {
        String resultStr = "{" +
                "                    \"formName\":\"taxForm\"," +
                "                    \"tableNum1\":\"50\"," +
                "                    \"tableRemarks2\":\"\"," +
                "                    \"name\":\"周燕\"," +
                "                    \"mobileNum\":\"13984824461\"," +
                "                    \"taxNumber\":\"91110113665E43456M\"," +
                "                    \"taxName\":\"北京华嵘商贸有限责任公司\"," +
                "                    \"detailAddress\":\"石窟北路334号\"," +
                "                    \"address\":\"顺义区\"," +
                "                    \"postalCode\":\"101300\"," +
                "                    \"isYourSelfGet\":\"1\"," +
                "                    \"tableNum2\":\"25\"" +
                "                }";

        System.out.println(resultStr);

        //用数组存表头
        String[] title = {"id", "name", "sex"};
        //创建Excel文件
        File file = new File("D:\\dataList\\jxl_test.xls");
        if (!file.exists()) {
            try {
                file.createNewFile();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
        try {
            file.createNewFile();
            //创建工作簿，Sheet的下标是从0开始
            WritableWorkbook workbook = Workbook.createWorkbook(file);
            //创建新的一页sheet
            WritableSheet sheet = workbook.createSheet("sheet1", 0);
            Label label = null;
            //设置列名（第一行）
            for (int i = 0; i < title.length; i++) {
                //添加Label对象
                label = new Label(i, 0, title[i]);
                sheet.addCell(label);
            }
            //插入数据：行数，从第二行开始
            for (int i = 1; i < 10; i++) {
                //在Label对象的构造子中指名单元格位置是第一列第一行(0,0)
                label = new Label(0, i, "a" + i);
                // 将定义好的单元格添加到工作表中
                sheet.addCell(label);
                label = new Label(1, i, "user" + i);
                sheet.addCell(label);
                label = new Label(2, i, "男" + i);
                sheet.addCell(label);
            }
            //写入数据
            workbook.write();
            //关闭输出流
            workbook.close();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public static void main(String[] args){
        String resultStr = "{" +
                "                    \"formName\":\"taxForm\"," +
                "                    \"tableNum1\":\"50\"," +
                "                    \"tableRemarks2\":\"\"," +
                "                    \"name\":\"周燕\"," +
                "                    \"mobileNum\":\"13984824461\"," +
                "                    \"taxNumber\":\"91110113665E43456M\"," +
                "                    \"taxName\":\"北京华嵘商贸有限责任公司\"," +
                "                    \"detailAddress\":\"石窟北路334号\"," +
                "                    \"address\":\"顺义区\"," +
                "                    \"postalCode\":\"101300\"," +
                "                    \"isYourSelfGet\":\"1\"," +
                "                    \"tableNum2\":\"25\"" +
                "                }";

//        String str2 = "[{\"id\":308,\"eventName\":\"仿真-成立有限合伙公司-基本信息\",\"eventType\":0,\"eventUrl\":\"https://zledu-oss-sx.cailian.net/cjdd/course/20201113/44578B18-1605272950971.jpg\",\"eventParam\":\"platform=dummy&templateCode=001&roles=3032\",\"eventTemplateUrl\":\"https://dummyedusx.cailian.net/#/establishLimitedPartnership\",\"eventTemplatePic\":\"modelType=partnership_infoEnterprise\",\"eventDesp\":\".peter\",\"roles\":null,\"type\":true,\"modelType\":\"partnership_infoEnterprise\",\"dynmaicParamReqList\":[{\"id\":109208,\"questionId\":11430,\"eventId\":308,\"param\":\"platform\",\"value\":\"dummy\",\"type\":1,\"sort\":0},{\"id\":109209,\"questionId\":11430,\"eventId\":308,\"param\":\"templateCode\",\"value\":\"001\",\"type\":1,\"sort\":0},{\"id\":109210,\"questionId\":11430,\"eventId\":308,\"param\":\"roles\",\"value\":\"3001\",\"type\":1,\"sort\":0},{\"id\":109211,\"questionId\":11430,\"eventId\":308,\"param\":\"platform\",\"value\":\"dummy\",\"type\":1,\"sort\":0},{\"id\":109212,\"questionId\":11430,\"eventId\":308,\"param\":\"templateCode\",\"value\":\"001\",\"type\":1,\"sort\":0},{\"id\":109213,\"questionId\":11430,\"eventId\":308,\"param\":\"roles\",\"value\":\"3001\",\"type\":1,\"sort\":0}],\"eventWeight\":10,\"timestamp\":1605508624117,\"value\":{\"formName\":\"partnership_infoEnterpriseForm\",\"domdistrict\":\"东城区\",\"domdistrictAddress\":\"1\",\"yiedistrict\":\"东城区\",\"yiedistrictAddress\":\"1\",\"domyears\":\"1\",\"domacreage\":\"1\",\"domusagetype\":\"1\",\"domowner\":\"1\",\"domownertype\":\"有房产证\",\"domproright\":\"自有\",\"tradeterm\":\"1\",\"copyno\":\"1\",\"domcernum\":\"1\",\"isinpark\":\"否\",\"weightMapper\":{\"domdistrict\":\"8\",\"domdistrictAddress\":\"8\",\"yiedistrict\":\"7\",\"yiedistrictAddress\":\"7\",\"domyears\":\"7\",\"domacreage\":\"7\",\"domusagetype\":\"7\",\"domowner\":\"7\",\"domownertype\":\"7\",\"domproright\":\"7\",\"tradeterm\":\"7\",\"copyno\":\"7\",\"domcernum\":\"7\",\"isinpark\":\"7\"},\"aggrementMapper\":{\"domdistrictAddress\":5,\"yiedistrictAddress\":5}},\"standParseType\":1,\"sort\":0},{\"id\":371,\"eventName\":\"仿真-成立有限合伙公司-企业补充信息\",\"eventType\":0,\"eventUrl\":\"https://cjddcloudtest.cailian.net/cjdd/course/20201020/C8A30BE7-1603177616073.jpg\",\"eventParam\":\"platform=dummy&templateCode=001&roles=3001\",\"eventTemplateUrl\":\"https://dummyedusx.cailian.net/#/establishLimitedPartnership/infoEnterpriseComplement\",\"eventTemplatePic\":\"modelType=infoEnterpriseComplement\",\"eventDesp\":\".peter\",\"roles\":null,\"type\":true,\"modelType\":\"infoEnterpriseComplement\",\"dynmaicParamReqList\":[{\"id\":109214,\"questionId\":11430,\"eventId\":371,\"param\":\"platform\",\"value\":\"dummy\",\"type\":1,\"sort\":1},{\"id\":109215,\"questionId\":11430,\"eventId\":371,\"param\":\"templateCode\",\"value\":\"001\",\"type\":1,\"sort\":1},{\"id\":109216,\"questionId\":11430,\"eventId\":371,\"param\":\"roles\",\"value\":\"3001\",\"type\":1,\"sort\":1},{\"id\":109217,\"questionId\":11430,\"eventId\":371,\"param\":\"platform\",\"value\":\"dummy\",\"type\":1,\"sort\":1},{\"id\":109218,\"questionId\":11430,\"eventId\":371,\"param\":\"templateCode\",\"value\":\"001\",\"type\":1,\"sort\":1},{\"id\":109219,\"questionId\":11430,\"eventId\":371,\"param\":\"roles\",\"value\":\"3001\",\"type\":1,\"sort\":1}],\"eventWeight\":20,\"timestamp\":1605508624651,\"value\":{\"formName\":\"establishLimitedPartnershipinfoEnterpriseComplement\",\"entnature\":[\"总部企业\",\"其他\"],\"inviscenter\":\"是\",\"inviscentertype\":[\"中央在京事业单位\",\"中央企业\",\"驻京部队\",\"其他\"],\"calculationmethod\":\"独立核算\",\"leptispm\":\"否\",\"leptispmo\":\"否\",\"iscreatepo\":\"否\",\"partynumber\":\"\",\"parins\":\"\",\"parorgw\":\"\",\"iscreatelu\":\"否\",\"unionnumber\":\"\",\"iscreatepocuryear\":\"否\",\"iscreateco\":\"否\",\"leaguenumber\":\"\",\"empnum\":\"1\",\"empnumlocal\":\"1\",\"empnumnolocal\":\"1\",\"femailnum\":\"1\",\"laidoffnum\":\"1\",\"hasnewgraivtr\":\"否\",\"hasnewgraivtrbj\":\"\",\"hypotaxis\":\"市、地区\",\"econtype\":\"内资/其他内资\",\"dwjc\":\"1\",\"comcategory\":\"非法人单位\",\"socialagencies\":\"北京市东城区社会保险基金管理中心\",\"medicalarea\":\"北京市东城区社会保险基金管理中心\",\"payarea\":\"北京市东城区社会保险基金管理中心\",\"socialsetcycle\":\"按月\",\"housingfundagencies\":\"海淀管理部\",\"transtype\":\"无\",\"confdate\":\"\",\"weightMapper\":{\"entnature\":\"3\",\"inviscenter\":\"3\",\"inviscentertype\":\"3\",\"calculationmethod\":\"3\",\"leptispm\":\"3\",\"leptispmo\":\"3\",\"iscreatepo\":\"3\",\"partynumber\":\"3\",\"parins\":\"3\",\"parorgw\":\"3\",\"iscreatelu\":\"3\",\"unionnumber\":\"3\",\"iscreatepocuryear\":\"3\",\"iscreateco\":\"3\",\"leaguenumber\":\"3\",\"empnum\":\"3\",\"empnumlocal\":\"3\",\"empnumnolocal\":\"3\",\"femailnum\":\"3\",\"laidoffnum\":\"3\",\"hasnewgraivtr\":\"3\",\"hasnewgraivtrbj\":\"3\",\"hypotaxis\":\"4\",\"econtype\":\"3\",\"dwjc\":\"3\",\"comcategory\":\"3\",\"socialagencies\":\"3\",\"medicalarea\":\"3\",\"payarea\":\"3\",\"socialsetcycle\":\"3\",\"housingfundagencies\":\"3\",\"transtype\":\"3\",\"confdate\":\"3\"},\"aggrementMapper\":{\"dwjc\":5}},\"standParseType\":1,\"sort\":1},{\"id\":372,\"eventName\":\"仿真-成立有限合伙公司-企业基本信息-经营范围\",\"eventType\":0,\"eventUrl\":\"https://cjddcloudtest.cailian.net/cjdd/course/20201020/44C75754-1603177623816.jpg\",\"eventParam\":\"platform=dummy&templateCode=001&roles=3001\",\"eventTemplateUrl\":\"https://dummyedusx.cailian.net/#/establishLimitedPartnership/infoBusinessScope\",\"eventTemplatePic\":\"modelType=partnership_infoBusinessScope\",\"eventDesp\":\".peter\",\"roles\":null,\"type\":true,\"modelType\":\"partnership_infoBusinessScope\",\"dynmaicParamReqList\":[{\"id\":109220,\"questionId\":11430,\"eventId\":372,\"param\":\"platform\",\"value\":\"dummy\",\"type\":1,\"sort\":2},{\"id\":109221,\"questionId\":11430,\"eventId\":372,\"param\":\"templateCode\",\"value\":\"001\",\"type\":1,\"sort\":2},{\"id\":109222,\"questionId\":11430,\"eventId\":372,\"param\":\"roles\",\"value\":\"3001\",\"type\":1,\"sort\":2},{\"id\":109223,\"questionId\":11430,\"eventId\":372,\"param\":\"platform\",\"value\":\"dummy\",\"type\":1,\"sort\":2},{\"id\":109224,\"questionId\":11430,\"eventId\":372,\"param\":\"templateCode\",\"value\":\"001\",\"type\":1,\"sort\":2},{\"id\":109225,\"questionId\":11430,\"eventId\":372,\"param\":\"roles\",\"value\":\"3001\",\"type\":1,\"sort\":2}],\"eventWeight\":20,\"timestamp\":1605508625131,\"value\":{\"formName\":\"establishLimitedPartnershipinfoBusinessScope\",\"textarea\":\"1\",\"checkList\":[\"0\"],\"weightMapper\":{\"textarea\":\"20\",\"checkList\":\"80\"},\"aggrementMapper\":{\"checkList\":98,\"textarea\":5}},\"standParseType\":1,\"sort\":2},{\"id\":374,\"eventName\":\"仿真-成立有限合伙公司-企业基本信息-合伙人\",\"eventType\":0,\"eventUrl\":\"https://cjddcloudtest.cailian.net/cjdd/course/20201020/5D041984-1603177631213.jpg\",\"eventParam\":\"platform=dummy&templateCode=001&roles=3001\",\"eventTemplateUrl\":\"https://dummyedusx.cailian.net/#/establishLimitedPartnership/shareHolder\",\"eventTemplatePic\":\"modelType=shareHolder\",\"eventDesp\":\".peter\",\"roles\":null,\"type\":true,\"modelType\":\"shareHolder\",\"dynmaicParamReqList\":[{\"id\":109226,\"questionId\":11430,\"eventId\":374,\"param\":\"platform\",\"value\":\"dummy\",\"type\":1,\"sort\":3},{\"id\":109227,\"questionId\":11430,\"eventId\":374,\"param\":\"templateCode\",\"value\":\"001\",\"type\":1,\"sort\":3},{\"id\":109228,\"questionId\":11430,\"eventId\":374,\"param\":\"roles\",\"value\":\"3001\",\"type\":1,\"sort\":3},{\"id\":109229,\"questionId\":11430,\"eventId\":374,\"param\":\"platform\",\"value\":\"dummy\",\"type\":1,\"sort\":3},{\"id\":109230,\"questionId\":11430,\"eventId\":374,\"param\":\"templateCode\",\"value\":\"001\",\"type\":1,\"sort\":3},{\"id\":109231,\"questionId\":11430,\"eventId\":374,\"param\":\"roles\",\"value\":\"3001\",\"type\":1,\"sort\":3}],\"eventWeight\":20,\"timestamp\":1605508626526,\"value\":{\"formName\":\"establishLimitedPartnershipShareHolder\",\"arrNaturaPerson\":[{\"invname\":\"1\",\"invtype\":\"自然人股东\",\"certype\":\"中华人民共和国居民身份证\",\"cerno\":\"110101199003076472\",\"country\":\"中国\",\"nation\":\"汉族\",\"sex\":\"男\",\"occst\":\"1\",\"address\":\"1\",\"certdatebegin\":\"2020-11-16\",\"certdateend\":\"2020-11-16\",\"polstand\":\"群众\",\"tel\":\"13212121212\",\"respform\":\"无限责任\",\"exeaffsign\":\"是\",\"totalchuzie\":1,\"tableDataChuZi\":[{\"chuzie\":\"1\",\"chuzifangshi\":\"货币\",\"guquanjili\":\"无\",\"chuzishijian\":\"2020-11-16\",\"shijiaobiaozhi\":\"实缴\"}]}],\"arrCompanyPerson\":[{\"invname\":\"1\",\"invtype\":\"法人股东\",\"country\":\"中国\",\"certype\":\"企业法人营业执照(公司)\",\"cerno\":\"1\",\"legal\":\"1\",\"certdatebegin\":\"2020-11-16\",\"certdateend\":\"2020-11-16\",\"address\":\"1\",\"respform\":\"无限责任\",\"exeaffsign\":\"否\",\"wp_name\":\"\",\"wp_sex\":\"\",\"wp_certype\":\"\",\"wp_cerno\":\"\",\"wp_country\":\"中国\",\"wp_nation\":\"\",\"wp_address\":\"\",\"wp_polstand\":\"\",\"wp_tel\":\"\",\"wp_mobile\":\"\",\"wp_email\":\"\",\"totalchuzie\":1,\"tableDataChuZi\":[{\"chuzie\":\"1\",\"chuzifangshi\":\"货币\",\"guquanjili\":\"无\",\"chuzishijian\":\"2020-11-16\",\"shijiaobiaozhi\":\"实缴\"}]}],\"weightMapper\":{\"arrNaturaPerson\":50,\"arrNaturaPersonMapper\":{\"invname\":\"7\",\"invtype\":\"7\",\"certype\":\"7\",\"cerno\":\"7\",\"country\":\"7\",\"nation\":\"7\",\"sex\":\"7\",\"occst\":\"7\",\"address\":\"7\",\"certdatebegin\":\"7\",\"certdateend\":\"6\",\"polstand\":\"6\",\"tel\":\"6\",\"respform\":\"6\",\"exeaffsign\":\"6\",\"totalchuzie\":0,\"tableDataChuZi\":0},\"arrCompanyPerson\":50,\"arrCompanyPersonMapper\":{\"invname\":\"10\",\"invtype\":\"10\",\"country\":\"10\",\"certype\":\"10\",\"cerno\":\"10\",\"legal\":\"10\",\"certdatebegin\":\"10\",\"certdateend\":\"10\",\"address\":\"10\",\"respform\":\"5\",\"exeaffsign\":\"5\",\"totalchuzie\":0,\"tableDataChuZi\":0}},\"aggrementMapper\":{\"arrNaturaPerson\":96,\"arrCompanyPerson\":96,\"arrNaturaPersonMapper\":{\"address\":5},\"arrCompanyPersonMapper\":{\"invname\":5,\"address\":5}}},\"standParseType\":1,\"sort\":3},{\"id\":375,\"eventName\":\"仿真-成立有限合伙公司-内资合伙人\",\"eventType\":0,\"eventUrl\":\"https://cjddcloudtest.cailian.net/cjdd/course/20201020/CAEDED91-1603177638136.jpg\",\"eventParam\":\"platform=dummy&templateCode=001&roles=3001\",\"eventTemplateUrl\":\"https://dummyedusx.cailian.net/#/establishLimitedPartnership/infoPerson\",\"eventTemplatePic\":\"modelType=partnership_infoPerson\",\"eventDesp\":\".peter\",\"roles\":null,\"type\":true,\"modelType\":\"partnership_infoPerson\",\"dynmaicParamReqList\":[{\"id\":109232,\"questionId\":11430,\"eventId\":375,\"param\":\"platform\",\"value\":\"dummy\",\"type\":1,\"sort\":4},{\"id\":109233,\"questionId\":11430,\"eventId\":375,\"param\":\"templateCode\",\"value\":\"001\",\"type\":1,\"sort\":4},{\"id\":109234,\"questionId\":11430,\"eventId\":375,\"param\":\"roles\",\"value\":\"3001\",\"type\":1,\"sort\":4},{\"id\":109235,\"questionId\":11430,\"eventId\":375,\"param\":\"platform\",\"value\":\"dummy\",\"type\":1,\"sort\":4},{\"id\":109236,\"questionId\":11430,\"eventId\":375,\"param\":\"templateCode\",\"value\":\"001\",\"type\":1,\"sort\":4},{\"id\":109237,\"questionId\":11430,\"eventId\":375,\"param\":\"roles\",\"value\":\"3001\",\"type\":1,\"sort\":4}],\"eventWeight\":20,\"timestamp\":1605508626886,\"value\":{\"formName\":\"establishLimitedPartnershipinfoPerson\",\"contactname\":\"1\",\"contactcertype\":\"中华人民共和国居民身份证\",\"contactcerno\":\"1\",\"contactmobile\":\"1\",\"contacttel\":\"1\",\"contactemail\":\"1\",\"contactcertdatebegin\":\"2020-11-16\",\"contactcertdateend\":\"2020-11-16\",\"financename\":\"1\",\"financecertype\":\"中华人民共和国居民身份证\",\"financecerno\":\"1\",\"financemobile\":\"1\",\"financetelephone\":\"1\",\"financeemail\":\"1\",\"financecertdatebegin\":\"2020-11-16\",\"financecertdateend\":\"2020-11-16\",\"taxname\":\"1\",\"taxcertype\":\"中华人民共和国居民身份证\",\"taxcerno\":\"1\",\"taxmobile\":\"1\",\"taxtelephone\":\"1\",\"taxemail\":\"1\",\"taxcertdatebegin\":\"2020-11-16\",\"taxcertdateend\":\"2020-11-16\",\"socialSecurityname\":\"1\",\"socialSecuritycertype\":\"中华人民共和国居民身份证\",\"socialSecuritycerno\":\"1\",\"socialSecuritymobile\":\"1\",\"socialSecuritydepartment\":\"1\",\"socialSecuritycertdatebegin\":\"2020-11-16\",\"socialSecuritycertdateend\":\"2020-11-16\",\"housingFundname\":\"1\",\"housingFundcertype\":\"中华人民共和国居民身份证\",\"housingFundcerno\":\"1\",\"housingFundmobile\":\"1\",\"housingFundtelephone\":\"1\",\"housingFundcertdatebegin\":\"2020-11-16\",\"housingFundcertdateend\":\"2020-11-16\",\"buyInvoicename\":\"1\",\"buyInvoicecertype\":\"中华人民共和国居民身份证\",\"buyInvoicecerno\":\"1\",\"buyInvoicemobile\":\"1\",\"buyInvoicecertdatebegin\":\"2020-11-16\",\"buyInvoicecertdateend\":\"2020-11-16\",\"weightMapper\":{\"contactname\":\"57\",\"contactcertype\":\"1\",\"contactcerno\":\"1\",\"contactmobile\":\"1\",\"contacttel\":\"1\",\"contactemail\":\"1\",\"contactcertdatebegin\":\"1\",\"contactcertdateend\":\"1\",\"financename\":\"1\",\"financecertype\":\"1\",\"financecerno\":\"1\",\"financemobile\":\"1\",\"financetelephone\":\"1\",\"financeemail\":\"1\",\"financecertdatebegin\":\"1\",\"financecertdateend\":\"1\",\"taxname\":\"1\",\"taxcertype\":\"1\",\"taxcerno\":\"1\",\"taxmobile\":\"1\",\"taxtelephone\":\"1\",\"taxemail\":\"1\",\"taxcertdatebegin\":\"1\",\"taxcertdateend\":\"1\",\"socialSecurityname\":\"1\",\"socialSecuritycertype\":\"1\",\"socialSecuritycerno\":\"1\",\"socialSecuritymobile\":\"1\",\"socialSecuritydepartment\":\"1\",\"socialSecuritycertdatebegin\":\"1\",\"socialSecuritycertdateend\":\"1\",\"housingFundname\":\"1\",\"housingFundcertype\":\"1\",\"housingFundcerno\":\"1\",\"housingFundmobile\":\"1\",\"housingFundtelephone\":\"1\",\"housingFundcertdatebegin\":\"1\",\"housingFundcertdateend\":\"1\",\"buyInvoicename\":\"1\",\"buyInvoicecertype\":\"1\",\"buyInvoicecerno\":\"1\",\"buyInvoicemobile\":\"1\",\"buyInvoicecertdatebegin\":\"1\",\"buyInvoicecertdateend\":\"1\"},\"aggrementMapper\":{\"socialSecuritydepartment\":5}},\"standParseType\":1,\"sort\":4},{\"id\":403,\"eventName\":\"仿真m - 成立有限合伙公司-合伙人-企业基本信息 - 我要起名\",\"eventType\":0,\"eventUrl\":\"https://cjddcloudtest.cailian.net/cjdd/course/20201107/4111E8F6-1604734929118.jpg\",\"eventParam\":\"platform=dummy&templateCode=001&roles=3001\",\"eventTemplateUrl\":\"https://dummyedusx.cailian.net/#/establishLimitedPartnership/newName\",\"eventTemplatePic\":\"modelType=f_newName\",\"eventDesp\":\"政务仿真中级 - 成立有限合伙公司 - 企业基本信息 - 我要起名\",\"roles\":null,\"type\":true,\"modelType\":\"f_newName\",\"dynmaicParamReqList\":[{\"id\":109238,\"questionId\":11430,\"eventId\":403,\"param\":\"platform\",\"value\":\"dummy\",\"type\":1,\"sort\":5},{\"id\":109239,\"questionId\":11430,\"eventId\":403,\"param\":\"templateCode\",\"value\":\"001\",\"type\":1,\"sort\":5},{\"id\":109240,\"questionId\":11430,\"eventId\":403,\"param\":\"roles\",\"value\":\"3001\",\"type\":1,\"sort\":5},{\"id\":109241,\"questionId\":11430,\"eventId\":403,\"param\":\"platform\",\"value\":\"dummy\",\"type\":1,\"sort\":5},{\"id\":109242,\"questionId\":11430,\"eventId\":403,\"param\":\"templateCode\",\"value\":\"001\",\"type\":1,\"sort\":5},{\"id\":109243,\"questionId\":11430,\"eventId\":403,\"param\":\"roles\",\"value\":\"3001\",\"type\":1,\"sort\":5}],\"eventWeight\":10,\"timestamp\":1605508627201,\"value\":{\"formName\":\"establishLimitedPartnershipNewName\",\"district\":\"北京\",\"zihao\":\"1\",\"hangyetedian\":\"商贸\",\"hangyetedianyewu\":\"畜牧渔业饲料批发、渔业产品批发\",\"zuzhixingshi\":\"有限公司\",\"zhutisuozaidi\":\"东城区\",\"companyname\":\"北京1商贸有限公司\",\"weightMapper\":{\"district\":\"10\",\"zihao\":\"10\",\"hangyetedian\":\"10\",\"zuzhixingshi\":\"10\",\"zhutisuozaidi\":\"10\",\"companyname\":\"50\"},\"aggrementMapper\":{}},\"standParseType\":1,\"sort\":5}]";
        String str2 = "[{\"id\":238,\"eventName\":\"仿真 - 计算机软件著作权登记申请表\",\"eventType\":0,\"eventUrl\":\"https://zledu-oss-sx.cailian.net/cjdd/course/20201113/DD4EDE1C-1605271306368.jpg\",\"eventParam\":\"platform=dummy&templateCode=001&roles=3032\",\"eventTemplateUrl\":\"https://dummyedusx.cailian.net/#/registration\",\"eventTemplatePic\":\"modelType=f_copyright_register\",\"eventDesp\":\"\",\"roles\":null,\"type\":true,\"modelType\":\"f_copyright_register\",\"dynmaicParamReqList\":[{\"id\":121886,\"questionId\":11427,\"eventId\":238,\"param\":\"platform\",\"value\":\"dummy\",\"type\":1,\"sort\":0},{\"id\":121887,\"questionId\":11427,\"eventId\":238,\"param\":\"templateCode\",\"value\":\"001\",\"type\":1,\"sort\":0},{\"id\":121888,\"questionId\":11427,\"eventId\":238,\"param\":\"roles\",\"value\":\"3001\",\"type\":1,\"sort\":0}],\"eventWeight\":100,\"timestamp\":1605938168584,\"value\":{\"formName\":\"RegistrationForm\",\"allname\":\"1\",\"forShort\":\"1\",\"classNumber\":\"系统软件类，操作系统 包括实时、分时、分布式、智能操作系统，系统使用程序，系统扩充程序 包括操作系统的扩充、汉化，网络系统软件，其他系统软件\",\"versionNumber\":\"1\",\"sslradio\":\"2\",\"dct\":\"2020-11-20T16:00:00.000Z\",\"PublishedState\":\"2\",\"Starting\":\"\",\"StartingPlace\":\"\",\"city\":\"\",\"exploit\":\"2\",\"acquire\":\"2\",\"Transplant\":\"11\",\"type\":[\"软件是否登记\",\"原登记是否做过变更或补充\"],\"originalNumber\":\"1\",\"change\":\"1\",\"interestField\":\"1\",\"publication\":[\"发表权\",\"署名权\",\"修改权\",\"复制权\",\"发行权\",\"出租权\",\"信息网络传播权\",\"翻译权\",\"应当由著作权人享有的其他权利\"],\"hardware\":\"范德萨发达\",\"software\":\"发范德萨的\",\"programme\":\"饭打饭打啊f\",\"sourceRoutine\":\"范德萨\",\"technicalFeature\":\"fd啊\",\"proposerList\":[{\"workNnits\":\"1\",\"category\":\"1\",\"nationality\":\"1\",\"province\":\"1\",\"site\":\"1\",\"documenttype\":\"1\",\"IDNumber\":\"1\",\"garden\":\"1\",\"Businesscategory\":\"1\"}],\"applicationlist\":[{\"Organization\":\"1\",\"Address\":\"1\",\"Postcode\":\"1\",\"linkman\":\"1\",\"phoneCode\":\"1\",\"email\":\"1\",\"phoneNumber\":\"1\",\"facsimile\":\"1\"}],\"proposer\":\"2\",\"covers\":\"1\",\"weightMapper\":{\"allname\":\"4\",\"forShort\":\"4\",\"classNumber\":\"4\",\"versionNumber\":\"4\",\"sslradio\":\"4\",\"dct\":\"4\",\"PublishedState\":\"4\",\"Starting\":\"4\",\"StartingPlace\":\"4\",\"city\":\"4\",\"exploit\":\"4\",\"acquire\":\"4\",\"Transplant\":\"4\",\"originalNumber\":\"4\",\"change\":\"4\",\"interestField\":\"4\",\"publication\":\"4\",\"hardware\":\"4\",\"software\":\"4\",\"programme\":\"4\",\"sourceRoutine\":\"4\",\"technicalFeature\":\"4\",\"proposerList\":\"4\",\"applicationlist\":\"4\",\"proposer\":\"4\"},\"aggrementMapper\":{\"originalNumber\":5,\"change\":5,\"hardware\":5,\"software\":5,\"programme\":5,\"sourceRoutine\":5,\"technicalFeature\":5,\"diversified\":5},\"applicant\":\"2\",\"publishedState\":\"2\",\"Deposit\":\"16\",\"onekind\":\"2\",\"diversified\":\"111111\",\"exception\":\"19\",\"pagination\":\"20\"},\"standParseType\":1,\"sort\":0}]";


        HashMap<String,List> resultMap = new HashMap<>();

//        JSONArray jsonArray = JSON.parseArray(str2);
//        int arraySize = jsonArray.size();
//        for(int i = 0 ; i < arraySize ; i++ ){
//            JSONObject allValue = (JSONObject)jsonArray.get(i);
//            JSONObject value = (JSONObject)allValue.get("value");
//            System.out.println(value);
//
//            ArrayList nowList = new ArrayList();
//            Collection collections = value.values();
//            Iterator valueIterator = collections.iterator();
//            while(valueIterator.hasNext()){
//                Object object = valueIterator.next();
//                if( object != null ){
//                    object = object.toString();
//
//                }else{
//                    object = "";
//
//                }
//
//                nowList.add(object);
//
//            }
//
//            for( int j = 0 ; j < nowList.size() ; j++ ){
//                System.out.println( (j+1) + ":"  + nowList.get(j));
//            }
//        }
//
//        System.out.println(result.get("value"));




        JsonParser jp = new JsonParser();
        //将json字符串转化成json对象
        JsonArray ja = jp.parse(str2).getAsJsonArray();
        int size = ja.size();
        for ( int i = 0 ; i < size ; i++ ){
           JsonObject jo =  (JsonObject)ja.get(i);
           System.out.println( i + "--" + jo.get("value") );

            JsonObject value = (JsonObject)jo.get("value");

            ArrayList list = new ArrayList();

            Set<Map.Entry<String, JsonElement>> setValue = value.entrySet();
            for(Map.Entry<String, JsonElement> nowSetValue: setValue){

                String key = nowSetValue.getKey();
//                System.out.println(key);
                String allValue = "";
                if (nowSetValue.getValue() != null) {
                    allValue = nowSetValue.getValue().toString();
                }
                String nowValue = allValue.substring(1,allValue.length()-1);
                if("formName".equals(key)){
                    resultMap.put(nowValue,list);
                }
//                System.out.println(nowSetValue.getKey() +":" + nowSetValue.getValue());
                list.add(nowValue);
            }

        }

        List list = resultMap.get("RegistrationForm");
        for(int i = 1; i < list.size() ;i++ ){
            System.out.println( i + ":" + list.get(i) );
        }


//        System.out.println(resultMap.get("RegistrationForm"));



//        JsonObject jo = jp.parse(str2);//.getAsJsonObject();
//        String filename = jo.get("formName").getAsString();
//        String allname = jo.get("tableNum1").getAsString();
//        System.out.println("formName:" + filename);

    }

}
