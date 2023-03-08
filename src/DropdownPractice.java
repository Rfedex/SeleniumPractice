import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;
import org.testng.Assert;

public class DropdownPractice {

	public static void main(String[] args) {
		
		System.setProperty("webdriver.chrome.driver", "C:\\Users\\Himanshu\\Downloads\\chromedriver_win32 (1)\\chromedriver.exe");
		WebDriver driver = new ChromeDriver();
		
		driver.get("https://rahulshettyacademy.com/dropdownsPractise/");
		
		driver.findElement(By.cssSelector("input[id$='SeniorCitizenDiscount']")).click();
		Boolean checked = driver.findElement(By.cssSelector("input[id$='SeniorCitizenDiscount']")).isSelected();
		Assert.assertEquals(true, checked);
		System.out.println(driver.findElements(By.cssSelector("[type='checkbox']")).size());
//		WebElement staticDropdown = driver.findElement(By.id("ctl00_mainContent_DropDownListCurrency"));
//		
//		Select dropdown = new Select(staticDropdown);
//		dropdown.selectByIndex(1);
//		System.out.println(dropdown.getFirstSelectedOption().getText());
//		dropdown.selectByVisibleText("AED");
//		System.out.println(dropdown.getFirstSelectedOption().getText());
//		dropdown.selectByValue("USD");
//		System.out.println(dropdown.getFirstSelectedOption().getText());
		
		

	}

}
