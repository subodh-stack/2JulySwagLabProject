package test;

import java.io.IOException;

import org.apache.poi.EncryptedDocumentException;
import org.testng.Assert;
import org.testng.ITestResult;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.Status;

import pojo.Browser;
import pom.SwagLabLoginPage;
import pom.SwagLabProductPage;
import utility.BaseClass;
import utility.Parametrization;
import utility.Reports;

@Listeners(utility.Listeners.class)
public class VerifyAddToCartButton extends BaseClass {

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
	
	@Test
	public void verifyAddToCartButton() throws EncryptedDocumentException, IOException {
		test =reports.createTest("verifyAddToCartButton");
		SwagLabLoginPage swagLabLoginPage = new SwagLabLoginPage(driver);
		swagLabLoginPage.enterUserName(Parametrization.getData("Credentials", 1, 0));
		swagLabLoginPage.enterPassword(Parametrization.getData("Credentials", 1, 1));
		swagLabLoginPage.clickOnLogin();
		SwagLabProductPage swagLabProductPage = new SwagLabProductPage(driver);
		swagLabProductPage.addProductToCart(0);
		Assert.assertTrue(swagLabProductPage.isRemoveButtonDisplayed(0));
	}
	
	@Test
	public void verifyAdddingMultipleProductsToCart() throws EncryptedDocumentException, IOException, InterruptedException {
		test =reports.createTest("verifyAdddingMultipleProductsToCart");
		SwagLabLoginPage swagLabLoginPage = new SwagLabLoginPage(driver);
		swagLabLoginPage.enterUserName(Parametrization.getData("Credentials", 1, 0));
		swagLabLoginPage.enterPassword(Parametrization.getData("Credentials", 1, 1));
		swagLabLoginPage.clickOnLogin();
		SwagLabProductPage swagLabProductPage = new SwagLabProductPage(driver);
		int addToCart =swagLabProductPage.getNumberOfAddToCartButton();
		swagLabProductPage.addMultipleProductToCart(addToCart);
		Assert.assertEquals(swagLabProductPage.getNumberOfRemoveButton(),addToCart );	
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
