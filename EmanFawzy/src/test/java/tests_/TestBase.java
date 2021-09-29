package tests_;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.util.Arrays;
import java.util.Properties;
import java.util.concurrent.TimeUnit;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.Dimension;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.ITestResult;
import org.testng.annotations.*;

import static tests_.TestBaseCucumber.configpath;


public class TestBase  {

	public static WebDriver driver;
	public static Properties prop;
	static String chromepath =System.getProperty("user.dir")+"\\drivers\\chromedriver.exe";
	static String firefoxpath =System.getProperty("user.dir")+"\\drivers\\geckodriver.exe";

	public TestBase() throws IOException
	{
		prop=new Properties();
		FileInputStream file=new FileInputStream(configpath);
		prop.load(file);
	}

	@Parameters({"browser"})
	@BeforeSuite
	public void startdriver(@Optional("chrome") String browsername)
	{
		if(browsername.equalsIgnoreCase("chrome"))
		{

			System.setProperty("webdriver.chrome.driver", chromepath); 
			driver=new ChromeDriver();
		}
		else if(browsername.equalsIgnoreCase("firefox"))
		{
			System.setProperty("webdriver.gecko.driver", firefoxpath);
			driver=new FirefoxDriver();
		}


		driver.get(prop.getProperty("URL"));
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		Dimension size = new Dimension(1024,768);
		driver.manage().window().setSize(size);
	}

	@AfterMethod
	public void takeScreenShotOnFailureAndClosebrowser(ITestResult testResult) throws IOException { 
		if (testResult.getStatus() == ITestResult.FAILURE) { 
			File scrFile = ((TakesScreenshot)driver).getScreenshotAs(OutputType.FILE); 
			FileUtils.copyFile(scrFile, new File("errorScreenshots\\" + testResult.getName() + "-"
					+ Arrays.toString(testResult.getParameters()) + ".png"));
		} 
	
	}
	
//	@AfterTest
//	public void teardown()
//{
//		driver.quit();
//
//	}


}
