package Util.zl;

import com.google.gson.JsonObject;
import com.google.gson.JsonParser;


public class getJsonValue {


    public static class Test {
        public static void main(String[] args) {

            String resultStr = "{\n" +
                    "                    \"formName\":\"taxForm\",\n" +
                    "                    \"tableNum1\":\"50\",\n" +
                    "                    \"tableRemarks2\":\"\",\n" +
                    "                    \"name\":\"周燕\",\n" +
                    "                    \"mobileNum\":\"13984824461\",\n" +
                    "                    \"taxNumber\":\"91110113665E43456M\",\n" +
                    "                    \"taxName\":\"北京华嵘商贸有限责任公司\",\n" +
                    "                    \"detailAddress\":\"石窟北路334号\",\n" +
                    "                    \"address\":\"顺义区\",\n" +
                    "                    \"postalCode\":\"101300\",\n" +
                    "                    \"isYourSelfGet\":\"1\",\n" +
                    "                    \"tableNum2\":\"25\"\n" +
                    "                }";


            JsonParser jp = new JsonParser();
            //将json字符串转化成json对象
            JsonObject jo = jp.parse(resultStr).getAsJsonObject();
            //获取formName对应的值
            String formName = jo.get("formName").getAsString();
            String tableNum1 = jo.get("tableNum1").getAsString();
            String name = jo.get("name").getAsString();
            System.out.println("formName：" + formName);
            System.out.println("tableNum1：" + tableNum1);
            System.out.println("name：" + name);

        }
    }


}
