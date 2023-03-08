import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;

public class LoopingInDropdown {

	public static void main(String[] args) throws InterruptedException {
		// TODO Auto-generated method stub
		//System.setProperty("webdriver.chrome.driver", "C:\\Users\\Himanshu\\Downloads\\chromedriver_win32 (1)\\chromedriver.exe");
		WebDriver driver = new ChromeDriver();
		
		driver.get("https://rahulshettyacademy.com/dropdownsPractise/");
//		driver.findElement(By.id("divpaxinfo")).click();
//		Thread.sleep(2000);
//		int i=0;
//		while(i<4) {
//			driver.findElement(By.id("hrefIncAdt")).click();
//			i++;
//		}
//		
//		driver.findElement(By.id("btnclosepaxoption")).click();
//		String passenger = driver.findElement(By.id("divpaxinfo")).getText();
//		Assert.assertEquals(passenger, "5 Adult");
//		
//		driver.close();
		//a[@value='BLR']
		
		driver.findElement(By.id("ctl00_mainContent_ddl_originStation1_CTXT")).click();
		driver.findElement(By.xpath("//a[@value='BLR']")).click();
		Thread.sleep(2000);
		//driver.findElement(By.xpath("(//a[@value='MAA'])[2]")).click();
		driver.findElement(By.xpath("//div[@id='glsctl00_mainContent_ddl_destinationStation1_CTNR'] //a[@value='MAA']")).click();
		driver.findElement(By.cssSelector("[class*='highlight']")).click();
		
		//System.out.println(driver.findElement(By.name("ctl00$mainContent$view_date2")).isEnabled());
		System.out.println(driver.findElement(By.id("Div1")).getAttribute("style"));
		Assert.assertFalse(driver.findElement(By.id("Div1")).getAttribute("style").contains("1"));
		driver.findElement(By.id("ctl00_mainContent_rbtnl_Trip_1")).click();
		Assert.assertTrue(driver.findElement(By.id("Div1")).getAttribute("style").contains("1"));
		//System.out.println(driver.findElement(By.name("ctl00$mainContent$view_date2")).isEnabled());
		
		System.out.println(driver.findElement(By.id("Div1")).getAttribute("style"));

	}

}
