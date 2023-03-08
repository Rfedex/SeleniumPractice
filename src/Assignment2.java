import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;

public class Assignment2 {

	public static void main(String[] args) {
		WebDriver driver = new ChromeDriver();
		
		driver.get("https://rahulshettyacademy.com/angularpractice/");
		
		driver.findElement(By.name("name")).sendKeys("Tina");
		driver.findElement(By.xpath("//label[text()='Email']/following-sibling::input")).sendKeys("tina@hotmail.com");
		driver.findElement(By.cssSelector("input[type='password']")).sendKeys("Tina@123");
		driver.findElement(By.cssSelector("div[class='form-check'] input[type='checkbox']")).click();
		
		WebElement dropdown = driver.findElement(By.id("exampleFormControlSelect1"));
		
		Select drop = new Select(dropdown);
		drop.selectByVisibleText("Female");
		
		driver.findElement(By.id("inlineRadio1")).click();
		driver.findElement(By.name("bday")).sendKeys("23-02-2023");
		
		driver.findElement(By.xpath("//*[@value='Submit']")).click();
		
		String successMessage = driver.findElement(By.cssSelector("div[class*='success']")).getText();
		System.out.println(successMessage);
		

	}

}
