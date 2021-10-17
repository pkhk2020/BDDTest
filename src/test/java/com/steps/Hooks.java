package com.steps;

import com.utils.Base;
import io.cucumber.java.After;
import io.cucumber.java.Before;
import org.openqa.selenium.remote.RemoteWebDriver;


public class Hooks extends Base {

    /**
     * Annotation implemented before the test
     * @author: Hari
     */
    @Before
    public  void initHooks() throws Exception {
        driver = (RemoteWebDriver) invokeBrowser();
    }

    /**
     * annotation implemented after the test
     * @author: Hari
     */
    @After
    public void TearDown(){
        driver.quit();
    }
}
