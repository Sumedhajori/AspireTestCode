package PageObjects;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

public class ProductsPage {
	
	public WebDriver driver;
	WebDriverWait wait;
	
	By createButton = By.cssSelector("button[title='Create record']");
	By productNameField = By.xpath("//input[@name='name']");
	By productTypeField = By.xpath("//Select[@name='detailed_type']");
	By notesField = By.cssSelector(".note-editable.odoo-editor-editable p");
	By saveButton = By.cssSelector(".btn.btn-primary.o_form_button_save");
	By updateQuantityButton = By.xpath("//button[@name='action_update_quantity_on_hand']");
	By createQuantityButton = By.xpath("//div[@class='o_list_buttons d-flex']/button[4] ");
	By inventoryQuantityField = By.cssSelector("input[name='inventory_quantity']");
	By saveQuantityButton = By.cssSelector("button[title='Save record']");
	By applicationMenu = By.cssSelector(".fa.o_menu_toggle.fa-th");
	By inventoryQuantity = By.xpath("//span[@name='inventory_quantity']");
	
	
	public ProductsPage(WebDriver driver) {
		this.driver = driver;
	}
	
	

	public WebElement getCreateButton() {
		return driver.findElement(createButton);
	}
	
	public WebElement getProductNameField() {
		return driver.findElement(productNameField);
	}
	
	public Select getProductsTypeField() {
		Select productType = new Select(driver.findElement(productTypeField));
		return productType;
	}
	

	
	public WebElement getNotesField() {
		return driver.findElement(notesField);
	}
	
	public WebElement getSaveButton() {
		return driver.findElement(saveButton);
	}
	
	public WebElement getUpdateQuantityButton() {
		System.out.println(driver.findElement(updateQuantityButton).isEnabled());
		wait = new WebDriverWait(driver, 20);
		wait.until(ExpectedConditions.elementToBeClickable(updateQuantityButton));
		return driver.findElement(updateQuantityButton);
	}
	
	public WebElement getCreateQuantityButton() {
		wait = new WebDriverWait(driver, 20);
		wait.until(ExpectedConditions.visibilityOfElementLocated(createQuantityButton));
		return driver.findElement(createQuantityButton);
	}
	
	
	public WebElement getSaveQuantityButton() {
		return driver.findElement(saveQuantityButton);
	}

	public WebElement getInventoryQuantityField() {
		return driver.findElement(inventoryQuantityField);
	}
	
	public WebElement getApplicationMenu() {
		return driver.findElement(applicationMenu);
	}
	
	public String getInventoryQuantity() {
		return driver.findElement(inventoryQuantity).getText();
	}
	


}
