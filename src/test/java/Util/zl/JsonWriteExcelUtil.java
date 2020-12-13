package Util.zl;


import com.google.gson.JsonObject;
import com.google.gson.JsonParser;
import jxl.Workbook;
import jxl.write.Label;
import jxl.write.WritableSheet;
import jxl.write.WritableWorkbook;
import jxl.write.WriteException;

import java.io.File;
import java.io.IOException;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Random;

/**
 * @author fj
 * 自动获取json中的formName并存储到excel中
 */
public class JsonWriteExcelUtil {

    public static void main(String[] args) throws IOException, WriteException {
        Random r = new Random();
        Date date = new Date();
        // String curdate = date.toString();
        DateFormat df6 = new SimpleDateFormat("yyMMddhhmmss");
        String formatdate = df6.format(date);
        File fileDir = new File("D:\\dataList");
        if (!fileDir.exists()) {
            fileDir.mkdir();
        }
        File xlsFile = new File("D:\\dataList\\data" + formatdate + ".xls");
        System.out.println("xlsFile" + xlsFile);
        // 创建一个工作簿
        WritableWorkbook workbook = Workbook.createWorkbook(xlsFile);
        // 创建一个工作表
        WritableSheet sheet = workbook.createSheet("sheet1", 0);
        // 设置titles
        String[] titles = {"formName", "allname", "tableRemarks2", "name"};
        // 设置单元格
        Label label = null;
        // 给第一行设置列名
        for (int i = 0; i < titles.length; i++) {
            // x,y,第一行的列名
            Label lable = new Label(i, 0, titles[i]);
            // 添加单元格
            sheet.addCell(lable);

        }

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
        String filename = jo.get("formName").getAsString();
        String allname = jo.get("tableNum1").getAsString();
        System.out.println("formName:" + filename);

        for (int row = 1; row < 5; row++) {
            for (int col = 0; col < 5; col++) {


                // 向工作表中添加数据
                sheet.addCell(new Label(col, row, filename));
            }
        }
        workbook.write();
        workbook.close();

    }
}

