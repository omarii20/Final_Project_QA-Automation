package infrastructre;
import test.enums.Enums;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.Properties;

public class PropertiesWrapper {

    private final String propPath="src/test/resources/config.properties";
    private  Properties prop ;
    public PropertiesWrapper() {
        prop = new Properties();
        try {
            FileInputStream ip = new FileInputStream(propPath);
            prop.load(ip);
        } catch (Exception e) {
            System.out.println(e);
        }
    }

    public String getProperties(Enums key){
        return (String)prop.get(key.toString());
    }

    public void setProprieties(Enums key, String value){
        prop.setProperty(key.toString(), value);
        try (FileOutputStream fileOutputStream = new FileOutputStream(propPath)) {
            // Write properties to the output stream
            prop.store(fileOutputStream, "");
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
