package logic;

import infrastructre.PropertiesWrapper;
import infrastructre.enums.Method;
import infrastructre.http.HttpRequest;
import infrastructre.http.HttpResponse;

import java.io.IOException;

import static infrastructre.http.HttpFacade.sendHttpRequest;

public class ApiRequests {


        private  String baseUrl;

        private PropertiesWrapper propertiesWrapper;

        public ApiRequests(){
            propertiesWrapper=new PropertiesWrapper();
            baseUrl=propertiesWrapper.getProperties("BaseURL");
        }


        public HttpResponse addToCart(String itemid){

                String requestBody = String.format("""
            {
                "store": 331,
                "isClub": 0,
                "supplyAt": "2023-12-24T18:55:50.956Z",
                "items": {
                    "%s": "1.00"
                },
                "meta": null
            }
            """, itemid);

            HttpRequest postRequest = new HttpRequest(Method.POST, baseUrl+"/v2/cart", null, requestBody);
            postRequest.setHeader("Ecomtoken",propertiesWrapper.getProperties("token"));
            postRequest.setHeader("Host","www.rami-levy.co.il");
            postRequest.setHeader("Content-Length","154");
            postRequest.setHeader("Content-Type", "application/json");

            HttpResponse response = null;
            try {
                response = sendHttpRequest(postRequest);
            } catch (IOException e) {
                System.out.println(e);;
            }
            return response;

        }


}
