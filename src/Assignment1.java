import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;

public class Assignment1 {

	public static void main(String[] args) {
		
		System.setProperty("webdriver.chrome.driver", "C:\\Users\\Himanshu\\Downloads\\chromedriver_win32 (1)\\chromedriver.exe");
		WebDriver driver = new ChromeDriver();
		
		driver.get("https://rahulshettyacademy.com/AutomationPractice/");
		driver.manage().window().maximize();
		
		List<WebElement> checkbox = driver.findElements(By.xpath("//input[@type='checkbox']"));
		
		WebElement firstCheckbox = driver.findElement(By.xpath("//div[contains(@id,'checkbox')] //input[@value='option1']"));
		firstCheckbox.click();
		Assert.assertTrue(firstCheckbox.isSelected());
		firstCheckbox.click();
		Assert.assertFalse(firstCheckbox.isSelected());
		
		
		Assert.assertEquals(checkbox.size(), 3);
		
		driver.close();
	}

}
