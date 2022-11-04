package test;

import java.io.IOException;

import org.apache.poi.EncryptedDocumentException;
import org.testng.Assert;
import org.testng.ITestResult;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.Status;

import pojo.Browser;
import pom.SwagLabLoginPage;
import utility.BaseClass;
import utility.Parametrization;
import utility.Reports;

@Listeners(utility.Listeners.class)
public class SwagLabLoginTest extends BaseClass {
	ExtentReports reports;
	ExtentTest test;
	
	@BeforeTest
	public void configureReports() {
		reports =Reports.createReport();
	}

	@BeforeMethod
	public void lunchBrowser() {
		driver =Browser.openChrome();
	}
	
	@DataProvider (name = "LoginData")
	public Object[][] data() throws EncryptedDocumentException, IOException{
		String password=	Parametrization.getData("Credentials", 1, 1);
		return new Object[][] {{Parametrization.getData("Credentials", 1, 0),password},{Parametrization.getData("Credentials", 2, 0),password}};
		}
	
	
	@Test(dataProvider = "LoginData")
	public void swagLabLoginTestWithValidCredentials(String user, String pass) {
		test =reports.createTest("swagLabLoginTestWithValidCredentials");
		SwagLabLoginPage swagLabLoginPage = new SwagLabLoginPage(driver);
		swagLabLoginPage.enterUserName(user);
		swagLabLoginPage.enterPassword(pass);
		swagLabLoginPage.clickOnLogin();
		Assert.assertEquals(driver.getCurrentUrl(), "https://www.saucedemo.com/inventory.html");
	
	}
	
	@AfterMethod
	public void getTestResults(ITestResult result) {
		if(result.getStatus()== ITestResult.SUCCESS)
		{
			test.log(Status.PASS, result.getName());
		}
		else if(result.getStatus()==ITestResult.FAILURE) 
		{
			test.log(Status.FAIL, result.getName());
		}
		else
		{
			test.log(Status.SKIP, result.getName());
		}
	}
	
	@AfterTest
	public void publishResult() {
		reports.flush();
	}
	
	
	
	
	
}
