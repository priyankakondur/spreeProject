package general;

import org.testng.ITestListener;
import org.testng.ITestResult;

import java.io.IOException;

public class Listeners extends BaseTest implements ITestListener {
    //BaseTest b = new BaseTest();
    @Override
    public void onTestFailure(ITestResult result) {
        String testName = result.getName();

        try {
            takeScreenshot( testName);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    @Override
    public void onTestSuccess(ITestResult result) {
        String testName = result.getName();
        try {
            takeScreenshot(testName);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

}
