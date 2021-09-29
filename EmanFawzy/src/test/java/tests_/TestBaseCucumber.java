package tests_;

import cucumber.api.testng.AbstractTestNGCucumberTests;
import io.cucumber.java.Before;
import io.github.bonigarcia.wdm.WebDriverManager;
import org.apache.commons.io.FileUtils;
import org.openqa.selenium.Dimension;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.ie.InternetExplorerDriver;
import org.testng.ITestResult;
import org.testng.annotations.*;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Arrays;
import java.util.Properties;
import java.util.concurrent.TimeUnit;

public class TestBaseCucumber {

    public static WebDriver driver;
    public static Properties prop;

    static String configpath=System.getProperty("user.dir")+"\\src\\test\\java\\com\\configuration\\config.properties"; // to get path for config properties file


    public TestBaseCucumber() throws IOException {
        prop=new Properties();
        FileInputStream file=new FileInputStream(configpath);
        prop.load(file);
    }

    public static void startdriver()
    {

        if(prop.getProperty("browser").equalsIgnoreCase("chrome"))
        {
            WebDriverManager.chromedriver().setup();
            driver=new ChromeDriver();
        }
        else if (prop.getProperty("browser").equalsIgnoreCase("firefox"))
        {
            WebDriverManager.chromedriver().setup();
            driver=new FirefoxDriver();
        }
        driver.get(prop.getProperty("URL"));
        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
    }

}
