package task10;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import io.github.bonigarcia.wdm.WebDriverManager;

public class WebComponenet_Q3 {

	public static void main(String[] args) {

		WebDriverManager.chromedriver().setup();
		WebDriver driver = new ChromeDriver();
		driver.get("https://www.guvi.in/");
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(3));

		driver.findElement(By.xpath("//a[text()='Sign up']")).click();

		driver.findElement(By.id("name")).sendKeys("rameshwar");
		driver.findElement(By.id("email")).sendKeys("mitkarir.1@gmail.com");
		driver.findElement(By.id("password")).sendKeys("Ram@1234");

		driver.findElement(By.id("mobileNumber")).sendKeys("9404360846");
		driver.findElement(By.xpath("//a[@id='signup-btn']")).click();

		driver.findElement(By.xpath("//a[text()='May be later']")).click();
		driver.findElement(By.id("login-btn")).click();

		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));

		driver.findElement(By.xpath("//input[@id='email']")).sendKeys("mitkarir.1@gmail.com");
		driver.findElement(By.id("password")).sendKeys("Ram@1234");
		driver.findElement(By.id("login-btn")).click();

		driver.findElement(By.id("dropdown_title")).click();
		System.out.println(driver.getTitle());
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
		driver.close();

	}

}
