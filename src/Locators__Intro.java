import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.testng.Assert;

public class Locators__Intro {

	public static void main(String[] args) throws InterruptedException {

		System.setProperty("webdriver.chrome.driver", "C:\\Users\\Himanshu\\Downloads\\chromedriver_win32 (1)\\chromedriver.exe");
		WebDriver driver = new ChromeDriver();
		//WebDriver driver = new EdgeDriver();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));
		
		String name = "rahul";
		String password = getPassword(driver);
		driver.get("https://rahulshettyacademy.com/locatorspractice/");
//		driver.findElement(By.id("inputUsername")).sendKeys("rahul");
//		driver.findElement(By.xpath("//input[@name='inputPassword']")).sendKeys("pass");
//		driver.findElement(By.xpath("//div[@class='checkbox-container']/span[1]/input")).click();
//		driver.findElement(By.cssSelector("button[class*='submit']")).click();
//		System.out.println(driver.findElement(By.xpath("//form[@class='form']/p[@class='error']")).getText());
//		driver.findElement(By.linkText("Forgot your password?")).click();
//		driver.findElement(By.cssSelector("input[type='text']:nth-child(2)")).sendKeys(name);
//		driver.findElement(By.xpath("//form/input[2]")).sendKeys("raul@gmail.com");
//		driver.findElement(By.cssSelector("input[placeholder='Phone Number']")).sendKeys("9854321344");
//		Thread.sleep(1000);
//		driver.findElement(By.xpath("//button[contains(@class,'reset')]")).click();
//		System.out.println(driver.findElement(By.xpath("//form/p[@class='infoMsg']")).getText());
//		driver.findElement(By.xpath("//div[contains(@class,'pwd')]/button[1]")).click();
		driver.findElement(By.id("inputUsername")).sendKeys(name);
		driver.findElement(By.xpath("//input[@name='inputPassword']")).sendKeys(password);
		Thread.sleep(1000);
		driver.findElement(By.xpath("//div[@class='checkbox-container']/span[1]/input")).click();
		driver.findElement(By.cssSelector("button[class*='submit']")).click();
		Thread.sleep(1000);
		String loginText = driver.findElement(By.cssSelector("div[class='login-container'] p")).getText();
		System.out.println(loginText);
		Assert.assertEquals(loginText, "You are successfully logged in.");
		Assert.assertEquals(driver.findElement(By.cssSelector("div h2")).getText(), "Hello "+name+",");
		driver.findElement(By.xpath("//*[text()='Log Out']")).click();
		driver.close();
		
		
		
		

	}
	
	public static String getPassword(WebDriver driver) throws InterruptedException {
		driver.get("https://rahulshettyacademy.com/locatorspractice/");
		driver.findElement(By.linkText("Forgot your password?")).click();
		Thread.sleep(1000);
		driver.findElement(By.xpath("//button[contains(@class,'reset')]")).click();
		String passInfo = driver.findElement(By.xpath("//form/p[@class='infoMsg']")).getText();
		String[] pass = passInfo.split("'");
		String password = pass[1].split("'")[0];
		return password;
		
		
		
	}

}
