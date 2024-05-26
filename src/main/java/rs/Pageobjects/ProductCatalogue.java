package rs.Pageobjects;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import rs.AbstractComponents.AbstractComponent;

public class ProductCatalogue extends AbstractComponent {

	WebDriver driver;

	public ProductCatalogue(WebDriver driver) {

		super(driver);
		this.driver = driver;
		PageFactory.initElements(driver, this);
	}

	@FindBy(xpath = "//div[contains(@class,\\\"mb-3\\\")]/descendant::b")
	WebElement products;

	By findBy = By.cssSelector("#toast-container");

	@FindBy(css = ".ng-animating")
	WebElement elet;

	public void getProduct(String productname) {
		List<WebElement> products = driver.findElements(By.xpath("//div[contains(@class,\"mb-3\")]/descendant::b"));
		int productcount = products.size();
		System.out.println(productcount);
		for (int i = 0; i < productcount; i++) {

			WebElement product = products.get(i);
			String ProductName = product.getText();
			System.out.println(ProductName);

			if (ProductName.equalsIgnoreCase(productname)) {
				product.findElement(By.xpath("//div[contains(@class,\"card-body\")]/descendant::button[2]")).click();
			}

		}
		// return productname;
	}

	public void clickCart() {

		driver.findElement(By.cssSelector("[routerlink*='cart']")).click();
	}

}
