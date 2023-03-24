import java.time.Duration;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;

public class Calendar {

	public static void main(String[] args) throws InterruptedException {
		
		ChromeOptions co = new ChromeOptions();
		co.addArguments("--remote-allow-origins=*");
		
		WebDriver driver = new ChromeDriver(co);
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));
		
		driver.get("https://www.makemytrip.com/");
		
		//Date should be 25 Dec
		
		driver.findElement(By.cssSelector("label[for='departure'] .lbl_input")).click();
		Thread.sleep(2000L);
		
		//String month = driver.findElement(By.xpath("(//div[@class='DayPicker-Caption'])[1]")).getText();
		
		while(!driver.findElement(By.xpath("(//div[@class='DayPicker-Caption'])[1]")).getText().startsWith("December")) {
			driver.findElement(By.cssSelector("span[aria-label='Next Month']")).click();
		}
		
		List<WebElement> dates = driver.findElements(By.cssSelector(".DayPicker-Day"));
		//System.out.println(dates.size());
		
		for(int i=0;i<dates.size();i++) {
			
			if(dates.get(i).getText().startsWith("25")) {
				dates.get(i).click();
				break;
			}
		}

	}

}
