package HomePage;

import Util.ReadExcel;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

public class Testss {


    @BeforeClass
    public void beforeClass() {
        System.out.println("beforeClass");
    }

    @Test(dataProvider = "excelData", dataProviderClass = ReadExcel.class, groups = "test", description = "aaa")
    public void test11(String user, String password) {
        System.out.println(user + " " + password);
    }

    @AfterClass
    public void afterClass() {
        System.out.println("afterClass");
    }
}












//
//    @Test
//    public void test(){
//        System.out.println("test");
//    }
//
//    @Test
//    public void test1(){
//        System.out.println("test1");
//    }