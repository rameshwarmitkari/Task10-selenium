package task10;

import java.awt.Color;
import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import io.github.bonigarcia.wdm.WebDriverManager;

public class WebComponent_Q2 {

	public static void main(String[] args) {

		WebDriverManager.chromedriver().setup();
		WebDriver driver = new ChromeDriver();
		driver.get("https://jqueryui.com/droppable/");
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(3));
		driver.switchTo().frame(0);

		WebElement source = driver.findElement(By.xpath("//p[text()='Drag me to my target']"));
		WebElement dest = driver.findElement(By.xpath("//p[text()='Drop here']"));
		System.out.println("Before dragand drop ---------------"); //print the color code in rgba format
		String color1 = dest.getCssValue("color");
		System.out.println(color1);

		Actions act = new Actions(driver);

		act.dragAndDrop(source, dest).build().perform();

		WebElement l = driver.findElement(By.xpath("//p[text()='Dropped!']"));
		System.out.println("After drag and drop---------------");
		String color2 = l.getCssValue("color"); // print the color code in rgba format
		
		System.out.println(color2);

		String expected = "Dropped!";
		if (l.getText().equals(expected)) {
			System.out.println("Text verified successfully");
		}
		driver.quit();
	}

}
