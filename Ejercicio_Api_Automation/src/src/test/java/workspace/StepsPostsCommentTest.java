package workspace;

import examples.steps.UserSteps;
import helpers.ClientManager;
import helpers.ConfigHelper;
import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;
import org.json.simple.parser.ParseException;
import org.junit.Assert;
import org.junit.Test;

import javax.ws.rs.client.Client;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;


public class StepsPostsCommentTest {

    String testMethodURL;

    public StepsPostsCommentTest()
    {
        this.testMethodURL = ConfigHelper.getPostURL();
    }

    @Test
    public void test_GetAnUser() throws ParseException {
        //TODO: Evaluate if a data-driven test would be a better approach!

        UserSteps step = new UserSteps();
        step.getRequest(this.testMethodURL + "?userId=1");
        step.validateResponseCode(200);
        step.validateResponseHeaders();
        step.validateTitle();

    }
}
