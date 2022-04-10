package PageObjects;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class ManufacturingOrder {

	public WebDriver driver;
	WebDriverWait wait;
	
	By createManufacturingOrder = By.cssSelector(".btn.btn-primary.o_list_button_add");
	By productNameField = By.xpath("(//input[@class='o_input ui-autocomplete-input'])[1]");
	By productQuantity = By.cssSelector("input[name='product_qty']");
	By confirmButton = By.cssSelector("button[name='action_confirm']");
	By markAsDoneButton = By.xpath("//div[@class='o_statusbar_buttons']/button[4]/span");
	By okButton = By.xpath("//footer[@class='c']/button/span");
	By applyButton = By.xpath("//button[@name='process']");
	By currentState = By.xpath("//div[@name='state']/button[1]");
	
	public ManufacturingOrder(WebDriver driver) {
		this.driver = driver;
	}

	public WebElement getCreateManufacturingOrder() {
		return driver.findElement(createManufacturingOrder);
	}
	
	public WebElement getProductNameField() {
		return driver.findElement(productNameField);
	}
		
	public WebElement getProductQuantityField() {
		return driver.findElement(productQuantity);
	}

	
	public WebElement getConfirmButton() {
		return driver.findElement(confirmButton);
	}
	
	public WebElement getMarkAsDoneButton() {
		return driver.findElement(markAsDoneButton);
	}
	
	public WebElement getOkButton() {
		wait = new WebDriverWait(driver, 20);
		wait.until(ExpectedConditions.visibilityOfElementLocated(okButton));
		return driver.findElement(okButton);
	}
	
	public WebElement getApplyButton() {
		return driver.findElement(applyButton);
	}
	
	public WebElement getCurrentState() {
		return driver.findElement(currentState);
	}
	
}
