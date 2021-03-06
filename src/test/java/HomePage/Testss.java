package HomePage;

import Util.ReadExcel;
import org.testng.annotations.Test;

import javax.annotation.Resource;


public class Testss {
    @Test(dataProvider = "excelData",dataProviderClass = ReadExcel.class,groups = "test",description = "aaa")
    @Resource
    public void test11(String name1,String ag1e){
        System.out.println(name1+"_"+ag1e);
    }
}
