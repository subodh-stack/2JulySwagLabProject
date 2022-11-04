package pom;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class SwagLabLoginPage {

	@FindBy (xpath = "//input[@id='user-name']") private WebElement userName;
	@FindBy (xpath = "//input[@id='password']") private WebElement password;
	@FindBy (xpath = "//input[@id='login-button']")private WebElement login;
	
	
	public SwagLabLoginPage(WebDriver driver) {
		PageFactory.initElements(driver, this);
	}
	
	public void enterUserName(String name) {
		userName.sendKeys(name);
	}
	
	public void enterPassword(String pass) {
		password.sendKeys(pass);
	}
	
	public void clickOnLogin() {
		login.click();
	}
	
}
