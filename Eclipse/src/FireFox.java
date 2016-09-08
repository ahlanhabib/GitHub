import java.util.concurrent.TimeUnit;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

public class FireFox {
	public void main (String [] arg){
		System.setProperty("webdriver.gecko.driver", "A:\\New folder\\Selenium\\WebDrivers\\geckodriver.exe");
		WebDriver driver = new FirefoxDriver();
		driver.manage().timeouts().implicitlyWait(15, TimeUnit.MICROSECONDS);
		driver.navigate().to("http://amazon.com");
		driver.manage().window().maximize();
		
	}
}
