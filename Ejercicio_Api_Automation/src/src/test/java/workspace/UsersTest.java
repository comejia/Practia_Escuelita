package workspace;

import com.google.gson.JsonArray;
import com.google.gson.JsonObject;
import examples.steps.UserSteps;
import helpers.ClientManager;
import helpers.ConfigHelper;
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
    String testMethodURL;

    public UsersTest()
    {
        this.testMethodURL = ConfigHelper.getUserURL();
    }

    @Test
    public void testGetUserList() throws ParseException
    {
        UserSteps usteps = new UserSteps();

        usteps.getRequest(this.testMethodURL);
        usteps.validateResponseCode(200);
        usteps.validateResponseHeaders();
        usteps.validateUserData();
    }


}
