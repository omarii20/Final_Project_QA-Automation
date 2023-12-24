package logic;

import infrastructre.enums.Method;
import infrastructre.http.HttpRequest;
import infrastructre.http.HttpResponse;

import java.io.IOException;

import static infrastructre.http.HttpFacade.sendHttpRequest;

public class ApiRequests {


private final String baseUrl="https://www-api.rami-levy.co.il/api";


        public HttpResponse loginApi(){
            String requestBody ="";
        //            "{\n" +
        //            "  \"id\": " + res.getId() + ",\n" +
        //            "  \"name\": \"" + res.getName() + "\",\n" +
        //            "  \"score\": " + res.getScore() + ",\n" +
        //            "  \"address\": \"" + res.getAddress() + "\"\n" +
        //            "}";

            HttpRequest postRequest = new HttpRequest(Method.POST, baseUrl+"/v2/site/auth/login", null, requestBody);
            HttpResponse response = null;
            try {
                response = sendHttpRequest(postRequest);
            } catch (IOException e) {
                System.out.println(e);;
            }
            return response;
        }


}
