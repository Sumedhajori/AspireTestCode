package PageObjects;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class HomePage {
	
	public WebDriver driver;
	
	By inventoryFeature = By.cssSelector("#result_app_1 div");
	By manufacturingFeature = By.cssSelector("#result_app_2 div");
	
	public HomePage(WebDriver driver) {
		this.driver = driver;
	}

	public WebElement getInventoryFeature() {
		return driver.findElement(inventoryFeature);
	}

	public WebElement getManufacturingFeature() {
		return driver.findElement(manufacturingFeature);
	}

}
