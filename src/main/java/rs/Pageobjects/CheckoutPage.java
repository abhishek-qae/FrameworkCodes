package rs.Pageobjects;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;


public class CheckoutPage {

	WebDriver driver;

	public CheckoutPage(WebDriver driver) {

		this.driver = driver;
		PageFactory.initElements(driver, this);
	}

	

	@FindBy(xpath = "//ul[contains(@class,'cartWrap')]")
	WebElement allcartproducts;

	
	
	public void verifyProduct(String productname) {
		 List<WebElement> AddedProducts = driver.findElements(By.xpath("//ul[contains(@class,'cartWrap')]"));
		 int AllAddedProducts = AddedProducts.size();
		 for(int i=0; i<AllAddedProducts;i++) {
			 
			WebElement SelectedProducts = AddedProducts.get(i);
			WebElement desiredproduct = SelectedProducts.findElement(By.xpath("//ul[contains(@class,'cartWrap')]//descendant::h3"));
			String selectedProductName = desiredproduct.getText();
			  
			  if(selectedProductName.equalsIgnoreCase(productname)) {
				  //Assert.assertEquals(selectedProductName, productname);
				  System.out.println("Product is Displaying");
			  }
			  
		 }
	}
	
	public void clickCheckout() {
		 Actions a = new Actions(driver);
		 
		 a.moveToElement(driver.findElement(By.xpath( "//button[normalize-space()='Checkout']"))).click().build() .perform();
		
	}



}
