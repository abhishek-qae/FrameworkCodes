package rs.Pageobjects;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;


public class CardDetailPage {

	WebDriver driver;

	public CardDetailPage(WebDriver driver) {

		this.driver = driver;
		PageFactory.initElements(driver, this);
	}

	@FindBy(xpath = "//ul[contains(@class,'cartWrap')]")
	WebElement allcartproducts;

	public void clickPlaceOrder() throws InterruptedException {
		Actions a = new Actions(driver);

		a.sendKeys(driver.findElement(By.cssSelector("[placeholder='Select Country']")), "india").build().perform();

		Thread.sleep(2000);
		//wait.until(ExpectedConditions.visibilityOfElementLocated(By.cssSelector(".ta-results")));

		driver.findElement(By.xpath("(//button[contains(@class,'ta-item')])[2]")).click();
		a.moveToElement(driver.findElement(By.cssSelector(".action__submit"))).click().build().perform();

	}

}
