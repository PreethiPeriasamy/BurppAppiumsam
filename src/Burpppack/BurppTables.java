package Burpppack;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.List;
import java.util.concurrent.TimeUnit;

	import io.appium.java_client.TouchAction;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.android.AndroidKeyCode;

	import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class BurppTables {
		
		AndroidDriver dr;
		@BeforeClass
		public void SelectTables() throws MalformedURLException, Exception{
			DesiredCapabilities capability = new DesiredCapabilities();
			capability.setCapability("deviceName", "MACHONE");
			capability.setCapability("platformName", "Android");
			capability.setCapability("platformVersion", "4.4.2");
			capability.setCapability("appPackage", "kot.burpp");
			capability.setCapability("appActivity", "kot.burpp.SplashScreenlogin");
			dr = new AndroidDriver(new URL("http://192.168.1.3:4723/wd/hub"),capability);
		}
			
		@BeforeMethod
		public void loginUser(){
				WebDriverWait wait = new WebDriverWait(dr, 40);
				wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("kot.burpp:id/infoip")));
				dr.findElement(By.id("kot.burpp:id/displayname")).sendKeys("staging");
				dr.pressKeyCode(AndroidKeyCode.BACK);
				dr.findElement(By.id("kot.burpp:id/nexttologin")).click();
				wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("kot.burpp:id/loginhelp")));
				dr.findElement(By.id("kot.burpp:id/username")).sendKeys("waiter1@burpp.com");
				dr.findElement(By.id("kot.burpp:id/password")).sendKeys("password");
				dr.findElement(By.id("kot.burpp:id/loginthru")).click();
				wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//android.widget.ImageView[@content-desc='More options']")));
			}
			
		@Test
		public void selectTable() throws Exception{
			//side popup
			WebDriverWait wait = new WebDriverWait(dr, 40);
			dr.findElement(By.xpath("//android.widget.ImageButton[@index='0']")).click();
			TimeUnit.SECONDS.sleep(5);
			dr.findElement(By.xpath("//android.widget.ImageView[@index='0']")).click();
			
			//Refresh select table page
			dr.swipe(411,290,411,900,2000);
			
			//Click Take away
			dr.findElement(By.id("kot.burpp:id/parcelintableview")).click();
			wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//android.widget.ImageButton[@index='0']")));
			dr.pressKeyCode(AndroidKeyCode.BACK);
			wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//android.widget.ImageButton[@index='0']")));
			
			//Click Red table
			dr.findElement(By.xpath("//android.widget.TextView[@text='T1']")).click();
			wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//android.widget.ImageButton[@index='0']")));
			
			//Click blocked table
			dr.findElement(By.xpath("//android.widget.TextView[@text='T12']")).click();
			wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//android.widget.ImageButton[@index='0']")));
			
			//Click Available table
			dr.findElement(By.xpath("//android.widget.TextView[@text='T2']")).click();
			dr.findElement(By.id("kot.burpp:id/currentocc")).sendKeys("2");
			dr.findElement(By.id("android:id/button2")).click();
			
			//Pass pax details
			dr.findElement(By.xpath("//android.widget.TextView[@text='T2']")).click();
			dr.findElement(By.id("kot.burpp:id/currentocc")).sendKeys("4");
			dr.findElement(By.id("android:id/button1")).click();
			wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//android.widget.ImageButton[@index='0']")));
			
			//Click Back button in category page
			dr.findElement(By.xpath("//android.widget.ImageButton[@index='0']")).click();
			wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//android.widget.ImageButton[@index='0']")));
			dr.findElement(By.xpath("//android.widget.TextView[@text='T2']")).click();
			
			//Order a item
			dr.findElement(By.xpath("//android.widget.TextView[@text='Starters1']")).click();
			TimeUnit.SECONDS.sleep(2);
			dr.findElement(By.xpath("//android.widget.TextView[@text='Potato Bites']")).click();
			dr.findElement(By.id("android:id/button1")).click();
			
			//Place a order
			dr.findElement(By.id("kot.burpp:id/pink_icon")).click();
			dr.findElement(By.id("kot.burpp:id/print")).click();
			wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//android.widget.ImageButton[@index='0']")));
			dr.findElement(By.id("kot.burpp:id/printconfirm")).click();
			dr.findElement(By.xpath("//android.widget.TextView[@text='BTprinter8045']")).click();
			wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//android.widget.ImageButton[@index='0']")));
			
			//Bill a order
			dr.findElement(By.xpath("//android.widget.TextView[@text='T2']")).click();
			dr.findElement(By.id("kot.burpp:id/pink_icon")).click();
			dr.findElement(By.id("kot.burpp:id/bill")).click();
			dr.findElement(By.id("android:id/button1")).click();
			dr.findElement(By.id("kot.burpp:id/billconfirm")).click();
			dr.findElement(By.xpath("//android.widget.TextView[@text='BTprinter8045']")).click();
			wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//android.widget.ImageButton[@index='0']")));
			
			//Bill paid and Release a Table
			dr.findElement(By.xpath("//android.widget.TextView[@text='T2']")).click();
			dr.findElement(By.id("kot.burpp:id/billconfirm")).click();
			dr.findElement(By.id("android:id/button1")).click();
			wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//android.widget.ImageButton[@index='0']")));
			
			//Touch action store element
		    //WebElement table = dr.findElement(By.xpath("//android.widget.TextView[@text='T4']"));
		    
			//Split a table
			TouchAction action = new TouchAction(dr);
			dr.findElement(By.xpath("//android.widget.TextView[@text='T2']")).click();
			dr.findElement(By.id("kot.burpp:id/currentocc")).sendKeys("2");
			dr.findElement(By.id("android:id/button1")).click();
			wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//android.widget.ImageButton[@index='0']")));
		    dr.findElement(By.xpath("//android.widget.ImageButton[@index='0']")).click();
		    wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//android.widget.ImageButton[@index='0']")));
			action.longPress(dr.findElement(By.xpath("//android.widget.TextView[@text='T2']"))).perform();
		    dr.findElement(By.id("kot.burpp:id/splittableoption")).click();
		    wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//android.widget.TextView[@text='T2A']")));
		    
		    //Block a table
		    TouchAction action1 = new TouchAction(dr);
		    action1.longPress(dr.findElement(By.xpath("//android.widget.TextView[@text='T11']"))).perform();
		    dr.findElement(By.id("kot.burpp:id/blackoption")).click();
		    wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//android.widget.ImageButton[@index='0']")));
		    
		    //Release a table
		    TouchAction action2 = new TouchAction(dr);
		    action2.longPress(dr.findElement(By.xpath("//android.widget.TextView[@text='T11']"))).perform();
		    dr.findElement(By.id("kot.burpp:id/releaseoption")).click();
		    wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//android.widget.ImageButton[@index='0']")));
		    TimeUnit.SECONDS.sleep(10);
		    
		   /* //Scroll to a table
		    dr.scrollToExact("T20").click();
		    dr.findElement(By.id("android:id/button2")).click();
		    dr.scrollToExact("T1");
		    dr.findElement(By.xpath("//android.widget.ImageView[@index='0']")).click();
		    dr.pressKeyCode(AndroidKeyCode.BACK);
		   */
		    dr.findElement(By.xpath("//android.widget.TextView[@text='T2']")).click();
		    wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//android.widget.ImageButton[@index='0']")));
		    dr.findElement(By.xpath("//android.widget.ImageView[@index='1']")).click();
		    List <WebElement> content = dr.findElements(By.xpath("//android.widget.ListView[@index='0']"));
		    content.get(2).click();
		    dr.findElement(By.id("android:id/button1"));
		    wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//android.widget.ImageButton[@index='0']")));
		    
		    List<WebElement> tables = dr.findElements(By.xpath("//android.widget.LinearLayout/android.view.View/android.widget.GridView/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.widget.TextView[@text]"));
			 int size = 0;
			 size = size+tables.size();
			 
			 for (int i=0;i<size;i++)
			 
			 {
				 System.out.print(i);
				tables.get(i).click();
					  {
			    		checkOk();
			    	}
			 }	
		}
		
		public void checkOk(){
			WebDriverWait wait = new WebDriverWait(dr, 40);
			if (dr.getPageSource().contains("kot.burpp:id/currentocc"))
			{
			dr.findElement(By.id("android:id/button2")).click();
			
			wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//android.widget.ImageButton[@index='0']")));
			}
			else{
				wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//android.widget.ImageButton[@index='0']")));
			}
			}
		
		@AfterMethod
		public void signout(){
			WebDriverWait wait = new WebDriverWait(dr, 40);
		    dr.findElement(By.xpath("//android.widget.ImageButton[@index='0']")).click();
		    dr.findElement(By.id("kot.burpp:id/logoutnav")).click();
		    dr.findElement(By.id("android:id/button1")).click();
		    wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("kot.burpp:id/username")));
		}
		
		@AfterClass
		public void closeApp(){
			dr.navigate().back();
		    dr.navigate().back();
		    dr.findElement(By.id("android:id/button1")).click();
		}
	}


