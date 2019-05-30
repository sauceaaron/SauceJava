import org.junit.Rule;
import org.junit.Test;
import org.junit.rules.TestName;
import org.openqa.selenium.WebDriver;

import java.net.MalformedURLException;

public class TestWithDriverFactory
{
	@Rule
	public TestName testName = new TestName();

	@Test
	public void openSauceDemo() throws MalformedURLException
	{
		WebDriver driver = new DriverFactory().getInstance();
		driver.get("http://saucedemo.com");
		driver.quit();
	}

	@Test
	public void openSauceDemoInChromeOnMac() throws MalformedURLException
	{
		WebDriver driver = new DriverFactory().withChrome().withPlatform("MacOS 10.13").withTestName(testName.getMethodName()).getInstance();
		driver.get("http://saucedemo.com");
		driver.quit();
	}
}
