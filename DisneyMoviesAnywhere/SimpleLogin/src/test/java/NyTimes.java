import org.testng.annotations.Test;

/**
 * Created by PlayBoy on 6/22/16.
 */
public class NyTimes extends SimpleLoginCore{
    @Test
    public void nyTimes() throws InterruptedException {
        navigateToURL("http://www.nytimes.com/");
        for (int i=3; i<=25; i++){
            clickByXpath(".//*[@id='mini-navigation']/ul/li["+i+"]/a");
            sleep(3);
            //driver.getCurrentUrl();
            navigateBack();

        }
    }
}
