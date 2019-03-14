package examples.steps;

import io.qameta.allure.Step;
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


}
