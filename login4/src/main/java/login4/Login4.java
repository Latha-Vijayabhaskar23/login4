package login4;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.edge.*;
import org.testng.Assert;

public class Login4 {

	public static void main(String[] args) {

		EdgeOptions options = new EdgeOptions();
		options.addArguments("--remote-allow-origins");

		WebDriver driver = new EdgeDriver(options);

		String url = "https://www.saucedemo.com/";

		driver.get(url);

		driver.manage().window().maximize();
		WebElement username = driver.findElement(By.xpath("//*[@id=\"user-name\"]"));
		WebElement password = driver.findElement(By.xpath("//*[@id=\"password\"]"));
		WebElement login = driver.findElement(By.xpath("//*[@id=\"login-button\"]"));
		username.sendKeys("problem_user");
		password.sendKeys("secret_sauce");
		login.click();

		String title = "Welcome - Saucedemo";

		String actualTitle = driver.getTitle();

		System.out.println("Verifying the page title has started");
		Assert.assertEquals("true", title.equals(actualTitle),("checked"));
		Assert.assertEquals(actualTitle, title, "Page title doesnt match");

		System.out.println("The page title has been successfully verified");

		System.out.println("User logged in successfully");

		driver.close();

		driver.quit();
	}

}
