package rs.Pageobjects;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class LoginPage {

	WebDriver driver;

	public LoginPage(WebDriver driver) {

		this.driver = driver;
		PageFactory.initElements(driver, this);
	}

	// WebElement username = driver.findElement(By.id("userEmail"));

	@FindBy(id = "userEmail")
	WebElement username;

	@FindBy(id = "userPassword")
	WebElement passwordEle;

	@FindBy(id = "login")
	WebElement submit;

	By findBy = By.xpath("//div[contains(@class,'mb-3')]");

	public void loginApplication(String email, String password) {

		username.sendKeys(email);
		passwordEle.sendKeys(password);
		submit.click();
		
	}

	public void goTO() {
		driver.get("https://rahulshettyacademy.com/client");

	}

}
