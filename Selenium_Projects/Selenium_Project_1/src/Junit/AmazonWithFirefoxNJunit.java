package Junit;

import static org.junit.Assert.*;

import java.sql.Driver;
import java.util.concurrent.TimeUnit;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

public class AmazonWithFirefoxNJunit {
	WebDriver driver = null;
	@Before
	public void setUp() throws Exception {
		System.setProperty("webdriver.gecko.driver", "A:\\New folder\\Selenium\\WebDrivers\\geckodriver.exe");
		driver = new FirefoxDriver();
		driver.manage().timeouts().implicitlyWait(15, TimeUnit.SECONDS);
		driver.navigate().to("http://amazon.com");
		driver.manage().window().maximize();
	}

	@After
	public void tearDown() throws Exception {
		driver.quit();
	}

	@Test
	public void test1() {
		driver.findElement(By.cssSelector("#twotabsearchtextbox")).sendKeys("Laptop", Keys.ENTER);
		System.out.println(driver.getTitle());
	}
	@Test
	public void test2() {
		driver.findElement(By.cssSelector("#twotabsearchtextbox")).sendKeys("book", Keys.ENTER);
	}
}
