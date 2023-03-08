import java.util.Arrays;
import java.util.List;
import java.util.concurrent.TimeUnit;
import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class Genericmultipledatasets {

	public static void main(String[] args) throws InterruptedException {
		String[] productList = { "Cucumber", "Cauliflower" };
		List<String> prodList = Arrays.asList(productList);
		WebDriver driver = new ChromeDriver();
		
		//driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));
		WebDriverWait w = new WebDriverWait(driver , Duration.ofSeconds(5));

		driver.get("https://rahulshettyacademy.com/seleniumPractise/");
		
		addItemsToCart(driver,prodList);
		
		driver.findElement(By.xpath("//img[@alt='Cart']")).click();
		driver.findElement(By.xpath("//button[contains(.,'PROCEED TO CHECKOUT')]")).click();
		
		w.until(ExpectedConditions.visibilityOfElementLocated(By.cssSelector("input.promoCode")));
		
		driver.findElement(By.cssSelector("input.promoCode")).sendKeys("rahulshettyacademy");
		driver.findElement(By.cssSelector("button.promoBtn")).click();
		
		w.until(ExpectedConditions.visibilityOfElementLocated(By.cssSelector("span.promoInfo")));
		
		System.out.println(driver.findElement(By.cssSelector("span.promoInfo")).getText());

		// driver.findElement(By.xpath("//h4[contains(text(),'Cucumber')]/following-sibling::div[2]/button")).click();

		

	}
	
	public static void addItemsToCart(WebDriver driver , List<String> prodList) {
		List<WebElement> products = driver.findElements(By.cssSelector("h4.product-name"));

		System.out.println(products.size());

		int index = 0;

		for (int i = 0; i < products.size(); i++) {
			String productName = products.get(i).getText();
			productName = productName.split(" ")[0];
			System.out.println(productName);
			if (prodList.contains(productName)) {
				WebElement element = driver
						.findElements(By.xpath(
								"//h4[@class='product-name']/following-sibling::div[@class='product-action']/button"))
						.get(i);
				element.click();
				index++;
				if (index == prodList.size()) {
					break;
				}

			}
		}

	}

}
