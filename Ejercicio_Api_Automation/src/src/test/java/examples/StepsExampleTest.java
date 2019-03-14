package examples;

import examples.steps.UserSteps;
import helpers.ConfigHelper;
import org.json.simple.parser.ParseException;
import org.junit.Test;

public class StepsExampleTest {

    String testMethodURL;

    public StepsExampleTest()
    {
        this.testMethodURL = ConfigHelper.getUserURL();
    }

    @Test
    public void test_GetAnUser() throws ParseException {
        //TODO: Evaluate if a data-driven test would be a better approach!

        UserSteps step = new UserSteps();
        step.getRequest(this.testMethodURL + "1");
        step.validateResponseCode(200);
        step.validateResponseHeaders();
        step.validateResponseBody();

    }

}
