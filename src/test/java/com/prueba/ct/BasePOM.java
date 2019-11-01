package com.prueba.ct;

import java.util.List;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class BasePOM {
	
	private WebDriver driver;
	
	public BasePOM (WebDriver driver) {
		this.driver = driver;		
	}
	
	public WebDriver chromeDriverConnection() {
		System.setProperty("webdriver.chrome.driver", "./src/test/resources/chromedriver/chromedriver.exe");
		driver = new ChromeDriver();
		return driver;
	}
	
	public WebElement findElement(By locator) {		
		return driver.findElement(locator);
	}
	
	public List<WebElement> findElements(By locator){
		return driver.findElements(locator);
	}
	
	public String getText(WebElement element) {
		return element.getText();
	}
	
	public String getText(By locator) {
		return driver.findElement(locator).getText();
	}
	
	public void click(By locator) {
		driver.findElement(locator).click();
	}
	
	public void visit(String url) {
		driver.get(url);
	}
	
	public void waitSearch() {
		driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
	}
	
	public String titleNewPage() {
		return driver.getTitle();
	}
	
	public void navigateBack() {
		driver.navigate().back();
	}
	
	

}
