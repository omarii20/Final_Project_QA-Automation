package infrastructre;

import java.io.FileInputStream;
import java.util.Properties;

public class PropertiesWrapper {

    private  Properties prop ;
    public PropertiesWrapper() {
        prop = new Properties();
        try {
            FileInputStream ip = new FileInputStream("src/test/resources/config.properties");
            prop.load(ip);
        } catch (Exception e) {
            System.out.println(e);
        }

    }

    public String getProperties(String key){
        return (String)prop.get(key);
    }

}
