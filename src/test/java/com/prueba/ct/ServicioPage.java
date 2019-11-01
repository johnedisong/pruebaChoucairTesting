package com.prueba.ct;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class ServicioPage extends BasePOM {
	By servicioSearchLocator = By.xpath("//li[@class=\"d-none astm-search-menu is-menu sliding\"]");
	By inputSearchLocator = By.name("s");	

	public ServicioPage(WebDriver driver) {
		super(driver);
		// TODO Auto-generated constructor stub
	}
	
	public String searchCT(String textSearch) {
		click(servicioSearchLocator);
		WebElement searchBox = findElement(inputSearchLocator);
		searchBox.clear();
		searchBox.sendKeys(textSearch);
		searchBox.submit();
		waitSearch();		
		return titleNewPage();
	}
	
	public String[] findlinks(By locator) {
		By linksPage = locator;
		List<WebElement> listLinks = findElements(linksPage);
		String[] linkTexts = new String[listLinks.size()];              
		int i = 0;          
		for (WebElement e : listLinks) {
			linkTexts[i] = e.getText();
			i++;
			}      
		
		return linkTexts;		
	};
	
	

}
