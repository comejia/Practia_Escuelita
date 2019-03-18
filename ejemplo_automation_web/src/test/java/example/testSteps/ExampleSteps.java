package example.testSteps;

import Steps.BaseSteps;
import io.qameta.allure.Step;
import static org.junit.Assert.*;


public class ExampleSteps extends BaseSteps {

    private String url;

    @Step("Example: create start page - print method parameter example {url}")
    public void startPage(String url) throws Exception {

        ExamplePage examplePage = getPage(ExamplePage.class, url);
        assertTrue("Check condition", true);
    }

    @Step("Example: navegate page")
    public void navegatePage() throws Exception {

        ExamplePage examplePage = getPage(ExamplePage.class);
    }
}
