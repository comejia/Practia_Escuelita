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

    @Step("Validate that exists a title with ")
    public void validateTitle() throws ParseException {
        Object obj = new JSONParser().parse(response_body);
        JSONArray anArray = (JSONArray) obj;

        Assert.assertTrue("Title validation failed",existeAlgunTitulo(anArray,"eum et est occaecati"));

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
