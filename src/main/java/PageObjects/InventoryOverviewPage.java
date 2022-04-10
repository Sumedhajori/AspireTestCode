package PageObjects;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class InventoryOverviewPage {
	
	public WebDriver driver;
	
	By productsTab = By.cssSelector("button[title='Products']");
	By productsSubTab = By.cssSelector("a[data-section='124']");
	
	
	public InventoryOverviewPage(WebDriver driver) {
		this.driver=driver;
	}

	public WebElement getProductsTab() {
		return driver.findElement(productsTab);
	}
	
	public WebElement getProductsSubTab() {
		return driver.findElement(productsSubTab);
	}

}
