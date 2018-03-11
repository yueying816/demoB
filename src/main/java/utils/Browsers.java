package utils;

import java.io.File;
import java.io.IOException;
import java.util.Arrays;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.firefox.FirefoxProfile;
import org.openqa.selenium.ie.InternetExplorerDriver;
import org.openqa.selenium.remote.DesiredCapabilities;

public class Browsers {
	public WebDriver driver = null;
	private FirefoxProfile firefoxProfile = null;
	private static DesiredCapabilities caps = null;
	private String projectPath = System.getProperty("user.dir");
	
	public Browsers(BrowsersType browserstype) {
		switch(browserstype) {
		case firefox:
			System.setProperty("webdriver.firefox.bin", "D:/softWare/Mozilla Firefox/firefox.exe");
			
			File firebug = new File(projectPath + "\\tool\\firebug@software.joehewitt.com.xpi");
			File firepath = new File(projectPath + "\\tool\\FireXPath@pierre.tholence.com.xpi");
			
			firefoxProfile = new FirefoxProfile();
			try {
				firefoxProfile.addExtension(firebug);
				firefoxProfile.addExtension(firepath);
				firefoxProfile.setPreference("webdriver.accept.untrusted.certs", "true");
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}

			driver = new FirefoxDriver(firefoxProfile);
			driver.manage().window().maximize();
			break;
		case ie:
			System.setProperty("webdriver.ie.driver", projectPath + "/tool/IEDriverServer.exe");  //����IEDriver·��
			caps = DesiredCapabilities.internetExplorer();
			//caps.setCapability(InternetExplorerDriver.FORCE_CREATE_PROCESS, false);
			caps.setCapability(InternetExplorerDriver.INTRODUCE_FLAKINESS_BY_IGNORING_SECURITY_DOMAINS, true);  //ʵ�ֺ���IE��Protected Mode����
			caps.setCapability(InternetExplorerDriver.IE_SWITCHES, "-private");  //����ΪInPrivate ģʽ����ģʽ�²��Ỻ������
			caps.setCapability("ignoreZoomSetting", true);  //�Ŵ���С����
			driver = new InternetExplorerDriver(caps);  //selenium����IE
			driver.manage().window().maximize();
			break;
		case chrome:
			System.setProperty("webdriver.chrome.driver", projectPath + "/tool/chromedriver.exe"); //����IEDriver·��
			caps = DesiredCapabilities.chrome();
			caps.setCapability("chrome.switche", Arrays.asList("--start-maximized"));  //���browser
			driver = new ChromeDriver(caps);  //selenium����chrome
			driver.manage().window().maximize();
			break;
		}	 	


	}

}
