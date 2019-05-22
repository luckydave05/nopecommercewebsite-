package com.nopecommerce.demohybrid;

import org.apache.commons.io.FileUtils;
import org.junit.Assert;
import org.openqa.selenium.*;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.interactions.SourceType;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;
import ru.yandex.qatools.ashot.AShot;
import ru.yandex.qatools.ashot.Screenshot;
import ru.yandex.qatools.ashot.shooting.ShootingStrategies;

import javax.imageio.ImageIO;
import java.io.File;
import java.io.IOException;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;

public class Utils extends BasePage
{
    public static void clickelement(By by) {
        driver.findElement(by).click();
    }

// input text

    public static void clickElememet(By by, String text) {
        driver.findElement(by).sendKeys(text);
    }
    //1. Clear Text form inout box/area

    public static void cleartextfrominputbox(By by, String text) {
        driver.findElement(by).clear();
    }

    //Enter text in input field
    public static void enterTextInInputField(By by, String text) {
        driver.findElement(by).sendKeys(text);
    }

    //2 .Clear and enter text in input field

    public static void clearAndentertext(By by, String text) {
        driver.findElement(by).clear();
        driver.findElement(by).sendKeys(text);
    }
    //3. Checking WebElemnt present in DOM

    public static void checkWebelementpresent(By by) {
        try {
            driver.findElement(by);
            System.out.println("Element is present");
        } catch (NoSuchElementException e) {
            System.out.println("Element is not present");
        }

    }

    //4. Checking WebElemnt displayed or not use for assert all the time

    public static boolean webElement(By by) {
//        driver.findElement(by).isDisplayed();
//    }

        try {
            driver.findElement(by).isDisplayed();
            return true;
        } catch ( NoSuchElementException e){
            return false;
        }
    }
    //5.Wait for fixed time given in seconds

    public static void fixedTime(By by, int time) {
        WebDriverWait wait = new WebDriverWait(driver, time);
        wait.until(ExpectedConditions.visibilityOfElementLocated(by));
    }


    //6. Try to click element three times if not available in first go try to use explicite wait
    // how to re try and click


    public static void tryToClickElementThreeTimes(By by) {

        if (driver.findElement(by).isDisplayed()) {

            driver.findElement(by).click();
        } else if (driver.findElement(by).isDisplayed()) {

            driver.findElement(by).click();

        } else if (driver.findElement(by).isDisplayed()) {

            driver.findElement(by).click();
        } else {
            System.out.println("Click Element Is not Available");
        }
    }

    //7.  Wait for locator to be clickable for given time in seconds

    public static void forLocatorToBeClickable(By by, int time) {
        WebDriverWait wait = new WebDriverWait(driver, time);
        wait.until(ExpectedConditions.elementToBeClickable(by));

    }

    //8.  Wait for element to be clickable for given time in seconds
    public static void elementToBeClickable(By by, int time) {
        WebDriverWait wait = new WebDriverWait(driver, time);
        wait.until(ExpectedConditions.elementToBeClickable(by));

    }

    //9.  date stamp short date and time
    public static void dateStempshort() {
        DateFormat dateFormat = new SimpleDateFormat ("mm/dd/yyyyhhmmss");

        Date date = new Date();

        String getCurrentDateTime = dateFormat.format(date);
    }

    //10.  Date stamp Long
    public static void dateStampLong() {

        Date ts = new Date(System.currentTimeMillis());
        Date date = new Date(ts.getTime());
        System.out.println(date);

    }
    //11. Wait for element lockter for given time in second

    public static void waitForElement(By by, int time) {
        WebDriverWait wait = new WebDriverWait(driver, time);
        wait.until(ExpectedConditions.visibilityOfElementLocated(by));

    }

    // 12. select from visible text

    public static void selectFromVisibleText(By by, String text) {
        // WebElement element = driver.findElement(by);
        Select select = new Select (driver.findElement(by));
        select.selectByVisibleText(text);
    }

    // 13. Select from visible number
    public static void selectFromVisibleNumber(By by, int number) {
        Select select = new Select(driver.findElement(by));
        select.selectByIndex(number);
    }

    // 14. Select from value
    public static void selectFromValue(By by, int number) {
        Select select = new Select(driver.findElement(by));
        select.selectByIndex(number);
    }

    //15.  get selected value from dropdown
    public static void getSelectedValuefromDropdown(By by, String name)
    {

        Select select = new Select(driver.findElement(by));
        select.selectByValue(name);

    }

    //16 Scroll to element and click
    public static void scrollToElementAndClick(By by) {
        JavascriptExecutor jse = (JavascriptExecutor)driver;
        jse.executeScript("window.scrollBy(0,250)", "");
        driver.findElement(by).click();
    }

    //17 Wait for alert to display
    public static void waitForAlertToDisplay(int time) {

        try {
            WebDriverWait wait = new WebDriverWait(driver, time);
            wait.until(ExpectedConditions.alertIsPresent());

            Alert alert = driver.switchTo().alert();
            System.out.println("Alert box text " + alert.getText());
            alert.accept();
        }
        catch (NoAlertPresentException noAlert) {
            noAlert.getMessage();
        }

    }
    //18 Get attribute of element
    public  static void GetAttributeOfElement(By by)
    {
        driver.findElement(by).getText ();

    }

    //19 get css property of element
    public static void getCssPropertyofElement(By by,String a)
    {
        driver.findElement(by).getCssValue(a);
    }
    //20 take screenshot of browser
    public static void takeScreenshotOfBrowser()  {
        File scrFile = ((TakesScreenshot)driver).getScreenshotAs(OutputType.FILE);
        try {
            FileUtils.copyFile(scrFile, new File("c:\\tmp\\screenshot.png"));
        }
        catch (IOException e)
        {
            System.out.println(e.getMessage());
        }



    }
    //21 take screenshot of current display(full)
    public static void takeScreenshortofCurrentDisplay()
    {
        Screenshot fpScreenshot = new AShot ().shootingStrategy(ShootingStrategies.viewportPasting(1000)).takeScreenshot(driver);
        try {
            ImageIO.write(fpScreenshot.getImage(),"PNG",new File("D:///FullPageScreenshot.png"));
        } catch (IOException e) {
            e.printStackTrace ( );
        }
        //  Screenshot schreenshot = new AShot().shootingStrategy(ShootingStrategies.viewportPasting(1000)).takeScreenshot(driver);
        //  ImageIO.write(Screenshot.get,"PMG");



    }
    // covert date
//       public static void conertDate()
//       {
//           DateFormat format = new SimpleDateFormat ()
//
//       } common.io depdency  common.io 1.2 maven depenciey
    /* Method for assert

     */

    // Method for assert
    public static void assertUrl(String text)
    {
        Assert.assertTrue (driver.getCurrentUrl ().contains(text));
    }
    // Method for 2 assert
    private static String getTextFromElement(By by)
    {
        return null;
    }
    public static void assertTextMessage(String expected, By by)
    {
        String actual = driver.findElement (by).getText ();
        Assert.assertEquals(expected,actual);
        System.out.println ("Expected result :" +expected );
        System.out.println ("Actual result :" +actual );
    }
    // Reuseable method for Assert equals where we
    public static String textGet(By by)
    {
        return driver.findElement (by).getText ();
    }
    //Method for Hover action

    public static void elementAction (By by,By by1)
    {
        Actions action = new Actions (driver);
        WebElement element = driver.findElement (by);
        action.moveToElement (element).moveToElement (driver.findElement (by1)).click ().build ().perform ();

    }
    // high to low and low to high

    public static void verifyPriceIsAscendingOrDecendingOrder(By by)

    {
        java.util.List<WebElement> price = driver.findElements (by);
        System.out.println (price.size() );
        for ( int i= 0; i < price.size();i = i+1)
        {
            System.out.println (price.get(i).getText () );
        }
    }
    public static void assertUseingSubString(String expected,By by)
    {
        try {
            String actual = driver.findElement (by).getText ().substring (0,1);
            Assert.assertEquals (expected,actual);
            System.out.println ("Expect Vale :"+expected);
            System.out.println ("Actual Vale :"+actual );
        }catch (AssertionError e){
            e.printStackTrace ();
        }

    }
}
