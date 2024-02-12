package Shashi.ExtentReports;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.reporter.ExtentSparkReporter;

public class initialDemo {
	
	ExtentReports extent;
	
	@BeforeTest
	public void config() {
		
		String path=System.getProperty("user.dir")+"/reports/index.html";
		//String path="/Users/shashi/eclipse-workspace/ExtentReports/reports/index.html";
		ExtentSparkReporter reporter=new ExtentSparkReporter(path);
		reporter.config().setReportName("Web Automation Results");
		reporter.config().setDocumentTitle("Test Results");
		
	    extent=new ExtentReports();
		extent.attachReporter(reporter);
		extent.setSystemInfo("Tester", "Shashi");
		
	}
	@Test
	public void initialDemo() {
		
		ExtentTest test=extent.createTest("Initial demo");
		
		System.getProperty("webdriver.chrome.driver","/Users/shashi/Documents/chromedriver-mac-x64/chromedriver");
		WebDriver driver=new ChromeDriver();
		driver.get("https://rahulshettyacademy.com");
		System.out.println(driver.getTitle());
		test.fail("Test failed");
		//driver.close();
		extent.flush();
		
	}

}
