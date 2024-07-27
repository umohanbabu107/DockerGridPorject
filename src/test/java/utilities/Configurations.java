package utilities;

import java.io.FileInputStream;
import java.util.Properties;

public class Configurations {
    public String getPropertyByKey(String key){
        Properties properties = new Properties();
        try {
            FileInputStream fis = new FileInputStream(".resources/technicalConfigurations.properties");
            properties.load(fis);
        }
        catch (Exception exception){
            System.out.println("This file didn't found");
        }
        return properties.getProperty(key);
    }
    public static void main(String args[]){
        final Configurations configurations = new Configurations();
        System.out.println(configurations.getPropertyByKey("browser"));
        System.out.println(configurations.getPropertyByKey("env"));
        System.out.println(configurations.getPropertyByKey("hubUrl"));
    }
}
