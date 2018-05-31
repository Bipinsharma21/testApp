
package TesterApp;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.List;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.remote.RemoteWebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

public class TestAlertMessages {
       RemoteWebDriver driver;
         
       @BeforeClass
       public void setUP() throws MalformedURLException{
       
       DesiredCapabilities cap= new DesiredCapabilities();
       
       cap.setCapability("Version", "6.0.1");
       cap.setCapability("deviceName", "MotoG3");
       cap.setCapability("platformName", "Android");
       cap.setCapability("appPackage", "com.testerapp");
       cap.setCapability("appActivity", "com.testerapp.MainActivity");
       
       driver = new RemoteWebDriver(new URL("http://127.0.0.1:4723/wd/hub"),cap);
       driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
       }
       
       @Test
       public void TestAlert() 
       {
              List <WebElement> Buttons=driver.findElementsByXPath("//android.widget.TextView") ;
              
              System.out.println("Number of Buttons are " + Buttons.size());
              
              for(int i=0; i<Buttons.size();i++)
              {
                     
              Buttons.get(i).click();
              
              WebDriverWait wait = new WebDriverWait(driver, 3);
              
              wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("android:id/button1")));
              
              String Message= driver.findElementById("android:id/message").getText();
              
              System.out.println("BUTTON" +(i+1) +" is clicked: " +Message);
              
              driver.findElementById("android:id/button1").click();
              
              }
       }
       
       @AfterClass   
       public void TestOver()
       {
              driver.quit();
              System.out.println("Test is Over.");
       }
       
       }
