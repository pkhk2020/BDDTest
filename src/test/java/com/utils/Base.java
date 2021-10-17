package com.utils;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.remote.RemoteWebDriver;

/**
 * The type Base.
 */
public class Base {

    /**
     * The constant driver.
     */
    public static RemoteWebDriver driver;
    /**
     * The Config.
     */
    public Config config = new Config();
    /**
     * The Browser.
     */
    String browser="";
    /**
     * The Url.
     */
    String url="";
    /**
     * The Driverpath.
     */
    String driverpath ="";

    private void getConfigPropertyValues(){
        try{
            browser=config.getBrowser();
            driverpath=config.getChromeDriver();
            url= config.getURL();
        }
        catch (Exception e){
            System.out.println("values not found");
        }
    }

    /**
     * Invooke Browser implemented before the test
     *
     * @return the web driver
     * @author: Hari
     */
    public WebDriver invokeBrowser()  {
        getConfigPropertyValues();
        switch(browser)
        {
            case "chrome":
                System.setProperty("webdriver.chrome.driver",driverpath);
                ChromeOptions options = new ChromeOptions();
                options.setHeadless(false);
                driver = new ChromeDriver(options);
                driver.manage().deleteAllCookies();
                driver.get(url);
                driver.manage().window().maximize();
                break;
            case "IE":
                //code for IE driver
                break;

        }
        return driver;
    }
}
