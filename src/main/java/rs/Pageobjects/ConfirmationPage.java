package rs.Pageobjects;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.testng.Assert;

public class ConfirmationPage {

	WebDriver driver;

	public ConfirmationPage(WebDriver driver) {

		this.driver = driver;
		PageFactory.initElements(driver, this);
	}

	@FindBy(xpath = "//ul[contains(@class,'cartWrap')]")
	WebElement allcartproducts;
	

	public void orderConfirmation() {
		 String confirmMessage =driver.findElement(By.cssSelector(".hero-primary")).getText();
				 Assert.assertTrue(confirmMessage.equalsIgnoreCase("THANKYOU FOR THE ORDER."));
				 System.out.println(confirmMessage); 
		
	}

}
