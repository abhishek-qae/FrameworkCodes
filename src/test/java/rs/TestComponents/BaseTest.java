package rs.TestComponents;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.nio.charset.StandardCharsets;
import java.util.HashMap;
import java.util.List;
import java.util.Properties;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;

import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;

import rs.Pageobjects.LoginPage;

public class BaseTest {

	public WebDriver driver;

	public WebDriver initializeBrowser() throws IOException {

		Properties prop = new Properties();
		FileInputStream fis = new FileInputStream(
				System.getProperty("user.dir") + "\\src\\main\\java\\rs\\resources\\global.properties");
		prop.load(fis);

		String browserName = prop.getProperty("browser");

		if (browserName.equalsIgnoreCase("chrome")) {
			System.setProperty("webdriver.chrome.driver",
					"C:\\Users\\1118a\\automation\\SeleniumFrameworkDesign\\ExeFile\\chromedriver.exe");
			driver = new ChromeDriver();
			driver.manage().window().maximize();
			System.out.println("Chrome launched");

		}

		else if (browserName.equalsIgnoreCase("firefox")) {
			System.setProperty("webdriver.gecko.driver",
					"C:\\Users\\1118a\\automation\\SeleniumFrameworkDesign\\ExeFile\\geckodriver.exe");
			driver = new FirefoxDriver();
			driver.manage().window().maximize();
			System.out.println("Firfox launched");

		}
		return driver;
	}

	@BeforeMethod
	public void LoginApp() throws IOException {

		driver = initializeBrowser();
		LoginPage loginpage = new LoginPage(driver);
		loginpage.goTO();
		loginpage.loginApplication("ashwani7500@yopmail.com", "Ashwani@7");
		System.out.println("Application Login");
	}

	@AfterMethod
	public void CloseApp() {
		driver.close();
		System.out.println("Browser Terminate, Application Close");
	}

	public List<HashMap<String, String>> getJSONDataToMap(String filePath) throws IOException {

		String jsonContent = FileUtils.readFileToString(new File(filePath), StandardCharsets.UTF_8);

		ObjectMapper mapper = new ObjectMapper();
		List<HashMap<String, String>> data = mapper.readValue(jsonContent,
				new TypeReference<List<HashMap<String, String>>>() {
				});
		return data;
	}

	public String getScreenshot(String testCaseName, WebDriver driver) throws IOException {
		TakesScreenshot ts = (TakesScreenshot) driver;
		File source = ts.getScreenshotAs(OutputType.FILE);
		File file = new File(System.getProperty("user.dir") + "//reports//" + testCaseName + ".png");
		FileUtils.copyFile(source, file);
		return System.getProperty("user.dir") + "//reports//" + testCaseName + ".png";

	}

}
