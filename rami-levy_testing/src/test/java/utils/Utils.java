package utils;
import io.cucumber.core.internal.com.fasterxml.jackson.databind.JsonNode;
import io.cucumber.core.internal.com.fasterxml.jackson.databind.ObjectMapper;
import org.openqa.selenium.JavascriptExecutor;

import java.util.ArrayList;
import java.util.List;

public class Utils {

    public static String extractTokenFromJson(String jsonString) {
        try {
            ObjectMapper objectMapper = new ObjectMapper();
            JsonNode jsonNode = objectMapper.readTree(jsonString);

            // Navigate to the 'token' field in the JSON structure
            JsonNode tokenNode = jsonNode.at("/authuser/user/token");

            // Check if the 'token' field exists
            if (!tokenNode.isMissingNode()) {
                return tokenNode.asText();
            }
        } catch (Exception e) {
            e.printStackTrace();
        }

        return null;
    }

    public static void myWait(int num){
        try {
            Thread.sleep(num);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
    }

    public static int extractNumber(String str){
        String[] s = str.split(" ");
        String newString=s[s.length-1].substring(1,s[s.length-1].length()-1);
        return Integer.parseInt(newString);
    }

    public static List<String> extractItems(JavascriptExecutor js) {
        JsonNode itemsNode=null;
        String localstorage = (String) js.executeScript("return localStorage.getItem('ramilevy');");
        List<String> IDs=new ArrayList<>();
        try {
            ObjectMapper objectMapper = new ObjectMapper();
            JsonNode jsonNode = objectMapper.readTree(localstorage);
            itemsNode = jsonNode.path("cart").path("items");

            for(JsonNode node:itemsNode){
                IDs.add(node.path("id").toString());
            }
            System.out.println(itemsNode);
        } catch (Exception e) {
            e.printStackTrace();
        }
        return IDs;
    }

}
