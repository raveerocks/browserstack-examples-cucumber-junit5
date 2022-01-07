package com.browserstack;



public class ParallelPlatformTest {

   /* @Test
    public void runWebDriverTests() throws IOException {
        System.out.println("runWebDriverTests started");
        String[] argv = new String[]{
                CommandlineOptions.THREADS,"25",
                //CommandlineOptions.TAGS,"@Random",
                // CommandlineOptions.PLUGIN,"com.browserstack.WebDriverHolders",
                CommandlineOptions.PLUGIN,"com.browserstack.rerun.RerunExecutionManager:2",
                CommandlineOptions.PLUGIN,"com.browserstack.report.CustomReportListener:target/reports",
                CommandlineOptions.NAME,"End to End Scenario",
                CommandlineOptions.GLUE, "", "src/test/resources/com/browserstack"};
        WebDriverTestRunner.run(true,argv);
        System.out.println("runWebDriverTests finished");
        //CustomReportBuilder customReporter = new CustomReportBuilder();
        //customReporter.create();
    }
*/

}
