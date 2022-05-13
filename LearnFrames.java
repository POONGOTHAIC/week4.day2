package week4.day2;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;

import io.github.bonigarcia.wdm.WebDriverManager;

public class LearnFrames {
	
	public static void main(String[] args) {
		WebDriverManager.chromedriver().setup();
		ChromeDriver driver = new ChromeDriver();
		driver.get("https://chercher.tech/practice/frames-example-selenium-webdriver");
		driver.manage().window().maximize();
		
		driver.switchTo().frame("frame1");
		driver.findElement(By.tagName("input")).sendKeys("Cat");
		driver.switchTo().frame("frame3");
		driver.findElement(By.tagName("input")).click();
		driver.switchTo().defaultContent();
		driver.switchTo().frame("frame2");
		WebElement Index = driver.findElement(By.tagName("select"));
		Select select = new Select(Index);
		select.selectByIndex(1);
		driver.switchTo().defaultContent();
	}

}
