import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.support.ui.Select;
import org.testng.Assert;

public class Assignment3 {

	public static void main(String[] args) {
		
		//System.setProperty("webdriver.chrome.driver", "C:\\Users\\Himanshu\\Downloads\\chromedriver_win32 (1)\\chromedriver.exe");

		ChromeOptions co = new ChromeOptions();
		co.addArguments("--remote-allow-origins=*");
		
		WebDriver driver = new ChromeDriver(co);

		driver.get("https://rahulshettyacademy.com/AutomationPractice");
		driver.manage().window().maximize();
		
		driver.findElement(By.id("checkBoxOption3")).click();
		String optionSelected = driver.findElement(By.cssSelector("label[for='honda']")).getText().trim();
		System.out.println(optionSelected);
		
		WebElement drodpwonLoc = driver.findElement(By.id("dropdown-class-example"));
		
		Select dropdown = new Select(drodpwonLoc);
		dropdown.selectByVisibleText(optionSelected);
		
		Assert.assertEquals(dropdown.getFirstSelectedOption().getText(), optionSelected);
		
		driver.findElement(By.id("name")).sendKeys(optionSelected);
		driver.findElement(By.id("alertbtn")).click();
		
		String alertMessage = driver.switchTo().alert().getText();
		System.out.println(alertMessage);
		Assert.assertTrue(alertMessage.contains(optionSelected));
		driver.switchTo().alert().accept();
		
		driver.close();
	}

}
