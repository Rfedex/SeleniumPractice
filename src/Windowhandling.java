import java.util.Iterator;
import java.util.Set;


import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class Windowhandling {

	public static void main(String[] args) {
		
		WebDriver driver = new ChromeDriver();
		driver.get("https://rahulshettyacademy.com/loginpagePractise/");
		
		driver.manage().window().maximize();
		
		driver.findElement(By.linkText("Free Access to InterviewQues/ResumeAssistance/Material")).click();
		
		Set<String> windows = driver.getWindowHandles();
		Iterator<String>it = windows.iterator();
		
		String parentId = it.next();
		String childId = it.next();
		
		driver.switchTo().window(childId);
		
		String text = driver.findElement(By.cssSelector(".im-para.red")).getText().split("at")[1].split("with")[0];
		text = text.trim();
		System.out.println(text);
		
		driver.switchTo().window(parentId);
		
		driver.findElement(By.id("username")).sendKeys(text);

	}

}
