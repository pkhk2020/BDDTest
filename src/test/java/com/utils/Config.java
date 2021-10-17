package com.utils;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.Properties;

public class Config {

    public static String absPAth = (new File("")).getAbsolutePath().toString();
    public String bootstrap = absPAth+"/"+"bootstrap.properties";

    /**
     * Loading properties
     *  @author: Hari
     */
    public String getVal(String fileName,String key) throws Exception {
        Properties properties = new Properties();
        properties.load(new FileReader(fileName));
        String val = properties.getProperty(key);
        if(val == null || val.isEmpty())
            throw  new Exception("No Value present in the file: "+fileName + " for the key: "+key);
        else
            return  val;

    }

    /**
     * Loading URL from Bootstrap file
     * @author: Hari
     */
    public String getURL() throws Exception {
        String URL = getVal(bootstrap,"URL");
        return URL;
    }

    /**
     * Loading Browser from Bootstrap file
     * @author: Hari
     */
    public String getBrowser() throws Exception {
        String Browser = getVal(bootstrap,"browser");
        return Browser;
    }

    /**
     * Loading Driver  from Bootstrap file
     * @author: Hari
     */
    public String getChromeDriver() throws Exception {
        String Driver = getVal(bootstrap,"chrome.driver");
        return Driver;
    }

}
