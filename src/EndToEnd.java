import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;
import org.testng.Assert;

public class EndToEnd {

	public static void main(String[] args) throws InterruptedException {
		System.setProperty("webdriver.chrome.driver",
				"C:\\Users\\Himanshu\\Downloads\\chromedriver_win32 (1)\\chromedriver.exe");
		WebDriver driver = new ChromeDriver();

		driver.get("https://rahulshettyacademy.com/dropdownsPractise/");
		driver.manage().window().maximize();

		driver.findElement(By.id("ctl00_mainContent_ddl_originStation1_CTXT")).click();
		driver.findElement(By.cssSelector("a[value='DEL']")).click();
		Thread.sleep(2000);
		driver.findElement(By.xpath("//div[contains(@id,'destinationStation')] //a[@value='DED']")).click();
		driver.findElement(By.cssSelector("a[class*='highlight']")).click();

		Boolean opacity = driver.findElement(By.xpath("//div[@id='Div1']")).getAttribute("style").contains("0.5");
		Assert.assertTrue(opacity);

		driver.findElement(By.id("divpaxinfo")).click();
		Thread.sleep(2000);

		int i = 3;
		while (i > 0) {
			driver.findElement(By.id("hrefIncAdt")).click();
			i--;
		}

		WebElement drop = driver.findElement(By.id("ctl00_mainContent_DropDownListCurrency"));

		Select dropdown = new Select(drop);
		dropdown.selectByValue("USD");

		driver.findElement(By.cssSelector("div[id='familyandfriend'] input")).click();
		driver.findElement(By.xpath("//input[@type='submit']")).click();

		driver.close();

	}

}
