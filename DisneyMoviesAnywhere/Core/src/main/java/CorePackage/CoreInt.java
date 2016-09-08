package CorePackage;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import java.io.IOException;
import java.util.List;

/**
 * Created by Sharif on 6/22/16.
 */
public interface CoreInt {
//Declare the fundamental methods to be implemented on Core Class


    //Drivers & Environment Setup
        public WebDriver getLocalDriver(String os, String browserName);
        public WebDriver getDriver(String os, String browser);
        public WebDriver getSauceLabDriver (String userName, String key, String os, String browserName,
                                           String browserVersion) throws IOException;

    //WebElement Handling
        public void clickByClass(String locator);
        public void clickByXpath(String locator);
        public void clickByCss(String locator);
        public void  typeByCss(String locator, String text);
        public void typeByXPathThenEnter(String locator, String text);
        public void typeByCssThenEnter(String locator, String text);
        public void typeByXpath(String locator, String text);
        public void clickById(String locator);
        public void clickByName(String locator);

    //Keys
        public void clearInputBoxByCss(String locator);
        public void clearInputBoxById(String locator);
        public void clearInputBoxByTag(String locator);
        public void clearInputBoxByXpath(String locator);
        public void clearInputBoxByClass(String locator);

        public void sendKeysByCss(String locator, String text);
        public void sendKeysByXpath(String locator, String text);
        public void sendKeysById(String locator, String text);
        public void sendKeysByName(String locator, String text);
        public void sendKeysByClass(String locator, String text);

        public String getTextByCss(String locator);
        public String getTextByXpath(String locator);
        public String getTextById(String locator);
        public String getTextByName(String locator);
        public WebElement getWebElementByCss(String locator);
        public WebElement getWebElementByXpath(String locator);

    //get WebElements
    public List<WebElement> getWebElements(String locator);
    //get texts
    public List<String> getElementTexts(String locator);

    //Browser Navigation
    public void navigateToURL(String url);
    public void navigateBack();
    public void navigateForward();

    //Synchronization
    public void waitUntilClickAble(By locator);
    public void waitUntilVisible(By locator);
    public void waitUntilSelectable(By locator);

    //Additional
    public void sleep(int sec) throws InterruptedException;
    public void mouseHover(String locator);
    public void hoverToCss(String locator);
    public void hoverToxpath(String locator);
    public void hoverToId(String locator);
    public void getScreenshot(String testName) throws IOException;
    public void iframeHandle(int value);
    public void iframeHandle(WebElement element);
}
