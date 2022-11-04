package pom;

import java.util.List;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.Select;

public class SwagLabProductPage {

	@FindBy (xpath = "//button[text()='Add to cart']")private List<WebElement> addToCart;
	@FindBy (xpath = "//button[text()='Remove']") private List<WebElement> remove;
	@FindBy (xpath = "//select[@data-test='product_sort_container']") private WebElement filter;
	@FindBy (xpath = "//div[@id='shopping_cart_container']") private WebElement cart;
	@FindBy (xpath = "//button[@id='react-burger-menu-btn']") private WebElement pageOptions;
	@FindBy (xpath = "//a[@id='inventory_sidebar_link']") private WebElement allItem;
	@FindBy (xpath = "//a[@id='about_sidebar_link']") private WebElement about;
	@FindBy (xpath = "//a[@id='logout_sidebar_link']") private WebElement logout;
	@FindBy (xpath = "//a[@id='reset_sidebar_link']") private WebElement resetAppState;
	@FindBy (xpath = "//a[text()='Twitter']") private WebElement twitter;
	@FindBy (xpath = "//a[text()='Facebook']") private WebElement facebook;
	@FindBy (xpath = "//a[text()='LinkedIn']") private WebElement linkedIn;
	
	public SwagLabProductPage(WebDriver driver) {
		PageFactory.initElements(driver, this);
	}
	
	public void addProductToCart(int product) {
		addToCart.get(product).click();
	}
	
	public void removeProductFromCart(int product) {
		remove.get(product).click();
	}
	
	public void selectFilter(String value) {
		Select select = new Select(filter);
		select.selectByValue(value);
	}
	
	public void clickOnCart() {
		cart.click();
	}
	
	public void clickOnPageOptions() {
		pageOptions.click();
	}
	
	public void clickOnAllItem() {
		allItem.click();
	}
	
	public void clickOnAbour() {
		about.click();
	}
	
	public void clickOnLogout() {
		logout.click();
	}
	
	public void clickOnReset() {
		resetAppState.click();
	}
	
	public void openTwitterPage() {
		twitter.click();
	}
	
	public void openFaceBookPage() {
		facebook.click();
	}
	
	public void openLinkedInPage() {
		linkedIn.click();
	}
	
	public boolean isRemoveButtonDisplayed(int product) {
		return remove.get(product).isDisplayed();
	}
	
	public void addMultipleProductToCart(int size) throws InterruptedException {
		 
		for(int i =addToCart.size()-1; i>=0 ; i--)
		{	
			addToCart.get(i).click();	
		}
	}
	
	public int getNumberOfAddToCartButton() {
		return addToCart.size();
	}
	
	public int getNumberOfRemoveButton() {
		return remove.size();
	}
}
