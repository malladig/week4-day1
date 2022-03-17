package week4.day1;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Set;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import io.github.bonigarcia.wdm.WebDriverManager;

public class IRCTC {

	public static void main(String[] args) throws InterruptedException {
		// TODO Auto-generated method stub
        
		WebDriverManager.chromedriver().setup();
		ChromeDriver chd= new ChromeDriver();
		chd.get("https://www.irctc.co.in/");
		chd.manage().window().maximize();
		chd.manage().timeouts().implicitlyWait(5000, TimeUnit.SECONDS);
		
		//Click on OK button in the dialog 
		chd.findElement(By.xpath("//button[@class= 'btn btn-primary']")).click();
		Thread.sleep(5000);
		
		//Click on FLIGHTS link 
		String currentWindowHandle = chd.getWindowHandle();
		System.out.println(currentWindowHandle);
		chd.findElement(By.linkText("FLIGHTS")).click();
		
	
		 Set<String> handler= chd.getWindowHandles();
         Iterator<String> it = handler.iterator();
         String parentWindowID=it.next();
         System.out.println("Parent window is"+parentWindowID);
         
         //Go to the Flights tab
         String childWindowID=it.next();
         System.out.println("child window is"+childWindowID);
         chd.switchTo().window(childWindowID);
         
         //Print the customer care email id
         chd.findElement(By.xpath("//a[@class='nav-link dropdown-toggle']")).click();
         Thread.sleep(5000);
         String text=chd.findElement(By.xpath("//a[contains(text(),'flights@irctc.co.in')]")).getText();
        
         System.out.println("the customer care address is"+text);
         
         chd.switchTo().window(parentWindowID);
         System.out.println("Parent window is"+parentWindowID);
         chd.quit();
         
         
         
         
		
	}

}
