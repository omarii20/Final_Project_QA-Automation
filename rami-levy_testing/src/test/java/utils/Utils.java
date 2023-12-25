package utils;

import io.cucumber.core.internal.com.fasterxml.jackson.databind.JsonNode;
import io.cucumber.core.internal.com.fasterxml.jackson.databind.ObjectMapper;

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
}
