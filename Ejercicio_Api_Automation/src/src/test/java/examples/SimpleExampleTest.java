package examples;

import helpers.ClientManager;
import org.apache.commons.collections.map.HashedMap;
import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;
import org.json.simple.parser.ParseException;
import org.junit.Assert;
import org.junit.Test;

import javax.ws.rs.client.Client;
import javax.ws.rs.client.Entity;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;
import java.util.Collection;
import java.util.Map;
import java.util.Set;

public class SimpleExampleTest {

    @Test
    public void testGetAnUser() throws ParseException {
        String endpointUrl = "https://jsonplaceholder.typicode.com/users/1";

        //SEND GET REQUEST
        Client client = ClientManager.getClient();
        Response response = client.target(endpointUrl)
                .request(MediaType.APPLICATION_JSON_TYPE)
                .header("Content-type", "application/json; charset=UTF-8")
                .get();

        //GET RESPONSE BODY AS JSON OBJECT
        String response_body = response.readEntity(String.class);

        Object obj = new JSONParser().parse(response_body);
        JSONObject anObject = (JSONObject) obj;

        Assert.assertEquals("1", anObject.get("id").toString());
        Assert.assertEquals("Leanne Graham", anObject.get("name"));
        Assert.assertEquals("Bret", anObject.get("username"));
        Assert.assertEquals("Email validation failed", "Sincere@april.biz", anObject.get("email"));
    }

    @Test
    public void testCreateAPost() throws ParseException {
        //Defino el endopoint de la prueba
        String endpointUrl = "https://jsonplaceholder.typicode.com/posts";

        //Creo el payload del request, el json que voy a mandar dentro del body del mensaje
        Map newPost = new HashedMap();
        newPost.put("title","foo");
        newPost.put("body","bar");
        newPost.put("userId",1);

        //Creo el cliente y mando el post
        Client client = ClientManager.getClient();
        Response response = client.target(endpointUrl)
                .request(MediaType.APPLICATION_JSON_TYPE)
                .post(Entity.json(newPost));

        //Extraigo al body de la respuesta
        String response_body = response.readEntity(String.class);
        System.out.print("response: " + response_body);

        //Transformo el body de la respuesta en un objeto JSON
        Object obj = new JSONParser().parse(response_body);
        JSONObject postsList = (JSONObject) obj;

        //Valido condiciones esperadas
        Assert.assertEquals("Failed post quantity validation", 4, postsList.size());

    }
}
