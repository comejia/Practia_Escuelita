package workspace;

import com.google.gson.JsonArray;
import com.google.gson.JsonObject;
import helpers.ClientManager;
import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;
import org.json.simple.parser.ParseException;
import org.junit.Assert;
import org.junit.Test;
import org.openqa.selenium.json.Json;

import javax.ws.rs.client.Client;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;

public class UsersTest
{
    @Test
    public void testGetUserList() throws ParseException {
        String endpointUrl = "https://jsonplaceholder.typicode.com/users";

        //SEND GET REQUEST
        Client client = ClientManager.getClient();
        Response response = client.target(endpointUrl)
                .request(MediaType.APPLICATION_JSON_TYPE)
                .header("Content-type", "application/json; charset=UTF-8")
                .get();


        //GET RESPONSE BODY AS JSON OBJECT
        String response_body = response.readEntity(String.class);


        Object arrayObject = new JSONParser().parse(response_body);
        JSONArray jsonArray = (JSONArray) arrayObject;


        JSONObject User2 = (JSONObject) jsonArray.get(1); /*Data user 2*/

        Assert.assertEquals("Failed to get users size",10, jsonArray.size());
        Assert.assertEquals("Ervin Howell", User2.get("name").toString());
    }


}
