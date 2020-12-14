package Util;

import java.io.BufferedInputStream;
import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;

public class ProUtil {
    Properties Pro;

    public ProUtil(String filePath) {
        Pro = getProElement(filePath);
    }

    private Properties getProElement(String filePath) {
        Properties properties = new Properties();
        FileInputStream fileInputStream;
        try {
            fileInputStream = new FileInputStream(filePath);
            BufferedInputStream bufferedInputStream = new BufferedInputStream(fileInputStream);
            properties.load(bufferedInputStream);
        } catch (IOException e) {
            e.printStackTrace();
        }
        return properties;
    }

    public String getP(String key) {
        String value;
        if (Pro.containsKey(key)) {
            value = Pro.getProperty(key);
            return value;
        }
        return "错误的关键字";
    }

    public int size(){
        int size = Pro.size();
        return size;
    }
    public static void main(String[] args) {
//        ProUtil proUtil = new ProUtil("F:\\Final exercise selenium\\element.properties");
        ProUtil proUtil = new ProUtil("E:\\Final exercise selenium1206\\Final exercise selenium\\ddd\\examElement.properties");
        String username = proUtil.getP("usernameElement");
        System.out.println(username);
    }
}
