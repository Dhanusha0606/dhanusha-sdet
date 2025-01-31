package SDETSelenium;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.Test;

public class S6_003_DeleteAccount {
	
	@Test
	public void DeleteAccount() throws InterruptedException
	{
		
		ChromeDriver driver=new ChromeDriver();
		driver.get("https://login.salesforce.com/");
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(30));
		driver.manage().window().maximize();
		driver.findElement(By.id("username")).sendKeys("gokul.sekar@testleaf.com");
		driver.findElement(By.id("password")).sendKeys("Leaf$321");
		driver.findElement(By.id("Login")).click();
		Thread.sleep(3000);
		driver.findElement(By.xpath("//button[@title='App Launcher']/div")).click();
		driver.findElement(By.xpath("//button[text()='View All']")).click();
		driver.findElement(By.xpath("//p[text()='Sales']")).click();
		WebElement eleAccounts = driver.findElement(By.xpath("//a[@title='Accounts']"));
		driver.executeScript("arguments[0].click();", eleAccounts);
		driver.findElement(By.xpath("//input[@name='Account-search-input']")).sendKeys("Dhanusha");
		Thread.sleep(3000);
		driver.findElement(By.xpath("//span[text()='Show Actions']/parent::span")).click();
		driver.findElement(By.xpath("//a[@title='Delete']")).click();
		driver.findElement(By.xpath("//button[@title='Delete']")).click();
		String desc=driver.findElement(By.xpath("//div[contains(@id,'toastDescription')]")).getText();
		System.out.println(desc);
		driver.close();
	}

}
