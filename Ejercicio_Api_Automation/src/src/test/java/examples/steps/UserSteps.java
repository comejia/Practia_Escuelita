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
        Assert.assertEquals("Email validation failed", "Sincere@april.biz", anObject.get("email"));

    }

    @Step("Validate that Response user data is formed as expected")
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
        Assert.assertEquals("Failed to user id", "1",user.get("id").toString());
        Assert.assertEquals("Failed to name","Leanne Graham",user.get("name"));
        Assert.assertEquals("Failed to user name","Bret",user.get("username"));
        Assert.assertEquals("Failed to phone","1-770-736-8031 x56442",user.get("phone"));
        Assert.assertEquals("Failed to website","hildegard.org",user.get("website"));

        Assert.assertEquals("Failed to address street","Kulas Light", address.get("street"));
        Assert.assertEquals("Failed to address suite","Apt. 556", address.get("suite"));
        Assert.assertEquals("Failed to address city","Gwenborough", address.get("city"));
        Assert.assertEquals("Failed to address zipcode","92998-3874", address.get("zipcode"));

        Assert.assertEquals("Failed to company name","Romaguera-Crona",company.get("name"));
        Assert.assertEquals("Failed to company catchPrase","Multi-layered client-server neural-net",company.get("catchPhrase"));
        Assert.assertEquals("Failed to company bs","harness real-time e-markets",company.get("bs"));

    }


}
