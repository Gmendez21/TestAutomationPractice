package AppHooks;

import java.io.IOException;
import java.util.Properties;

import org.apache.commons.lang3.StringUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;

import com.qa.factory.DriverFactory;
import com.qa.util.ConfigReader;

import io.cucumber.java.After;
import io.cucumber.java.Before;
import io.cucumber.java.Scenario;

public class ApplicationHooks {

	private DriverFactory driverFactory;
	private WebDriver driver;
	Properties configProperties;

	@Before(order = 0)
	public void getProperty() {

		configProperties = ConfigReader.loadConfigProperties();
	}

	@Before(order = 1)
	public void launchBrowser() {

		String browserName = StringUtils.firstNonBlank(System.getenv("tf_browser"),
				configProperties.getProperty("browser"));
		String driverPath = StringUtils.firstNonBlank(System.getenv("tf_driver_path"),
				configProperties.getProperty("driverPath"));
		driverFactory = new DriverFactory();
		driver = driverFactory.initDriver(browserName, driverPath);

	}

	@After(order = 0)
	public void quitBrowser() {

		driver.quit();

	}

	@After(order = 1)
	public void tearDown(Scenario scenario) throws IOException {

		if (scenario.isFailed()) {
			// take screenshot
			String screenshotName = scenario.getName().replace(" ", "_");
			byte[] sourcePath = ((TakesScreenshot) driver).getScreenshotAs(OutputType.BYTES);
			scenario.attach(sourcePath, "image/png", screenshotName);

		}
	}

	@After(order = 2)
	public void takeScreenshotAfter(Scenario scenario) {

		String screenshotName = scenario.getName().replace(" ", "_");
		byte[] sourcePath = ((TakesScreenshot) driver).getScreenshotAs(OutputType.BYTES);
		scenario.attach(sourcePath, "image/png", screenshotName);

	}
}
