package example.listeners;

import Helpers.DriverWeb;
import Pages.WebComponent;
import io.qameta.allure.Attachment;
import io.qameta.allure.listener.StepLifecycleListener;
import io.qameta.allure.model.StepResult;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;

import java.util.logging.Logger;

public class StepReporterEventListener implements StepLifecycleListener {
    private static final Logger LOGGER = Logger.getLogger(String.valueOf(WebComponent.class));

    @Override
    public void afterStepStart(StepResult result) {
        LOGGER.info("STEP :: STARTED :: " + result.getName() + " - " + result.getDescription() );
        this.takeScreenShot_BeforeStep();
    }

    @Attachment("Step Screenshot :: Previo a ejecutarse accinn en el step")
    public byte[] takeScreenShot_BeforeStep() {
        return ((TakesScreenshot) DriverWeb.getInstance()).getScreenshotAs(OutputType.BYTES);
    }


    @Override
    public void afterStepUpdate(StepResult result) {
        LOGGER.info("STEP :: COMPLETED :: " + result.getName() + " - " + result.getDescription() );
        this.takeScreenShot_OnStepUpdate();
    }

    @Attachment("Step Screenshot :: Al ejecutarse accion en el step")
    public byte[] takeScreenShot_OnStepUpdate() {
        return ((TakesScreenshot) DriverWeb.getInstance()).getScreenshotAs(OutputType.BYTES);
    }
}
