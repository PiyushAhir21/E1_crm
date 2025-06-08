package listeners_utility;

import org.testng.ISuite;
import org.testng.ISuiteListener;
import org.testng.ITestListener;
import org.testng.ITestResult;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.Status;
import com.aventstack.extentreports.reporter.ExtentSparkReporter;
import com.aventstack.extentreports.reporter.configuration.Theme;

public class List_Imp implements ITestListener, ISuiteListener {

	ExtentReports report = new ExtentReports();
	ExtentTest test;

	@Override
	public void onStart(ISuite suite) {
//		ExtentSparkReporter class
		ExtentSparkReporter spark = new ExtentSparkReporter(
				"C:\\Users\\User\\git\\E1\\E1-Vtiger-crm\\AdvanceReports\\adRep1.html");
		spark.config().setDocumentTitle("E1-Vtiger-CRM-FW");
		spark.config().setReportName("First Report");
		spark.config().setTheme(Theme.DARK);

//		ExtentReports class
		report = new ExtentReports();
		report.attachReporter(spark);
		report.setSystemInfo("OS", "Linux");
		report.setSystemInfo("ATE", "Ranaji");
		report.setSystemInfo("Browser", "Chrome");
	}

	@Override
	public void onTestStart(ITestResult result) {
		String methodName = result.getMethod().getMethodName();
		test = report.createTest(methodName);
	}

	@Override
	public void onTestSuccess(ITestResult result) {
		System.out.println("Yayyy... It got passed...");
		test.log(Status.PASS, "this is passing purpose....");
	}

	@Override
	public void onTestFailure(ITestResult result) {
		System.out.println("Sheyyy.... It got failed....");
		test.log(Status.FAIL, "this is failing purpose....");
	}

	@Override
	public void onTestSkipped(ITestResult result) {
		System.out.println("Skipped...");
		test.log(Status.SKIP, "this is skipping purpose....");
	}

	@Override
	public void onFinish(ISuite suite) {
		report.flush();
	}
}
