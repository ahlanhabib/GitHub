package Junit;

import static org.junit.Assert.*;

import java.util.concurrent.TimeUnit;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class Amazon {

WebDriver driver = null;

	@Before
	public void setUp() throws Exception {
		System.setProperty("webdriver.chrome.driver", "A:\\New folder\\Mentoring 26th_August\\Browsers\\chromedriver.exe");
		driver = new ChromeDriver();
		driver.manage().timeouts().implicitlyWait(15, TimeUnit.MICROSECONDS);
		driver.navigate().to("http://amazon.com");
		driver.manage().window().maximize();
	}

	@After
	public void tearDown() throws Exception {
		driver.quit();
		
	}

	@Test
	public void test() {
		driver.findElement(By.cssSelector("#twotabsearchtextbox")).sendKeys("Books", Keys.ENTER);
		System.out.println(driver.getTitle());
	}

}
