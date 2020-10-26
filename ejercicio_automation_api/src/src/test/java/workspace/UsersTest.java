package workspace;

import workspace.steps.UserSteps;
import helpers.ConfigHelper;
import org.json.simple.parser.ParseException;
import org.junit.Test;

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
