package flarekids;

import java.io.File;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.remote.CapabilityType;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.remote.RemoteWebDriver;
import org.openqa.selenium.support.ui.ExpectedCondition;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.Test;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.BeforeSuite;

public class FirstClass {
	WebDriver driver;
	WebDriverWait wait;
  
	@BeforeSuite
  public void setCapabilities() throws MalformedURLException  {
	  
		
	//Setting up the desired capablities
	  File classpathroot = new File(System.getProperty("user.dir"));
	  File appDir= new File(classpathroot,"/app");
	  File app = new File(appDir,"FlareKids.apk");
	  DesiredCapabilities capablities = new DesiredCapabilities();
	  capablities.setCapability("deviceName", "");
	  capablities.setCapability(CapabilityType.BROWSER_NAME, "");
	  capablities.setCapability("platformName", "Android");
//	  	capablities.setCapability("platformName", "iOS");
	  System.out.println(" Hi Hello");
	  capablities.setCapability("platformVersion", "5.1.1");
//	  	System.out.println(" Hi Hello");
	  capablities.setCapability("app", app.getAbsolutePath());
	  System.out.println(" Hi Hello 2");
	  // capablities.setCapability("bundleId","com.codecraft.flaremilenial");
	  // capablities.setCapability("udid","17a95bca61b8c74516df227901f8d474ed58bbd9");
	  capablities.setCapability("appPackage", "com.cox.flarekids");
	  //capablities.setCapability("appPackage", "com.fathom");
	  //capablities.setCapability("appWaitActivity", "SplashActivity");
	  capablities.setCapability("appWaitActivity", "FKOnBoardingActivity");
	  //capablities.setCapability("appWaitActivity", "LoginActivity");
	//  capablities.setCapability("autoLaunch", "true");
	  driver = new RemoteWebDriver(new URL("http://127.0.0.1:4721/wd/hub"), capablities);
	  System.out.println(" Hi Hello3");
	  driver.manage().timeouts().implicitlyWait(60, TimeUnit.SECONDS);  
  }
	
	@Test
	public void login(){
		try{
		wait = new WebDriverWait(driver, 120);
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("bt_signin")));
		 driver.findElement(By.id("bt_signin")).click();
		 wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("et_email_address")));
		  driver.findElement(By.id("et_email_address")).click();
		  driver.findElement(By.id("et_email_address")).sendKeys("chethan@codecraft.co.in");
		  driver.navigate().back();
		  driver.findElement(By.id("et_password")).click();
		  driver.findElement(By.id("et_password")).sendKeys("Qwerty123");
		  driver.navigate().back();
		  driver.findElement(By.id("bt_sign_in")).click();
		  System.out.println(" App has successfully logged in!!");
		  
	}catch(Exception e){
		e.printStackTrace();
	}
		
	}
	
}
