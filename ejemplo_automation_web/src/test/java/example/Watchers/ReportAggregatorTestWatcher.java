package example.Watchers;

import org.junit.rules.TestWatcher;
import org.junit.runner.Description;
import org.junit.runners.model.Statement;

import java.util.logging.Level;
import java.util.logging.Logger;

public class ReportAggregatorTestWatcher extends TestWatcher {
    private static String resultLog = "";
    private static final Logger LOGGER = Logger.getLogger(String.valueOf(ReportAggregatorTestWatcher.class));

    public ReportAggregatorTestWatcher() {

    }

    @Override
    public Statement apply(Statement base, Description description) {
        return super.apply(base, description);
    }

    @Override
    protected void succeeded(Description description) {
        resultLog = "TEST :: SUCCEDED :: " + description.getMethodName();
        LOGGER.log(Level.INFO, resultLog);
        super.succeeded(description);
    }

    @Override
    protected void failed(Throwable e, Description description) {
        resultLog = "TEST :: FAILED :: " + description.getMethodName();
        LOGGER.log(Level.INFO, resultLog);
        super.failed(e, description);
    }

    @Override
    protected void starting(Description description) {
        resultLog = "TEST :: STARTING :: " + description.getMethodName();
        LOGGER.log(Level.INFO, resultLog);
        super.starting(description);
    }

    @Override
    protected void finished(Description description) {
        super.finished(description);

    }
}
