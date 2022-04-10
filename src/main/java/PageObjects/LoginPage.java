package PageObjects;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class LoginPage {

	public WebDriver driver;
	
	By emailField = By.cssSelector("#login");
	By passowordField = By.cssSelector("#password");
	By loginButton = By.cssSelector("button[type='submit']");
	
	public LoginPage(WebDriver driver) {
		
		this.driver=driver;
	}

	public WebElement getEmail() {
		return driver.findElement(emailField);
	}
	
	public WebElement getPassword() {
		return driver.findElement(passowordField);
	}
	
	public WebElement getLoginButton() {
		return driver.findElement(loginButton);
	}
	
}
