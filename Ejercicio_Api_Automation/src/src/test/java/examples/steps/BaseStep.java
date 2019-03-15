package examples.steps;
import helpers.ClientManager;
import io.qameta.allure.Step;
import org.junit.Assert;

import javax.ws.rs.client.Client;
import javax.ws.rs.client.Entity;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.MultivaluedHashMap;
import javax.ws.rs.core.MultivaluedMap;
import javax.ws.rs.core.Response;
import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import java.util.Map;

public class BaseStep {
    protected Entity payload;
    protected Response response;
    protected String response_body;


    @Step("Do a POST Request to url :: {endpoint_url}")
    public void postRequest(String endpoint_url) {
        //TODO: Evaluate if any assert should be usefull here

        Client client = ClientManager.getClient();
        response = client.target(endpoint_url)
                .request(MediaType.APPLICATION_JSON_TYPE)
                .post(payload);

        traceRequestResponse(endpoint_url, "POST", payload, response);
    }

    @Step("Do a POST Request to url with specific headers:: {endpoint_url}")
    public void postRequest(String endpoint_url, MultivaluedMap<String, Object> headers) {
        //TODO: Evaluate if any assert should be usefull here

        Client client = ClientManager.getClient();
        response = client.target(endpoint_url)
                .request(MediaType.APPLICATION_JSON_TYPE)
                .headers(headers)
                .post(payload);

        traceRequestResponse(endpoint_url, "POST", payload, response);
    }

    @Step("Do a GET Request to url :: {endpoint_url}")
    public void getRequest(String endpoint_url) {
        //TODO: Evaluate if any assert should be usefull here

        Client client = ClientManager.getClient();
        response = client.target(endpoint_url)
                .request(MediaType.APPLICATION_JSON_TYPE)
                .get();

        traceRequestResponse(endpoint_url, "GET", payload, response);
    }

    @Step("Do a GET Request to url with specific headers:: {endpoint_url}")
    public void getRequest(String endpoint_url, MultivaluedMap<String, Object> headers) {
        //TODO: Evaluate if any assert should be usefull here

        Client client = ClientManager.getClient();
        response = client.target(endpoint_url)
                .request(MediaType.APPLICATION_JSON_TYPE)
                .headers(headers)
                .get();

        traceRequestResponse(endpoint_url, "GET", payload, response);
    }

    protected void traceRequestResponse(String endpoint_url, String method, Entity payload, Response response) {
        //
        response_body = response.readEntity(String.class);

        System.out.println("Request URL: " + endpoint_url);
        System.out.println("Request Method: " + method);
        System.out.println("Request Body: " + payload);
        System.out.println("Response status: " + response.getStatus());
        System.out.println("Response headers: " + response.getHeaders());
        System.out.println("Response body:" + response_body);
    }

    @Step("Validate that Response Headers are conformed as expected")
    public void validateResponseHeaders(){
        //TODO: Assert to headers, what headers should come and witch are the correct values
        Assert.assertEquals("application/json; charset=utf-8", response.getHeaderString("Content-Type"));
    }

    @Step("Validate that Response Code is :: {expected_code}")
    public void validateResponseCode(int expected_code){
        Assert.assertEquals(expected_code, response.getStatus());
    }

}
