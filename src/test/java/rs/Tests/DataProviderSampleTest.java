package rs.Tests;

import java.io.IOException;
import java.time.Duration;
import java.util.HashMap;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import rs.Pageobjects.CardDetailPage;
import rs.Pageobjects.CheckoutPage;
import rs.Pageobjects.ConfirmationPage;
import rs.Pageobjects.LoginPage;
import rs.Pageobjects.ProductCatalogue;
import rs.TestComponents.BaseTest;

public class DataProviderSampleTest extends BaseTest {

	WebDriver driver;
	// String productName = "ZARA COAT 3";

	@Test(dataProvider = "getData")
	public void OrderDataProvider(HashMap<String, String> input) throws InterruptedException {

		System.setProperty("webdriver.chrome.driver",
				"C:\\Users\\1118a\\automation\\SeleniumFrameworkDesign\\ExeFile\\chromedriver.exe");
		WebDriver driver = new ChromeDriver();
		driver.manage().window().maximize();

		LoginPage loginpage = new LoginPage(driver);
		loginpage.goTO();
		loginpage.loginApplication(input.get("email"), input.get("password"));

		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(5));
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.cssSelector(".mb-3")));

		ProductCatalogue pc = new ProductCatalogue(driver);
		pc.getProduct(input.get("productname"));

		wait = new WebDriverWait(driver, Duration.ofSeconds(5));

		wait.until(ExpectedConditions.visibilityOfElementLocated(By.cssSelector("#toast-container")));
		wait.until(ExpectedConditions.invisibilityOf(driver.findElement(By.cssSelector(".ng-animating"))));

		pc.clickCart();

		CheckoutPage cp = new CheckoutPage(driver);
		cp.verifyProduct(input.get("productname"));

		Thread.sleep(2000);

		cp.clickCheckout();

		CardDetailPage cd = new CardDetailPage(driver);

		cd.clickPlaceOrder();

		Thread.sleep(2000);

		ConfirmationPage confirmationPage = new ConfirmationPage(driver);
		confirmationPage.orderConfirmation();

		driver.close();

	}

	@DataProvider
	public Object[][] getData() throws IOException {

		List<HashMap<String, String>> data = getJSONDataToMap(
				"C:\\\\Users\\\\1118a\\\\automation\\\\SeleniumFrameworkDesign\\\\src\\\\test\\\\java\\\\rs\\\\data\\\\purchaseorder.json");
		return new Object[][] { { data.get(0) }, { data.get(1) } };

	}
}
