package Browsers;
import java.util.concurrent.TimeUnit;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

public class GoogleChrome {

	public static void main(String[] args) {
		System.setProperty("webdriver.chrome.driver", "A:\\New folder\\Mentoring 26th_August\\chromedriver_win32\\chromedriver.exe");
		WebDriver driver = new ChromeDriver();
		driver.manage().timeouts().implicitlyWait(15, TimeUnit.MICROSECONDS);
		driver.navigate().to("http://amazon.com");
		driver.manage().window().maximize();
		driver.findElement(By.cssSelector("#twotabsearchtextbox")).sendKeys("Laptop", Keys.ENTER);
		System.out.println(driver.getTitle());

	}
}
