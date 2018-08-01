package ca.sanrus.automation.utils;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.safari.SafariDriver;

import ca.sanrus.automation.constant.Browser;

public class WebDriverUtils {
	
	public static WebDriver getWebDriver (Browser browser) {
	
		WebDriver webDriver = null;
		
		if (browser !=null) {
			
			String osName = System.getProperty("os.name").toLowerCase();
			String cpuArchitecture = System.getProperty("os.arch").toLowerCase();
			String driverPath ="drivers/";
			boolean is32Bit = cpuArchitecture.equalsIgnoreCase("x86");
			
			switch(browser) {
				case FIREFOX:
					if(osName.contains("win")) {
						if (is32Bit) {
							driverPath = driverPath + "geckodriver-32bit.exe";
						} else {
							driverPath = driverPath + "geckodriver-64bit.exe";
						}
						
					} else if (osName.contains("mac")) {
						driverPath = driverPath + "geckodriver-macos";
					}
					
					System.setProperty("webdriver.gecko.driver", driverPath);
					
					webDriver = new FirefoxDriver();
					break;
				
				case IE:
					if (osName.contains("mac")) {
						throw new RuntimeException("Internet Explorer cannot be launched in Mac OS");
					}
					break;
					
				case SAFARI:
					if(osName.contains("win")) {
						if (is32Bit) {
							driverPath = driverPath + "Safari";
						} else {
							driverPath = driverPath + "Safari";
						}
						
					} else if (osName.contains("mac")) {
						driverPath = driverPath + "Safaridriver";
					}
					
					System.setProperty("webdriver.Safari.driver", driverPath);
					
					webDriver = new SafariDriver();
					break;
					
				case CHROME:
					if(osName.contains("win")) {
						if (is32Bit) {
							driverPath = driverPath + "chromedriver-32bit.exe";
						} else {
							driverPath = driverPath + "chromedriver-32bit.exe";
						}
						
					} else if (osName.contains("mac")) {
						driverPath = driverPath + "chromedriver";
					}
					
					System.setProperty("webdriver.chrome.driver", driverPath);
					
					webDriver = new ChromeDriver();
					
					break;
						
				}
		}
			
		return webDriver;
	}
}
