package search;

import common.Base;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.testng.annotations.Test;

import java.util.ArrayList;
import java.util.List;

import static javafx.application.Platform.exit;

/**
 * Created by rrt on 8/21/2016.
 */
public class SearchContent extends Base {
   List<String> urlLinks = new ArrayList<String>();
    @Test
    public void searchNews()throws InterruptedException {
        typeByCssNEnter("#newSearchQueryTop", "Olympic");
        sleepFor(2);
        grabList(".columnGroup #searchResults .searchResultsList li");
        clickByCss(".stepToPage.next");
        grabList(".columnGroup #searchResults .searchResultsList li");
}

    public void grabList(String locator1)throws InterruptedException{
        if(urlLinks.size()<=15) {
                int newLimit = 15 - urlLinks.size();
                List<WebElement> links = getListOfWebElementsByCss(locator1);
                for (int i = 2; i < links.size(); i++) {
                    if(urlLinks.size()<15) {
                        clickByXpath(".//*[@id='searchResults']/ol/li[" + i + "]/div[2]/h3/a");
                        String currenturl = getCurrentPageUrl();
                        System.out.println(currenturl);
                        urlLinks.add(currenturl);
                        sleepFor(1);
                        navigateBack();
                        sleepFor(1);
                    }  else{
                        System.out.println("We got 15 urls");
                    }
                }
        }
    }
}
