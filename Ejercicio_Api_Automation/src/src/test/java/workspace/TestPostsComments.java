package workspace;

import helpers.ClientManager;
import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;
import org.json.simple.parser.ParseException;
import org.junit.Assert;
import org.junit.Test;

import javax.ws.rs.client.Client;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;

public class TestPostsComments {

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
}
