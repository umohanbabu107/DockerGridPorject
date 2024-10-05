package utilities;

import org.testng.ITestContext;
import org.testng.ITestListener;
import org.testng.ITestResult;

public class Listeners implements ITestListener {
    public void onStart(ITestContext context) {
        System.out.println("Execution started...");
    }
    public void onTestStart(ITestResult result) {
        System.out.println(result.getMethod() + " execution started...");
    }

    public void onTestSuccess(ITestResult result) {
        System.out.println(result.getMethod() + " passed");
    }

    public void onTestFailure(ITestResult result) {
        System.out.println(result.getMethod() + " failed");
    }

    public void onTestSkipped(ITestResult result) {
        System.out.println(result.getMethod() + " skipped");
    }

    public void onFinish(ITestContext context) {
        System.out.println("Execution finished...");
    }
}
