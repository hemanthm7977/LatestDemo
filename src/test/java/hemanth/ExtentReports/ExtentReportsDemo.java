package hemanth.ExtentReports;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.reporter.ExtentSparkReporter;

public class ExtentReportsDemo {

	ExtentReports extent = new ExtentReports();

	@BeforeTest
	public void config() {

		String pathExtentReport = System.getProperty("user.dir") + "\\reports\\index.html";
		ExtentSparkReporter reporter = new ExtentSparkReporter(pathExtentReport);

		reporter.config().setReportName("Web Automation Results");
		reporter.config().setDocumentTitle("Test Resultss");

		extent.attachReporter(reporter);
		extent.setSystemInfo("Tester", "hemanth M");
		
		System.out.print("This is of Master");
		
		System.out.print("Demo updated from original repo");
		
		System.out.print("Demo updated from original repo - NEW ONE");

	}

	@Test
	public void initialDemo() {
		
		ExtentTest test = extent.createTest("Initial Demo");
		WebDriver driver = new ChromeDriver();
		driver.get("https://rahulshettyacademy.com/");
		System.out.println(driver.getTitle());
		driver.close();
		
		test.fail("Result do not match");
		
		
		extent.flush();
	}

}
