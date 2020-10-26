package workspace;

import helpers.ConfigHelper;
import org.json.simple.parser.ParseException;
import org.junit.Test;

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
import java.util.ArrayList;
import java.util.Collection;
import java.util.Map;
import java.util.Set;


public class PostsCommentsTest {

    @Test
    public void testGetPostId1Comments () throws ParseException{

        String endpointUrl = ConfigHelper.getPostURL()+"?userId=1";

        //SEND GET REQUEST
        Client client = ClientManager.getClient();
        Response response = client.target(endpointUrl)
                .request(MediaType.APPLICATION_JSON_TYPE)
                .header("Content-type", "application/json; charset=UTF-8")
                .get();

        //GET RESPONSE BODY AS JSON OBJECT
        String response_body = response.readEntity(String.class);

        Object obj = new JSONParser().parse(response_body);
        JSONArray anArray = (JSONArray) obj;

        Assert.assertTrue(existeAlgunTitulo(anArray,"eum et est occaecati"));

    }

    @Test
    public void testGetCommmentsFirstPostNikita() throws ParseException {
        String endpointUrl = "https://jsonplaceholder.typicode.com/posts/1/comments";
        String expectedEmail = "Nikita@garfield.biz";
        String expectedId = "1";

        //SEND GET REQUEST
        Client client = ClientManager.getClient();
        Response response = client.target(endpointUrl)
                .request(MediaType.APPLICATION_JSON_TYPE)
                .header("Content-type", "application/json; charset=UTF-8")
                .get();

        //GET RESPONSE BODY AS JSON OBJECT
        String response_body = response.readEntity(String.class);

        Object arr = new JSONParser().parse(response_body);
        JSONArray anArray = (JSONArray) arr;


        Assert.assertTrue("Failed looking for a comment of Nikita User", existsCommentWithID(expectedEmail, expectedId, anArray));

    }


    public boolean existsCommentWithID(String expectedEmail, String expectedId, JSONArray anArray)
    {
        boolean existePost = false;
        for (int i=0; i<anArray.size(); i++){
            JSONObject aPost = (JSONObject) anArray.get(i);
            String postID = aPost.get("postId").toString();
            String email = aPost.get("email").toString();

            if (postID.equals(expectedId) && email.equals(expectedEmail)){
                existePost = true;
                break;
            }
        }
        return existePost;
    }

    public boolean existeAlgunTitulo(JSONArray  array,String titulo)
    {
        for(int n = 0; n < array.size(); n++)
        {
            JSONObject object = (JSONObject) array.get(n);//getJSONObject(n);
            if (object.get("title").equals(titulo)) return true;
        }
        return false;
    }
}
