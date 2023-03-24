import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;

public class Assignment7 {

	public static void main(String[] args) {
		
		ChromeOptions co =new ChromeOptions();
		co.addArguments("--remote-allow-origins=*");
		
		WebDriver driver = new ChromeDriver(co);
		driver.get("https://rahulshettyacademy.com/AutomationPractice/");
		
		JavascriptExecutor js = (JavascriptExecutor)driver;
		js.executeScript("window.scrollBy(0,500)");
		
		int rowsCount = driver.findElements(By.cssSelector("[name='courses'] tr")).size();
		System.out.println(rowsCount);
		
		int columnsCount = driver.findElements(By.cssSelector("[name='courses'] th")).size();
		System.out.println(columnsCount);
		
		List<WebElement> secondRow =driver.findElements(By.cssSelector("[name='courses'] tr:nth-child(3) td"));

		for(WebElement rowData : secondRow) {
			
			System.out.println(rowData.getText());
		}
	}

}
