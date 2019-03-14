package examples.steps;

import io.qameta.allure.Step;
import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;
import org.json.simple.parser.ParseException;
import org.junit.Assert;

import javax.ws.rs.client.Entity;

public class UserSteps extends BaseStep {

    @Step("Validate that Response Body is formed as expected")
    public void validateResponseBody() throws ParseException {

        Object obj = new JSONParser().parse(response_body);
        JSONObject anObject = (JSONObject) obj;

        Assert.assertEquals("1", anObject.get("id").toString());
        Assert.assertEquals("Leanne Graham", anObject.get("name"));
        Assert.assertEquals("Bret", anObject.get("username"));
        Assert.assertEquals("Email validation failed", "ale@hotmail.com", anObject.get("email"));

    }

    public void validateUserData() throws ParseException
    {
        Object arrayObject = new JSONParser().parse(response_body);
        JSONArray jsonArray = (JSONArray) arrayObject;

        JSONObject user = (JSONObject) jsonArray.get(0); /*Data user */

       JSONObject address = (JSONObject) user.get("address");
       JSONObject company = (JSONObject) user.get("company");

                                    /*Asserts*/
        /*Users size*/
        Assert.assertEquals("Failed to get users size",10, jsonArray.size());

        /*Validate User*/
        Assert.assertEquals("1",user.get("id").toString());
        Assert.assertEquals("Leanne Graham",user.get("name"));
        Assert.assertEquals("Bret",user.get("username"));

        Assert.assertEquals("Kulas Light", address.get("street"));
        Assert.assertEquals("Apt. 556", address.get("suite"));
        Assert.assertEquals("Gwenborough", address.get("city"));
        Assert.assertEquals("92998-3874", address.get("zipcode"));

        Assert.assertEquals("1-770-736-8031 x56442",user.get("phone"));
        Assert.assertEquals("hildegard.org",user.get("website"));

        Assert.assertEquals("Romaguera-Crona",company.get("name"));
        Assert.assertEquals("Multi-layered client-server neural-net",company.get("catchPhrase"));
        Assert.assertEquals("harness real-time e-markets",company.get("bs"));

    }


}
