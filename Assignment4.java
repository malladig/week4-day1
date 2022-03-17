package week4.day1;

import java.util.List;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import io.github.bonigarcia.wdm.WebDriverManager;

public class Assignment4 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		    WebDriverManager.chromedriver().setup();
			ChromeDriver chd= new ChromeDriver();
			chd.get("http://leafground.com/pages/frame.html");
			chd.manage().window().maximize();
			chd.manage().timeouts().implicitlyWait(5000, TimeUnit.SECONDS);
			
			//Find the number of frames
			 List<WebElement> count= chd.findElements(By.xpath("//iframe"));
			 System.out.println("the no.of iframes are"+count.size());
			
		    
		

	}

}
