package rs.Tests;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import rs.Pageobjects.CardDetailPage;
import rs.Pageobjects.CheckoutPage;
import rs.Pageobjects.ConfirmationPage;
import rs.Pageobjects.LoginPage;
import rs.Pageobjects.ProductCatalogue;

public class SubmitOrderTest {

	WebDriver driver;

	public static void main(String args[]) throws InterruptedException {
		String productName = "ZARA COAT 3";

		System.setProperty("webdriver.chrome.driver",
				"C:\\Users\\1118a\\automation\\SeleniumFrameworkDesign\\ExeFile\\chromedriver.exe");
		WebDriver driver = new ChromeDriver();
		driver.manage().window().maximize();

		LoginPage loginpage = new LoginPage(driver);
		loginpage.goTO();
		loginpage.loginApplication("ashwani7500@yopmail.com", "Ashwani@7");

		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(5));
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.cssSelector(".mb-3")));

		ProductCatalogue pc = new ProductCatalogue(driver);
		pc.getProduct(productName);

		wait = new WebDriverWait(driver, Duration.ofSeconds(5));

		wait.until(ExpectedConditions.visibilityOfElementLocated(By.cssSelector("#toast-container")));
		wait.until(ExpectedConditions.invisibilityOf(driver.findElement(By.cssSelector(".ng-animating"))));

		pc.clickCart();

		CheckoutPage cp = new CheckoutPage(driver);
		cp.verifyProduct(productName);

		Thread.sleep(2000);

		cp.clickCheckout();

		CardDetailPage cd = new CardDetailPage(driver);
		
		cd.clickPlaceOrder();
		
		Thread.sleep(2000);

		ConfirmationPage confirmationPage = new ConfirmationPage(driver);
		confirmationPage.orderConfirmation();

		driver.close();

	}
	
	
}
