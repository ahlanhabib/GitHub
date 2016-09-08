package home.page;

import common.Base;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.testng.annotations.Test;

/**
 * Created by rrt on 8/21/2016.
 */
public class SearchProducts extends Base {

    @Test
    public void searchItems()throws InterruptedException{
        typeByCss("#twotabsearchtextbox", "Laptop");
        sleepFor(3);
    }
}
