package com.he.spring.web.webservice.servicejson;

import com.fasterxml.jackson.jaxrs.json.JacksonJsonProvider;
import org.apache.cxf.jaxrs.client.WebClient;

import javax.ws.rs.core.GenericType;
import javax.ws.rs.core.MediaType;
import java.util.ArrayList;
import java.util.List;

public class CXFWebClient {

    public static void main(String[] args) {
        String baseAddress = "http://localhost:8080/ws/rest";

        List<Object> providerList = new ArrayList<Object>();
        providerList.add(new JacksonJsonProvider());

        List productList = WebClient.create(baseAddress, providerList)
            .path("/products")
            .accept(MediaType.APPLICATION_JSON)
            .get(List.class);
        for (Object product : productList) {
            System.out.println(product);
        }

        List<Product> productList2 = WebClient.create(baseAddress, providerList)
            .path("/products")
            .accept(MediaType.APPLICATION_JSON)
            .get(new GenericType<List<Product>>() {});
        for (Product product : productList2) {
            System.out.println(product);
        }
    }
}
