package com.qa.pages;

	import org.openqa.selenium.By;
	import org.openqa.selenium.WebDriver;

	public class ProductsPage {

	    private WebDriver driver;

	    private By productsTitle = By.xpath("//div[@class='product_label']");

	    public ProductsPage(WebDriver driver) {
	        this.driver = driver;
	    }

	    public boolean isOnProductsPage() {
	        return driver.findElement(productsTitle).isDisplayed();
	    }
	}


