package com.jiochem.selenium.exam.exam;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.interactions.Actions;

public class ExamApplication {

	public static void main(String[] args) throws InterruptedException {

		WebDriver driver = new ChromeDriver();

		driver.get("https://www.123-stickers.com");

		WebElement searchBox = driver.findElement(By.id("search_query_top"));
		searchBox.sendKeys("toilette");
		searchBox.submit();

		Thread.sleep(2000);

		WebElement thirdResult = driver.findElement(By.xpath("(//div[@class='product-container'])[3]"));
		thirdResult.click();

		Thread.sleep(2000);

		WebElement sizeDropdown = driver.findElement(By.id("attrib-40"));
		Select sizeSelect = new Select(sizeDropdown);
		sizeSelect.selectByVisibleText("40");

		WebElement positionToggle = driver.findElement(By.id("attrib-invert"));
		positionToggle.click();

		WebElement colorDropdown = driver.findElement(By.id("attrib-color"));
		Select colorSelect = new Select(colorDropdown);
		colorSelect.selectByVisibleText("Bleu clair");

		WebElement addToCartButton = driver.findElement(By.name("Submit"));
		addToCartButton.click();

		WebElement closePopupButton = driver.findElement(By.xpath("//span[@title='Close window']"));
		closePopupButton.click();

		WebElement cartIcon = driver.findElement(By.xpath("//b[contains(text(),'Cart')]"));
		Actions actions = new Actions(driver);
		actions.moveToElement(cartIcon).perform();

		WebElement checkoutButton = driver.findElement(By.xpath("//a[@title='Check out']"));
		checkoutButton.click();

		driver.quit();
	}
}
