package workspace.steps;

import examples.steps.BaseStep;
import io.qameta.allure.Step;
import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;
import org.json.simple.parser.ParseException;
import org.junit.Assert;

public class UserPostSteps extends BaseStep {
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
