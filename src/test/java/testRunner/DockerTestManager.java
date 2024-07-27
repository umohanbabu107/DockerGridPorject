package testRunner;

import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;
import org.testng.TestNG;

import java.io.BufferedReader;
import java.io.File;
import java.io.IOException;
import java.io.InputStreamReader;
import java.text.SimpleDateFormat;
import java.util.Date;

public class DockerTestManager {

    // Paths to your batch files
    private static final String START_DOCKER_CMD = "batchFiles/start_dockerGrid.bat";
    private static final String SCALE_BROWSERS_CMD = "batchFiles/scaleupBrowsers.bat";
    private static final String STOP_DOCKER_CMD = "batchFiles/stop_dockerGrid.bat";
    private static final String REPORT_SRC_DIR = "test-output"; // Default location for TestNG reports
    private static final String REPORT_DEST_DIR = "reports"; // Directory to store reports with timestamp

    @BeforeClass
    public void setUp() throws Exception {
        // Start Docker Compose
        System.out.println("Starting Docker Compose...");
        executeCommand(START_DOCKER_CMD);

        // Scale up browsers
        System.out.println("Scaling up browsers...");
        executeCommand(SCALE_BROWSERS_CMD);
    }

    @Test
    public void runTests() {
        // Run tests using TestNG
        TestNG testng = new TestNG();
        testng.setTestSuites(java.util.Collections.singletonList("testng.xml"));
        testng.run();
    }

    @AfterClass
    public void tearDown() throws Exception {
        // Stop Docker Compose
        System.out.println("Stopping Docker Compose...");
        executeCommand(STOP_DOCKER_CMD);

        // Generate TestNG report
        System.out.println("Generating TestNG report...");
        moveReports();
    }

    private static void executeCommand(String command) throws Exception {
        Process process = Runtime.getRuntime().exec(command);
        try (BufferedReader reader = new BufferedReader(new InputStreamReader(process.getInputStream()))) {
            String line;
            while ((line = reader.readLine()) != null) {
                System.out.println(line);
            }
        }
        process.waitFor();
    }
    private void moveReports() {
        // Create timestamp for report names
        String timestamp = new SimpleDateFormat("yyyyMMddHHmmss").format(new Date());
        File sourceDir = new File(REPORT_SRC_DIR);
        File destDir = new File(REPORT_DEST_DIR);

        // Create destination directory if it does not exist
        if (!destDir.exists()) {
            destDir.mkdirs();
        }

        // Define new report directory with timestamp
        File newReportDir = new File(destDir, "report_" + timestamp);
        newReportDir.mkdirs();

        try {
            // Move the report files to the new directory
            org.apache.commons.io.FileUtils.copyDirectory(sourceDir, newReportDir);
            System.out.println("Reports moved to: " + newReportDir.getAbsolutePath());
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
