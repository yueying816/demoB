package TestModule3;



import org.openqa.selenium.WebDriver;
import org.testng.annotations.Test;

import utils.Browsers;
import utils.BrowsersType;

public class TestMutipleThreads {
	
	WebDriver driver;
	
	@Test
	public void visitJD() {
		Browsers browser = new Browsers(BrowsersType.firefox);
		driver = browser.driver;
		driver.get("http://www.jd.com");
		driver.quit();
		}
	
	@Test
	public void visit51buy() {
		Browsers browser = new Browsers(BrowsersType.chrome);
		driver = browser.driver;
		driver.get("http://www.taobao.com");
		driver.quit();
		}

}

