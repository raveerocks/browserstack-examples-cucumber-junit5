package com.browserstack;

import io.cucumber.core.cli.CommandlineOptions;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

public class JunitSampleTest {

    private static String THREAD_COUNT ="parallel.threads";


    public static String THREADS;
    private static String FEATURE_PATH;

    @BeforeAll
    public static void readConfiguration(){
        THREADS = System.getProperty(THREAD_COUNT);
        FEATURE_PATH = "src/test/resources/com/browserstack";
    }


    @Test
    public void runWebDriverTests() {
        String[] argv = new String[]{
                CommandlineOptions.THREADS, THREADS,
                CommandlineOptions.PLUGIN, "com.browserstack.rerun.RerunExecutionManager:2",
                CommandlineOptions.PLUGIN, "com.browserstack.report.CustomReportListener:custom/reports",
                CommandlineOptions.PLUGIN,"com.browserstack.logger.EventLogger",
                 FEATURE_PATH};
        WebDriverTestRunner.run(true, argv);
    }
}
