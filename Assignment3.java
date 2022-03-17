package week4.day1;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;

import io.github.bonigarcia.wdm.WebDriverManager;

public class Assignment3 {

	public static void main(String[] args) throws InterruptedException {
		// TODO Auto-generated method stub
		
        WebDriverManager.chromedriver().setup();
		ChromeDriver chd= new ChromeDriver();
		chd.get("https://chercher.tech/practice/frames-example-selenium-webdriver");
		chd.manage().window().maximize();
		chd.manage().timeouts().implicitlyWait(5000, TimeUnit.SECONDS);
		
		//enter text in 1st frame
		WebElement webelement= chd.findElement(By.id("frame1"));
		chd.switchTo().frame(webelement);
		chd.findElement(By.xpath("//input")).sendKeys("text");
		System.out.println("1st frame completed");
		
		//click the checkbox
		WebElement webelement1= chd.findElement(By.id("frame3"));
		chd.switchTo().frame(webelement1);
		chd.findElement(By.xpath("//input[@type='checkbox']")).click();
		System.out.println("checkbox clicked");
		
		chd.switchTo().defaultContent();
		
		
		//select from drodown
		Thread.sleep(5000);
		
		chd.switchTo().frame("frame2");
		WebElement animal= chd.findElement(By.xpath("//select[@id='animals']"));
		Select dd=new Select(animal);
		dd.selectByVisibleText("Avatar");
		System.out.println("Avatar selected");
		
		

	}

}
