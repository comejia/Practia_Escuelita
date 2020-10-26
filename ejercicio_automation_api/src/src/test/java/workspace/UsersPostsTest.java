package workspace;

import workspace.steps.UserPostSteps;
import workspace.steps.UserSteps;
import helpers.ConfigHelper;
import org.json.simple.parser.ParseException;
import org.junit.Test;


public class UsersPostsTest {

    String testMethodURL;

    public UsersPostsTest()
    {
        this.testMethodURL = ConfigHelper.getPostURL();
    }

    @Test
    public void testGetPostFromAnUser() throws ParseException {
        //TODO: Evaluate if a data-driven test would be a better approach!

        UserPostSteps step = new UserPostSteps();
        step.getRequest(this.testMethodURL + "?userId=1");
        step.validateResponseCode(200);
        step.validateResponseHeaders();
        step.validateTitle();

    }
}
