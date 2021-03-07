package Util;

import jxl.Cell;
import jxl.Sheet;
import jxl.Workbook;
import org.testng.Assert;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.InputStream;
import java.lang.reflect.Method;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;


    public class ReadExcel implements Iterator<Object[]> {
    private Workbook book = null;
    private Sheet sheet = null;
    private int rowNum = 0;
    private int currentRowNo = 0;
    private int columnNum = 0;
    private String[] columnnName;
    private String path = null;
    private InputStream inputStream = null;

    public void  ReadExcel(){

    }

    public String[][]  init(String path, String moduleName, int startRow, int col) {
        String[][] result = null;
        try {
            inputStream = new FileInputStream(path);
            book = Workbook.getWorkbook(inputStream);
            sheet = book.getSheet(moduleName);
            rowNum = sheet.getRows();
            result = new String[rowNum-startRow][col];
            int rowPoint = 0;
            for (int r = startRow; r < rowNum; r++,rowPoint++) {
                Cell[] cell = sheet.getRow(r);
                columnNum = cell.length;
                columnnName = new String[cell.length];
                for (int i = 0; i < cell.length; i++) {
                    result[rowPoint][i] = cell[i].getContents().toString();
//                    System.out.println(r + "," + i + "=" + result[rowPoint][i]);
                }
            }

        } catch (FileNotFoundException e) {
            Assert.fail("文件路径错误" + "[" + path + "]");
        } catch (Exception e) {
            Assert.fail("数据文件错误" + path + "]");
        }
        return result;
    }

    public boolean hasNext() {
        if (this.rowNum == 0 || this.currentRowNo >= this.rowNum) {
            try {
                inputStream.close();
                book.close();
            } catch (Exception e) {
                e.printStackTrace();
            }
            return false;
        } else {
            if ((sheet.getRow(currentRowNo))[0].getContents().equals(""))
                return false;
            return true;
        }
    }

    public Object[] next() {
        Cell[] c = sheet.getRow(this.currentRowNo);
        Map<String, String> data = new HashMap<String, String>();
        for (int i = 0; i < this.columnNum; i++) {
            String temp = "";
            try {
                temp = c[i].getContents().toString();
            } catch (ArrayIndexOutOfBoundsException ex) {
                temp = "";
            }
            data.put(this.columnnName[i], temp);
        }
        Object object[] = new Object[1];
        object[0] = data;
        this.currentRowNo++;
        return object;
    }

    public void remove() {
        throw new UnsupportedOperationException("remove unsupported.");
    }
    @DataProvider(name = "excelData")
    protected Object[][] excel(Method method) {
        String path = ReadExcel.class.getResource("/").getPath();
        String fileName = path+"files\\userList1.xls";
        System.out.println("111111111111"+path);
        String moduleName = "login";
        return init(fileName, moduleName, 1,2);
    }
    @Test(dataProvider="excelData")
    public void test11(String name,String age){
        System.out.println("<"+name+","+age+">");
    }

}
