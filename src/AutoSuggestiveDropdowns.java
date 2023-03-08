import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;

public class AutoSuggestiveDropdowns {

	public static void main(String[] args) throws InterruptedException {
		// TODO Auto-generated method stub
		WebDriver driver = new ChromeDriver();
		
		driver.get("https://rahulshettyacademy.com/dropdownsPractise/");
		driver.findElement(By.id("autosuggest")).sendKeys("ind");
		Thread.sleep(2000);
		
		List<WebElement> options = driver.findElements(By.cssSelector("li[class='ui-menu-item'] a"));
		for(WebElement option : options) {
			
			if(option.getText().equalsIgnoreCase("India")) {
				option.click();
				break;
			}
		}
		
//		WebElement dropdownElement = driver.findElement(By.cssSelector("ul[class='ui-autocomplete ui-front ui-menu ui-widget ui-widget-content ui-corner-all']"));
//		
//		Select dropdown = new Select(dropdownElement);
//		dropdown.selectByVisibleText("India");

	}

}
