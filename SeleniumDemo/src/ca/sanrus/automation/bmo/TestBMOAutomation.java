package ca.sanrus.automation.bmo;

import java.util.List;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.Dimension;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import ca.sanrus.automation.constant.Browser;
import ca.sanrus.automation.utils.WebDriverUtils;
import ca.sanrus.automation.constant.URLConstant;

public class TestBMOAutomation {

	public static void main(String[] args) throws InterruptedException {
		
		WebDriver driver = WebDriverUtils.getWebDriver(Browser.CHROME);
		driver.get(URLConstant.BMO_URL);
		driver.manage().window().maximize();
		String currentURL = driver.getCurrentUrl();
		System.out.println(currentURL);
		
		driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
		WebElement h2Element = driver.findElement(By.className("edb-only-question"));
		System.out.println(h2Element.getText());
		
		Dimension dimension = driver.manage().window().getSize();
		System.out.println(dimension.getHeight());
		
		
		WebElement questionElement = driver.findElement(By.className("questions"));
		Thread.sleep(5000);
		System.out.println(questionElement.getRect().getY());
		
//		Dimension newDimension = new Dimension(1440, 900);
//		driver.manage().window().setSize(newDimension);
//		
//		System.out.println(driver.manage().window().getSize().getHeight());
//		
//		
//		System.out.println(currentURL);
//		List<WebElement> elements = driver.findElements(By.tagName("h2"));
//		WebElement matchedWebElement = null;
//		for (WebElement webElement : elements) {
//			String value = webElement.getAttribute("ng-class");
//			if ("newToBMO ? 'no-padding' : 'edb-only-question'".equals(value)) {
//				matchedWebElement = webElement;
//				break;
//			}
//		}
//		
//		if (matchedWebElement != null) {
//			matchedWebElement.click();
//		}
		
	}

}