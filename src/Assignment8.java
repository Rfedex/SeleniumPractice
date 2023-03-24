import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.interactions.Actions;

public class Assignment8 {

	public static void main(String[] args) throws InterruptedException {
		
		ChromeOptions co =new ChromeOptions();
		co.addArguments("--remote-allow-origins=*");
		
		WebDriver driver = new ChromeDriver(co);
		driver.get("https://rahulshettyacademy.com/AutomationPractice/");
		
		driver.findElement(By.id("autocomplete")).sendKeys("uni");
		Thread.sleep(5000);
		
		List<WebElement> autoDropdown = driver.findElements(By.cssSelector(".ui-menu-item"));
		Actions a = new Actions(driver);
		
		
		for(int i=0;i<autoDropdown.size();i++) {
			
			a.moveToElement(autoDropdown.get(i)).keyDown(Keys.ARROW_DOWN).build().perform();
			if(driver.findElement(By.id("autocomplete")).getAttribute("value").equalsIgnoreCase("United States (USA)")) {
				autoDropdown.get(i).click();
				System.out.println(driver.findElement(By.id("autocomplete")).getAttribute("value"));
				break;
			}
		}
		

	}

}
