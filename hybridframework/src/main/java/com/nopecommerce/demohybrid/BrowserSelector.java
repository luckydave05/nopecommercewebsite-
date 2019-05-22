package com.nopecommerce.demohybrid;

import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.ie.InternetExplorerDriver;
import org.openqa.selenium.ie.InternetExplorerOptions;

public class BrowserSelector extends Utils
{
    LoadProp loadProp = new LoadProp ();

    public void browser()
    {
        String browser = loadProp.getPropety("browser");

        if ( browser.equalsIgnoreCase ("Firefox"))
        {
            System.setProperty ("webdriver.gecko.driver", "src\\test\\Resources\\BrowserDirectory\\geckodriver.exe");
            System.setProperty (FirefoxDriver.SystemProperty.DRIVER_USE_MARIONETTE, "true");
            System.setProperty (FirefoxDriver.SystemProperty.BROWSER_LOGFILE, "/dev/null");
            driver = new FirefoxDriver ( );
            driver.manage ( ).window ( ).fullscreen ( );
        }
        else if (browser.equalsIgnoreCase ("chrome"))
        {
            System.setProperty ("webdriver.chrome.driver", "src\\test\\Resources\\BrowserDirectory\\chromedriver.exe");
            ChromeOptions options = new ChromeOptions ();
            options.addArguments ("disable-infobars");
            options.addArguments ("--disable-extension");
            options.addArguments ("--disable-browser-");
            options.addArguments ("--incongnito");
            options.addArguments ("--disable-blink-feature");
            driver = new ChromeDriver (options);
            driver.manage ().window ().fullscreen ();
        }
        else if (browser.equalsIgnoreCase ("ie")){
            System.setProperty ("webdriver.ie.driver", "src\\test\\Resources\\BrowserDirectory\\IEDriverServer.exe");
            InternetExplorerOptions options = new InternetExplorerOptions ();
            options.setCapability (InternetExplorerDriver.IE_SWITCHES,"=");
            options.setCapability (InternetExplorerDriver.IE_ENSURE_CLEAN_SESSION,"");
            driver = new InternetExplorerDriver (options);
            driver.manage().window ().maximize ();
        }
        else{
            System.out.println ( "Browser Name is Empty or typed wrong :"+"options" );
        }
    }

}
