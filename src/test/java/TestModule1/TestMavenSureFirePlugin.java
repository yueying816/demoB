package TestModule1;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import utils.Browsers;
import utils.BrowsersType;

public class TestMavenSureFirePlugin {
	
	WebDriver driver;
	
	@BeforeClass
	public void beforeClass() {
		Browsers browser = new Browsers(BrowsersType.firefox);
		driver = browser.driver;
	}
	
	@Test
	public void start() {
		driver.get("http://www.126.com");
		try {
			Thread.sleep(1000);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		driver.switchTo().frame(driver.findElement(By.xpath("//iframe[@id='x-URS-iframe']")));
		
		driver.findElement(By.xpath("//input[@name='email']")).clear();
		driver.findElement(By.xpath("//input[@name='email']")).sendKeys("yueying816");
		driver.findElement(By.xpath("//input[@name='password']")).sendKeys("602215ly");
		driver.findElement(By.xpath("//a[@id='dologin']"));
	}
	
	@AfterClass
	public void release() {
		driver.quit();
	}

}
