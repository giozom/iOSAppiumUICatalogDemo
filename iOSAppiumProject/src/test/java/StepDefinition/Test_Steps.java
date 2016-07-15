package StepDefinition;

//import Utility.Log;
import cucumber.api.PendingException;
import cucumber.api.java.en.And;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.When;
import io.appium.java_client.ios.IOSDriver;

import cucumber.api.java.Before;
import cucumber.api.java.After;
//import cucumber.api.java.en.*;
import io.appium.java_client.remote.MobileCapabilityType;
import org.apache.commons.io.FileUtils;
//import org.apache.log4j.xml.DOMConfigurator;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.remote.DesiredCapabilities;

import java.io.File;
import java.io.IOException;
import java.net.URL;
import java.net.MalformedURLException;
import java.util.UUID;
import java.util.concurrent.TimeUnit;



public class Test_Steps {

    //set Global driver object
    IOSDriver driver;


    @Before
    public void setup() throws MalformedURLException {


        DesiredCapabilities capabilities = new DesiredCapabilities();

        capabilities.setCapability("platformName", "iOS");
        capabilities.setCapability("deviceName", "iPhone 6 Plus");
        capabilities.setCapability("platformVersion", "8.4");
        capabilities.setCapability("noReset", false);
        capabilities.setCapability("fullReset", false);
        capabilities.setCapability("showIOSLog", true);
        capabilities.setCapability("orientation", "PORTRAIT");
        capabilities.setCapability(MobileCapabilityType.TAKES_SCREENSHOT, true);


        /**
        * Enable bundleid and udid if running on mobile device
        */
        //capabilities.setCapability("bundleId", "au.com.crownmelbourne.mobilerecruiter");
        //capabilities.setCapability("udid", "cf97ea55a19ccfaeda37f59d9038837a59f46d76");



        //instantiate iOS driver
        driver = new IOSDriver(new URL("http://127.0.0.1:4723/wd/hub"), capabilities);
        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);


    }


    @After
    public void teardown() {

        driver.quit();

    }




    @Given("^the UICatalog app is opened$")
    public void theUICatalogAppIsOpened() throws Throwable {
        driver.findElement(By.xpath("//UIAApplication[1]/UIAWindow[2]/UIANavigationBar[1]/UIAStaticText[1]")).isDisplayed();
        takeScreenshot();

    }


    @When("^I click ActionSheet button$")
        public void clickActionSheetsButton() throws Throwable {
        driver.findElement(By.xpath("//UIAApplication[1]/UIAWindow[2]/UIATableView[1]/UIATableCell[1]")).click();
        driver.manage().timeouts().implicitlyWait(3, TimeUnit.SECONDS);
        driver.findElement(By.xpath("//UIAApplication[1]/UIAWindow[2]/UIANavigationBar[1]/UIAButton[1]")).click();
        driver.manage().timeouts().implicitlyWait(3, TimeUnit.SECONDS);
        takeScreenshot();

    }


    @And("^I click AlertViews button$")
    public void clickAlertViewsButton() throws Throwable{
        driver.findElement(By.xpath("//UIAApplication[1]/UIAWindow[2]/UIATableView[1]/UIATableCell[3]/UIAStaticText[1]")).click();
        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
        driver.findElement(By.xpath("//UIAApplication[1]/UIAWindow[2]/UIATableView[1]/UIATableCell[1]/UIAStaticText[1]")).isDisplayed();
        driver.findElement(By.xpath("//UIAApplication[1]/UIAWindow[2]/UIATableView[1]/UIATableCell[2]/UIAStaticText[1]")).isDisplayed();
        driver.findElement(By.xpath("//UIAApplication[1]/UIAWindow[2]/UIATableView[1]/UIATableCell[3]/UIAStaticText[1]")).isDisplayed();
        driver.findElement(By.xpath("//UIAApplication[1]/UIAWindow[2]/UIATableView[1]/UIATableCell[4]/UIAStaticText[1]")).isDisplayed();
        driver.findElement(By.xpath("//UIAApplication[1]/UIAWindow[2]/UIATableView[1]/UIATableCell[5]/UIAStaticText[1]")).isDisplayed();
        driver.findElement(By.xpath("//UIAApplication[1]/UIAWindow[2]/UIANavigationBar[1]/UIAButton[1]")).click();
        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
        takeScreenshot();
    }


    @And("^I scroll and click TextFields Button$")
    public void scrollAndClickTextFieldsButton() throws Throwable {
        driver.scrollTo("Text Fields").click();
        driver.manage().timeouts().implicitlyWait(5, TimeUnit.SE    CONDS);
        takeScreenshot();
    }


    public void takeScreenshot() {
        try {

            File scrFile = driver.getScreenshotAs(OutputType.FILE);
            String fileName = UUID.randomUUID().toString();
            File targetFile = new File("target/screenshots/" + fileName + ".jpg");
            FileUtils.copyFile(scrFile, targetFile);

            System.out.println(targetFile);
        } catch (IOException e) {

            e.printStackTrace();
        }
    }


}
