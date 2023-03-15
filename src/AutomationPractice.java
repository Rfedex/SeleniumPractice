import java.time.Duration;
import java.util.Iterator;
import java.util.List;
import java.util.Set;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class AutomationPractice {

	public static void main(String[] args) throws InterruptedException {

		//System.setProperty("webdriver.chrome.driver", "C:\\Users\\Himanshu\\Downloads\\chromedriver_win32 (1)\\chromedriver.exe");
		
		ChromeOptions co = new ChromeOptions();
		co.addArguments("--remote-allow-origins=*");
		
		WebDriver driver = new ChromeDriver(co);
		
		driver.get("https://rahulshettyacademy.com/AutomationPractice");
		
		int totalLinks =driver.findElements(By.tagName("a")).size();
		System.out.println(totalLinks);
		
		WebElement footerElement =  driver.findElement(By.cssSelector("[id$='gf-BIG']"));
		
		int footerLinks =  footerElement.findElements(By.tagName("a")).size();
		System.out.println(footerLinks);
		
		WebElement firstTableLink = footerElement.findElement(By.xpath("//table[@class='gf-t']//td[1]"));
		int footerFirstTableLinks =  firstTableLink.findElements(By.tagName("a")).size();
		System.out.println(footerFirstTableLinks);
		
		
		 List<WebElement> elements = firstTableLink.findElements(By.tagName("a"));
		 Actions a = new Actions(driver);
		
		 
		 for(int i=1;i<elements.size();i++) {
			 
			// a.moveToElement(elements.get(i)).keyDown(Keys.CONTROL).click().build().perform();
			 String controlClick = Keys.chord(Keys.CONTROL,Keys.ENTER);
			 elements.get(i).sendKeys(controlClick);
			 Thread.sleep(5000L);
		 }
		 
		 Set<String> windows = driver.getWindowHandles();
		 Iterator<String>it = windows.iterator();
		 
		 while(it.hasNext()) {
			 driver.switchTo().window(it.next());
			 System.out.println(driver.getTitle());
	 }
	

	}

}
