package listeners;

import io.qameta.allure.Attachment;
import io.qameta.allure.listener.StepLifecycleListener;
import io.qameta.allure.model.StepResult;
import org.openqa.selenium.OutputType;

import java.util.logging.Logger;

public class StepReporterEventListener implements StepLifecycleListener {
    private static final Logger LOGGER = Logger.getLogger(String.valueOf(StepReporterEventListener.class));

    @Override
    public void afterStepUpdate(StepResult result) {
        //LOGGER.info("ScreenShot taken after step Update: " + result.getName());
        //this.takeScreenShot();
    }

    /*
    @Attachment("Step Screenshot :: After Step Update")
    public byte[] takeScreenShot() {
        return MDriver.getInstance().getScreenshotAs(OutputType.BYTES);
    }
*/

}
