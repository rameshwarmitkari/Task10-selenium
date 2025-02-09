package task10;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import io.github.bonigarcia.wdm.WebDriverManager;

public class WebComponent_Q1 {

	public static void main(String[] args) {

		WebDriverManager.chromedriver().setup();

		WebDriver driver = new ChromeDriver();

		driver.get("https://jqueryui.com/datepicker/");

		driver.manage().window().maximize();

		String Year = "2025";
		String month = "March";
		String date = "22";

		driver.switchTo().frame(0); // frame
		driver.findElement(By.id("datepicker")).click();

		while (true) {
			String currentmonth = driver.findElement(By.xpath("//span[@class='ui-datepicker-month']")).getText();
			String currentyear = driver.findElement(By.xpath("//span[@class='ui-datepicker-year']")).getText();
			if (currentmonth.equals(month) && currentyear.equals(Year)) {
				break;
			}

			driver.findElement(By.xpath("//span[@class='ui-icon ui-icon-circle-triangle-e']")).click();
		}

		List<WebElement> list = driver.findElements(By.xpath("//table[@class='ui-datepicker-calendar']/tbody/tr/td/a"));

		for (WebElement ele : list) {
			if (ele.getText().equals(date)) {
				ele.click();
				break;
			}

		}

		System.out.println("date is-> " + date);
		driver.quit();

	}

}
