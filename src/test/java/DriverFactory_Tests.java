import org.junit.Test;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.remote.RemoteWebDriver;

import java.net.MalformedURLException;

import static org.assertj.core.api.Assertions.assertThat;


public class DriverFactory_Tests
{

	@Test
	public void should_have_null_selenium_server_if_not_explicitly_set()
	{
		DriverFactory factory = new DriverFactory();
		assertThat(factory.seleniumServer).isNull();
	}

	@Test
	public void should_have_selenium_server_if_explicitly_set()
	{
		DriverFactory factory = new DriverFactory();
		factory.withSeleniumServer("http://locahost/wd/hub");
		assertThat(factory.seleniumServer).isNotNull();
	}

	@Test
	public void should_have_default_selenium_server_url_be_saucelabs() throws MalformedURLException
	{
		DriverFactory factory = new DriverFactory();
		WebDriver driver = factory.getInstance();

		assertThat(factory.seleniumServer).isEqualTo("https://ondemand.saucelabs.com/wd/hub");
	}

	@Test
	public void should_use_sauceURL_when_using_sauce()
	{

	}
}
