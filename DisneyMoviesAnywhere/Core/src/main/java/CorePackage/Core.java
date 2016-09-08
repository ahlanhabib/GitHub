package CorePackage;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.*;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import java.sql.*;
//import org.openqa.selenium.htmlunit.HtmlUnitDriver;
import org.openqa.selenium.ie.InternetExplorerDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.remote.RemoteWebDriver;
import org.openqa.selenium.safari.SafariDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Parameters;

import java.io.File;
import java.io.IOException;
import java.net.URL;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.concurrent.TimeUnit;
import java.util.logging.Logger;

/**
 * Created by Sharif on 6/22/16.
 */
public class Core implements CoreInt {
    public WebDriver driver = null;
    public Logger log = Logger.getLogger(Core.class.getName());

//Annotations
    @Parameters({"useSauceLab","userName", "key","appUrl","os","browserName","browserVersion"})

    @BeforeMethod
    public void setUp(boolean
                          useSauceLab,String userName,String key,String appUrl, String os,
                  String browserName,String browserVersion) throws IOException {

    if (useSauceLab == true) {
        log.info("Test running on saucelabs");
        getSauceLabDriver(userName, key, os, browserName, browserVersion);
    } else {
        getLocalDriver(os, browserName);

    }

    driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);

        driver.navigate().to(appUrl);
    driver.manage().window().maximize();

}
    @AfterMethod
    public void afterMethod() throws InterruptedException {
        sleep(2);
        log.info("Test quitting");
        driver.quit();
    }

    //Get Local Drivers
    public WebDriver getLocalDriver(String os, String browserName) {
        if(browserName.equalsIgnoreCase("firefox")){
            //FirefoxProfile fp=new FirefoxProfile();
            //fp.setEnableNativeEvents(true);
            driver = new FirefoxDriver();

            // driver = new FirefoxDriver();

        }else if(browserName.equalsIgnoreCase("chrome")){
            if(os.equalsIgnoreCase("windows")){
                System.setProperty("webdriver.chrome.driver","Core\\selenium-browser-driver\\chromedriver.exe");
            }else{
                System.setProperty("webdriver.chrome.driver", "selenium-browser-driver/chromedriver");
            }
            driver = new ChromeDriver();
        }else if(browserName.equalsIgnoreCase("safari")){
            driver = new SafariDriver();
        }else if(browserName.equalsIgnoreCase("ie")){
            System.setProperty("webdriver.ie.driver","Core\\selenium-browser-driver\\IEDriverServer.exe");
            driver = new InternetExplorerDriver();
        }else if(browserName.equalsIgnoreCase("htmlunit")){
            //driver = new HtmlUnitDriver();
        }
        return driver;
    }

    public WebDriver getDriver(String os, String browser) {
        WebDriver driver = null;
        if(browser.equalsIgnoreCase("firefox")){
            driver = new FirefoxDriver();
        }else if(browser.equalsIgnoreCase("chrome")){
            if(os.equalsIgnoreCase("windows")){
                System.setProperty("webdriver.chrome.driver","selenium-browser-driver\\chromedriver.exe");
            }else{
                System.setProperty("webdriver.chrome.driver", "selenium-browser-driver/chromedriver");
            }
            driver = new ChromeDriver();
        }else if(browser.equalsIgnoreCase("safari")){
            driver = new SafariDriver();
        }else if(browser.equalsIgnoreCase("ie")){
            System.setProperty("webdriver.ie.driver","selenium-browser-driver\\IEDriverServer.exe");
            driver = new InternetExplorerDriver();
        }else if(browser.equalsIgnoreCase("htmlunit")){
            //driver = new HtmlUnitDriver();
        }
        return driver;
    }


    //Get SauceLabs Driver
    public WebDriver getSauceLabDriver(String userName, String key, String os, String browserName,
                                       String browserVersion )throws IOException {

        DesiredCapabilities cap = new DesiredCapabilities();
        cap.setCapability("platform", os);
        cap.setBrowserName(browserName);
        cap.setCapability("version", browserVersion);

        driver = new RemoteWebDriver(new URL("http://"+ userName + ":" +  key +
                "@ondemand.saucelabs.com:80/wd/hub"), cap);

        return driver;
    }

    //WebElement Handling
    public void clickByClass(String locator) {
        driver.findElement(By.className(locator)).click();


    }

    public void clickByXpath(String locator) {
        driver.findElement(By.xpath(locator)).click();

    }

    public void clickByCss(String locator) {
        driver.findElement(By.cssSelector(locator)).click();

    }

    public void typeByCss(String locator, String text) {
        driver.findElement(By.cssSelector(locator)).sendKeys(Keys.CLEAR, text);

    }

    public void typeByXPathThenEnter(String locator, String text) {
        driver.findElement(By.xpath(locator)).sendKeys(Keys.CLEAR, text, Keys.ENTER);

    }

    public void typeByCssThenEnter(String locator, String text) {
        driver.findElement(By.cssSelector(locator)).sendKeys(Keys.CLEAR, text, Keys.ENTER);

    }

    public void typeByXpath(String locator, String text) {
        driver.findElement(By.xpath(locator)).sendKeys(Keys.CLEAR, text);

    }

    public void clickById(String locator) {
        driver.findElement(By.id(locator)).click();

    }

    public void clickByName(String locator) {
        driver.findElement(By.name(locator)).click();

    }

    //Keys
    public void clearInputBoxByCss(String locator) {
        driver.findElement(By.cssSelector(locator)).clear();
    }

    public void clearInputBoxById(String locator) {
        driver.findElement(By.id(locator)).clear();
    }

    public void clearInputBoxByTag(String locator) {
        driver.findElement(By.tagName(locator)).clear();
    }

    public void clearInputBoxByXpath(String locator) {
        driver.findElement(By.xpath(locator)).clear();
    }

    public void clearInputBoxByClass(String locator) {
        driver.findElement(By.className(locator)).clear();
    }

    public void sendKeysByCss(String locator, String text) {
        driver.findElement(By.cssSelector(locator)).sendKeys(Keys.CLEAR,text);
    }

    public void sendKeysByXpath(String locator, String text) {
        driver.findElement(By.xpath(locator)).sendKeys(Keys.CLEAR,text);
    }

    public void sendKeysById(String locator, String text) {
        driver.findElement(By.id(locator)).sendKeys(Keys.CLEAR, text);
    }

    public void sendKeysByName(String locator, String text) {
        driver.findElement(By.name(locator)).sendKeys(Keys.CLEAR, text);
    }

    public void sendKeysByClass(String locator, String text) {
        driver.findElement(By.className(locator)).sendKeys(Keys.CLEAR, text);
    }


    //Get Text
    public java.lang.String getTextByCss(String locator){
        java.lang.String st = driver.findElement(By.cssSelector(locator)).getText();

        return st;
    }
    public java.lang.String getTextByXpath(String locator){
        java.lang.String st = driver.findElement(By.xpath(locator)).getText();

        return st;
    }
    public java.lang.String getTextById(String locator){
        java.lang.String st = driver.findElement(By.id(locator)).getText();

        return st;
    }
    public java.lang.String getTextByName(String locator){
        java.lang.String st = driver.findElement(By.name(locator)).getText();

        return st;
    }
    public WebElement getWebElementByCss(String locator){
        WebElement element = driver.findElement(By.cssSelector(locator));

        return element;
    }
    public WebElement getWebElementByXpath(String locator){
        WebElement element = driver.findElement(By.xpath(locator));

        return element;
    }

    //Get WebElements
    public List<WebElement> getWebElements(String locator){
        List<WebElement> elements = driver.findElements(By.cssSelector(locator));
        return elements;
    }
    //get texts
    public List<String> getElementTexts(String  locator){
        List<String> texts = new ArrayList<String>();
        List<WebElement> element = new ArrayList<WebElement>();
        element = getWebElements(locator);
        for(WebElement st:element){
            texts.add(st.getText());
        }
        return texts;
    }


    //Browser Navigation
    public void navigateToURL(String url) {
    driver.navigate().to(url);
    }

    public void navigateBack() {
        driver.navigate().back();
    }

    public void navigateForward() {
        driver.navigate().forward();
    }



    //Synchronization
    public void waitUntilClickAble(By locator){
        WebDriverWait wait = new WebDriverWait(driver, 10);
        WebElement element = wait.until(ExpectedConditions.elementToBeClickable(locator));
    }
    public void waitUntilVisible(By locator){
        WebDriverWait wait = new WebDriverWait(driver, 10);
        WebElement element = wait.until(ExpectedConditions.visibilityOfElementLocated(locator));
    }
    public void waitUntilSelectable(By locator){
        WebDriverWait wait = new WebDriverWait(driver, 10);
        boolean element = wait.until(ExpectedConditions.elementToBeSelected(locator));
    }

    //Sleep
    public void sleep(int sec) throws InterruptedException{
        Thread.sleep(sec*1000);

    }



    //MouseHover
    public void mouseHover(String locator) {
        WebElement element= driver.findElement(By.cssSelector(locator));
        Actions action = new Actions(driver);
        Actions hover= action.moveToElement(element);
    }

    public void hoverToCss(String locator) {
        Actions action= new Actions(driver);
        action.moveToElement(driver.findElement(By.cssSelector(locator))).build().perform();

    }

    public void hoverToxpath(String locator) {
        Actions action= new Actions(driver);
        action.moveToElement(driver.findElement(By.xpath(locator))).build().perform();

    }

    public void hoverToId(String locator) {
        Actions action= new Actions(driver);
        action.moveToElement(driver.findElement(By.id(locator))).build().perform();
    }


    //Take Screenshot
    public void getScreenshot(String testName) throws IOException {
        File scrFile = ((TakesScreenshot)driver).getScreenshotAs(OutputType.FILE);
        DateFormat dateFormat = new SimpleDateFormat("yy-mm-dd HH-mm-ss");
        Date date = new Date();
        FileUtils.copyFile(scrFile, new File("TestoutputData/Screenshots/" + testName + "_" + dateFormat.format(date) + ".png"));
    }


    //iFrame Handling
    public void iframeHandle(int fvalue){
        driver.switchTo().frame(fvalue);
    }
    public void iframeHandle(WebElement element){
        driver.switchTo().frame(element);
    }


    //Addition Methods Created other than the Core Interface

}
