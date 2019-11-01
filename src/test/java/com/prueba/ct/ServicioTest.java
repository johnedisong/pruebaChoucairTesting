package com.prueba.ct;

import static org.junit.Assert.*;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class ServicioTest {
	
	private WebDriver driver;
	String url ="https://www.choucairtesting.com/servicio/";
	ServicioPage servicioPage;

	@Before
	public void setUp() throws Exception {
		servicioPage = new ServicioPage(driver);
		driver = servicioPage.chromeDriverConnection();
		servicioPage.visit(url);
	}

	@After
	public void tearDown() throws Exception {
		driver.quit();
	}

	@Test
	public void searchTest() {
		String busqueda = "Software";
		assertEquals("Resultados de búsqueda para «"+busqueda+"» – Choucair Testing",servicioPage.searchCT(busqueda));
	}
	
	
	@Test
	public void enlacesAnclaTest() {
		By locator = By.className("elementor-animation-grow attachment-full size-full");
		String titlePage = "Servicios – Choucair Testing";
		String[] linkTexts = servicioPage.findlinks(locator);
		for (String t : linkTexts) {
			servicioPage.click(By.linkText(t));
			assertEquals(servicioPage.titleNewPage(), titlePage);			
			servicioPage.navigateBack();
			}
		
	}
	
	@Test
	public void enlacesMenuTest() {
		By locator = By.xpath("//*[contains(@id, 'menu-item')]");		
		String[] linkTexts = servicioPage.findlinks(locator);
		
		for (String t : linkTexts) {
			servicioPage.click(By.linkText(t));
			String titlePage = t+" – Choucair Testing";
			assertEquals(servicioPage.titleNewPage(), titlePage);			
			servicioPage.navigateBack();
			}
	}
	
	
	
	

}
