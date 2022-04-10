package com.aspire.testpoject;

import java.io.IOException;
import org.testng.Assert;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

import com.aspire.resources.BaseClass;

import PageObjects.HomePage;
import PageObjects.InventoryOverviewPage;
import PageObjects.LoginPage;
import PageObjects.ManufacturingOrder;
import PageObjects.ProductsPage;

public class TestClass extends BaseClass{
	
	LoginPage loginPage;
	HomePage homePage;
	ProductsPage productsPage;
	InventoryOverviewPage invetoryPage;
	ManufacturingOrder manufacturingOrder;
	
	@BeforeTest
	public void beforeTest() throws IOException {
		driver = initializeDriver();
		String url = prop1.getProperty("url");
		driver.get(url);
		Assert.assertEquals(driver.getTitle(),"Odoo","URL is not working");
	}
	
	@Parameters({"email" , "password"})
	@Test
	public void login(String email, String password) {
		
		loginPage = new LoginPage(driver);
		loginPage.getEmail().sendKeys(email);
		loginPage.getPassword().sendKeys(password);
		loginPage.getLoginButton().click();
	}
	
	
	@Test(dependsOnMethods="login")
	public void createProduct() throws InterruptedException {
		homePage = new HomePage(driver);
		invetoryPage = new InventoryOverviewPage(driver);
		productsPage = new ProductsPage(driver);
		
		homePage.getInventoryFeature().click();
		invetoryPage.getProductsTab().click();
		invetoryPage.getProductsSubTab().click();
		productsPage.getCreateButton().click();
		productsPage.getProductNameField().sendKeys(prop2.getProperty("ProductName"));
		productsPage.getProductsTypeField().selectByVisibleText(prop2.getProperty("ProductType"));
		productsPage.getNotesField().sendKeys(prop2.getProperty("Notes"));
		productsPage.getSaveButton().click();
		productsPage.getUpdateQuantityButton().click();
		productsPage.getCreateQuantityButton().click();
		productsPage.getInventoryQuantityField().clear();
		productsPage.getInventoryQuantityField().sendKeys(prop2.getProperty("InventoryQuantity"));
		productsPage.getSaveQuantityButton().click();
		Assert.assertEquals(productsPage.getInventoryQuantity(), prop2.getProperty("InventoryQuantity"),"Quantity is not updated");
		
	}
	
	@Test(dependsOnMethods="createProduct")
	public void createManufacturingOrder() {
		productsPage = new ProductsPage(driver);
		manufacturingOrder = new ManufacturingOrder(driver);
		homePage = new HomePage(driver);
		
		productsPage.getApplicationMenu().click();
		homePage.getManufacturingFeature().click();
		manufacturingOrder.getCreateManufacturingOrder().click();
		manufacturingOrder.getProductNameField().sendKeys(prop2.getProperty("ProductName"));
		manufacturingOrder.getProductQuantityField().clear();
		manufacturingOrder.getProductQuantityField().sendKeys(prop2.getProperty("InventoryQuantity"));
		manufacturingOrder.getConfirmButton().click();
		manufacturingOrder.getMarkAsDoneButton().click();
		manufacturingOrder.getOkButton().click();
		manufacturingOrder.getApplyButton().click();
		Assert.assertTrue(manufacturingOrder.getCurrentState().getAttribute("title").equals(prop2.getProperty("State")));
	}
	
	@AfterTest
	public void afterTest() {
		driver.close();
	}
	
}
