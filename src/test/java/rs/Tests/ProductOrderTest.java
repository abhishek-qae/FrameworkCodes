package rs.Tests;

import java.io.IOException;
import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.Test;

import rs.Pageobjects.CardDetailPage;
import rs.Pageobjects.CheckoutPage;
import rs.Pageobjects.ConfirmationPage;
import rs.Pageobjects.ProductCatalogue;
import rs.TestComponents.BaseTest;

public class ProductOrderTest extends BaseTest {

	WebDriver driver;

	@Test
	public void OrderProduct() throws InterruptedException, IOException {

		String productName = "ZARA COAT 3";

		WebDriverWait wait = new WebDriverWait(super.driver, Duration.ofSeconds(5));
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.cssSelector(".mb-3")));

		ProductCatalogue pc = new ProductCatalogue(super.driver);
		pc.getProduct(productName);

		wait = new WebDriverWait(super.driver, Duration.ofSeconds(5));

		wait.until(ExpectedConditions.visibilityOfElementLocated(By.cssSelector("#toast-container")));
		wait.until(ExpectedConditions.invisibilityOf(super.driver.findElement(By.cssSelector(".ng-animating"))));

		pc.clickCart();

		CheckoutPage cp = new CheckoutPage(super.driver);
		cp.verifyProduct(productName);

		Thread.sleep(2000);

		cp.clickCheckout();

		CardDetailPage cd = new CardDetailPage(super.driver);

		cd.clickPlaceOrder();

		Thread.sleep(2000);

		ConfirmationPage confirmationPage = new ConfirmationPage(super.driver);
		confirmationPage.orderConfirmation();

	}
	
	
}
