package genericLibraries;

import org.testng.ITestContext;
import org.testng.ITestListener;
import org.testng.ITestResult;

public class ListenerImplementation implements ITestListener {

	@Override
	public void onTestStart(ITestResult result) {
		System.out.println(result.getMethod().getMethodName()+"execution starts");
		
	}

	@Override
	public void onTestSuccess(ITestResult result) {
	System.out.println(result.getMethod().getMethodName()+"pass");
	
	}

	@Override
	public void onTestFailure(ITestResult result) {
     System.out.println(result.getMethod().getMethodName()+"failed");
		System.out.println("failure occured due to:"+result.getThrowable());
		WebDriverUtility web = new WebDriverUtility();
		web.takeScreenshot(BaseClass.sdriver, result.getMethod().getMethodName(), BaseClass.sjutil);
		
		
	}

	@Override
	public void onTestSkipped(ITestResult result) {
	System.out.println(result.getMethod().getMethodName()+"skipped");
	System.out.println("skipped due to:"+result.getThrowable());
	
	
	}

	@Override
	public void onStart(ITestContext context) {
     System.out.println("suite execution starts");
	}

	@Override
	public void onFinish(ITestContext context) {
     System.out.println("suite execution ends");
	}
	
	
	
	

}
