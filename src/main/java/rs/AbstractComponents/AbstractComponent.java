package rs.AbstractComponents;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.WebDriverWait;

public class AbstractComponent {

	WebDriver driver;
	WebDriverWait wait;

	public AbstractComponent(WebDriver driver) {
		this.driver = driver;
	}

	

}
