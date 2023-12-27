package logic;
import com.google.gson.Gson;
import infrastructre.PropertiesWrapper;
import infrastructre.enums.Method;
import infrastructre.http.HttpRequest;
import infrastructre.http.HttpResponse;
import test.enums.Enums;
import java.io.IOException;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.HashMap;
import java.util.Map;

import static infrastructre.http.HttpFacade.sendHttpRequest;

public class ApiRequests {

    private  String baseUrl;
    private PropertiesWrapper propertiesWrapper;
    public ApiRequests(){
        propertiesWrapper=new PropertiesWrapper();
        baseUrl=propertiesWrapper.getProperties(Enums.BaseURL);
    }

    public HttpResponse addToCart(String itemid) {
        Map<String, String> items = new HashMap<>();
        items.put(itemid, "1.00");

        LocalDateTime now = LocalDateTime.now();
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd'T'HH:mm:ss.SSS'Z'");
        String formattedDateTime = now.format(formatter);

        CartRequest cartRequest = new CartRequest(331, 0, formattedDateTime, items, null);

        // Convert the CartRequest object to JSON
        Gson gson = new Gson();
        String requestBody = gson.toJson(cartRequest);

        HttpRequest postRequest = new HttpRequest(Method.POST, baseUrl + "/v2/cart", null, requestBody);
        postRequest.setHeader("Ecomtoken", propertiesWrapper.getProperties(Enums.token));
        postRequest.setHeader("Host", "www.rami-levy.co.il");
        postRequest.setHeader("Content-Length", String.valueOf(requestBody.length()));
        postRequest.setHeader("Content-Type", "application/json");

        HttpResponse response = null;
        try {
            response = sendHttpRequest(postRequest);
        } catch (IOException e) {
            System.out.println(e);
        }
        return response;
    }
}