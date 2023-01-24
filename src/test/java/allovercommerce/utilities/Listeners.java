package allovercommerce.utilities;

import org.testng.ITestContext;
import org.testng.ITestListener;
import org.testng.ITestResult;

import java.io.IOException;



public class Listeners implements ITestListener{

    /*
    ITestListener in an interface.
    It is used for customising our testNG framework.
    It triggers some extra codes e.g.
    onStart, onFinish, onTestStart, onTestFinish, onTestSuccess, onTestFail
    These are special method names to LISTEN the test methods.
    We specially use Listeners for adding a special condition such as test pass, fail or skip.
     */

    @Override
    public void onStart(ITestContext context) {
        System.out.println("onStart - Execute ONCE before All Tests " + context.getName());
    }

    @Override
    public void onFinish(ITestContext context) {
        System.out.println("onFinish - Execute ONCE after All Tests " + context.getName());
    }

    @Override
    public void onTestStart(ITestResult result) {
        System.out.println("onTestStart - Execute ONCE before EACH @Test " + result.getName());
    }

    @Override
    public void onTestSuccess(ITestResult result) {
        System.out.println("onTestSuccess - Execute ONCE after EACH PASSED @Test " + result.getName());
    }

    @Override
    public void onTestFailure(ITestResult result) {
//        System.out.println("onTestFailure - Execute AFTER EACH FAILED @Test : "+result.getName());
        try {
            ReusableMethods.getScreenshot("TEST CASE FAILED : " + result.getName());
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    @Override
    public void onTestSkipped(ITestResult result) {
        System.out.println("onTestSkipped - Execute ONCE after EACH SKIPPED @Test " + result.getName());
    }


}
