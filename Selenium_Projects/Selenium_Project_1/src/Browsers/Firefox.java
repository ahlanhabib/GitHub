package Browsers;
import java.io.File;
import java.util.concurrent.TimeUnit;

import org.apache.tools.ant.taskdefs.Sleep;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxBinary;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.firefox.FirefoxProfile;

public class Firefox {

	public static void main(String[] args) {
//		File pathToBinary = new File("C:\\Program Files (x86)\\Mozilla Firefox\\firefox.exe");
//		FirefoxBinary ffBinary = new FirefoxBinary(pathToBinary);
//		FirefoxProfile firefoxProfile = new FirefoxProfile(); ffBinary,firefoxProfile
		System.setProperty("webdriver.gecko.driver", "A:\\New folder\\Selenium\\WebDrivers\\geckodriver.exe");
		WebDriver driver = new FirefoxDriver();
		driver.manage().timeouts().implicitlyWait(15, TimeUnit.SECONDS);
		driver.navigate().to("http://amazon.com");
		driver.manage().window().maximize();
		driver.findElement(By.cssSelector("#twotabsearchtextbox")).sendKeys("Laptop", Keys.ENTER);
		System.out.println(driver.getTitle());
	}
}