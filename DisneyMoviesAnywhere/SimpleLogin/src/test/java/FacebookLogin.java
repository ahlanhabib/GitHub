import org.openqa.selenium.By;
import org.testng.annotations.Test;

import java.io.IOException;

/**
 * Created by Sharif on 6/22/16.
 */
public class FacebookLogin extends SimpleLoginCore{
    @Test
    public void facebookLogin() throws IOException, InterruptedException {
        navigateToURL("www.facebook.com");
        typeByXpath(".//*[@id='email']", "sharifur.rahman");
        typeByCssThenEnter("#pass", "dont4getFacebooK");
        getScreenshot("facebook login");

        driver.navigate().refresh();
        clickById("userNavigationLabel");
        waitUntilClickAble(By.xpath(".//*[@id='BLUE_BAR_ID_DO_NOT_USE']/div/div/div[1]/div/div/ul/li[19]/a/span/span"));
        clickByXpath(".//*[@id='BLUE_BAR_ID_DO_NOT_USE']/div/div/div[1]/div/div/ul/li[19]/a/span/span");
        //driver.navigate().to("www.google.com");

    }
}
