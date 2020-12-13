package Util.zl;

import jxl.Cell;
import jxl.Sheet;
import jxl.Workbook;
import jxl.read.biff.BiffException;
import jxl.write.WritableWorkbook;

import java.io.File;
import java.io.IOException;

public class readExcelUtil {
    public static void getExcel() {
        WritableWorkbook wwb = null;
        //1:创建workbook
        Workbook workbook = null;

        try {
            workbook = Workbook.getWorkbook(new File("D:\\dataList\\data201205103527.xls"));
        } catch (IOException e) {
            e.printStackTrace();
        } catch (BiffException e) {
            e.printStackTrace();
        }
        //2:获取第一个工作表sheet
        Sheet sheet = workbook.getSheet(0);

        //3:获取数据
        System.out.println("行:" + sheet.getRows());
        System.out.println("列:" + sheet.getColumns());

        for (int i = 0; i < sheet.getRows(); i++) {
            Cell cell = sheet.getCell(0, i);
            System.out.print(cell.getContents() + " ");
            System.out.println();
        }

        //最后一步：关闭资源
        workbook.close();
    }

    public static void main(String[] args) {
        getExcel();
    }
}
