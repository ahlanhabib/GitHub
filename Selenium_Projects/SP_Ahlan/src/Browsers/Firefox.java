package Browsers;

import java.util.concurrent.TimeUnit;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

public class Firefox {

	public static void main(String[] args) {
	System.setProperty("webdriver.gecko.driver", "A:\\New folder\\Mentoring 26th_August\\Browsers\\geckodriver.exe");
		
		WebDriver driver = new FirefoxDriver();
		driver.manage().timeouts().implicitlyWait(15, TimeUnit.MICROSECONDS);
		driver.navigate().to("http://amazon.com");
		driver.manage().window().maximize();

	}
}
