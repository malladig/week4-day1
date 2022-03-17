package week4.day1;

import java.util.List;
import java.util.Set;
import java.util.*;
import java.util.concurrent.TimeUnit;
import java.util.Iterator;

import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import io.github.bonigarcia.wdm.WebDriverManager;

public class Assignment1 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		WebDriverManager.chromedriver().setup();
		ChromeDriver chd= new ChromeDriver();
		chd.get("http://leaftaps.com/opentaps/control/login");
		chd.manage().window().maximize();
		chd.manage().timeouts().implicitlyWait(5000, TimeUnit.SECONDS);
		
		//Enter UserName and Password Using Id Locator
		WebElement uname=chd.findElement(By.id("username"));
		uname.sendKeys("Demosalesmanager");
		WebElement pwd=chd.findElement(By.id("password"));
		pwd.sendKeys("crmsfa");
		
		//Click on Login Button using Class Locator
		WebElement login=chd.findElement(By.className("decorativeSubmit"));
		login.click();
		
		//Click on CRM/SFA Link
		WebElement link=chd.findElement(By.linkText("CRM/SFA"));
		link.click();
		
		//Click on contacts Button
		chd.findElement(By.linkText("Contacts")).click();
		 
		//Click on Merge Contacts using Xpath Locator
		chd.findElement(By.xpath("//a[text()='Merge Contacts']")).click();
		
		
		//Click on Widget of From Contact
		chd.findElement(By.xpath(" (//img[@src='/images/fieldlookup.gif'])[1]")).click();
		
         Set<String> handler= chd.getWindowHandles();
         Iterator<String> it = handler.iterator();
         String parentWindowID=it.next();
         System.out.println("Parent window is"+parentWindowID);
         
         String childWindowID=it.next();
         System.out.println("child window is"+childWindowID);
         chd.switchTo().window(childWindowID);
         
        //Click on First Resulting Contact
	    chd.findElement(By.xpath("(//div[@class='x-grid3-cell-inner x-grid3-col-partyId'])[1]//a")).click();
	    
	    chd.switchTo().window(parentWindowID);
	    System.out.println("parent window title is"+chd.getTitle());
	      
	    
	    //Click on Widget of To Contact
	    chd.findElement(By.xpath("(//img[@src='/images/fieldlookup.gif'])[2]")).click();
	    
	  
	    Set<String> handler1= chd.getWindowHandles();
        Iterator<String> it1 = handler1.iterator();
        String parentWindowID1=it1.next();
        System.out.println("Parent window is"+parentWindowID1);
	    
	    
	    String childWindowID1=it1.next();
        chd.switchTo().window(childWindowID1);
        System.out.println("child window title is"+chd.getTitle());
        
        
        //Click on Second Resulting Contact
        chd.findElement(By.xpath("(//div[@class='x-grid3-cell-inner x-grid3-col-partyId'])[2]/a")).click();
        chd.switchTo().window(parentWindowID1);
        System.out.println("parent window title is"+chd.getTitle());
        
        //click on merge button
        chd.findElement(By.xpath("//a[text()='Merge']")).click();
        
        //accept the alert
        Alert a1= chd.switchTo().alert();
		a1.accept();
		
		//verify the title of the page
		System.out.println("the title of the page is"+chd.getTitle());
       
	}

}
