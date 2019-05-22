package com.nopecommerce.demohybrid;

import cucumber.api.Scenario;
import cucumber.api.java.After;
import cucumber.api.java.Before;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;

import java.io.File;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.concurrent.TimeUnit;

import static org.apache.commons.io.FileUtils.copyFile;

public class Hooks extends BasePage
{
    BrowserSelector browserSelector = new BrowserSelector ();
    static String timestamp = new SimpleDateFormat ("dd.MM.yy.HH.mm.ss").format (new Date ());

    @Before
    public void setUpBrowser()
    {
        browserSelector.browser ();
        driver.manage ().timeouts ().implicitlyWait (20, TimeUnit.MILLISECONDS);
        driver.manage ().window ().fullscreen ();
        driver.get("https://demo.nopcommerce.com/");
    }

    @After
    public void closeBrowser(Scenario scenario)
    {

        if (scenario.isFailed ()){
            String screenshotName = scenario.getName ().replaceAll ("[.,:;?!]","")+ timestamp + ".png";

            try{

                // THIS TAKE A SCREENSHOT FROM THE DRIVER TO SAVE IT TO THE SPECIFIED LOCATION

                File sourcePath = ((TakesScreenshot)driver).getScreenshotAs (OutputType.FILE);

                // BUILDING UP THE DESTINATION PATH FOR THE SCREENSHOT TO SAVE
                // ALSO MAKE SURE TO CREATE A FOLDER " SCREENSHOTS " WITH IN THE CUCUMBER - REPORT FOLDER

                File destinationPath = new File (System.getProperty ("user.dri")+"/target/cucumber-reports/screenshots/"+screenshotName);

                // COPY TAKEN SCREENSHOT FROM THE SOURCE LOCATION TO DESTINATION LOCATION

                copyFile (sourcePath,destinationPath);

                // ATTACH THE SCREENSHOT TO OUR REPORT

                scenario.embed (((TakesScreenshot)driver).getScreenshotAs (OutputType.BYTES),"image/png");
            }
            catch (IOException e )
            {

            }
        }
        driver.close();
    }

}
