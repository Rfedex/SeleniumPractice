import java.io.File;
import java.io.IOException;

import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.apache.commons.io.FileUtils;

public class HttpCertification {

	public static void main(String[] args) throws IOException {
		
		ChromeOptions co = new ChromeOptions();
		co.setAcceptInsecureCerts(true);
		co.addArguments("--remote-allow-origins=*"); // connection failed
		
		WebDriver driver = new ChromeDriver(co);
		
		driver.manage().window().maximize();
		driver.manage().deleteAllCookies();
		
		driver.get("https://expired.badssl.com/");
		
		System.out.println(driver.getTitle());
		
		File src = ((TakesScreenshot)driver).getScreenshotAs(OutputType.FILE);
		FileUtils.copyFile(src, new File("C:\\Users\\Himanshu\\Documents\\Selenium_Practice_main\\target\\screenshot.png"));
		
		

	}

}
