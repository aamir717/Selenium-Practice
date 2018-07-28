package ca.sanrus.automation;

import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;

import org.openqa.selenium.By;

import org.openqa.selenium.Keys;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.safari.SafariDriver;

import ca.sanrus.automation.constant.Browser;
import ca.sanrus.automation.utils.WebDriverUtils;

public class TestWebAutoamtion {

	public static void main(String[] args) throws InterruptedException {
		
		WebDriver webDriver = WebDriverUtils.getWebDriver(Browser.FIREFOX);
		webDriver.get("https://google.com/");
		WebElement searchText = webDriver.findElement(By.id("lst-ib"));
		
		searchText.sendKeys("munna");
		searchText.submit();
		
		try {
			Thread.sleep(2000);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
		
		byte[] screenshotBytes = ((TakesScreenshot)webDriver).getScreenshotAs(OutputType.BYTES);
		try {
			FileOutputStream fos = new FileOutputStream("screenshot_google_search_results.png");
			fos.write(screenshotBytes);
			fos.flush();
			fos.close();
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
}