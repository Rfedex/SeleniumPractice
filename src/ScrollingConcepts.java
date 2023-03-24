import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.testng.Assert;

public class ScrollingConcepts {

	public static void main(String[] args) throws InterruptedException {
		
		ChromeOptions co =new ChromeOptions();
		co.addArguments("--remote-allow-origins=*");
		
		WebDriver driver = new ChromeDriver(co);
		driver.get("https://rahulshettyacademy.com/AutomationPractice/");
		
		JavascriptExecutor js = (JavascriptExecutor)driver;
		js.executeScript("window.scrollBy(0,500)");
		
		Thread.sleep(2000);
		
		js.executeScript("document.querySelector('.tableFixHead').scrollTop=500");
		
		List<WebElement> amounts = driver.findElements(By.cssSelector(".tableFixHead td:nth-child(4)"));
		
		int sum =0;
		for(int i=0;i<amounts.size();i++) {
			
			String amount = amounts.get(i).getText();
			int am = Integer.parseInt(amount);
			sum+=am;
			
		}
		
		System.out.println(sum);
		String amountFromUi =driver.findElement(By.cssSelector(".totalAmount")).getText().split(": ")[1];
		String calculatedAmount = String.valueOf(sum);
		//Assert.assertTrue(driver.findElement(By.cssSelector(".totalAmount")).getText().contains(""+sum));

		Assert.assertEquals(amountFromUi, calculatedAmount);
	}

}
