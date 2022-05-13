package week4.day2;

import java.time.Duration;
import java.util.ArrayList;
import java.util.List;
import java.util.Set;

import org.openqa.selenium.By;
import org.openqa.selenium.chrome.ChromeDriver;

import io.github.bonigarcia.wdm.WebDriverManager;

public class MergeContact {
	public static void main(String[] args) {
		WebDriverManager.chromedriver().setup();
		ChromeDriver driver=new ChromeDriver();
		driver.get("http://leaftaps.com/opentaps/control/login");
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(30));
		driver.findElement(By.xpath("//input[@id=\"username\"]")).sendKeys("Demosalesmanager");
		driver.findElement(By.xpath("//input[@id=\"password\"]")).sendKeys("crmsfa");
		driver.findElement(By.xpath("//input[@class='decorativeSubmit']")).click();
		driver.findElement(By.xpath("//a[contains(text(),'CRM')]")).click();
		driver.findElement(By.xpath("//a[contains(text(),'Contacts')]")).click();
		driver.findElement(By.partialLinkText("Merge Contacts")).click();
		driver.findElement(By.xpath("(//img[@alt='Lookup'])[1]")).click();
		
		Set<String> windowHandle = driver.getWindowHandles();
		List<String> windowHandleList=new ArrayList<String>(windowHandle); 
		driver.switchTo().window(windowHandleList.get(1));
		
		driver.findElement(By.xpath("//div[@class='x-grid3-cell-inner x-grid3-col-partyId']//a")).click();
		
		Set<String> windowHandle1 = driver.getWindowHandles();
		List<String> windowHandleList1=new ArrayList<String>(windowHandle1); 
		driver.switchTo().window(windowHandleList1.get(0));
		driver.findElement(By.xpath("(//img[@alt='Lookup'])[2]")).click();
		
		Set<String> windowHandle2 = driver.getWindowHandles();
		List<String> windowHandleList2=new ArrayList<String>(windowHandle2); 
		driver.switchTo().window(windowHandleList2.get(1));
		driver.findElement(By.xpath("//div[@class='x-grid3-cell-inner x-grid3-col-partyId']//a")).click();
		
		Set<String> windowHandle3 = driver.getWindowHandles();
		List<String> windowHandleList3=new ArrayList<String>(windowHandle3); 
		driver.switchTo().window(windowHandleList3.get(0));
		driver.findElement(By.xpath("(//form[@name='MergePartyForm']//td//a)[3]")).click();
		
		driver.switchTo().alert().accept();
		String title = driver.getTitle();
		if(title.contains("Merge")) {
			System.out.println("Title is verified");
		}
	}

}
